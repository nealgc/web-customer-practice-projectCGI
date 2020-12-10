package com.grahamjava.springmvc.dao;

import com.grahamjava.springmvc.entity.CgiPassword;

public interface LoginDAO {
	
	CgiPassword getPassword(String userId);

}
