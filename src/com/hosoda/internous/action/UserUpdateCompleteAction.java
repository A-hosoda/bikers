package com.hosoda.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.UserUpdateDAO;
import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateCompleteAction  extends ActionSupport implements SessionAware  {

	public Map<String, Object> session;

	public String execute() {
		
		UserUpdateDAO dao = new UserUpdateDAO();
		
		UserDTO newUserDTO = (UserDTO) session.get("newUserDTO");
		
		dao.getUserInfo(newUserDTO.getId(), newUserDTO.getUserMail(), newUserDTO.getComment(), newUserDTO.getBike1(), newUserDTO.getBike2(), newUserDTO.getBike3(), newUserDTO.getImg());
		session.remove("newUserDTO");

		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
