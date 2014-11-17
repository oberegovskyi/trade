package com.bionic.edu;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

@Named
public class SecurityOfficerServiceImpl implements SecurityOfficerService {
	@Inject
	private SecurityOfficerDAO securityOfficerDAO;
	
	public SecurityOfficerServiceImpl () {
		
	}
	@Transactional
	public void addNewEmployee(Employee employee) {
		securityOfficerDAO.addNewEmployee(employee);
	}

	@Transactional
	public void saveEmployee(Employee employee) {
		securityOfficerDAO.saveEmployee(employee);
	}

	@Transactional
	public void blockEmployee(Employee employee) {
		securityOfficerDAO.blockEmployee(employee);
	}

	@Transactional
	public void addNewCustomer(Customer customer) {
		securityOfficerDAO.addNewCustomer(customer);
	}

	@Transactional
	public void saveCustomer(Customer customer) {
		securityOfficerDAO.saveCustomer(customer);
	}
	@Transactional
	public void blockCustomer(Customer customer) {
		securityOfficerDAO.blockCustomer(customer);
	}
	
	public List<Customer> getAllCustomers() {
		return securityOfficerDAO.getAllCustomers();
	}
}
