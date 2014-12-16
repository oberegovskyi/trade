package com.bionic.edu.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.entities.OutParcelItem;
import com.bionic.edu.methods.Cloner;
import com.bionic.edu.services.ColdManagerService;
import com.bionic.edu.services.CustomerService;

@Named("orderBean")
@Scope("session")
public class OrderBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<FishItem> coldList;
	private List<FishItem> availableList;
	private List<FishItem> orderList = new ArrayList<FishItem>();
	private double totalWeight;
	private double total;
	private double weight=1;

	private FishItem temp;
	private FishItem tempWork;

	private Customer activeUser;

	@Inject
	private CustomerService customerService;
	@Inject
	private ColdManagerService coldManagerService;

	public FishItem getTemp() {
		return temp;
	}

	public void setTemp(FishItem temp) {
		this.temp = temp;
		Cloner cloner = new Cloner();
		tempWork = (FishItem) cloner.deepCopy(temp);
		total = 0;
		totalWeight = 0;
		for (FishItem in : orderList) {
			totalWeight += in.getWeight();
			total += in.getWeight() * in.getSellPrice();
		}
	}

	public List<FishItem> getAvailableList() {
		init();
		return availableList;
	}

	public List<FishItem> getColdList() {
		init();
		return coldList;
	}

	public void setColdList(List<FishItem> coldList) {
		this.coldList = coldList;
	}

	public void setAvailableList(List<FishItem> availableList) {
		this.availableList = availableList;
	}

	public List<FishItem> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<FishItem> orderList) {
		this.orderList = orderList;
	}

	@PostConstruct
	public void init() {
		availableList = customerService.getAllAvailableFishItems();
		coldList = coldManagerService.getSettedFishItems();
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Customer getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(Customer activeUser) {
		this.activeUser = activeUser;
	}

	public String addFishItemToList() {

		tempWork.setWeight(weight);
		orderList.add(tempWork);

		temp = null;
		weight = 0.1;
		total = 0;
		totalWeight = 0;
		for (FishItem in : orderList) {
			totalWeight += in.getWeight();
			total += in.getWeight() * in.getSellPrice();
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Успішно","Риба "+tempWork.getFishName()+" додана до партії"));
		return "fishView";
	}

	public void deleteFishItem(FishItem ff) {
		orderList.remove(ff);
		total = 0;
		totalWeight = 0;
		for (FishItem in : orderList) {
			totalWeight += in.getWeight();
			total += in.getWeight() * in.getSellPrice();
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Успішно","Риба "+ff.getFishName()+" видалена з корзини"));
	}
	
	public void deleteAllFishItems() {
		orderList.clear();
		total = 0;
		totalWeight = 0;
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Успішно","Корзина очищена"));
	}

	public double countPrice(FishItem fish) {
		return fish.getSellPrice() * fish.getWeight();
	}

	public void preSubmitOrder() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if (!orderList.isEmpty()) {
			if (activeUser == null) {
				RequestContext.getCurrentInstance().execute("PF('userDialog').show();");
			} else {

				java.util.Calendar cal = java.util.Calendar.getInstance();
				java.util.Date utilDate = cal.getTime();
				java.sql.Date sqlDate = new Date(utilDate.getTime());
				OutParcel out = new OutParcel(sqlDate, activeUser, 0, 0, 0);
				List<OutParcelItem> oo = new ArrayList<OutParcelItem>();
				for (FishItem ff : orderList) {
					oo.add(new OutParcelItem(out, ff, ff.getWeight()));
				}
				customerService.addOutParcelWithItems(out, oo);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Успішно","Сформована нова партія"));
				orderList.clear();
				
			}
		} else {
			
		}
	}
	
	public void setWriteOff () {
		coldManagerService.setWriteOffFishItem(temp);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Успішно","Риба "+temp.getFishName()+" успішно списана"));
		temp=null;
	}
}
