package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.bionic.edu.Customer;
import com.bionic.edu.SecurityOfficerService;

@SuppressWarnings("serial")
@Named("editCustomer")
public class EditCustomerBean implements Serializable {
	
	@Inject
	private SecurityOfficerService securityOfficerService;

	private Customer temp;
	
	private List<Customer> list ;
	
	public EditCustomerBean () {
		
	}

	
	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	public Customer getTemp() {
		return temp;
	}

	public void setTemp(Customer temp) {
		this.temp = temp;
	}
	
	@PostConstruct
	public void init() {
        this.list = securityOfficerService.getAllCustomers();
    }
	
	public String saveCustomer () {
		securityOfficerService.saveCustomer(temp);
		return "editCustomer";
	}

}
