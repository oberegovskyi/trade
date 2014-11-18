package com.bionic.edu.servicesImpl;

import javax.inject.Inject;
import javax.inject.Named;

import com.bionic.edu.DAO.ColdManagerDAO;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.services.ColdManagerService;


@Named
public class ColdManagerServiceImpl implements ColdManagerService{
	@Inject 
	private ColdManagerDAO coldManagerDAO;
	
	public ColdManagerServiceImpl () {
		
	}
	public void saveCameWeightDate (FishItem fishItem) {
		coldManagerDAO.saveCameWeightDate(fishItem);
	}
	public void setTaken (OutParcel outParcel) {
		coldManagerDAO.setTaken(outParcel);
	}
	public void setWriteOffFishItem (FishItem fishItem) {
		coldManagerDAO.setWriteOffFishItem(fishItem);
	}
}
