package com.bionic.edu.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="customer")
@RequestScoped
public class CustomerBean
{
	private String login;
	private String password;
	private String fName;
	private String sName;
	private String email;

	public CustomerBean () {
		
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
	@Override
	public String toString() {
		return "CustomerBean [login=" + login + ", password=" + password
				+ ", fName=" + fName + ", sName=" + sName + ", email=" + email
				+ "]";
	}
	
}
