package com.bionic.edu;
import java.io.Serializable;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
public class Employee  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;
	private String login;
	private String password;
	private String fName;
	private String sName;
	private int level;
	private int blocked;
	public Employee () {
		
	}
	
	public Employee(String login, String password,
			String fName, String sName, int level, int blocked) {
		super();
		this.login = login;
		this.password = password;
		this.fName = fName;
		this.sName = sName;
		this.level = level;
		this.blocked = blocked;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getBlocked() {
		return blocked;
	}

	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", login=" + login
				+ ", password=" + password + ", fName=" + fName + ", sName="
				+ sName + ", level=" + level + ", blocked=" + blocked + "]";
	}

}
