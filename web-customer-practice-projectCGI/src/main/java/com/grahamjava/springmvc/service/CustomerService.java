package com.grahamjava.springmvc.service;

import java.util.List;

import com.grahamjava.springmvc.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();	
	
	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);

}
