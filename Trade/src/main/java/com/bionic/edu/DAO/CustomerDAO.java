package com.bionic.edu.DAO;

import java.util.List;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;
import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.entities.OutParcelItem;

public interface CustomerDAO {
	public List<FishItem> getAllAvailableFishItems();

	public void addFishToParcelItem(OutParcelItem temp);

	public void addCustomer(Customer temp);

	public void deleteFishItem(OutParcelItem temp);

	public void saveOutParcelItem(OutParcelItem temp);

	public double getAllWeightOfParcel(OutParcelItem temp);

	public double getPriceOfParcel(OutParcel temp);
	
	public List<InParcel> getAllInParcels ();
}