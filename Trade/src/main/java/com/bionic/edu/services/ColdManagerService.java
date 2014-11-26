package com.bionic.edu.services;

import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;
import com.bionic.edu.entities.OutParcel;


public interface ColdManagerService {
	public void saveCameWeightDate (FishItem fishItem);
	public void updateOutParcel (OutParcel outParcel);
	public void setWriteOffFishItem (FishItem fishItem);
	public void updateInParcel (InParcel inParcel);
	
}
