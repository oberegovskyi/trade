package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bionic.edu.entity.FishItem;
import com.bionic.edu.entity.InParcel;
@SuppressWarnings("serial")
@ManagedBean (name="inParcel")
@ViewScoped
public class InParcelBean implements Serializable{
	private List <InParcel> list = new ArrayList<InParcel>(
			Arrays.asList(new InParcel(1,new java.sql.Date(new java.util.Date().getTime())),
				    new InParcel(2,new java.sql.Date(new java.util.Date().getTime())),
				    new InParcel(3,new java.sql.Date(new java.util.Date().getTime())),
				    new InParcel(4,new java.sql.Date(new java.util.Date().getTime()))));
	
	private FishItem selected;

	public List<InParcel> getList() {
		return list;
	}

	public void setList(List<InParcel> list) {
		this.list = list;
	}

	public FishItem getSelected() {
		return selected;
	}

	public void setSelected(FishItem selected) {
		this.selected = selected;
	}

}
