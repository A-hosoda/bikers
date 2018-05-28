package com.hosoda.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.IventConfirmDAO;
import com.hosoda.internous.dto.IventDTO;
import com.opensymphony.xwork2.ActionSupport;

public class IventCompleteAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	private IventDTO newIventDTO = new IventDTO();
	
	public String execute(){
		IventConfirmDAO dao = new IventConfirmDAO();
		newIventDTO = (IventDTO) session.get("newIventDTO");
		dao.insertIventInfo(newIventDTO);
		
		session.remove("newIventDTO");
		
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public IventDTO getNewIventDTO() {
		return newIventDTO;
	}

	public void setNewIventDTO(IventDTO newIventDTO) {
		this.newIventDTO = newIventDTO;
	}
	
	
}
