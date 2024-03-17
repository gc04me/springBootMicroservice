package net.javaguides.springboot.entity;

public class APIResponse {
	
	
	private Employee employee;
	private Department department;
	public APIResponse(Employee employee, Department department) {
		super();
		this.employee = employee;
		this.department = department;
	}
	public APIResponse() {
		super();
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	

}
