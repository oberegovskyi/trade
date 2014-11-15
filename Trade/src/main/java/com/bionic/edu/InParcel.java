package com.bionic.edu;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class InParcel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int inParcelId;
	private Date dateIncome;
	private Date realDate;
	@OneToMany (mappedBy="inParcel", fetch=FetchType.EAGER)
	private Collection<FishItem> fishItems;
	
	public InParcel () {
		
	}

	public InParcel(Date dateIncome) {
		this.dateIncome = dateIncome;
	}

	public int getInParcelId() {
		return inParcelId;
	}

	public void setInParcelId(int inParcelId) {
		this.inParcelId = inParcelId;
	}

	public Date getDateIncome() {
		return dateIncome;
	}

	public void setDateIncome(Date dateIncome) {
		this.dateIncome = dateIncome;
	}

	public Date getRealDate() {
		return realDate;
	}

	public void setRealDate(Date realDate) {
		this.realDate = realDate;
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
		return "InParcel [inParcelId=" + inParcelId + ", dateIncome="
				+ dateIncome + ", realDate=" + realDate + ", fishItemsId="
				+ getFishItemsId() + "]";
	}


}
