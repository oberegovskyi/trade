package com.bionic.edu.fishTradeNew;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class FishItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fishItemId;
	private String fishName;
	private String description;
	private int status;
	private double weight;
	private double buyPrice;
	private double sellPrice;
	@ManyToOne
	@JoinColumn(name="inParcelId")
	private InParcel inParcel;
	private double cameWeight;
	@ManyToMany()
	@JoinTable(name="outParcelItem", joinColumns=@JoinColumn(name="fishItemId"),
	   inverseJoinColumns=@JoinColumn(name="outParcelId"))
	private Collection<OutParcel> outParcels;

	public FishItem () {
		
	}

	public FishItem(String fishName, String description, int status,
			double weight, double buyPrice, double sellPrice,
			InParcel inParcel, int deleted) {
		super();
		this.fishName = fishName;
		this.description = description;
		this.status = status;
		this.weight = weight;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.inParcel = inParcel;
	}

	public int getFishItemId() {
		return fishItemId;
	}

	public void setFishItemId(int fishItemId) {
		this.fishItemId = fishItemId;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public InParcel getInParcel() {
		return inParcel;
	}

	public void setInParcel(InParcel inParcel) {
		this.inParcel = inParcel;
	}

	public double getCameWeight() {
		return cameWeight;
	}

	public void setCameWeight(double cameWeight) {
		this.cameWeight = cameWeight;
	}

	public Collection<OutParcel> getOutParcels() {
		return outParcels;
	}

	public void setOutParcels(Collection<OutParcel> outParcels) {
		this.outParcels = outParcels;
	}

	@Override
	public String toString() {
		return "FishItem [fishItemId=" + fishItemId + ", fishName=" + fishName
				+ ", description=" + description + ", status=" + status
				+ ", weight=" + weight + ", buyPrice=" + buyPrice
				+ ", sellPrice=" + sellPrice + ", inParcel=" + inParcel
				+ ", cameWeight=" + cameWeight + "]";
	}




}
