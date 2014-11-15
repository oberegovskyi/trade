package com.bionic.edu;

import java.util.List;

public interface CustomerService {
	public List<FishItem> getAllAvailableFishItems();

	public void addFishToParcelItem(OutParcelItem temp);

	public void addCustomer(Customer temp);

	public void deleteFishItem(OutParcelItem temp);

	public void saveOutParcelItem(OutParcelItem temp);

	public double getAllWeightOfParcel(OutParcelItem temp);

	public double getPriceOfParcel(OutParcel temp);
}
