package com.scaletech.com.employeeManagement.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBLOrganization")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Organization implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrganizationID", nullable = false)
	private Long identifier;

	@JsonProperty("organizationName")
	@Column(name = "OrganizationName", nullable = false)
	private String organizationName;

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

}
