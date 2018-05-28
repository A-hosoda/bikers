package com.hosoda.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.SankaDAO;
import com.hosoda.internous.dto.IventDTO;
import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SankaAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;

	public String execute() {
		SankaDAO dao = new SankaDAO();
		IventDTO iventDTO = (IventDTO) session.get("iventDTO");
		UserDTO loginDTO = (UserDTO) session.get("loginDTO");
		String result = ERROR;

		boolean check = dao.setPaticipant(loginDTO.getId(), loginDTO.getUserName(), iventDTO.getCurrentPeople(),iventDTO.getId());

		
		if (check) {

			result = SUCCESS;
		}

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
