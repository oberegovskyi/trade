package com.bionic.edu.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "addCustomerMessagesBean", eager = true)
@RequestScoped
public class AddCustomerMessagesBean {
	private String loginReq ="¬вед≥ть лог≥н";
	private String loginVal ="Ћише латиниц€ та цифри в≥д 3 до 20 символ≥в";
	private String passwordReq = "¬вед≥ть пароль";
	private String passwordVal = "Ћише латиниц€ та цифри довжиною в≥д 3 до 20 символ≥в";
	private String passwordNotEq = "¬веден≥ парол≥ не сп≥впадають";
	private String fNameReq = "¬вед≥ть ≥м'€";
	private String fNameVal = "Ћише кирилиц€ в≥д 2 до 20 символ≥в (—ерг≥й)";
	private String sNameReq = "¬вед≥ть пр≥звище";
	private String sNameVal = "Ћише кирилиц€ в≥д 2 до 20 символ≥в (ѕетренко)";
	private String emailReq="¬вед≥ть e-mail";
	private String emailVal="Ќев≥рно введений e-mail";
	public AddCustomerMessagesBean() {
		
	}
	public String getLoginReq() {
		return loginReq;
	}
	public void setLoginReq(String loginReq) {
		this.loginReq = loginReq;
	}
	public String getLoginVal() {
		return loginVal;
	}
	public void setLoginVal(String loginVal) {
		this.loginVal = loginVal;
	}
	public String getPasswordReq() {
		return passwordReq;
	}
	public void setPasswordReq(String passwordReq) {
		this.passwordReq = passwordReq;
	}
	public String getPasswordVal() {
		return passwordVal;
	}
	public void setPasswordVal(String passwordVal) {
		this.passwordVal = passwordVal;
	}
	public String getfNameReq() {
		return fNameReq;
	}
	public void setfNameReq(String fNameReq) {
		this.fNameReq = fNameReq;
	}
	public String getfNameVal() {
		return fNameVal;
	}
	public void setfNameVal(String fNameVal) {
		this.fNameVal = fNameVal;
	}
	public String getPasswordNotEq() {
		return passwordNotEq;
	}
	public void setPasswordNotEq(String passwordNotEq) {
		this.passwordNotEq = passwordNotEq;
	}
	public String getsNameReq() {
		return sNameReq;
	}
	public void setsNameReq(String sNameReq) {
		this.sNameReq = sNameReq;
	}
	public String getsNameVal() {
		return sNameVal;
	}
	public void setsNameVal(String sNameVal) {
		this.sNameVal = sNameVal;
	}
	public String getEmailReq() {
		return emailReq;
	}
	public void setEmailReq(String emailReq) {
		this.emailReq = emailReq;
	}
	public String getEmailVal() {
		return emailVal;
	}
	public void setEmailVal(String emailVal) {
		this.emailVal = emailVal;
	}

}
