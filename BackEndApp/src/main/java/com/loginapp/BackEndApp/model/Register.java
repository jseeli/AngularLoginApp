package com.loginapp.BackEndApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Register extends BaseDomain
{
	@NotNull(message="Login ID cannot be null")
	@Size(min=8, max=15)
	@Id
	String loginid;
	
	@NotNull(message="Password cannot be null")
	@Size(min=8, max=15)
	String password;
	
	@NotNull(message="Name cannot be null")
	String username;
	
	@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$", message = "Email ID is not Proper.")
	String emailid;
	
	@NotNull(message="Mobile Number Can't be null")
	@Size(min=10, max=10)
	@Pattern(regexp = "[789]\\d{9}", message = "Mobile Number is not Proper.")
	String mobile;

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
