package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import main.Course;
import main.Data;
import main.Student;
import main.Transcript;
import main.User;
import main.UserPersonalInfo;


public class StudentMenu implements UserMenu {
	BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
	
	public void showMenu() {
		System.out.println("\n___________________ Student Commands __________________");
		System.out.println("________________________________________________________");
		System.out.println("              1.Register for discipline                 ");
		System.out.println("              2.Drop discipline                         ");
		System.out.println("              3.View disciplines                        "); 
		System.out.println("              4.Personal info                           ");
		System.out.println("              5.Transcript                              ");
		System.out.println("              0.Exit                                    ");
		System.out.println("________________________________________________________");
	}
	
	public void registerForCourse(User user) throws Exception, IOException{
		System.out.println("Choose course that you want to register : ");
		int id = 1;
		for(Course c : Data.getData().getCourses()) {
			System.out.println(id + ". " + c.getName());
			id++;
		}

		int chooseCourse = Integer.parseInt(inp.readLine());
		Course course = Data.getData().getCourses().get(chooseCourse - 1);
		if(((Student) user).getCourses().contains(course)) {
			System.out.println(course.getName() + " has already been added!");
		}
		else {
			((Student) user).registerForCourse(course);
			System.out.println(course.getName() + " is added successfully!");
		}
	}
	
	public void dropCourse(User user) throws Exception, IOException {
		if(((Student) user).getCourses().isEmpty()) {
			System.out.println("There is no course to drop!");
		}
		else {
			System.out.println("Choose course that you want to drop : ");
			viewMyCourses(((Student) user));

			int chooseCourse = Integer.parseInt(inp.readLine());
			System.out.println(((Student) user).getCourses().get(chooseCourse - 1).getName() + " is dropped successfully!");
			((Student) user).dropCourse(((Student) user).getCourses().get(chooseCourse - 1));
		}
	}
	
	public void viewDisciplines(User user) {
		if(((Student) user).getCourses().isEmpty()) {
			System.out.println("You have not added courses yet!");
		}
		else {
			System.out.println("The courses that you are studying currently : ");
			viewMyCourses(((Student) user));
		}
	}
	
	public void fillPersonalInfo(User user) throws IOException {
		System.out.println("Fill these fields : ");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		System.out.println("1) Birth date(d/MM/YYYY) : ");
		String date = inp.readLine();
		
		System.out.println("2) Nation : ");
		String nat = inp.readLine();
		
		System.out.println("3) Mobile phone : ");
		String mp = inp.readLine();
		
		System.out.println("4) Address : ");
		String add = inp.readLine();
		
		System.out.println("5) Marital Status : ");
		String ms = inp.readLine();
		
		((Student) user).setPersonalInfo(new UserPersonalInfo(LocalDate.parse(date, formatter), mp, nat, ms, add));
		
		System.out.println("\n");
		System.out.println(((Student) user).getPersonalInfo().toString());
	}
	
	public void viewTranscript(User user) {
		Transcript transcript = ((Student) user).getTranscript();
		if (transcript != null) {
            System.out.println("Transcript:");
            System.out.println(transcript.toString());
        } 
		else {
            System.out.println("No transcript available for " + ((Student) user).getName());
        }
	}
	
	public void viewMyCourses(User user) {
		int id = 1;
		for(Course c : ((Student) user).getCourses()) {
			System.out.println(id + ". " + c.getName());
			id++;
		}
	}
	
	public void performActions(User user) throws Exception {
	    BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

	    try {
	        boolean exit = false;

	        while (!exit) {
	            showMenu();
	            System.out.print("Enter your choice: ");
	            int choice = Integer.parseInt(inp.readLine());

	            switch (choice) {
	                case 1:
	                	registerForCourse(user);
	                    break;
	                case 2:
	                	dropCourse(user);
	                    break;
	                case 3:
	                	viewDisciplines(user);
	                    break;
	                case 4:
	                	fillPersonalInfo(user);
	                case 5:
	                	viewTranscript(user);
	                case 0:
	                    exit = true;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    } catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    } catch (ClassCastException e) {
	        System.out.println("Invalid user type for StudentMenu.");
	    }
	}
}
