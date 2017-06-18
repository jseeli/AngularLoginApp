package com.loginapp.BackEndApp.model;

import javax.persistence.Transient;

public class BaseDomain 
{
	@Transient
	public String errorcode;
	
	@Transient
	public String errordesc;

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrordesc() {
		return errordesc;
	}

	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}
	
	
}
