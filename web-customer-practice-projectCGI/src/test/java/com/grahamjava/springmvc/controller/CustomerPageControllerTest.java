package com.grahamjava.springmvc.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.grahamjava.springmvc.entity.Customer;
import com.grahamjava.springmvc.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerPageControllerTest {

	private MockMvc mockMvc;
	private List<Customer> customers;
	private Customer customer;
	
	@Mock
	private CustomerService customerService;
	
	@InjectMocks
	CustomerController customerController;
	
	
	/*
	 * We add the HelloWorldController to the standalone setup. 
	 * The MockMvcBuilders.standaloneSetup() allows to register one or more controllers 
	 * without the need to use the full WebApplicationContext
	 */

	@Before
	public void setup() {
		
		customers = new ArrayList<Customer>();
		customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Test");
		customer.setEmail("email");
		customers.add(customer);
		
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void testListCustomersControllerPage() throws Exception {
		

		
		when(customerService.getCustomers()).thenReturn(customers);
		
		this.mockMvc.perform(get("/customer/list")).andExpect(status().isOk())
        .andExpect(view().name("list-customers"))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}
	
	@Test
	public void testShowFormForAddControllerPage() throws Exception {
		
		this.mockMvc.perform(get("/customer/showFormForAdd")).andExpect(status().isOk())
        .andExpect(view().name("customer-form"))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}
	
	@Test
	public void testshowFormForUpdateControllerPage() throws Exception {
		
		when(customerService.getCustomer(anyInt())).thenReturn(customer);
		
		this.mockMvc.perform(get("/customer/showFormForUpdate?customerId=1")).andExpect(status().isOk())
        .andExpect(view().name("customer-form"))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}
}
