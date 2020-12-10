package com.grahamjava.springmvc.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grahamjava.springmvc.dao.LoginDAO;
import com.grahamjava.springmvc.entity.CgiPassword;

@Service
public class LoginServiceImpl implements LoginService {
	
	private Logger logger = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	LoginDAO loginDAO;
	
	@Override
    @Transactional
	public CgiPassword getPassword(String userId) {
		logger.info("LoginServiceImpl -> getPassword() ");
		return loginDAO.getPassword(userId);
	}

}
