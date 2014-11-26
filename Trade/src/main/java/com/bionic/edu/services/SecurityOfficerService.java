package com.bionic.edu.services;

import java.util.List;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.entities.Employee;

public interface SecurityOfficerService {
	public void addNewEmployee(Employee employee);

	public void saveEmployee(Employee employee);

	public void blockEmployee(Employee employee);

	public void addNewCustomer(Customer customer);

	public void saveCustomer(Customer customer);

	public void blockCustomer(Customer customer);

	public void unBlockCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Employee checkLoginPassword(String login, String password);
}
