package main;

import java.io.Serializable;
import java.util.Vector;
import java.util.Objects;

public class Faculty implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public TitleFaculty title;
	public Vector<Course> courses = new Vector<Course>();
	public Manager manager;
	
	public Faculty() {
		
	}
	
	public Faculty(TitleFaculty title) {
		this.title = title;
	}
	
	public Faculty(TitleFaculty title, Manager manager) {
		this(title);
		this.manager = manager;
	}
	
	public Faculty(TitleFaculty title, Manager manager, Vector<Course> courses) {
    	this(title, manager);
    	this.courses = courses;
    }
	
	public TitleFaculty getTitle() {
		return title;
	}
	
	public Vector<Course> getCourses() {
		return courses;
	}
	
	public Manager getManager() {
		return manager;
	}
	
	public void setTitle(TitleFaculty title) {
		this.title = title;
	}
	
	public void setCourses(Manager manager) {
		this.manager = manager;
	}
	
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	} 
	
	public int hashCode() {
		return Objects.hash(title, courses, manager);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Faculty other = (Faculty) obj;
		return title == other.title && Objects.equals(manager, other.manager) && Objects.equals(courses, other.courses);
	}
	
	public String toString() {
	    return "Faculty{" +
	            "title=" + title +
	            ", courses=" + courses +
	            ", manager=" + manager +
	            '}';
	}
	
}
