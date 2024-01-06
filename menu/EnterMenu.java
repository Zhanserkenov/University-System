package menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import main.Admin;
import main.Data;
import main.Manager;
import main.Student;
import main.Teacher;
import main.TechSupportSpecialist;
import main.User;

public class EnterMenu {
	
	private static final EnterMenu INSTANCE = new EnterMenu();
	
	BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
	
	private EnterMenu() {
		
	}
	
	public static EnterMenu getInstance() {
		return INSTANCE;
	}
	
	public void showMenu() {
		System.out.println("____________________ Welocome to WSP ____________________");
		System.out.println("_________________________________________________________");
	}
	
	public UserMenu getUserMenu(int userMenuType) {
		switch(userMenuType) {
			case 1:
				return new StudentMenu();
			case 2:
				return new TeacherMenu();
			case 3:
				return new ManagerMenu();
			case 4:
				return new AdminMenu();
			case 5:
				return new TechSupportSpecialistMenu();
			default:
				throw new IllegalArgumentException("Invalid user menu type");
		}
	}
	
	public void enterToTheSystem() throws Exception {
		User userType = null;
		int userMenuType = 0;
		
		while(userMenuType == 0) {
			System.out.print("Login: ");
			String login = inp.readLine();
			System.out.print("Password: ");
			String password = inp.readLine();
			
			for(User user : Data.getData().getUsers()) {
				if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
					if(user instanceof Student) {
						userMenuType = 1;
						Student s = (Student)user;
						userType = s;
					}
					else if(user instanceof Teacher) {
						userMenuType = 2;
						Teacher t = (Teacher)user;
						userType = t;
					}
					else if(user instanceof Manager) {
						userMenuType = 3;
						Manager m = (Manager)user;
						userType = m;
					}
					else if(user instanceof Admin) {
						userMenuType = 4;
						Admin a = (Admin)user;
						userType = a;
					}
					else if(user instanceof TechSupportSpecialist) {
						userMenuType = 5;
						TechSupportSpecialist t = (TechSupportSpecialist)user;
						userType = t;
					}
					break;
				}
			}
			
			if(userMenuType == 0) {
				System.out.println("Invalid login or password, try again!\n");
			}
		}
		UserMenu userMenu = getUserMenu(userMenuType);
		userMenu.performActions(userType);
	}

}
