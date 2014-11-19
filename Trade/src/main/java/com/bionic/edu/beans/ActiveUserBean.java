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
public class ActiveUserBean implements Serializable{
	private String login="login";
	private String password;
	private boolean logged;
	private Customer customer =null;
	
	private List <OutParcel> out;
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
		out =  customerService.getOutParcels(customer);
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
		outItemsList=customerService.getOutParcelItems(tempParcel);
	}

	public List<OutParcelItem> getOutItemsList() {
		return outItemsList;
	}

	public void setOutItemsList(List<OutParcelItem> outItemsList) {
		this.outItemsList = outItemsList;
	}

	public String logOut() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Успішно",login+" ,ви вийшли з системи"));
		setLogged(false);
		customer=null;
		setRole(null);
		return "index";
	}
	
	public String check () {
		password=DigestUtils.md5Hex(password);
		customer = customerService.checkLoginPassword(login, password);
		FacesContext context = FacesContext.getCurrentInstance();
		if (customer == null) {
			setLogged(false);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Помилка","Введений логін або пароль невірні"));
		} else {
			if (customer.getBlocked()==0) {
				setLogged(true);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Успішно", "Ласкаво просимо, "+customer.getLogin()));
				RequestContext.getCurrentInstance().execute("PF('userDialog').hide();");
				out= customerService.getOutParcels(customer);
				setRole("customer");
				return "myRoom";
				
				
			}else {
				setLogged(false);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Увага", "Користувач "+customer.getLogin()+ " заблокований!"));
				return "index";
			}			
		}
		password=null;
		return "index";
	}

		
}
