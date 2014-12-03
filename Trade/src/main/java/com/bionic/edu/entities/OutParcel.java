package com.bionic.edu.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Entity
public class OutParcel implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int outParcelId;
	private Date outParcelDate;
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	private double payed;
	private int taken;
	private int available;
	@ManyToMany()
	@JoinTable(name="outParcelItem", joinColumns=@JoinColumn(name="outParcelId"),
	   inverseJoinColumns=@JoinColumn(name="fishItemId"))
	private Collection<FishItem> fishItems;
	
	public OutParcel () {
		
	}

	public OutParcel(Date outParcelDate, Customer customer, int payed,
			int taken, int available) {
		super();
		this.outParcelDate = outParcelDate;
		this.customer = customer;
		this.payed = payed;
		this.taken = taken;
		this.available = available;
	}

	public int getOutParcelId() {
		return outParcelId;
	}

	public void setOutParcelId(int outParcelId) {
		this.outParcelId = outParcelId;
	}

	public Date getOutParcelDate() {
		return outParcelDate;
	}

	public void setOutParcelDate(Date outParcelDate) {
		this.outParcelDate = outParcelDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getPayed() {
		return payed;
	}

	public void setPayed(double payed) {
		this.payed = payed;
	}

	public int getTaken() {
		return taken;
	}

	public void setTaken(int taken) {
		this.taken = taken;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public Collection<FishItem> getFishItems() {
		return fishItems;
	}

	public void setFishItems(Collection<FishItem> fishItems) {
		this.fishItems = fishItems;
	}

	public List<String> getFishItemsId () {
		List<String> temp = new ArrayList<String>();
		for (FishItem oo : fishItems) {
			temp.add(oo.getFishItemId()+"");
		}
		return temp;
	}
	@Override
	public String toString() {
		return "OutParcel [outParcelId=" + outParcelId + ", outParcelDate="
				+ outParcelDate + ", customerId=" + customer.getCustomerId() + ", payed=" + payed
				+ ", taken=" + taken + ", available=" + available + ", fishItems=" +getFishItemsId()+"]";
	}

}