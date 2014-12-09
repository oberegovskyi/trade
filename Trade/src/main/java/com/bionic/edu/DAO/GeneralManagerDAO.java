package com.bionic.edu.DAO;

import java.util.List;
import java.util.Map;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;
import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.entities.OutParcelItem;


public interface GeneralManagerDAO {
	public int addNewInParcel (InParcel inParcel);
	public void addNewFishItem (FishItem fishItem);
	public void saveFishItem (FishItem fishItem);
	public void setFishUnsaled (FishItem fishItem);
	public void saveCustomer (Customer customer);
	public double getFishIncomeReport (FishItem fishItem);
	public double getFishSumReport (FishItem fishItem);
	public Map<java.sql.Date, Double> getFishWeightReport (FishItem fishItem, java.sql.Date date1, java.sql.Date date2);
	public List <FishItem> getAllFishItemsInParcel (InParcel inParcel);
	public void saveInParcel (InParcel inParcel) ;
	public InParcel getInParcel (int i) ;
	public List<OutParcel> getAllOutAvParcels () ;
	public Map<String, Double> getTotalFishReport(java.sql.Date date1, java.sql.Date date2);
	
}
