package com.grahamjava.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView showUserLoginPage() {
		
		System.out.println("in password controller");
 
		ModelAndView mv = new ModelAndView("loginPage");
		return mv;
	}
	
	@PostMapping("/loginCheck")
	public ModelAndView checkLogin() {
		
		System.out.println("in checkLogin()");
 
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
