package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Vector;

import main.Course;
import main.Data;
import main.ExamType;
import main.Mark;
import main.Student;
import main.Teacher;
import main.User;

public class TeacherMenu implements UserMenu {
	BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
	
	public void showMenu() {
		System.out.println("\n___________________ Teacher Commands ___________________");
		System.out.println("________________________________________________________");
		System.out.println("                 1.Put Mark                             ");
		System.out.println("                 2.View Courses                         ");
		System.out.println("                 3.View Personal Info                   ");
		System.out.println("                 4.View Student Info                    ");
		System.out.println("                 5.View Students                        ");
		System.out.println("                 6.Forward Support Request              ");
		System.out.println("                 0.Exit                                 ");
		System.out.println("________________________________________________________");
	}
	
	public void putMark(User user) throws IOException {
		System.out.println("Choose the course you want to rate : ");
		
		int id = 1;
		for(Course c : ((Teacher) user).getCourses()) {
			System.out.println(id + ". " + c.getName());
			id++;
		}
		
		int chooseCourse = Integer.parseInt(inp.readLine());
		Course c = ((Teacher) user).getCourses().get(chooseCourse - 1);
		
		id = 1;
		for(Student s : c.getStudents()) {
			System.out.println(id + ". " + s.getName() + " " + s.getSurname());
			id++;
		}
		
		id = 1;
		int chooseStudent = Integer.parseInt(inp.readLine());
		Student s = c.getStudents().get(chooseStudent - 1);
		System.out.println("Choose type of mark you want to put : ");
		ExamType[] mt = ExamType.values();
		for (ExamType dir : mt) {
			System.out.println(id + ". " + dir);
			id++;
		}
		int chooseMark = Integer.parseInt(inp.readLine());
		ExamType m = (ExamType)Array.get(mt, chooseMark);
		System.out.println("Write marks value you want put: ");
		int MarkVal = Integer.parseInt(inp.readLine());
		((Teacher) user).putMark(c, s, new Mark(m, MarkVal));
	}
	
	public void viewCourses(User user) {
		Teacher teacher = (Teacher) user;
		Vector<Course> courses = teacher.getCourses();

	    if (courses.isEmpty()) {
	        System.out.println("You are not assigned to any courses.");
	    } else {
	        System.out.println("Courses you are assigned to:");
	        int courseId = 1;
	        for (Course course : courses) {
	            System.out.println(courseId + ". " + course.getName());
	            courseId++;
	        }
	    }
	}
	
	private void viewPersonalInfo(User user) {
		Teacher teacher = (Teacher) user;
	    System.out.println("Personal Information:");
	    System.out.println("Name: " + teacher.getName());
	    System.out.println("Surname: " + teacher.getSurname());
	    System.out.println("Hire Date: " + teacher.getHireDate());
	    System.out.println("Salary: " + teacher.getSalary());
	    System.out.println("Work Experience: " + teacher.getWorkExperience() + " years");
	    System.out.println("Teacher Type: " + teacher.getTitle());
	}
	
	private void viewStudentInfo() throws IOException {
		System.out.println("Choose Student : ");
		int id = 1;
		for(Student s : Data.getData().getStudents()) {
			System.out.println(id + ". " + s.getName() + " " + s.getSurname());
			id++;
		}
		
		int chooseStudent = Integer.parseInt(inp.readLine());
		Student student = Data.getData().getStudents().get(chooseStudent - 1);
		System.out.println("Student Information:");
        System.out.println("Name: " + student.getName());
        System.out.println("Surname: " + student.getSurname());
        System.out.println("Transcript: \n" + student.getTranscript().toString());
	}
	
	public void viewStudents(User user) throws IOException {
	    Vector<Course> courses = ((Teacher) user).getCourses();

	    if (courses.isEmpty()) {
	        System.out.println("You are not assigned to any courses.");
	        return;
	    }

	    System.out.println("Choose a course to view students: ");
	    int courseId = 1;
	    for (Course course : courses) {
	        System.out.println(courseId + ". " + course.getName());
	        courseId++;
	    }

	    int chooseCourse = Integer.parseInt(inp.readLine());
	    Course selectedCourse = courses.get(chooseCourse - 1);

	    Vector<Student> students = selectedCourse.getStudents();

	    if (students.isEmpty()) {
	        System.out.println("No students registered for the selected course.");
	        return;
	    }

	    System.out.println("Students registered for " + selectedCourse.getName() + ":");
	    for (Student student : students) {
	        System.out.println(student.getName() + " " + student.getSurname());
	    }
	}
	
	public void forwardSupportRequest(User user) throws Exception {
		System.out.println("Enter the description for the support request: ");
		String description = inp.readLine();
		
		boolean success = ((Teacher) user).submitSupportRequest(description);
		
		if (success) {
            System.out.println("Support request submitted successfully!");
        } else {
            System.out.println("Failed to submit support request.");
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
	                    putMark(user);
	                    break;
	                case 2:
	                	viewCourses(user);
	                    break;
	                case 3:
	                	viewPersonalInfo(user);
	                    break;
	                case 4:
	                	viewStudentInfo();
	                case 5:
	                	viewStudentInfo();
	                case 6:
	                	viewStudents(user);
	                case 7:
	                	forwardSupportRequest(user);
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
