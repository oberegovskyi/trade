package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.bionic.edu.entities.Employee;
import com.bionic.edu.services.SecurityOfficerService;

@SuppressWarnings("serial")
@Named("editEmployee")
public class EditEmployeeBean implements Serializable {
	
	@Inject
	private SecurityOfficerService securityOfficerService;

	private Employee temp ;
	
	private List<Employee> list ;
	
	public EditEmployeeBean () {
		
	}

	
	public List<Employee> getList() {
		init();
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

	public Employee getTemp() {
		return temp;
	}

	public void setTemp(Employee temp) {
		this.temp = temp;
	}
	

	@PostConstruct
	public void init() {
        this.list = securityOfficerService.getAllEmployees();
    }
	
	public String saveEmployee () {
		securityOfficerService.saveEmployee(temp);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Успішно", "Працівник id:"+ temp.getEmployeeId()+" "+ temp.getLogin()+" збережений."));
		return "editEmployee";
	}
	
	public String blockEmployee (Employee tempBlock) {
		securityOfficerService.blockEmployee(tempBlock);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Успішно", "Працівник "+ tempBlock.getLogin()+" заблокований."));
		return "editEmployee";
	}
	
	public String unBlockEmployee (Employee tempBlock) {
		securityOfficerService.unBlockEmployee(tempBlock);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Успішно", "Працівник "+ tempBlock.getLogin()+" розблокований."));
		return "editEmployee";
	}

}
