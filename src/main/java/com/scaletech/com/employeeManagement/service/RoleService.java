package com.scaletech.com.employeeManagement.service;

import java.util.List;

import com.scaletech.com.employeeManagement.domain.Role;

public interface RoleService {

	Role create(Role role);
	
	List<Role> getAll();
	
	Role getById(Long id);
	
	void delete(Long id);
}
