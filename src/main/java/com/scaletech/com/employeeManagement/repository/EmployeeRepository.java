package com.scaletech.com.employeeManagement.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scaletech.com.employeeManagement.domain.Department;
import com.scaletech.com.employeeManagement.domain.Employee;
import com.scaletech.com.employeeManagement.domain.Role;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e.identifier FROM Employee e WHERE e.role = :role")
	Set<Long> getEmployeeByRoleId(@Param("role") Role role);
	
	@Query("SELECT e.identifier FROM Employee e WHERE e.department = :department")
	Set<Long> getEmployeeByDepartmentId(@Param("department") Department department);
	
}
