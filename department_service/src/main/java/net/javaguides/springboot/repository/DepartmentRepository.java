package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	Department findByDepartmentCode(String departmentCode);
}
