package com.scaletech.com.employeeManagement.service;

import java.util.List;

import com.scaletech.com.employeeManagement.domain.Organization;

public interface OrganizationService {

	Organization create(Organization organizations);
	
	List<Organization> getAll();
	
	Organization getById(Long id);
}
