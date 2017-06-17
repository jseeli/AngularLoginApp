package com.loginapp.BackEndApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.loginapp.BackEndApp.dao.RegisterDAO;
import com.loginapp.BackEndApp.model.Register;

public class RegisterUnitTestCase 
{

	AnnotationConfigApplicationContext context;
	
	@Before
	public void BeforeClass()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.loginapp.BackEndApp");
		context.refresh();
	}
	
	@Test
	public void test() 
	{
		RegisterDAO registerDAO=(RegisterDAO)context.getBean("registerDAO");
		
		Register register=new Register();
		register.setLoginid("harish");
		register.setPassword("12345");
		register.setUsername("Harish P");
		register.setEmailid("srinssit@gmail.com");
		register.setMobile("9911133332");
		
		assertEquals(registerDAO.insertRegister(register),true);
	}

}
