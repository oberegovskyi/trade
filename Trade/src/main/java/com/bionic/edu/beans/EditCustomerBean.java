package com.bionic.edu.beans;

import java.util.List;

import javax.inject.Named;

import com.bionic.edu.Customer;

@Named("editCustomer")
public class EditCustomerBean {
	private Customer temp;
	private List<Customer> list;

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

}
