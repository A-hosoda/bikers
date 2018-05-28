package com.hosoda.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private UserDTO userCreateDTO = new UserDTO();
	
	public String execute(){
		
		if(!(session.containsKey("userCreateDTO"))){
			session.put("userCreateDTO", userCreateDTO);
		}
		
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	

}
