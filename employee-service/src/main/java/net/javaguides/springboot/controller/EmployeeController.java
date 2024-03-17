package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.APIResponse;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.service.EmployeeService;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		Employee createdEmployee = employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(createdEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		List<Employee> employees=  employeeService.getAllEmployees();
		return employees;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<APIResponse> getEmployeeById(@PathVariable Long id){
		APIResponse employees=  employeeService.findEmployeeById(id);
		return ResponseEntity.ok(employees);
	}
	
}
