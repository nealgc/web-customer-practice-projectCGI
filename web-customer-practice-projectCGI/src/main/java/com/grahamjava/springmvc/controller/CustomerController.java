package com.grahamjava.springmvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grahamjava.springmvc.entity.Customer;
import com.grahamjava.springmvc.service.CustomerService;

@Controller
public class CustomerController {
	
	private Logger logger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		logger.info("CustomerController->listCustomers() ->  processing list Customers Page!");

		// get customers to DAO
		List<Customer> theCustomers = customerService.getCustomers();

		// add customers to attribute
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

}
