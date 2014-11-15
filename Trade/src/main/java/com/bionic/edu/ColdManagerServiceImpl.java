package com.bionic.edu;

import javax.inject.Inject;
import javax.inject.Named;


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
