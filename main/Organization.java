package main;

import java.util.Objects;
import java.util.Vector;

public class Organization {
	
	private OrganizationName name;
	private Student head;
	private Vector<Student> members;
	
	public Organization(){
		   
    }
	
	public Organization(OrganizationName name, Student head) {
    	this.name = name;
    	this.head = head;
    }
    public Organization(OrganizationName name, Student head, Vector<Student> members) {
    	this(name, head);
    	this.members = members;
    }
    
    public OrganizationName getName() {
        return this.name;
    }
    
    public Student getHead() {
        return this.head;
    }
    
    public Vector<Student> getMembers() {
        return this.members;
    }
    
    public void setTitle(OrganizationName name) {
        this.name = name;
    }
    
    public void setHead(Student head) {
        this.head = head;
    } 
    
    public void setMembers(Vector<Student> members) {
        this.members = members;
    }
    
    public boolean addMember(Student s) {
    	if(members.contains(s))
    		return false;
    	
    	members.add(s);
    	return true;
    }
    
    public int hashCode() {
		return Objects.hash(head, members, name);
	}
    
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Organization other = (Organization) obj;
		return this.name == other.name;
		
	}
	
	public String toString() {
	    return "Organization{" +
	            "name=" + name +
	            ", head=" + head +
	            ", members=" + members +
	            '}';
	}
	
}
