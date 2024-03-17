package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.javaguides.springboot.entity.APIResponse;
import net.javaguides.springboot.entity.Department;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Employee createEmployee(Employee employee) {
		Employee save = repository.save(employee);
		return save;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = repository.findAll();
		return allEmployees;
	}

	@Override
	public APIResponse findEmployeeById(Long id) {
		Employee employee = repository.findById(id).get();
	 	ResponseEntity<Department> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/" + employee.getDepartmentCode(),
				Department.class);
	 	
	 	Department department = responseEntity.getBody();
	 	
	 	APIResponse apiResponse= new APIResponse();
	 	apiResponse.setDepartment(department);
	 	apiResponse.setEmployee(employee);
	 	
		return apiResponse;
	}

}
