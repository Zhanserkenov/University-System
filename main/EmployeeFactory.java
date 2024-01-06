package main;

public class EmployeeFactory {
	public Employee getEmployee(String employeeType) {
		if (employeeType == null) {
			return null;
		}
		if (employeeType.equalsIgnoreCase("TEACHER")) {
			return new Teacher();
		}
		if (employeeType.equalsIgnoreCase("MANAGER")) {
			return new Manager();
		}
		
		return null;
	}
}
