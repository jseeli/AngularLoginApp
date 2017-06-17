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
	public ResponseEntity<String> addRegister(@RequestBody Register register)
	{
		registerDAO.insertRegister(register);
		return new ResponseEntity<String>("Successfully Inserted",HttpStatus.OK);
	}

}
