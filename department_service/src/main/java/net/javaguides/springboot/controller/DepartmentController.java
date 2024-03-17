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
import net.javaguides.springboot.entity.Department;
import net.javaguides.springboot.service.DepartmentService;

@RestController
@AllArgsConstructor
@RequestMapping("api/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		Department createUser = departmentService.createUser(department); 
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Department> getDepartment(){
		return departmentService.getDepartments();
	}
	
	@GetMapping("{departmentCode}")
	public ResponseEntity<Department> getDepartmentByCode(@PathVariable String departmentCode){
		Department departmentByCode = departmentService.getDepartmentByCode(departmentCode);
		return  ResponseEntity.ok(departmentByCode);
	}
	
	
}
