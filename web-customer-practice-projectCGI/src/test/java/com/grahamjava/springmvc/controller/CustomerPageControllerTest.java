package com.grahamjava.springmvc.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void testLoginControllerPage() throws Exception {
		
		List<Customer> customers = new ArrayList<Customer>();
		Customer c = new Customer();
		c.setId(1);
		c.setFirstName("Test");
		c.setLastName("Bloggs");
		c.setEmail("email");
		customers.add(c);
		
		when(customerService.getCustomers()).thenReturn(customers);
		
		this.mockMvc.perform(get("/list")).andExpect(status().isOk())
        .andExpect(view().name("list-customers"))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}
}
