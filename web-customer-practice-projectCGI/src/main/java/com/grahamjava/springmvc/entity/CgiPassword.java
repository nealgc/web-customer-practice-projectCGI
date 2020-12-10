package com.grahamjava.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cgi_password")
public class CgiPassword {
	
	@Id
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String salt;
	
	public CgiPassword() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "CgiPassword [username=" + username + ", password=" + password + ", salt=" + salt + "]";
	}

}
