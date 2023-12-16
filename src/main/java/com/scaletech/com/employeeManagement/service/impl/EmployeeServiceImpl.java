package com.scaletech.com.employeeManagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaletech.com.employeeManagement.domain.Employee;
import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.EmailNotValidException;
import com.scaletech.com.employeeManagement.repository.DepartmentRepository;
import com.scaletech.com.employeeManagement.repository.EmployeeRepository;
import com.scaletech.com.employeeManagement.repository.RoleRepository;
import com.scaletech.com.employeeManagement.repository.SubOrganizationRepository;
import com.scaletech.com.employeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\\.[a-zA-Z]+$";
	private static final Pattern email_pattern = Pattern.compile(EMAIL_PATTERN);
	
	private static final String AGE_PATTERN = "^(1[89]|[2-9]\\d)$";
    private static final Pattern age_pattern = Pattern.compile(AGE_PATTERN);

    private static final String MOBILE_NUMBER_PATTERN = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    private static final Pattern mobile_pattern = Pattern.compile(MOBILE_NUMBER_PATTERN);


	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private SubOrganizationRepository subOrganizationRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Employee create(Employee employee) {
		
		validation(employee);
		
		employee = employeeRepository.save(employee);
		
		employee.setSubOrganization(
				subOrganizationRepository.findById(employee.getSubOrganization().getIdentifier()).get());
		employee.setDepartment(departmentRepository.findById(employee.getDepartment().getIdentifier()).get());
		employee.setRole(roleRepository.findById(employee.getRole().getIdentifier()).get());
		
		return employee;
	}
	
	private void validation(Employee employee) {
		
		if (!isValidInput(employee.getEmail(),email_pattern)) {
			throw new EmailNotValidException("Email Id is not valid");
		}

		if (!isValidInput(employee.getMobile(),mobile_pattern)) {
			throw new EmailNotValidException("Mobile Number is not valid");
		}

		if (!isValidInput(employee.getAge(),age_pattern)) {
			throw new EmailNotValidException("Age must be 18+");
		}
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getById(Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

	public static boolean isValidInput(String input,Pattern pattern) {
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

}
