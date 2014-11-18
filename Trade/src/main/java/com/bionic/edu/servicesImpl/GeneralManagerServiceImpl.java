package com.bionic.edu.servicesImpl;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.bionic.edu.DAO.GeneralManagerDAO;
import com.bionic.edu.entities.Customer;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;
import com.bionic.edu.services.GeneralManagerService;

@Named
public class GeneralManagerServiceImpl implements GeneralManagerService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private GeneralManagerDAO generalManagerDAO;
	
	public GeneralManagerServiceImpl () {
		
	}

	public void addNewInParcel(InParcel inParcel) {
		generalManagerDAO.addNewInParcel(inParcel);
	}

	public void addNewFishItem(FishItem fishItem) {
		generalManagerDAO.addNewFishItem(fishItem);
	}

	public void saveFishItem(FishItem fishItem) {
		generalManagerDAO.saveFishItem(fishItem);
	}

	public void setFishUnsaled(FishItem fishItem) {
		generalManagerDAO.setFishUnsaled(fishItem);
	}

	public void saveCustomer(Customer customer) {
		generalManagerDAO.saveCustomer(customer);
	}

	public double getFishIncomeReport(FishItem fishItem) {
		return generalManagerDAO.getFishIncomeReport(fishItem);
	}

	public double getFishSumReport(FishItem fishItem) {
		return generalManagerDAO.getFishSumReport(fishItem);
	}

	public double getFishWeightReport(FishItem fishItem) {
		return generalManagerDAO.getFishWeightReport(fishItem);
	}
}
