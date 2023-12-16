package com.scaletech.com.employeeManagement.service;

import java.util.List;

import com.scaletech.com.employeeManagement.domain.Employee;

public interface EmployeeService {

	Employee create(Employee employee);
	
	List<Employee> getAll();
	
	Employee getById(Long id);
	
	void delete(Long id);
}
