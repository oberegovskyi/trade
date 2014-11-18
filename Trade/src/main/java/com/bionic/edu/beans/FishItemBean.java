package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.CustomerService;
import com.bionic.edu.FishItem;


@SuppressWarnings("serial")
@Named("fishItem")
@Scope("session")
public class FishItemBean implements Serializable {

	private String weight;
	private String firstWeight;
	private List <FishItem> list ;
	
	private FishItem selectedFish;
	private FishItem tempFish;
	
	@Inject
	private CustomerService customerService;
	
	
	public FishItemBean() {
		
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
		this.firstWeight=weight;
	}
	public List <FishItem> getList() {
		return list;
	}
	public void setList(List <FishItem> list) {
		this.list = list;
	}
	
	public FishItem getSelectedFish() {
		return selectedFish;
	}
	public void setSelectedFish(FishItem selectedFish) {
		this.selectedFish = selectedFish;
	}
	
	public FishItem getTempFish() {
		return tempFish;
	}
	public void setTempFish(FishItem tempFish) {
		this.tempFish = tempFish;
	}
	
	@PostConstruct
	public void init() {
		list=customerService.getAllAvailableFishItems();
	}
	public String getFirstWeight() {
		return firstWeight;
	}
	public void setFirstWeight(String firstWeight) {
		this.firstWeight = firstWeight;
	}
	
}
