package com.scaletech.com.employeeManagement.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "TBLEmployee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeID", nullable = false)
	private Long identifier;

	@JsonProperty("employeeName")
	@Column(name = "EmployeeName", nullable = false)
	private String employeeName;

	@JsonProperty("email")
	@Column(name = "Email", nullable = false)
	private String email;

	@JsonProperty("mobile")
	@Column(name = "Mobile", nullable = false)
	private String mobile;

	@JsonProperty("age")
	@Column(name = "Age", nullable = false)
	private String age;

	@ManyToOne
	@JsonIgnoreProperties("")
	@JoinColumn(name = "SubOrganizationID")
	private SubOrganization subOrganization;
	
	@ManyToOne
	@JsonIgnoreProperties("")
	@JoinColumn(name = "DepartmentID")
	private Department department;

	@ManyToOne
	@JsonIgnoreProperties("")
	@JoinColumn(name = "RoleID")
	private Role role;

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public SubOrganization getSubOrganization() {
		return subOrganization;
	}

	public void setSubOrganization(SubOrganization subOrganization) {
		this.subOrganization = subOrganization;
	}

}
