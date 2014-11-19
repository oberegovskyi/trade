package com.bionic.edu.beans;

import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.OutParcel;

@Named("myRoom")
@Scope("request")
public class MyRoomBean {
	private List <OutParcel> listOut;

	public List<OutParcel> getListOut() {
		return listOut;
	}

	public void setListOut(List<OutParcel> listOut) {
		this.listOut = listOut;
	}
	

}
