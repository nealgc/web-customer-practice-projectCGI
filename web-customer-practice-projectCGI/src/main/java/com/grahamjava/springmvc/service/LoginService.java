package com.grahamjava.springmvc.service;

import com.grahamjava.springmvc.entity.CgiPassword;

public interface LoginService {
	
	CgiPassword getPassword(String userId);

}
