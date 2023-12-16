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

import com.scaletech.com.employeeManagement.domain.Department;
import com.scaletech.com.employeeManagement.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/department")
	public ResponseEntity<Department> createDepartments(@RequestBody Department department) throws URISyntaxException {
		return ResponseEntity.ok().body(departmentService.create(department));
	}
	
	@PutMapping("/department")
	public ResponseEntity<Department> updateDepartments(@RequestBody Department department) throws URISyntaxException {
		return ResponseEntity.ok().body(departmentService.create(department));
	}

	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartments() throws URISyntaxException {
		return ResponseEntity.ok().body(departmentService.getAll());
	}
	
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getOneDepartment(@PathVariable Long id) throws URISyntaxException {
		return ResponseEntity.ok().body(departmentService.getById(id));
	}
	
	@DeleteMapping("/department/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id) throws URISyntaxException {
		departmentService.delete(id);
		return ResponseEntity.ok().body("Department deleted successFully.");
	}
}
