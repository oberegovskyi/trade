package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.entities.OutParcelItem;
import com.bionic.edu.services.CustomerService;

@SuppressWarnings("serial")
@Named("userBean")
@Scope("session")
public class ActiveUserBean implements Serializable {
	private String login = "login";
	private String password;
	private String passwordNew;
	private String password1;
	private String password2;
	private boolean logged;
	private Customer customer = null;

	private List<OutParcel> out;
	private OutParcel tempParcel;

	private List<OutParcelItem> outItemsList;

	private String role;
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

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public Customer getCustomer() {
		out = customerService.getOutParcels(customer);
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OutParcel> getOut() {
		return out;
	}

	public void setOut(List<OutParcel> out) {
		this.out = out;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public OutParcel getTempParcel() {
		return tempParcel;
	}

	public void setTempParcel(OutParcel tempParcel) {
		this.tempParcel = tempParcel;
		outItemsList = customerService.getOutParcelItems(tempParcel);
	}

	public List<OutParcelItem> getOutItemsList() {
		return outItemsList;
	}

	public void setOutItemsList(List<OutParcelItem> outItemsList) {
		this.outItemsList = outItemsList;
	}

	public String getPasswordNew() {
		return passwordNew;
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String logOut() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Успішно", login + " ,ви вийшли з системи"));
		setLogged(false);
		customer = null;
		setRole(null);
		return "index";
	}

	public String check() {
		password = DigestUtils.md5Hex(password);
		customer = customerService.checkLoginPassword(login, password);
		FacesContext context = FacesContext.getCurrentInstance();
		if (customer == null) {
			setLogged(false);
			context.addMessage(":formNavigator:growl", new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Помилка",
					"Введений логін або пароль невірні"));
		} else {
			if (customer.getBlocked() == 0) {
				setLogged(true);
				context.addMessage(":formNavigator:growl", new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Успішно",
						"Ласкаво просимо, " + customer.getLogin()));
				RequestContext.getCurrentInstance().execute(
						"PF('userDialog').hide();");
				out = customerService.getOutParcels(customer);
				setRole("customer");
				return "index";

			} else {
				setLogged(false);
				context.addMessage(":formNavigator:growl", new FacesMessage(
						FacesMessage.SEVERITY_FATAL, "Увага", "Користувач "
								+ customer.getLogin() + " заблокований!"));
				return "index";
			}
		}
		password = null;
		return "index";
	}

	public String updateUser() {
		customerService.updateCustomer(customer);
		System.out.println(customer);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(":myRoomForm:growlMyRoom",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Увага",
						"Користувач " + customer.getLogin()
								+ " успішно редагований!"));
		return "myRoom";
	}

	public String changePassword() {
		if (DigestUtils.md5Hex(passwordNew).equals(password)) {
			String newpass = DigestUtils.md5Hex(password1);
			customer.setPassword(newpass);
			customerService.updateCustomer(customer);
			setLogged(false);
			customer = null;
			setRole(null);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(":changePasswordForm:changegrowl",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Увага",
							"Пароль успішно змінено. Виконайте вхід в систему"));
			password=null;
			return "index";
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(":changePasswordForm:changegrowl",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Увага",
							"Старий пароль введено невірно"));
			return "changePassword";
		}

	}
}
