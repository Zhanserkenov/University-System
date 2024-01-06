package main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

public class Teacher extends Employee implements ViewInfo {
	private static final long serialVersionUID = 1L;
	
	private TeacherType type;
	
	public Teacher() {
		super();
	}
	
	public Teacher(String name, String surname) {
		super(name, surname);
	}
	
	public Teacher(String name, String surname, LocalDate hireDate, int salary, int workExperience) {
    	super(name, surname, hireDate, salary, workExperience);
    }
    
	public Teacher(String name, String surname, LocalDate hireDate, int salary, int workExperience, TeacherType type) {
    	super(name, surname, hireDate, salary, workExperience);
    	this.type = type;
    }
	
	public TeacherType getTitle() {
		return type;
	}
	
	public void setTitle(TeacherType type) {
		this.type = type;
	}
	
	public boolean submitSupportRequest(String description) {
		Message message = new Message("Support request from Teacher: " + description);
		SupportRequest supportRequest = new SupportRequest(message, this.getName());
		Data.getData().getSupportRequests().add(supportRequest);
		return true;
	}
	
	public boolean putMark(Course c, Student s, Mark m) {
		if(Data.getData().getCourses().contains(c)) {
			if(c.getStudents().contains(s)) {
				s.getTranscript().addGradeForCourse(c, m);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public Vector<Course> getCourses() {
		Vector<Course> courses = new Vector<Course>();
		for(Course c : Data.getData().getCourses()) {
			if(c.getInstructors().contains(this)) {
				courses.add(c);
			}
		}
		return courses;
	}
	
	public HashMap<Course, Vector<Student>> getStudents() {
		HashMap<Course, Vector<Student>> students = new HashMap<Course, Vector<Student>>();
		for(Course c : getCourses()) {
			students.put(c, c.getStudents());
		}
		return students;
	}
	
	public String viewStudentInfo(Student s) {
		if(Data.getData().getStudents().contains(s)) {
			return s.toString();
		}
		return "No such student";
	}
	
	public String viewTeacherInfo(Teacher t) {
		if(Data.getData().getTeachers().contains(t)) {
			return t.toString();
		}
		return "No such teacher";
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
		Teacher other = (Teacher) obj;
		return type == other.type;
	}
	
	public String toString() {
	    return "Teacher{" +
	            super.toString() +
	            ", type=" + type +
	            '}';
	}
}
