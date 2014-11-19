package com.bionic.edu.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.services.CustomerService;

@SuppressWarnings("serial")
@Named("userBean")
@Scope("session")
public class ActiveUserBean implements Serializable{
	private String login="login";
	private String password;
	private boolean logged;
	private Customer customer =null;
	@Inject
	private CustomerService customerService;

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
			return logged;
	}
	public String logOut() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Успішно",login+" ,ви вийшли з системи"));
		setLogged(false);
		customer=null;
		return "index";
	}
	
	public void check () {
		password=DigestUtils.md5Hex(password);
		customer = customerService.checkLoginPassword(login, password);
		FacesContext context = FacesContext.getCurrentInstance();
		if (customer == null) {
			setLogged(false);
			context.addMessage(null, new FacesMessage("Помилка","Введений логін або пароль невірні"));
		} else {
			if (customer.getBlocked()==0) {
				setLogged(true);
				context.addMessage(null, new FacesMessage("Успішно", "Ласкаво просимо, "+customer.getLogin()));
			}else {
				setLogged(false);
				context.addMessage(null, new FacesMessage("Увага", "Користувач "+customer.getLogin()+ " заблокований!"));
			}
			
		}
		password=null;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	
}
