package com.grahamjava.springmvc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grahamjava.springmvc.dao.CustomerDAO;
import com.grahamjava.springmvc.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private Logger logger = Logger.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerDAO customerDAO;

	@Override
    @Transactional
	public List<Customer> getCustomers() {
		
		logger.info("CustomerServiceImpl-> getCustomers()  ->  processing list of customers!");
		
		return customerDAO.getCustomers();
	}

}
