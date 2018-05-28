package com.hosoda.internous.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	
		public Map<String,Object> session;
		public String execute(){
			session.clear();
			
			UserDTO loginDTO = new UserDTO();
			loginDTO.setUserName("ゲスト");
			loginDTO.setId(-1);
			session.put("loginDTO", loginDTO);
			
			return SUCCESS;
		}
		@Override
		public void setSession(Map<String,Object> session){
			this.session = session;
		}

	
}
