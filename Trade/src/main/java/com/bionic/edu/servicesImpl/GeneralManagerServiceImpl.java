package com.bionic.edu.servicesImpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public void addNewInParcel(InParcel inParcel) {
		generalManagerDAO.addNewInParcel(inParcel);
	}

	@Transactional
	public void addNewFishItem(FishItem fishItem) {
		generalManagerDAO.addNewFishItem(fishItem);
	}

	@Transactional
	public void saveFishItem(FishItem fishItem) {
		generalManagerDAO.saveFishItem(fishItem);
	}

	@Transactional
	public void setFishUnsaled(FishItem fishItem) {
		generalManagerDAO.setFishUnsaled(fishItem);
	}

	@Transactional
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
	
	public List <FishItem> getAllFishItemsInParcel (InParcel inParcel) {
		return generalManagerDAO.getAllFishItemsInParcel(inParcel);
	}
	@Transactional
	public void saveInParcel (InParcel inParcel) {
		generalManagerDAO.saveInParcel(inParcel);
	}
}
