package com.bionic.edu.servicesImpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.DAO.ColdManagerDAO;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;
import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.services.ColdManagerService;


@Named
public class ColdManagerServiceImpl implements ColdManagerService,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject 
	private ColdManagerDAO coldManagerDAO;
	
	public ColdManagerServiceImpl () {
		
	}
	@Transactional
	public void saveCameWeightDate (FishItem fishItem) {
		coldManagerDAO.saveCameWeightDate(fishItem);
	}
	@Transactional
	public void updateOutParcel (OutParcel outParcel) {
		coldManagerDAO.updateOutParcel(outParcel);
	}
	@Transactional
	public void setWriteOffFishItem (FishItem fishItem) {
		coldManagerDAO.setWriteOffFishItem(fishItem);
	}
	
	@Transactional
	public void updateInParcel (InParcel inParcel) {
		coldManagerDAO.updateInParcel(inParcel);
	}
	public List<FishItem> getSettedFishItems() {
		return coldManagerDAO.getSettedFishItems();
	}
}
