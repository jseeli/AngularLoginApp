package com.loginapp.BackEndApp.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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
	public boolean insertRegister(Register register)
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(register);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	
	public Register loginCheck(String loginid,String password)
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Query query=session.createQuery("from Register where loginid=:loginid1 and password=:passwd1");
		query.setParameter("loginid1",loginid);
		query.setParameter("passwd1",password);
		@SuppressWarnings("unchecked")
		List<Register> list=(List<Register>)query.list();
		session.close();
		if(list.size()>0)
			return list.get(0);
		else
			return null;
		
	}
}
