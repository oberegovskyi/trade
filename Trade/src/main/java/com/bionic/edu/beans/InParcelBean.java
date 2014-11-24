package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;
import com.bionic.edu.methods.Cloner;
import com.bionic.edu.services.CustomerService;
import com.bionic.edu.services.GeneralManagerService;

@Named("inParcel")
@Scope("session")
public class InParcelBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List <InParcel> list ;
	
	private FishItem selected = new FishItem();
	private FishItem fishWork = new FishItem();
	
	private FishItem selectedForEdit = new FishItem();
	
	private InParcel tempInParcel = new InParcel();
	
	private List<FishItem> tempFishItems =  new ArrayList<>();
	
	private java.util.Date date;
	
	@Inject
	private CustomerService customerService;
	
	@Inject
	private GeneralManagerService generalManagerService;

	public List<InParcel> getList() {
		init();
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

	
	public InParcel getTempInParcel() {
		return tempInParcel;
	}

	public void setTempInParcel(InParcel tempInParcel) {
		this.tempInParcel = tempInParcel;
	}

	public List<FishItem> getTempFishItems() {
		return tempFishItems;
	}

	public void setTempFishItems(List<FishItem> tempFishItems) {
		this.tempFishItems = tempFishItems;
	}
	
	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public FishItem getSelectedForEdit() {
		return selectedForEdit;
	}

	public void setSelectedForEdit(FishItem selectedForEdit) {
		this.selectedForEdit = selectedForEdit;
	}

	@PostConstruct
	public void init () {
		list=customerService.getAllInParcels();
	}
	
	public java.sql.Date getSqlDate(java.util.Date calendarDate) {
		  return new java.sql.Date(calendarDate.getTime());
		}
	
	public void addFishToIn () {
		Cloner cloner = new Cloner();
		fishWork = (FishItem) cloner.deepCopy(selected);
		tempFishItems.add(fishWork);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(":formAddNewInParcel:gro", new FacesMessage("Успішно",fishWork.getFishName() +" успішно додана в партію"));
	}
	
	@Transactional
	public void addNewInParcel () {
		
		for (FishItem in: tempFishItems) {
			tempInParcel.setDateIncome(getSqlDate(date));
			int id = generalManagerService.addNewInParcel(tempInParcel);
			in.setInParcel(generalManagerService.getInParcel(id));
			generalManagerService.addNewFishItem(in);
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(":formAddNewInParcel:gro", new FacesMessage("Успішно","Нова партія успішно додана"));
		tempFishItems=null;
		date=null;
	}
	
	public void setNullDate () {
		this.date=null;
		this.tempFishItems.clear();
	}
}
