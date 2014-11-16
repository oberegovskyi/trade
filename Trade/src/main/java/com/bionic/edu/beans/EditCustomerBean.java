package com.bionic.edu.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.bionic.edu.entity.Customer;

@ManagedBean(name = "editCustomer")
public class EditCustomerBean {
	private Customer temp;
	private List<Customer> list = new ArrayList<>(Arrays.asList(
			new Customer(1, "ffdgfdgfdg", "fdgfdgfdgfd", "fdgfdg", "fdgfdg","fgdfgfdg", 90, 0), 
			new Customer(2, "gt5t", "4er", "dsfsdf", "fgfgfdg", "sdfdsfds", 10, 0)));

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
