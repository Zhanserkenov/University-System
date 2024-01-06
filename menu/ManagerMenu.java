package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Vector;

import exceptions.CourseNotFoundException;
import main.Data;
import main.Language;
import main.Manager;
import main.News;
import main.Student;
import main.Teacher;
import main.User;
import main.Course;

public class ManagerMenu implements UserMenu {
	BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
	
	public void showMenu() {
		System.out.println("\n__________________ Manager Commands __________________");
		System.out.println("________________________________________________________");
		System.out.println("                 1.Add course to student                ");
		System.out.println("                 2.Drop course from student             ");
		System.out.println("                 3.Report news                          ");
		System.out.println("                 4.Remove news                          ");
		System.out.println("                 5.View student info                    ");
		System.out.println("                 6.View teacher info                    ");
		System.out.println("                 7.Assign course to teacher             ");
		System.out.println("                 8.Forward Support Request              ");
		System.out.println("                 9. Add Course                          ");
		System.out.println("                 10. View Course                          ");
		System.out.println("                 0.Exit                                 ");
		System.out.println("________________________________________________________");
	}
	
	private void addCourseForStudent(User user) throws Exception, IOException {
		System.out.println("Choose course that you want add to student : ");
		int id = 1;
		for(Course c : Data.getData().getCourses()) {
			System.out.println(id + ". " + c.getName());
			id++;
		}
		
		int chooseCourse = Integer.parseInt(inp.readLine());
		Course course = Data.getData().getCourses().get(chooseCourse - 1);
		
		System.out.println("Choose student whom want add to course : ");
		id = 1;
		for(Student s : Data.getData().getStudents()) {
			System.out.println(id + ". " + s.getName() + " " + s.getSurname());
			id++;
		}
		
		int chooseStudent = Integer.parseInt(inp.readLine());
		Student student = Data.getData().getStudents().get(chooseStudent - 1);
		if(student.getCourses().contains(course)) {
			System.out.println(student.getName() + "has already registred for " + course.getName() + "\n\n");
		}
		else {
			((Manager)user).addCoursetoStudent(course, student);
			System.out.println(course.getName()  + " was saccessfully added to " + student.getName() + "\n\n");
		}
	}
	
	private void DropCourseFromStudent(User user) throws Exception {
		System.out.println("Choose student to drop from the course : ");
		int id = 1;
		for(Student s : Data.getData().getStudents()) {
			System.out.println(id + ". " + s.getName() + " " + s.getSurname());
			id++;
		}
		
		int chooseStudent = Integer.parseInt(inp.readLine());
		Student student = Data.getData().getStudents().get(chooseStudent - 1);
		
		if(student.getCourses().isEmpty()) {
			System.out.println(student.getName() + " has no lesson!");
		}
		else {
			System.out.println("Choose students's course that you want to drop : ");
			id = 1;
			for(Course c : student.getCourses()) {
				System.out.println(id + ". " + c.getName());
				id++;
			}
			
			int chooseCourse = Integer.parseInt(inp.readLine());
			Course course = student.getCourses().get(chooseCourse - 1);
			((Manager)user).dropCoursefromStudent(course, student);
			System.out.println(course.getName()  + " was saccessfully droped for + " + student.getName() + "\n\n");
		}
	}
	
	private void reportNews(User user) throws Exception {
		News n = new News();
		System.out.println("In which language will news be reported? ");
		Language[] ll = Language.values();
		
		int id = 1;
		for (Language dir : ll) {
			System.out.println(id + ". " + dir);
			id++;
		}
		
		int chooseLanguage = Integer.parseInt(inp.readLine());
		Language l = (Language)Array.get(ll, chooseLanguage - 1);
		
		System.out.print("Enter news title in " + l + ":");
		String title = inp.readLine();
		n.setTitle(title);
		
		if(n.getTitle().length()!=0) {
			System.out.print("Enter information about news: ");
			String inf = inp.readLine();	
			n.setInfo(inf);
			if(n.getInfo().length() > 0) {
				((Manager)user).reportNews(n);
				System.out.println("News was successfully reported!");	
			}
		}
	}
	
