package com.grahamjava.springmvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grahamjava.springmvc.entity.Customer;
import com.grahamjava.springmvc.service.CustomerService;

@Controller
@RequestMapping("/customer")
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
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		logger.info("CustomerController->showFormForAdd() ->  processing show Customer ADD Page!");

		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		logger.info("CustomerController->saveCustomer() ->  processing save Customer!");

		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {
		
		
		logger.info("CustomerController->showFormForUpdate() ->  processing update of a Customer!");

		// getCustomer from form
		Customer theCustomer = customerService.getCustomer(id);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to our form
		return "customer-form";

	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		logger.info("CustomerController->deleteCustomer() ->  delete a Customer!");

		customerService.deleteCustomer(id);
		// send over to our form
		return "redirect:/customer/list";

	}

}
