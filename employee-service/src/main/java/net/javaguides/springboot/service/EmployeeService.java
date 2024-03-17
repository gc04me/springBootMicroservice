package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.entity.APIResponse;
import net.javaguides.springboot.entity.Employee;

public interface EmployeeService {
   
	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

	APIResponse findEmployeeById(Long id);
}
