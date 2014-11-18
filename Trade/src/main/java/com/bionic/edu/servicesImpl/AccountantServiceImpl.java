package com.bionic.edu.servicesImpl;

import javax.inject.Inject;
import javax.inject.Named;

import com.bionic.edu.DAO.AccountantDAO;
import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.services.AccountantService;

@Named
public class AccountantServiceImpl implements AccountantService {
	@Inject
	private AccountantDAO accountantDAO;
	
	public AccountantServiceImpl () {
		
	}

	public void setAvailable(OutParcel outParcel) {
		accountantDAO.setAvailable(outParcel);
	}
}
