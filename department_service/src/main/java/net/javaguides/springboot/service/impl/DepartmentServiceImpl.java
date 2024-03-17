package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entity.Department;
import net.javaguides.springboot.repository.DepartmentRepository;
import net.javaguides.springboot.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department createUser(Department department) {
		Department dep = departmentRepository.save(department);
		return dep;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> allResult = departmentRepository.findAll();
		return allResult;
	}

	@Override
	public Department getDepartmentByCode(String departmentCode) {
		Department dep = departmentRepository.findByDepartmentCode(departmentCode);
		return dep;
	}

}
