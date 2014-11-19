package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;
import com.bionic.edu.services.GeneralManagerService;

@SuppressWarnings("serial")
@Named("editFishParcel")
@Scope("session")
public class EditFishParcelBean implements Serializable{
	private InParcel inParcelTemp;
	private List <FishItem> listFish= null;
	private FishItem selectedFish;
	@Inject
	private GeneralManagerService generalManagerService;

	public InParcel getInParcelTemp() {
		return inParcelTemp;
	}

	public void setInParcelTemp(InParcel inParcelTemp) {
		this.inParcelTemp = inParcelTemp;
		System.out.println(this.inParcelTemp);
	}

	
	public List<FishItem> getListFish() {
		return listFish;
	}

	public void setListFish(List<FishItem> listFish) {
		this.listFish = listFish;
	}
	


	public FishItem getSelectedFish() {
		return selectedFish;
	}

	public void setSelectedFish(FishItem selectedFish) {
		this.selectedFish = selectedFish;
	}

	public String getFishItems () {
		listFish = generalManagerService.getAllFishItemsInParcel(inParcelTemp);
		return "editCurFishParcel";
	}
	
	public String saveFishItem () {
		generalManagerService.saveFishItem(selectedFish);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(":formEditFishParcel:growl", new FacesMessage(FacesMessage.SEVERITY_INFO,"Успішно",selectedFish.getFishName()+" вдало відредагована"));
		selectedFish=null;
		return "editCurFishParcel";
	}
	
	public void saveInParcel () {
		generalManagerService.saveInParcel(inParcelTemp);
		System.out.println(inParcelTemp);
		inParcelTemp=null;
	}

}
