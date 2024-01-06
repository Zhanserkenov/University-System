package main;

import java.io.*;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public final class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static Data DATA;
	
	Vector<User> users;
	Vector<News> news;
	Vector<Faculty> faculties;
	Vector<Organization> organizations;
	Vector<SupportRequest> supportRequests;
	Vector<Course> courses;
	
	static {
		if(new File("data.out").exists()) {
			try {
				DATA = readData();	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			DATA = new Data();
			DATA.users = new Vector<User>();
			DATA.news = new Vector<News>();
			DATA.faculties = new Vector<Faculty>();
			DATA.organizations = new Vector<Organization>();
			DATA.supportRequests = new Vector<SupportRequest>();
			DATA.courses = new Vector<Course>();
			
			if (DATA.users.isEmpty()) {
	            Admin admin = Admin.getInstance();
	            admin.setName("Admin");
	            admin.setSurname("Admin");
	            admin.setLogin("admin");
	            admin.setPassword("admin123");
	            DATA.users.add(admin);
	            
	            TechSupportSpecialist techSupportSpecialist = new TechSupportSpecialist("Tech", "Support");
	            techSupportSpecialist.setLogin("techsupport");
	            techSupportSpecialist.setPassword("techsupport123");
	            DATA.users.add(techSupportSpecialist);
	            
	            
	        }
		}
	}
	
	private Data() {
		
	}
	
	public static Data getData() {
		return DATA;
	}
	
	public List<Employee> getEmployees() {
		return this.users.stream().filter(u->u instanceof Employee).map(u->(Employee)u).collect(Collectors.toList());
	}
	
	public List<Teacher> getTeachers(){
		return this.getEmployees().stream().filter(u->u instanceof Teacher).map(u->(Teacher)u).collect(Collectors.toList());
	}
	
	public List<Manager> getManagers(){
		return this.getEmployees().stream().filter(u->u instanceof Manager).map(u->(Manager)u).collect(Collectors.toList());
	}
	
	public List<Student> getStudents() {
		return this.users.stream().filter(u->u instanceof Student).map(u->(Student)u).collect(Collectors.toList());
	}
	
	public Vector<User> getUsers() {
		return this.users;
	}
	
	public Vector<News> getNews(){
		return news;
	}
	
	public Vector<SupportRequest> getSupportRequests(){
		return supportRequests;
	}
	
	public Vector<Course> getCourses() {
		//Vector<Course> courses = new Vector<Course>();
//		for(Faculty f : faculties) {
//			courses.addAll(f.getCourses());
//		}
		return courses;
	}
	
	static Data readData() throws Exception{
		FileInputStream fis = new FileInputStream("data.out");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Data data = (Data)ois.readObject();
		fis.close();
		ois.close();
		return data;
	}
	
	public static void saveData() throws Exception {
		FileOutputStream fos = new FileOutputStream("data.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(DATA);
		fos.close();
		oos.close();
	}
	
}
