package com.bionic.edu;

import javax.inject.Inject;
import javax.inject.Named;

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
