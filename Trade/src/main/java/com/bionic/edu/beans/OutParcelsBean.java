package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.services.AccountantService;
import com.bionic.edu.services.ColdManagerService;
import com.bionic.edu.services.CustomerService;
import com.bionic.edu.services.GeneralManagerService;

@Named("outBean")
@Scope("session")
public class OutParcelsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OutParcel> listOut = null;
	private List<OutParcel> listAcc = null;
	private OutParcel tempOutParcel;
	private OutParcel tempAccParcel;
	private double desPeyed=0;

	@Inject
	private GeneralManagerService generalManagerService;
	@Inject
	private ColdManagerService coldManagerService;
	@Inject
	private AccountantService accountantService;
	@Inject
	private CustomerService customerService;

	

	public double getDesPeyed() {
		return desPeyed;
	}

	public void setDesPeyed(double desPeyed) {
		this.desPeyed = desPeyed;
	}

	public List<OutParcel> getListOut() {
		init();
		return listOut;
	}

	public void setListAcc(List<OutParcel> listAcc) {
		this.listAcc = listAcc;
	}

	public List<OutParcel> getListAcc() {
		initAcc();
		return listAcc;
	}

	public void setListOut(List<OutParcel> listOut) {
		this.listOut = listOut;
	}

	public OutParcel getTempAccParcel() {
		return tempAccParcel;
	}

	public void setTempAccParcel(OutParcel tempAccParcel) {
		this.tempAccParcel = tempAccParcel;
	}

	public OutParcel getTempOutParcel() {
		return tempOutParcel;
	}

	public void setTempOutParcel(OutParcel tempOutParcel) {
		this.tempOutParcel = tempOutParcel;
		desPeyed = calcDesPaid(tempOutParcel);
	}

	@PostConstruct
	public void init() {
		listOut = generalManagerService.getAllOutAvParcels();
	}

	@PostConstruct
	public void initAcc() {
		listAcc = accountantService.getNotAv();
	}

	public String setTaken() {
		tempOutParcel.setTaken(1);
		coldManagerService.updateOutParcel(tempOutParcel);
		tempOutParcel = null;
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(":formOutParcel:growlOut", new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Увага",
				"Партія успішно позначена як відвантажена"));
		return "outParcelsCold";
	}

	public String setAvailable() {
		accountantService.setAvailable(tempOutParcel);
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(":formAccParcel:growlAcc", new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Увага",
				"Партія "+ tempOutParcel.getOutParcelId()+" успішно позначена як доступна для відвантаження"));
		tempOutParcel = null;
		return "outParcelsAcc";

	}

	public String updateOut() {
		coldManagerService.updateOutParcel(tempOutParcel);
		tempOutParcel = null;
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(":formAccParcel:growlAcc",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Увага",
						"Партія успішно збережена"));
		return "outParcelsAcc";
	}
	
	public double calcDesPaid (OutParcel dd) {
		return Math.round((customerService.getPriceOfParcel(dd)*(dd.getCustomer().getPayment()/100.0))*100)/100.0;
	}
}
