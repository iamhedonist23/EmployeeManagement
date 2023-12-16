package com.scaletech.com.employeeManagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaletech.com.employeeManagement.domain.Employee;
import com.scaletech.com.employeeManagement.domain.Role;
import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.RoleAttachedAlreadyException;
import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.RoleIsNotExistException;
import com.scaletech.com.employeeManagement.repository.EmployeeRepository;
import com.scaletech.com.employeeManagement.repository.RoleRepository;
import com.scaletech.com.employeeManagement.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Role create(Role department) {
		return roleRepository.save(department);
	}

	@Override
	public List<Role> getAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role getById(Long id) {
		Optional<Role> optional = roleRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Role role = getById(id);
		if(role == null) {
			throw new RoleIsNotExistException("Role is not exist in system");
		}
		Set<Long> employeeList = employeeRepository.getEmployeeByRoleId(role);
		if(!employeeList.isEmpty()) {
			throw new RoleAttachedAlreadyException("Role Is Already binded with employee so first remove it and try again.");
		}
		roleRepository.deleteById(id);
	}
	
}
