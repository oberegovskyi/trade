package com.bionic.edu.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("serial")
@ManagedBean(name = "userBean")
@SessionScoped
public class ActiveUserBean implements Serializable{
	private String login=null;
	private String password=null;

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

	public boolean isLogged() {
		if (login!=null && password!=null)
			return true;
		else
			return false;
	}
	public String logOut() {
		login=null;
		password=null;
		return "addCustomer";
	}
}
