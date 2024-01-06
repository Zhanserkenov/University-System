package main;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class User implements Serializable, Cloneable, Comparable<Object> {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	private String login;
	private String password;
	private UserPersonalInfo personalInfo = new UserPersonalInfo();
	
	public User() {
    	
    }
	
	public User(String name, String surname) {
    	this.setName(name);
    	this.setSurname(surname);
    }
	
	public UserPersonalInfo getPersonalInfo() {
        return this.personalInfo;
    }
	
	public void setPersonalInfo(UserPersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }
	
	public void fillPersonalInfo(LocalDate birth, String mobileNumber, String nationality, String maritalStatus, String address) {
    	this.personalInfo.setBirthDate(birth);
    	this.personalInfo.setMobileNumber(mobileNumber);
    	this.personalInfo.setNationality(nationality);
    	this.personalInfo.setMaritalStatus(maritalStatus);
    	this.personalInfo.setAddress(address);
    }
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getLogin() {
        return this.login;
    }
	
	public String getPassword() {
        return this.password;
    }
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setLogin(String login) {
    	this.login = login;
    }
	
	public void setPassword(String password) {
    	this.password = password;
    }
	
    public void changePassword(String password) {
    	this.setPassword(password);
    }
    
    public int hashCode() {
		return Objects.hash(login, password, personalInfo);
	}
    
    public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		User other = (User) obj;
		return Objects.equals(login, other.login);
	}
    
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                "\n" + personalInfo +
                '}';
    }
	
}
