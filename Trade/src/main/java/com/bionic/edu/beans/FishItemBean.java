package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;









import javax.faces.bean.ManagedBean;



import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.omnifaces.cdi.Eager;

import com.bionic.edu.entity.FishItem;

@ManagedBean (name="fishItem")
@SessionScoped
public class FishItemBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fishName;
	private String description;
	private String weight;
	private String sellPrice;
	private List <FishItem> list = new ArrayList<FishItem>(
			Arrays.asList(new FishItem(1,"Карась", "північного моря",1, 3000, 1200, 1222,1,900),
				    new FishItem(2,"Карась2", " північнd2",0, 1466, 12002, 1333,1,300),
				    new FishItem(3,"Карась3", " північного моря3",1, 1200, 12003, 1333,1,30002),
				    new FishItem(4,"Карась4", "північного моря4",2, 2300, 1204, 533,2,30004)));
	
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
		tempFish=selectedFish;
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
	
}
