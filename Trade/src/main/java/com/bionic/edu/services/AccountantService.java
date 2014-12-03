package com.bionic.edu.services;

import java.util.List;

import com.bionic.edu.entities.OutParcel;


public interface AccountantService {
	public void setAvailable (OutParcel outParcel);
	public List<OutParcel> getNotAv();
}
