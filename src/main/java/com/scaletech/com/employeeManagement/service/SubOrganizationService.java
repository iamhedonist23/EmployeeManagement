package com.scaletech.com.employeeManagement.service;

import java.util.List;

import com.scaletech.com.employeeManagement.domain.SubOrganization;

public interface SubOrganizationService {

	SubOrganization create(SubOrganization subOrganizations);
	
	List<SubOrganization> getAll();
	
	SubOrganization getById(Long id);
	
}
