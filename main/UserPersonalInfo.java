package main;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserPersonalInfo implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	
	private LocalDate birthDate;
	private String mobileNumber;
	private String nationality;
	private String maritalStatus;
	private String address;
	
	public UserPersonalInfo() {
		
	}
	
	public UserPersonalInfo(LocalDate birth, String mobileNumber, String nationality, String maritalStatus, String address) {
    	this.birthDate = birth;
    	this.mobileNumber = mobileNumber;
    	this.nationality = nationality;
    	this.maritalStatus = maritalStatus;
    	this.address = address;
    }
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public String mobileNumber() {
		return mobileNumber;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	public String getaddress() {
		return address;
	}
	
	public void setBirthDate(LocalDate birth) {
    	this.birthDate = birth;
    }
	
	public void setMobileNumber(String mobileNumber) {
    	this.mobileNumber = mobileNumber;
    }
	
	public void setNationality(String nationality) {
    	this.nationality = nationality;
    }
	
	public void setMaritalStatus(String maritalStatus) {
    	this.maritalStatus = maritalStatus;
    }
	
	public void setAddress(String address) {
    	this.address = address;
    }
	
	public int hashCode() {
		return Objects.hash(birthDate, mobileNumber, nationality, maritalStatus, address);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		UserPersonalInfo other = (UserPersonalInfo) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(mobileNumber, other.mobileNumber)
				&& Objects.equals(nationality, other.nationality) && Objects.equals(maritalStatus, other.maritalStatus)
				&& Objects.equals(address, other.address);
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	public String toString() {
	    return "UserPersonalInfo{" +
	            "birthDate=" + birthDate +
	            ", mobileNumber='" + mobileNumber + '\'' +
	            ", nationality='" + nationality + '\'' +
	            ", maritalStatus='" + maritalStatus + '\'' +
	            ", address='" + address + '\'' +
	            '}';
	}
	
}
