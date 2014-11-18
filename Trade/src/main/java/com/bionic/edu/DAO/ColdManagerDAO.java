package com.bionic.edu.DAO;

import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.OutParcel;


public interface ColdManagerDAO {
	public void saveCameWeightDate (FishItem fishItem);
	public void setTaken (OutParcel outParcel);
	public void setWriteOffFishItem (FishItem fishItem);
}
