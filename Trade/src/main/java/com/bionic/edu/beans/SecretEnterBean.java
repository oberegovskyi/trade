package com.bionic.edu.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.Employee;
import com.bionic.edu.services.SecurityOfficerService;

@Named("secretBean")
@Scope("session")
public class SecretEnterBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String login ;
	private String password;
	private Employee employee;
	private boolean logged;
	private String role;
	
	@Inject
	private SecurityOfficerService securityOfficerService;
	
	
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
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public boolean isLogged() {
		return logged;
	}
	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public void check() {
		employee = securityOfficerService.checkLoginPassword(login, password);
		FacesContext context = FacesContext.getCurrentInstance();
		if (employee == null) {
			setLogged(false);
			context.addMessage(":secretEnterForm:growl", new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Помилка",
					"Введений логін або пароль невірні"));
		} else {
			if (employee.getBlocked() == 0) {
				setLogged(true);
				context.addMessage(":secretEnterForm:growl", new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Успішно",
						"Ласкаво просимо, " + employee.getLogin()));
				switch (employee.getLevel()) {
				case 1: setRole("acc");break;
				case 2: setRole("cold");break;
				case 3: setRole("general");break;
				case 4: setRole("security");break;
				default: setRole(null);
				}

			} else {
				setLogged(false);
				context.addMessage(":secretEnterForm:growl", new FacesMessage(
						FacesMessage.SEVERITY_FATAL, "Увага", employee.getLogin() + " заблокований!"));
			}
		}
	}
	
	public String logOut() {
		setLogged(false);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(":formNavigator:growl", new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Увага", login+", Ви вийшли з системи"));
		employee=null;
		setRole(null);
		setLogin(null);
		return "index";
	}
	
}
