package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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

	@Inject
	private CustomerService customerService;

	public FishItem getTemp() {
		return temp;
	}

	public void setTemp(FishItem temp) {
		this.temp = temp;
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
		FishItem  tt = new FishItem();
		Cloner cloner = new Cloner();
		tt = (FishItem) cloner.deepCopy(temp);
		tt.setWeight(weight);
		orderList.add(tt);
		temp = null;
		weight=0;
		return "fishView";
	}
}
