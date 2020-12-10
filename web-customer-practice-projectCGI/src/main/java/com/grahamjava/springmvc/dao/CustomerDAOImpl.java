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

	@Override
	public void saveCustomer(Customer customer) {
		
		logger.info("CustomerDAOImpl -> saveCustomer()  ->  save customer to DB!");

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.update(customer);
	}

	@Override
	public Customer getCustomer(int theId) {

		logger.info("CustomerDAOImpl ->getCustomer()  ->  get a single customer from DB!");

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class, theId);
		// return the customer found
		return customer;

	}

	@Override
	public void deleteCustomer(int theId) {
		
		logger.info("CustomerDAOImpl ->deleteCustomer()  ->  delete  a single customer from DB!");
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class, theId);
		
		currentSession.delete(customer);
		
	}

}
