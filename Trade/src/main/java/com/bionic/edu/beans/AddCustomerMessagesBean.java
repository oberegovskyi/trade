package com.bionic.edu.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "addCustomerMessagesBean", eager = true)
@RequestScoped
public class AddCustomerMessagesBean {
	private String loginReq ="������ ����";
	private String loginVal ="���� �������� �� ����� �� 3 �� 20 �������";
	private String passwordReq = "������ ������";
	private String passwordVal = "���� �������� �� ����� �������� �� 3 �� 20 �������";
	private String passwordNotEq = "������ ����� �� ����������";
	private String fNameReq = "������ ��'�";
	private String fNameVal = "���� �������� �� 2 �� 20 ������� (�����)";
	private String sNameReq = "������ �������";
	private String sNameVal = "���� �������� �� 2 �� 20 ������� (��������)";
	private String emailReq="������ e-mail";
	private String emailVal="������ �������� e-mail";
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
