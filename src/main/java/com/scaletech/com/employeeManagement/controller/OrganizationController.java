package com.scaletech.com.employeeManagement.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaletech.com.employeeManagement.domain.Organization;
import com.scaletech.com.employeeManagement.service.OrganizationService;

@RestController
@RequestMapping("/api")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	
	@PostMapping("/organizations")
	public ResponseEntity<Organization> createOrganizations(@RequestBody Organization organization) throws URISyntaxException {
		return ResponseEntity.ok().body(organizationService.create(organization));
	}

	@GetMapping("/organizations")
	public ResponseEntity<List<Organization>> getAllOrganizations() throws URISyntaxException {
		return ResponseEntity.ok().body(organizationService.getAll());
	}
	
	@GetMapping("/organizations/{id}")
	public ResponseEntity<Organization> getAllOrganizations(@PathVariable Long id) throws URISyntaxException {
		return ResponseEntity.ok().body(organizationService.getById(id));
	}
}
