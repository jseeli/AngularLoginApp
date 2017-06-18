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
		
		/*Register register=new Register();
		register.setLoginid("harish");
		register.setPassword("12345");
		register.setUsername("Harish P");
		register.setEmailid("srinssit@gmail.com");
		register.setMobile("9911133332");
		
		registerDAO.insertRegister(register);
		System.out.println("Registration Completed:");*/
		
		Register register=registerDAO.loginCheck("dyna124","P@ssword@123");
		
		if(register!=null)
			System.out.println("Customer Name:"+register.getUsername());
		else
			System.out.println("Error - User Does not exist");
		
		
	}
}
