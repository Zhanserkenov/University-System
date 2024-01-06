package main;

import java.time.LocalDate;
import java.util.*;

public abstract class Employee extends User {
	private static final long serialVersionUID = 1L;
	
	private LocalDate hireDate;
	private int salary;
	private int workExperience;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String surname) {
    	super(name, surname);
    }
	
	public Employee(String name, String surname, LocalDate hireDate, int salary, int workExperience) {
    	this(name, surname);
    	this.hireDate = hireDate;
    	this.salary = salary;
    	this.workExperience = workExperience;
    }
	
	public LocalDate getHireDate() {
		return hireDate;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public double getWorkExperience() {
		return workExperience;
	}
	
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}  
	
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}
	
	public int compareTo(Object obj) {
		Employee other = (Employee) obj;
		if(getSalary() > other.getSalary()) return 1;
		if(getSalary() < other.getSalary()) return -1;
		return 0;
	}
	
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Employee other = (Employee) obj;
		return workExperience == other.workExperience && salary == other.salary && Objects.equals(hireDate, other.hireDate);
	}
	
	public String toString() {
	    return "Employee{" +
	            super.toString() + 
	            ", hireDate=" + hireDate +
	            ", salary=" + salary +
	            ", workExperience=" + workExperience +
	            '}';
	}
	
}
