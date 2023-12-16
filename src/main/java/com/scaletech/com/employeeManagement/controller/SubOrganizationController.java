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

import com.scaletech.com.employeeManagement.domain.SubOrganization;
import com.scaletech.com.employeeManagement.service.SubOrganizationService;

@RestController
@RequestMapping("/api")
public class SubOrganizationController {

	@Autowired
	private SubOrganizationService subOrganizationService;
	
	@PostMapping("/subOrganizations")
	public ResponseEntity<SubOrganization> createSubOrganizations(@RequestBody SubOrganization subOrganization) throws URISyntaxException {
		return ResponseEntity.ok().body(subOrganizationService.create(subOrganization));
	}

	@GetMapping("/subOrganizations")
	public ResponseEntity<List<SubOrganization>> getAllSubOrganizations() throws URISyntaxException {
		return ResponseEntity.ok().body(subOrganizationService.getAll());
	}
	
	@GetMapping("/subOrganizations/{id}")
	public ResponseEntity<SubOrganization> getAllSubOrganizations(@PathVariable Long id) throws URISyntaxException {
		return ResponseEntity.ok().body(subOrganizationService.getById(id));
	}
}
