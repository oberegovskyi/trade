package com.bionic.edu;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SecurityOfficerServiceImpl implements SecurityOfficerService {
	@Inject
	private SecurityOfficerDAO securityOfficerDAO;
	
	public SecurityOfficerServiceImpl () {
		
	}
	public void addNewEmployee(Employee employee) {
		securityOfficerDAO.addNewEmployee(employee);
	}

	public void saveEmployee(Employee employee) {
		securityOfficerDAO.saveEmployee(employee);
	}

	public void blockEmployee(Employee employee) {
		securityOfficerDAO.blockEmployee(employee);
	}

	public void addNewCustomer(Customer customer) {
		securityOfficerDAO.addNewCustomer(customer);
	}

	public void saveCustomer(Customer customer) {
		securityOfficerDAO.saveCustomer(customer);
	}

	public void blockCustomer(Customer customer) {
		securityOfficerDAO.blockCustomer(customer);
	}
	
	public List<Customer> getAllCustomers() {
		return securityOfficerDAO.getAllCustomers();
	}
}
