package com.scaletech.com.employeeManagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaletech.com.employeeManagement.domain.Organization;
import com.scaletech.com.employeeManagement.domain.SubOrganization;
import com.scaletech.com.employeeManagement.repository.OrganizationRepository;
import com.scaletech.com.employeeManagement.repository.SubOrganizationRepository;
import com.scaletech.com.employeeManagement.service.SubOrganizationService;

@Service
public class SubOrganizationServiceImpl implements SubOrganizationService {

	@Autowired
	private SubOrganizationRepository subOrganizationRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public SubOrganization create(SubOrganization subOrganizations) {
		subOrganizations = subOrganizationRepository.save(subOrganizations);
		Optional<Organization> optional = organizationRepository.findById(subOrganizations.getOrganization().getIdentifier());
		if(optional.isPresent()) {
			subOrganizations.setOrganization(optional.get());
		}
		return subOrganizations;
	}

	@Override
	public List<SubOrganization> getAll() {
		return subOrganizationRepository.findAll();
	}

	@Override
	public SubOrganization getById(Long id) {
		Optional<SubOrganization> optional = subOrganizationRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
