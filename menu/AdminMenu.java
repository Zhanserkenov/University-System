package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.Admin;
import main.Data;
import main.Manager;
import main.Student;
import main.Teacher;
import main.User;

public class AdminMenu implements UserMenu {
	
	int which;
	
	public void showMenu() {
		System.out.println("\n____________________ Admin Commands ____________________");
		System.out.println("________________________________________________________");
		System.out.println("                 1.Add User                             ");
		System.out.println("                 2.Remove User                          ");
		System.out.println("                 3.View Users                           ");
		System.out.println("                 4.Forward Support Request              ");
		System.out.println("                 0.Exit                                 ");
		System.out.println("________________________________________________________");
	}
	
	public void showUserTypes() {
		System.out.println("______________________ User Types ______________________");
		System.out.println("________________________________________________________");
		System.out.println("                 1.Student                              ");
		System.out.println("                 2.Teacher                              ");
		System.out.println("                 3.Manager                              ");
		System.out.println("________________________________________________________");
	}
	
	public void addUser() throws Exception, IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("You are adding user to WSP ...\n");
		
		showUserTypes();
		System.out.println("Enter the User type : ");
		
		which = Integer.parseInt(inp.readLine());
		
		System.out.print("Enter the Name : "); 
		String name = inp.readLine();
		
		System.out.println("Enter the Surname : ");
		String surname = inp.readLine();
		
		if(which==1) {
			Student u = new Student(name, surname);
			Admin.getInstance().addUser(u);
		}
		else if(which==2) {
			Teacher u = new Teacher(name, surname);
			Admin.getInstance().addUser(u);
		}
		else if(which==3) {
			Manager u = new Manager(name, surname);
			Admin.getInstance().addUser(u);
		}
		
		Data.saveData();
		System.out.println("User is successfully added! ");
	}
	
	public void removeUser() throws Exception, IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("You are removing user in WSP ...\n");
		
		showUserTypes();
		System.out.print("Enter the User type : ");
		which = Integer.parseInt(inp.readLine());
		
		if(which == 1) {
			System.out.println("Choose Student that you want to remove : ");
			int id = 1;
			for(Student s : Data.getData().getStudents()) {
				System.out.println(id + " " + s.getName() + " " + s.getSurname());
				id++;
			}
			
			int chooseStudent = Integer.parseInt(inp.readLine());
			Admin.getInstance().removeUser(Data.getData().getStudents().get(chooseStudent - 1));
		}
		else if(which == 2) {
			System.out.println("Choose Teacher that you want to remove : ");
			int id = 1;
			for(Teacher t : Data.getData().getTeachers()) {
				System.out.println(id + " " + t.getName() + " " + t.getSurname());
				id++;
			}
			int chooseTeacher = Integer.parseInt(inp.readLine());
			Admin.getInstance().removeUser(Data.getData().getTeachers().get(chooseTeacher - 1));
		}
		else if(which == 3) {
			System.out.println("Choose Manager that you want to remove : ");
			int id = 1;
			for(Manager m : Data.getData().getManagers()) {
				System.out.println(id + " " + m.getName() + " " + m.getSurname());
				id++;
			}
			int chooseManager = Integer.parseInt(inp.readLine());
			Admin.getInstance().removeUser(Data.getData().getManagers().get(chooseManager - 1));
		}
		
		Data.saveData();
		System.out.println("User was removed!");
	}
	
	private void viewUsers() {
		if (Data.getData().getUsers().isEmpty()) {
	        System.out.println("You have not added any user to UniSystem yet! Try next time!");
	    } 
		else {
	        int id = 1;
	        for (User u : Data.getData().getUsers()) {
	            System.out.println(id + ". " + u.getLogin());
	            id++;
	        }
	    }
	}
	
	public void forwardSupportRequest() throws Exception {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the description for the support request:");
		String description = inp.readLine();
		
		boolean success = Admin.getInstance().submitSupportRequest(description);
		
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
	                    addUser();
	                    break;
	                case 2:
	                    removeUser();
	                    break;
	                case 3:
	                    viewUsers();
	                    break;
	                case 4:
	                	forwardSupportRequest();
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
	        System.out.println("Invalid user type for AdminMenu.");
	    }
	}
	
}
