package com.scaletech.com.employeeManagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaletech.com.employeeManagement.domain.Organization;
import com.scaletech.com.employeeManagement.repository.OrganizationRepository;
import com.scaletech.com.employeeManagement.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public Organization create(Organization organizations) {
		return organizationRepository.save(organizations);
	}

	@Override
	public List<Organization> getAll() {
		return organizationRepository.findAll();
	}

	@Override
	public Organization getById(Long id) {
		Optional<Organization> optional = organizationRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
