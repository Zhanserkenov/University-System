package main;

import java.util.Objects;
import java.util.Vector;

public class Course {
	
	public CourseName name;
	public String name1;
	public int credit;
	public String code;
	public Vector<Teacher> instructors = new Vector<Teacher>();
	public Vector<Student> students = new Vector<Student>();
	public Vector<Lesson> lessons = new Vector<Lesson>();
	
	public Course() {
		
	}
	
	public Course(String name1, int credit, String code) {
		this.name1 = name1;
		this.credit = credit;
		this.code = code;
	}
	
	public Course(String name1, int credit) {
		this.name1 = name1;
		this.credit = credit;
	}
	
	public Course(CourseName name, int credit, String code) {
		this.name = name;
		this.credit = credit;
		this.code = code;
	}
	
	public Course(CourseName name, int credit, String code, Vector<Teacher> instructors) {
		this(name, credit, code);
		this.instructors = instructors;
	}
	
	public Course(CourseName name, int credit, String code, Vector<Teacher> instructors, Vector<Student> students) {
		this(name, credit, code, instructors);
		this.students = students;
	}
	
	public Course(CourseName name, int credit, String code, Vector<Teacher> instructors, Vector<Student> students, Vector<Lesson> lessons) {
		this(name, credit, code, instructors, students);
		this.lessons = lessons;
	}
	
	public CourseName getName() {
		return name;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public String getCode() {
		return code;
	}
	
	public Vector<Teacher> getInstructors(){
		return instructors;
	}
	
	public Vector<Student> getStudents(){
		return students;
	}
	
	public Vector<Lesson> getLessons() {
		return lessons;
	}
	
	void setName1(String name1) {
		this.name1 = name1;
	}
	
	void setName(CourseName name) {
		this.name = name;
	}
	
	void setCredit(int credit) {
		this.credit = credit;
	}
	
	void setCode(String code) {
		this.code = code;
	}
	
	void setInstructors(Vector<Teacher> instructors) {
		this.instructors = instructors;
	}
	
	void setStudents(Vector<Student> students) {
		this.students = students;
	}
	
	public void setLessons(Vector<Lesson> lessons) {
		this.lessons = lessons;
	}
	
	public boolean addStudent(Student student) {
		if(students.contains(student)) return false;
		students.add(student);
		return true;
	}
	
	public boolean addInstructor(Teacher teacher) {
		if(instructors.contains(teacher)) return false;
		instructors.add(teacher);
		return true;
	}
	
	public int hashCode() {
		return Objects.hash(name, credit, code, instructors, students);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Course other = (Course) obj;
		return credit == other.credit && Objects.equals(name, other.name) && Objects.equals(instructors, other.instructors)
				&& Objects.equals(students, other.students);
	}
	
	public String toString() {
		return "Course [name=" + name + ", credit=" + credit + ", code=" + code + ", instructors=" + instructors + 
				", students=" + students + "]";
	}
	
}
