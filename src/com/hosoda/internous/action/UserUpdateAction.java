package com.hosoda.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateAction extends ActionSupport implements SessionAware {
	
	private Map<String,Object> session;
	private UserDTO newUserDTO = new UserDTO();
	private String errorMessage = "";
	
	public String execute(){
		if(!session.containsKey("newUserDTO")){
			UserDTO loginDTO = new UserDTO();
			loginDTO = (UserDTO) session.get("loginDTO");
			
			newUserDTO.setId(loginDTO.getId());
			newUserDTO.setUserMail(loginDTO.getUserMail());
			newUserDTO.setBike1(loginDTO.getBike1());
			newUserDTO.setBike2(loginDTO.getBike2());
			newUserDTO.setBike3(loginDTO.getBike3());
			newUserDTO.setComment(loginDTO.getComment());
			
			session.put("newUserDTO", newUserDTO);
		}
		
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserDTO getNewUserDTO() {
		return newUserDTO;
	}

	public void setNewUserDTO(UserDTO newUserDTO) {
		this.newUserDTO = newUserDTO;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

	
	
	

}
