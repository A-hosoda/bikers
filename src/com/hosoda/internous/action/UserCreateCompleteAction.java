package com.hosoda.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.LoginDAO;
import com.hosoda.internous.dao.UserCreateConfirmDAO;
import com.hosoda.internous.dao.UserDAO;
import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {
	private UserCreateConfirmDAO dao = new UserCreateConfirmDAO();
	public Map<String,Object> session;
	
	public String execute(){
		
		UserDTO userCreateDTO = (UserDTO) session.get("userCreateDTO");

		if(dao.insertUserInfo(userCreateDTO)){
			//-----id取得用---------------
			LoginDAO loginDAO = new LoginDAO();
			int id = loginDAO.getLoginUserInfo(userCreateDTO.getUserName(),userCreateDTO.getUserPassword()).getId();
			//---------------------------------
			//------idからユーザー情報を取得する-------
			UserDAO userDAO = new UserDAO();
			userCreateDTO = userDAO.getUserInfo(id);
			//------------------------------------------
			userCreateDTO.setLoginFlg(true);
			session.put("loginDTO", userCreateDTO); //登録内容でログインする。
			session.remove("userCreateDTO"); //次回新規登録のためにuserCreateDTOを空にする。
			return SUCCESS;
		}
		return ERROR;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	

}
