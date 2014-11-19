package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.FishItem;
import com.bionic.edu.methods.Cloner;
import com.bionic.edu.services.CustomerService;

@Named("orderBean")
@Scope("session")
public class OrderBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<FishItem> availableList;
	private List<FishItem> orderList = new ArrayList<FishItem>();
	private double totalWeight;
	private double total;
	private double weight;

	private FishItem temp;
	private FishItem tempWork;
	
	private ActiveUserBean activeUser;

	@Inject
	private CustomerService customerService;

	public FishItem getTemp() {
		return temp;
	}

	public void setTemp(FishItem temp) {
		this.temp = temp;
		Cloner cloner = new Cloner();
		tempWork = (FishItem) cloner.deepCopy(temp);
		total=0;
		totalWeight=0;
		for (FishItem in : orderList) {
			totalWeight+=in.getWeight();
			total+=in.getWeight()*in.getSellPrice();
		}
	}

	public List<FishItem> getAvailableList() {
		return availableList;
	}

	public void setAvailableList(List<FishItem> availableList) {
		this.availableList = availableList;
	}

	public List<FishItem> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<FishItem> orderList) {
		this.orderList = orderList;
	}

	@PostConstruct
	public void init() {
		availableList = customerService.getAllAvailableFishItems();
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String addFishItemToList() {
		
		tempWork.setWeight(weight);
		orderList.add(tempWork);
		
		temp = null;
		weight=0;
		total=0;
		totalWeight=0;
		for (FishItem in : orderList) {
			totalWeight+=in.getWeight();
			total+=in.getWeight()*in.getSellPrice();
		}
		return "fishView";
	}
	
	public void deleteFishItem (FishItem ff) {
		orderList.remove(ff);
		total=0;
		totalWeight=0;
		for (FishItem in : orderList) {
			totalWeight+=in.getWeight();
			total+=in.getWeight()*in.getSellPrice();
		}
	}
	
	public double countPrice(FishItem fish) {
		return fish.getSellPrice()*fish.getWeight();
	}
	
	public String preSubmitOrder () {
		System.out.println(activeUser);
		if (activeUser==null ) {
			return "addCustomer";
		} else {
			return "fishView";
		}
	}
}
