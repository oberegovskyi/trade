package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.bionic.edu.entity.FishItem;


@SuppressWarnings("serial")
@ManagedBean(name="orderBean")
@ViewScoped
public class OrderBean implements Serializable {
	private List <FishItem> list= new ArrayList<FishItem>();
	private FishItem temp=null;
	private double total=0;
	private double totalWeight=0;
	public List<FishItem> getList() {
		return list;
	}
	public void setList(List<FishItem> list) {
		this.list = list;
	}
	public FishItem getTemp() {
		return temp;
	}
	public void setTemp(FishItem temp) {
		this.temp = temp;
		total=0;
		totalWeight=0;
		for (FishItem in:list) {
			total+=in.getSellPrice()*in.getWeight();
			totalWeight+=in.getWeight();
		}
	}
	
	public String addFishItemToList () {
		list.add(temp);
		temp=null;
		total=0;
		totalWeight=0;
		for (FishItem in:list) {
			total+=in.getSellPrice()*in.getWeight();
			totalWeight+=in.getWeight();
		}
		return "fishView12";
		
	}
	
	public void deleteFishItem(FishItem fish) {
		list.remove(fish);
		total=0;
		totalWeight=0;
		for (FishItem in:list) {
			total+=in.getSellPrice()*in.getWeight();
			totalWeight+=in.getWeight();
		}
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

}
