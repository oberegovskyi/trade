package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.CustomerService;
import com.bionic.edu.FishItem;
import com.bionic.edu.InParcel;
@SuppressWarnings("serial")
@Named("inParcel")
@Scope("session")
public class InParcelBean implements Serializable{
	private List <InParcel> list ;
	
	private FishItem selected;
	
	@Inject
	private CustomerService customerService;

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

	
	@PostConstruct
	public void init () {
		list=customerService.getAllInParcels();
	}
}
