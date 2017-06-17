package com.loginapp.BackEndApp.dao;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loginapp.BackEndApp.model.*;

@Repository("registerDAO")
public class RegisterDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public RegisterDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertRegister(Register register)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(register);
	}
}
