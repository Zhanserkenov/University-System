package main;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Vector;

import exceptions.*;


public class Manager extends Employee implements ManageNews, ViewInfo {
	private static final long serialVersionUID = 1L;
	
	
	private ManagerType type;
	
	public Manager() {
		super();
	}
	
	public Manager(String name, String surname) {
		super(name, surname);
	}
	
	public Manager(String name, String surname, LocalDate hireDate, int salary, int workExperience) {
		super(name, surname, hireDate, salary, workExperience);
	}
	
	public Manager(String name, String surname, LocalDate hireDate, int salary, int workExperience, ManagerType type) {
		super(name, surname, hireDate, salary, workExperience);
		this.type = type;
	}
	
	public ManagerType getType() {
		return type;
	}
	
	void setType(ManagerType type) {
		this.type = type;
	}
	
	public boolean submitSupportRequest(String description) {
		Message message = new Message("Support request from Manager: " + description);
		SupportRequest supportRequest = new SupportRequest(message, this.getName());
		Data.getData().getSupportRequests().add(supportRequest);
		return true;
	}
	
	public boolean approveStudentRegistration(Course c, Student s) {
		if(c.getStudents().contains(s))
			return false;

		if(s.getTotalCredits() + c.credit > 21)
			return false;

		return true;
	}
	
	public boolean dropCoursefromStudent(Course c, Student s) {
		return c.getStudents().remove(s);
	}
	
	public void addCoursetoStudent(Course c, Student s) throws CourseNotFoundException{
		try {
			if(Data.getData().getCourses().contains(c)) {
				c.getStudents().add(s);
			}
			else {
				throw new CourseNotFoundException("Course is not found in university database!");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean addCourse(Course course) {
		Data.getData().getCourses().add(course);
		return true;
	}
	
	public Vector<Course> viewCourses() {
		return Data.getData().getCourses();
	}
	
	public void assignCourseForTeacher(Course c, Teacher t) throws CourseNotFoundException{
		try {
			if(Data.getData().getCourses().contains(c)) {
				c.getInstructors().add(t);
			}
			else {
				throw new CourseNotFoundException("Course is not found in university database!");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public String reportGeneration(Course c) {
		String report = "Performance of students in course " + c.getName() + " : \n";

		for(Student s : c.getStudents()) {
			report += s.getSurname() + " " + s.getName() + " " + s.getTranscript().getTotalForCourse(c) + "\n";
		}

		return report;
	}
	
	public String viewStudentInfo(Student s) throws StudentNotFoundException{
		try {
			if(Data.getData().getStudents().contains(s)) {
				return s.toString();
			}
			else {
				throw new StudentNotFoundException("No such student in university database!");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return "";
	}
	
	public String viewTeacherInfo(Teacher t) throws TeacherNotFoundException{
		try {
			if(Data.getData().getTeachers().contains(t)) {
				return t.toString();
			}
			else {
				throw new TeacherNotFoundException("No such teacher in university database!");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return "";
	}
	
	public boolean reportNews(News news) {
		if(Data.getData().getNews().contains(news)) return false;
		Data.getData().getNews().add(news);
		return true;
	}
	
	public boolean removeNews(News news) {
		return Data.getData().getNews().remove(news);
	}
	
	
	
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(type);
		return result;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(obj == null || getClass() != obj.getClass()) return false;
		Manager other = (Manager) obj;
		return type == other.type;
	}
	
	public String toString() {
	    return "Manager{" +
	            "name='" + getName() + '\'' +
	            ", surname='" + getSurname() + '\'' +
	            ", hireDate=" + getHireDate() +
	            ", salary=" + getSalary() +
	            ", workExperience=" + getWorkExperience() +
	            ", type=" + type +
	            '}';
	}
	
}
