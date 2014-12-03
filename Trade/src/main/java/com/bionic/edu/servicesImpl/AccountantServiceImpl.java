package com.bionic.edu.servicesImpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.DAO.AccountantDAO;
import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.services.AccountantService;

@Named
public class AccountantServiceImpl implements AccountantService, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private AccountantDAO accountantDAO;
	
	public AccountantServiceImpl () {
		
	}

	@Transactional
	public void setAvailable(OutParcel outParcel) {
		accountantDAO.setAvailable(outParcel);
	}
	
	@Transactional
	public List<OutParcel> getNotAv() {
		return accountantDAO.getNotAv();
	}
}
