package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.services.ColdManagerService;
import com.bionic.edu.services.GeneralManagerService;

@Named("outBean")
@Scope("session")
public class OutParcelsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OutParcel> listOut = null;
	private OutParcel tempOutParcel;
	@Inject
	private GeneralManagerService generalManagerService;
	@Inject
	private ColdManagerService coldManagerService;

	public List<OutParcel> getListOut() {
		init();
		return listOut;
	}

	public void setListOut(List<OutParcel> listOut) {
		this.listOut = listOut;
	}



	public OutParcel getTempOutParcel() {
		return tempOutParcel;
	}

	public void setTempOutParcel(OutParcel tempOutParcel) {
		this.tempOutParcel = tempOutParcel;
	}

	@PostConstruct
	public void init() {
		listOut = generalManagerService.getAllOutAvParcels();
	}

	public String setTaken() {
		tempOutParcel.setTaken(1);
		coldManagerService.updateOutParcel(tempOutParcel);
		tempOutParcel = null;
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(":formOutParcel:growlOut", new FacesMessage(FacesMessage.SEVERITY_INFO, "Увага","Партія успішно позначена як відвантажена"));
		return "outParcelsCold";
	}
}
