package com.hosoda.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.RindoConfirmDAO;
import com.hosoda.internous.dto.RindoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class RindoCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	public String execute() {
		
		RindoConfirmDAO dao = new RindoConfirmDAO();
		
		RindoDTO dto = (RindoDTO) session.get("newRindoDTO");
		
		dao.insertRindoInfo(dto);
		session.remove("newRindoDTO");

		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
