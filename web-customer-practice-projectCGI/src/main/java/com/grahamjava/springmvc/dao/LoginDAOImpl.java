package com.grahamjava.springmvc.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grahamjava.springmvc.entity.CgiPassword;

@Repository
public class LoginDAOImpl implements LoginDAO {

	private Logger logger = Logger.getLogger(LoginDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CgiPassword getPassword(String userId) {

		logger.info("LoginDAOImpl -> getPassord()  ->  get Password from DB!");

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		CgiPassword cgiPassord = currentSession.get(CgiPassword.class, userId);
		
		return cgiPassord;

	}

}
