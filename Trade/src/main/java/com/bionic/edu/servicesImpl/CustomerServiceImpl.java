package com.bionic.edu.servicesImpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.DAO.CustomerDAO;
import com.bionic.edu.entities.Customer;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;
import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.entities.OutParcelItem;
import com.bionic.edu.services.CustomerService;

@Named
public class CustomerServiceImpl implements CustomerService {
	@Inject
	private CustomerDAO customerDAO;
	
	public CustomerServiceImpl () {
		
	}

	public List<FishItem> getAllAvailableFishItems() {
		return customerDAO.getAllAvailableFishItems();
	}

	@Transactional
	public void addFishToParcelItem(OutParcelItem temp) {
		customerDAO.addFishToParcelItem(temp);
	}

	@Transactional
	public void addCustomer(Customer temp) {
		customerDAO.addCustomer(temp);
	}

	@Transactional
	public void deleteFishItem(OutParcelItem temp) {
		customerDAO.deleteFishItem(temp);
	}

	@Transactional
	public void saveOutParcelItem(OutParcelItem temp) {
		customerDAO.saveOutParcelItem(temp);
	}

	public double getAllWeightOfParcel(OutParcelItem temp) {
		return customerDAO.getAllWeightOfParcel(temp);
	}

	public double getPriceOfParcel(OutParcel temp) {
		return customerDAO.getPriceOfParcel(temp);
	}
	
	public List <InParcel> getAllInParcels () {
		return customerDAO.getAllInParcels();
	}
	
	public Customer checkLoginPassword (String login, String password) {
		return customerDAO.checkLoginPassword(login, password);
	}
	
	@Transactional
	public void addOutParcelWithItems(OutParcel temp, List<OutParcelItem> items) {
		customerDAO.addOutParcelWithItems(temp, items);
	}
	
	public List<OutParcel> getOutParcels(Customer customer) {
		return customerDAO.getOutParcels(customer);
	}
	
	public List<OutParcelItem> getOutParcelItems (OutParcel outParcel) {
		return customerDAO.getOutParcelItems(outParcel);
	}
}
