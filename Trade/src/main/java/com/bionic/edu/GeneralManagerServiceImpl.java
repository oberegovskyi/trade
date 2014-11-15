package com.bionic.edu;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GeneralManagerServiceImpl implements GeneralManagerService {
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
