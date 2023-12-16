package com.scaletech.com.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scaletech.com.employeeManagement.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
