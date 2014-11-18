package com.bionic.edu.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Customer implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	private String login;
	private String password;
	private String fName;
	private String sName;
	private String email;
	private int payment;
	private int blocked;
	@OneToMany (mappedBy="customer", fetch=FetchType.EAGER)
	private Collection<OutParcel> outParcels;
	public Customer () {
		
	}
	public Customer(String login, String password, String fName, String sName,
			String email, int payment, int blocked) {
		super();
		this.login = login;
		this.password = password;
		this.fName = fName;
		this.sName = sName;
		this.email = email;
		this.payment = payment;
		this.blocked = blocked;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getBlocked() {
		return blocked;
	}
	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}
	public Collection<OutParcel> getOutParcels() {
		return outParcels;
	}
	public void setOutParcels(Collection<OutParcel> outParcels) {
		this.outParcels = outParcels;
	}
	public List<String> getOutParcelsId () {
		List<String> temp = new ArrayList<String>();
		for (OutParcel oo : outParcels) {
			temp.add(oo.getOutParcelId()+"");
		}
		return temp;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", login=" + login
				+ ", password=" + password + ", fName=" + fName + ", sName="
				+ sName + ", email=" + email + ", payment=" + payment
				+ ", blocked=" + blocked + ", outParcels=" + getOutParcelsId() + "]";
	}

	
}