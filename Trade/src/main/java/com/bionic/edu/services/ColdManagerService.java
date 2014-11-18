package com.bionic.edu.services;

import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.OutParcel;


public interface ColdManagerService {
	public void saveCameWeightDate (FishItem fishItem);
	public void setTaken (OutParcel outParcel);
	public void setWriteOffFishItem (FishItem fishItem);
}
