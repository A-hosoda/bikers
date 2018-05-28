package com.hosoda.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.LoginDAO;
import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginCompleteAction extends ActionSupport implements SessionAware {

	private String userName;
	private String userPassword;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private UserDTO loginDTO = new UserDTO();

	public String execute() {
		loginDTO = loginDAO.getLoginUserInfo(userName, userPassword);
		if (loginDTO.isLoginFlg()) {
			session.put("loginDTO", loginDTO);
			return SUCCESS;
		}
		session.put("loginError",true);
		return ERROR;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
	
}
