package com.bionic.edu;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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
