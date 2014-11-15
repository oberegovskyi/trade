package com.bionic.edu;

public interface SecurityOfficerService {
	public void addNewEmployee(Employee employee);

	public void saveEmployee(Employee employee);

	public void blockEmployee(Employee employee);

	public void addNewCustomer(Customer customer);

	public void saveCustomer(Customer customer);

	public void blockCustomer(Customer customer);
}
