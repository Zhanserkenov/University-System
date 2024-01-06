package main;

import java.util.Objects;
import java.util.Vector;

import exceptions.InvalidSupervisorException;

public class Student extends User {
	private static final long serialVersionUID = 1L;
	
	private double gpa;
	private String id;
	private Faculty faculty;
	private Degree degree;
	private int course;
	private Transcript transcript = new Transcript();
	private Researcher researchSupervisor;
	
	public Student() {

	}
	
	public Student(String name, String surname) {
    	super(name, surname);
    }
	
	public Student(String name, String surname, String id) {
    	this(name, surname);
    	this.id = id;
    }
	
	public Student(String name, String surname, String id, Degree degree, int course) {
		this(name, surname, id);
		this.degree = degree;
		this.course = course;
		this.researchSupervisor = null;
	}
	
	public Researcher getResearchSupervisor() {
        return researchSupervisor;
    }
	
	public Degree getDegree() {
		return degree;
	}
	
	public int getCourse() {
		return course;
	}
	
	public String getId() {
		return id;
	}
	
	public void setResearchSupervisor(Researcher researchSupervisor) throws InvalidSupervisorException {
        if (researchSupervisor == null || researchSupervisor.calculateHIndex() < 3) {
            throw new InvalidSupervisorException("Invalid research supervisor.");
        }
        this.researchSupervisor = researchSupervisor;
    }
	
	void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	void setCourse(int course) {
		this.course = course;
	}
	
	void setId(String id) {
		this.id = id;
	}
	
	public Manager getManager() {
		return faculty.getManager();
	}
	
	public Transcript getTranscript() {
		return this.transcript;
	}
	
	public int getTotalCredits() {
		int cnt = 0;
		for(Course c : this.getCourses()) {
			cnt += c.credit;
		}
		return cnt;
	}
	
	public boolean addLesson(Lesson lesson) {
		if(lesson.getStudents().contains(this)) return false;
		lesson.getStudents().add(this);
		return true;
	}
	
	public boolean dropCourse(Course course) {
		if(!course.getStudents().contains(this)) return false;
		course.getStudents().remove(this);
		this.getTranscript().getGrades().remove(course);
		return true;
	}
	
	public boolean registerForCourse(Course course) {
		if(this.getManager().approveStudentRegistration(course, this)) {
			course.getStudents().add(this);
			return true;
		}
		return false;
	}
	
	public Vector<Course> getCourses() {
		Vector<Course> myCourses = new Vector<Course>();
		for(Course c : Data.getData().getCourses()) {
			if(c.getStudents().contains(this))
				myCourses.add(c);
		}
		return myCourses;
	}
	
	public Vector<Lesson> getLessons(){
		Vector<Lesson> myLessons = new Vector<Lesson>();
		for(Course c : Data.getData().getCourses()) {
			for(Lesson l : c.getLessons()) {
				if(l.getStudents().contains(this))
					myLessons.add(l);
			}
		}
		return myLessons;
	}
	
	public double getGPA() {
		double score = this.transcript.getTotalScore(this);
		
		if(score >= 95)
			return 4.0;
		else if(score >= 90)
			return 3.67;
		else if(score >= 85)
			return 3.33;
		else if(score >= 80)
			return 3.0;
		else if(score >= 75)
			return 2.67;
		else if(score >= 70)
			return 2.33;
		else if(score >= 65)
			return 2.0;
		else if(score >= 60)
			return 1.67;
		else if(score >= 55)
			return 1.33;
		else if(score >= 50)
			return 1.0;
		
		return 0;
	}
	
	public int compareTo(Object obj) {
		Student s = (Student) obj;
		
	    if(this.getGPA() > s.getGPA()) return 1;
	    if(this.getGPA() < s.getGPA()) return -1;
	    return 0;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(gpa, id, faculty, degree, course, transcript);
		return result;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(obj == null || getClass() != obj.getClass()) return false;
		Student other = (Student) obj;
		return Double.compare(gpa, other.gpa) == 0 && Objects.equals(id, other.id) && Objects.equals(faculty, other.faculty) 
				&& Objects.equals(degree, other.degree) && course == other.course && Objects.equals(transcript, other.transcript);
	}
	
	public String toString() {
	    return "Student{" +
	            "gpa=" + gpa +
	            ", id='" + id + '\'' +
	            ", faculty=" + faculty +
	            ", degree=" + degree +
	            ", course=" + course +
	            ", transcript=" + transcript +
	            "} " + super.toString();
	}
	
}
