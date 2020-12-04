package com.grahamjava.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;

@Controller
public class LoginController {
	
	 private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping("/login")
	public ModelAndView showUserLoginPage() {

	    logger.info("showUserLoginPage() ->  processing loginPage!");

		ModelAndView mv = new ModelAndView("loginPage");
		return mv;
	}
	
	@PostMapping("/loginCheck")
	public ModelAndView checkLogin() {
		
		
		logger.info("checkLogin() ->  processing list-customer after login!");
 
		ModelAndView mv = new ModelAndView("list-customers");
		return mv;
	}
}
