package com.scaletech.com.employeeManagement.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaletech.com.employeeManagement.domain.Role;
import com.scaletech.com.employeeManagement.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping("/role")
	public ResponseEntity<Role> createRoles(@RequestBody Role role) throws URISyntaxException {
		return ResponseEntity.ok().body(roleService.create(role));
	}
	
	@PutMapping("/role")
	public ResponseEntity<Role> updateRoles(@RequestBody Role role) throws URISyntaxException {
		return ResponseEntity.ok().body(roleService.create(role));
	}

	@GetMapping("/role")
	public ResponseEntity<List<Role>> getAllroles() throws URISyntaxException {
		return ResponseEntity.ok().body(roleService.getAll());
	}
	
	@GetMapping("/role/{id}")
	public ResponseEntity<Role> getOnerole(@PathVariable Long id) throws URISyntaxException {
		return ResponseEntity.ok().body(roleService.getById(id));
	}
	
	@DeleteMapping("/role/{id}")
	public ResponseEntity<String> deleterole(@PathVariable Long id) throws URISyntaxException {
		roleService.delete(id);
		return ResponseEntity.ok().body("Role deleted successFully.");
	}
}
