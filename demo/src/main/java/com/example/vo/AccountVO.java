package com.example.vo;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
public class AccountVO implements Serializable{
	
	private String id;
	private String loginName;
	private String password;
	
	
	 public AccountVO() {  
	        super();  
	    }


	public AccountVO(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}  
    
}
