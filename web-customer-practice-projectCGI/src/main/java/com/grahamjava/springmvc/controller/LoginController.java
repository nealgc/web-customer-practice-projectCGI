package com.grahamjava.springmvc.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grahamjava.springmvc.entity.CgiPassword;
import com.grahamjava.springmvc.service.LoginService;
import com.grahamjava.springmvc.util.PasswordUtil;

@Controller
public class LoginController {

	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;

	@RequestMapping("/login")
	public ModelAndView showUserLoginPage() {

		logger.info("showUserLoginPage() ->  processing loginPage!");

		ModelAndView mv = new ModelAndView("loginPage");
		return mv;
	}
	
	
	@RequestMapping("/loginCheck")
	public String LoginPageCheck(String userid, String pwd) {

		logger.info("LoginPageCheck() ->  processing loginPage! for userid " + userid + " pwd " + pwd);
		
		CgiPassword password = loginService.getPassword(userid);
		if (password != null) {
            if (processPasswordEncrypt(userid, password.getPassword(), pwd, password.getSalt())) {
			    return "redirect:/customer/list";
		    } else {
			    return "/login";
		    }
		} else {
			return "/login";
		}
			
	}
	
	private static boolean processPasswordEncrypt(String usr, String dbPwd, String inputPwd, String dbSalt) {
		final String username = usr;
		final String password = inputPwd;
        final String salted = username+dbSalt;  
        
        System.out.println("processPasswordEncrypt( -> usr " + usr + " dbPwd " + dbPwd + " inputPwd " + inputPwd + " dbSalt " + dbSalt);
        
        
        
        final int iterations = 32;
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salted.getBytes(), iterations, 512);
        SecretKeyFactory skf = null;
        byte[] hashed = null;
		try {
			skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			hashed = skf.generateSecret(keySpec).getEncoded();		
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("The SHA-256 value salted with PBKDF2 is " + PasswordUtil.bytesToHex(hashed));
        System.out.println("The SHA-256 value salted with PBKDF2 is " + hashed);
        
        if (skf == null || hashed == null) {
        	return false;
        }
        return PasswordUtil.bytesToHex(hashed).equals(dbPwd);
	}

}
