package com.scaletech.com.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scaletech.com.employeeManagement.domain.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
