package com.grahamjava.springmvc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grahamjava.springmvc.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private Logger logger = Logger.getLogger(CustomerDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		logger.info("CustomerDAOImpl -> getCustomers()  ->  processing list of customers from DB!");

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		// execute query
		List<Customer> customerList = theQuery.getResultList();
		// return results
		return customerList;
	}

}
