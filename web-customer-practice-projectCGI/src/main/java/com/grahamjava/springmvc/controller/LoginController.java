package com.grahamjava.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping("/login")
	public ModelAndView showUserLoginPage() {

		logger.info("showUserLoginPage() ->  processing loginPage!");

		ModelAndView mv = new ModelAndView("loginPage");
		return mv;
	}

}
