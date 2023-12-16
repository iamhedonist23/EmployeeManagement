package com.scaletech.com.employeeManagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaletech.com.employeeManagement.domain.Department;
import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.DepartmentAttachedAlreadyException;
import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.DepartmentNotExistException;
import com.scaletech.com.employeeManagement.repository.DepartmentRepository;
import com.scaletech.com.employeeManagement.repository.EmployeeRepository;
import com.scaletech.com.employeeManagement.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Department create(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getById(Long id) {
		Optional<Department> optional = departmentRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {

		Department department = getById(id);

		if (department == null) {
			throw new DepartmentNotExistException("Department is not exist in system");
		}

		Set<Long> employeeList = employeeRepository.getEmployeeByDepartmentId(department);
		if (!employeeList.isEmpty()) {
			throw new DepartmentAttachedAlreadyException(
					"Department Is Already binded with employee so first remove it and try again.");
		}
		departmentRepository.deleteById(id);
	}

}
