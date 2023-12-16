package com.scaletech.com.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scaletech.com.employeeManagement.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