	private void removeNews(User user) throws Exception {
		System.out.println("Choose news that you want remove: ");
		if(Data.getData().getNews().isEmpty()) {
			System.out.println("No news in system");
		}
		else {
			int id = 1;
			for(News n: Data.getData().getNews()) {
				System.out.println(id + ". " + n.getTitle());
				id++;
			}
			int chooseNews = Integer.parseInt(inp.readLine());
			News news = Data.getData().getNews().get(chooseNews - 1);
			((Manager)user).removeNews(news);
			if(chooseNews > 0) {
				System.out.println("News successfully deleted!");
			}
		}
	}
	
	private void viewStudentInfo() throws Exception {
		System.out.println("Select the student: ");
		int id = 1;
		for(Student s : Data.getData().getStudents()) {
			System.out.println(id + ". " + s.getName() +  " "  + s.getSurname());
			id++;
		}
		int chooseStudent = Integer.parseInt(inp.readLine());
		Student s = Data.getData().getStudents().get(chooseStudent - 1);
		System.out.println(s.toString());
	}
	
	private void viewTeacherInfo() throws Exception {
		System.out.println("Select the teacher: ");
		int id = 1;
		for(Teacher s : Data.getData().getTeachers()) {
			System.out.println(id + ". " + s.getName() +  " "  + s.getSurname());
			id++;
		}
		int chooseTeacher = Integer.parseInt(inp.readLine());
		Teacher t = Data.getData().getTeachers().get(chooseTeacher - 1);
		System.out.println(t.toString());
	}
	
	private void assignCourseForTeacher(User user) throws Exception, IOException {
		System.out.println("Choose course that you want to assign to a teacher: ");
		int id = 1;
		for(Course c : Data.getData().getCourses()) {
			System.out.println(id + ". " + c.getName());
			id++;
		}
		
		int chooseCourse = Integer.parseInt(inp.readLine());
		Course course = Data.getData().getCourses().get(chooseCourse - 1);
		
		System.out.println("Choose teacher to assign the course: ");
		id = 1;
		for(Teacher s : Data.getData().getTeachers()) {
			System.out.println(id + ". " + s.getName() +  " "  + s.getSurname());
			id++;
		}
		int chooseTeacher = Integer.parseInt(inp.readLine());
		Teacher teacher = Data.getData().getTeachers().get(chooseTeacher - 1);
		
		
		try {
	        ((Manager) user).assignCourseForTeacher(course, teacher);
	        System.out.println(course.getName() + " was successfully assigned to " + teacher.getName() + "\n\n");
	    } catch (CourseNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public void forwardSupportRequest(User user) throws Exception {
		System.out.println("Enter the description for the support request: ");
		String description = inp.readLine();
		
		boolean success = ((Manager) user).submitSupportRequest(description);
		
		if (success) {
            System.out.println("Support request submitted successfully!");
        } else {
            System.out.println("Failed to submit support request.");
        }
	}
	
	
	public void addcourse(User user) throws IOException {
		System.out.println("Name: ");
		String name = inp.readLine();
		int credits = Integer.parseInt(inp.readLine());
//		String code = inp.readLine();
		Course course = new Course(name, credits);
		((Manager) user).addCourse(course);
	}
	
	public Vector<Course> viewcourse(User user) {
		return ((Manager)user).viewCourses();
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
	                    addCourseForStudent(user);
	                    break;
	                case 2:
	                	DropCourseFromStudent(user);
	                    break;
	                case 3:
	                	reportNews(user);
	                    break;
	                case 4:
	                	removeNews(user);
	                case 5:
	                	viewStudentInfo();
	                case 6:
	                	viewTeacherInfo();
	                case 7:
	                	assignCourseForTeacher(user);
	                case 8:
	                	forwardSupportRequest(user);
	                case 9:
	                	addcourse(user);
	                case 10:
	                	viewcourse(user);
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
	        System.out.println("Invalid user type for ManagerMenu.");
	    }
	}
	
}
