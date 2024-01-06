package main;

import java.time.LocalTime;
import java.util.Vector;

public class Lesson {
	
	private TypeLesson type;
	private Teacher teacher;
	private LocalTime time;
	private Vector<Student> students = new Vector<Student>();
	
	public Lesson() {
    	
    }
	
    public Lesson(TypeLesson type) {
    	this.type = type;
    }
    
    public Lesson(TypeLesson type, LocalTime time) {
    	this(type);
    	this.time = time;
    }
    
    public Lesson(TypeLesson type, LocalTime time, Teacher teacher, Vector<Student> students) {
    	this(type, time);
    	this.teacher = teacher;
    	this.students = students;
    }
    
    public TypeLesson getType() {
		return type;
	}
    
    public Teacher getTeacher() {
		return teacher;
	}
    
    public LocalTime getTime() {
		return time;
	}
    
    public Vector<Student> getStudents() {
		return students;
	}
    
    public void setType(TypeLesson type) {
		this.type = type;
	}
    
    public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
    
    public void setTime(LocalTime time) {
		this.time = time;
	}
    
    public void setStudents(Vector<Student> students) {
		this.students = students;
	}
    
    public String toString() {
        return "Lesson{" +
                "type=" + type +
                ", teacher=" + teacher +
                ", time=" + time +
                ", students=" + students +
                '}';
    }
	
}
