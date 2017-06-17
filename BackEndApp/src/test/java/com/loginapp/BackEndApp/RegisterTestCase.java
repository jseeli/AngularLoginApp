package com.loginapp.BackEndApp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.loginapp.BackEndApp.dao.RegisterDAO;
import com.loginapp.BackEndApp.model.Register;

public class RegisterTestCase 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.loginapp.BackEndApp");
		context.refresh();
		
		RegisterDAO registerDAO=(RegisterDAO)context.getBean("registerDAO");
		
		Register register=new Register();
		register.setLoginid("srinssit");
		register.setPassword("12345");
		register.setUsername("Srinivas P");
		register.setEmailid("srinssit@gmail.com");
		register.setMobile("9991113333");
		
		registerDAO.insertRegister(register);
		System.out.println("Registration Completed:");
		
	}
}
