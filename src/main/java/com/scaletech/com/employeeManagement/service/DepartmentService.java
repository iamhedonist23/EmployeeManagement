package com.scaletech.com.employeeManagement.service;

import java.util.List;

import com.scaletech.com.employeeManagement.domain.Department;

public interface DepartmentService {

	Department create(Department department);
	
	List<Department> getAll();
	
	Department getById(Long id);
	
	void delete(Long id);
}
