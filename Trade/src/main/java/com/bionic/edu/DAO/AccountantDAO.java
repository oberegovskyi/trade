package com.bionic.edu.DAO;

import java.util.List;

import com.bionic.edu.entities.OutParcel;


public interface AccountantDAO {
	public void setAvailable (OutParcel outParcel);
	public List<OutParcel> getNotAv ();
}
