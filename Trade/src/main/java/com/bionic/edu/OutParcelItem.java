package com.bionic.edu;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class OutParcelItem implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int outParcelItemId;
	@ManyToOne
	@JoinColumn(name="outParcelId")
	private OutParcel outParcel;
	@ManyToOne
	@JoinColumn(name="fishItemId")
	private FishItem fishItem;
	private double weight;
	private int isDeleted;
	
	public OutParcelItem () {
		
	}

	public OutParcelItem(OutParcel outParcel, FishItem fishItem, double weight) {
		this.outParcel = outParcel;
		this.fishItem = fishItem;
		this.weight = weight;
		this.isDeleted=0;
	}

	public int getOutParcelItemId() {
		return outParcelItemId;
	}

	public void setOutParcelItemId(int outParcelItemId) {
		this.outParcelItemId = outParcelItemId;
	}

	public OutParcel getOutParcel() {
		return outParcel;
	}

	public void setOutParcel(OutParcel outParcel) {
		this.outParcel = outParcel;
	}

	public FishItem getFishItem() {
		return fishItem;
	}

	public void setFishItem(FishItem fishItem) {
		this.fishItem = fishItem;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "OutParcelItem [outParcelItemId=" + outParcelItemId
				+ ", outParcelId=" + outParcel.getOutParcelId() + ", fishItemId=" + fishItem.getFishItemId()
				+ ", weight=" + weight + ", isDeleted=" + isDeleted + "]";
	}

}
