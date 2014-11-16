package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.FishItem;


@Named("fishItem")
@Scope("session")
public class FishItemBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fishName;
	private String description;
	private String weight;
	private String sellPrice;
	private List <FishItem> list ;
	
	private FishItem selectedFish;
	private FishItem tempFish;
	public FishItemBean() {
		
	}
	public String getFishName() {
		return fishName;
	}
	public void setFishName(String fishName) {
		this.fishName = fishName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
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
		setTempFish(selectedFish);
	}
	
	@Override
	public String toString() {
		return "FishItemBean [fishName=" + fishName + ", description="
				+ description + ", weight=" + weight + ", sellPrice="
				+ sellPrice + ", list=" + list + ", selectedFish="
				+ selectedFish + "]";
	}
	
	public void changeFish  (FishItem fi) {
		System.out.println(list);
		//FishItem temp = list.get(fi.getFishItemId());
		//list.remove(tempFish);
		//temp.setFishItemId(fi.getFishItemId());
		//temp.setBuyPrice(fi.getBuyPrice());
		//temp.setCameWeight(fi.getCameWeight());
		//temp.setDescription(fi.getDescription());
		//temp.setFishName(fi.getFishName());
		//temp.setInParcelId(fi.getInParcelId());
		//temp.setSellPrice(fi.getSellPrice());
		//temp.setStatus(fi.getStatus());
		//temp.setWeight(fi.getWeight());
		//list.add(temp);
		System.out.println(list);
	}
	public FishItem getTempFish() {
		return tempFish;
	}
	public void setTempFish(FishItem tempFish) {
		this.tempFish = tempFish;
	}
	
}
