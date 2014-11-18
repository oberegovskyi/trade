package com.bionic.edu.servicesImpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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

	public void addFishToParcelItem(OutParcelItem temp) {
		customerDAO.addFishToParcelItem(temp);
	}

	public void addCustomer(Customer temp) {
		customerDAO.addCustomer(temp);
	}

	public void deleteFishItem(OutParcelItem temp) {
		customerDAO.deleteFishItem(temp);
	}

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
}
