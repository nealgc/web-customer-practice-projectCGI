package com.grahamjava.springmvc.dao;

import java.util.List;

import com.grahamjava.springmvc.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);
	
}
