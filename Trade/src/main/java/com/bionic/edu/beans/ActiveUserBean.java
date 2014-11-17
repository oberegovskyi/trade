package com.bionic.edu.beans;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Named(value = "userBean")
@Scope("session")
public class ActiveUserBean implements Serializable{
	private String login;
	private String password;

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
		return "index";
	}
}
