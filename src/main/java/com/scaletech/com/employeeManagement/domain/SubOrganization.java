package com.scaletech.com.employeeManagement.domain;

import java.io.Serializable;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@DynamicUpdate
@Table(name = "TBLSubOrganization")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SubOrganization implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4085453605183290L;

	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SubOrganizationID", nullable = false)
	private Long identifier;

	@JsonProperty("subOrganizationName")
	@Column(name = "SubOrganizationName", nullable = false)
	private String subOrganizationName;

	@ManyToOne(fetch= FetchType.LAZY)
	@JsonIgnoreProperties("")
	@JoinColumn(name = "OrganizationID")
	private Organization organization;

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getSubOrganizationName() {
		return subOrganizationName;
	}

	public void setSubOrganizationName(String subOrganizationName) {
		this.subOrganizationName = subOrganizationName;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}
