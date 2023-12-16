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

import com.scaletech.com.employeeManagement.domain.Employee;
import com.scaletech.com.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployees(@RequestBody Employee Employee){
		return ResponseEntity.ok().body(employeeService.create(Employee));
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployees(@RequestBody Employee Employee){
		return ResponseEntity.ok().body(employeeService.create(Employee));
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() throws URISyntaxException {
		return ResponseEntity.ok().body(employeeService.getAll());
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable Long id) throws URISyntaxException {
		return ResponseEntity.ok().body(employeeService.getById(id));
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) throws URISyntaxException {
		employeeService.delete(id);
		return ResponseEntity.ok().body("Employee deleted successFully.");
	}
}
