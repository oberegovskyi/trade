package com.bionic.edu.DAO;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;


public interface GeneralManagerDAO {
	public void addNewInParcel (InParcel inParcel);
	public void addNewFishItem (FishItem fishItem);
	public void saveFishItem (FishItem fishItem);
	public void setFishUnsaled (FishItem fishItem);
	public void saveCustomer (Customer customer);
	public double getFishIncomeReport (FishItem fishItem);
	public double getFishSumReport (FishItem fishItem);
	public double getFishWeightReport (FishItem fishItem);	
}
