package com.loginapp.BackEndApp.config;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.loginapp.BackEndApp.model.*;
import com.loginapp.BackEndApp.dao.*;


@Configuration
@EnableTransactionManagement
public class DBConfig 
{
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		//Hibernate related properties
		Properties hibernateprop=new Properties();
		hibernateprop.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateprop.put("hibernate.show_sql", "true"); //optional
		hibernateprop.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		//Adding the Database related Properties
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(hibernateprop);
		sessionBuilder.addAnnotatedClass(Register.class);
		SessionFactory sessionfactory=sessionBuilder.buildSessionFactory();
		
		System.out.println("Session Factory Object Created");
		
		return sessionfactory;
		
	}
	
	@Bean(name="registerDAO")
	public RegisterDAO getBlogDAO(SessionFactory sessionFactory)
	{
		System.out.println("---RegisterDAO Created---");
		return new RegisterDAO(sessionFactory);
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Transaction Manager");
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	

}
