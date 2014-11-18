package com.bionic.edu.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.services.SecurityOfficerService;

@Named("addCustomer")
@Scope("request")
public class AddCustomerBean {
	private String login;
	private String password;
	private String fName;
	private String sName;
	private String email;
	private Customer cust;
	@Inject
	private SecurityOfficerService securityOfficerService;

	public AddCustomerBean() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String addCustomer() {
		password=DigestUtils.md5Hex(password);
		cust = new Customer(login, password, fName, sName, email, 100, 0);
		securityOfficerService.addNewCustomer(cust);

		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Успішно",
				"Додано нового користувача:" + login));
		login = null;
		password = null;
		fName = null;
		sName = null;
		email = null;
		return "addCustomer";
	}

}
