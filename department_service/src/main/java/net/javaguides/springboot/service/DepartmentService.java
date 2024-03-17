package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.entity.Department;

public interface DepartmentService {
    Department createUser(Department department);
    
	List<Department> getDepartments();

	Department getDepartmentByCode(String code);

	
}
