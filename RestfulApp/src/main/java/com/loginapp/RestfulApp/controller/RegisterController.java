package com.loginapp.RestfulApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loginapp.BackEndApp.dao.*;
import com.loginapp.BackEndApp.model.*;

@RestController
public class RegisterController 
{
	@Autowired
	RegisterDAO registerDAO;
	
	@RequestMapping(value="/insertRegister",method=RequestMethod.POST)
	public ResponseEntity<Register> addRegister(@RequestBody Register register)
	{
		registerDAO.insertRegister(register);
		return new ResponseEntity<Register>(register,HttpStatus.OK);
	}
	
	@RequestMapping(value="/loginCheck",method=RequestMethod.POST)
	public ResponseEntity<Register> loginCheck(@RequestBody Register register)
	{
		Register register1=new Register();
		try
		{		
		 register1=registerDAO.loginCheck(register.getLoginid(),register.getPassword());
		
		if(register1!=null)
		{
			register1.errorcode="200";
			register1.errordesc="Successful";
		}
		else
		{
			register1.errorcode="234";
			register1.errordesc="User does not exist";
		}
		}
		catch(Exception e)
		{
			register1.errorcode="235";
			register1.errordesc="Exception Occured";
		}
		
		return new ResponseEntity<Register>(register1,HttpStatus.OK);
	}

}
