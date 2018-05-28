package com.hosoda.internous.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.RindoAllDAO;
import com.hosoda.internous.dto.IventDTO;
import com.hosoda.internous.dto.RindoDTO;
import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class IventCreateAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private List<RindoDTO> rindoDTOList = new ArrayList<>();

	public String execute() {
		IventDTO iventDTO = new IventDTO();
		
//		ログインしていない場合はエラーを返す
		UserDTO checkDTO = (UserDTO) session.get("loginDTO");
		if(!(checkDTO.isLoginFlg())){
			session.put("errorMessage","ログインしていません");
			return ERROR;
		}
		
		RindoAllDAO dao = new RindoAllDAO();
		rindoDTOList = dao.getAllRindo();
		session.put("newIventDTO",iventDTO);
		session.put("rindoDTOList",rindoDTOList);
		
		return SUCCESS;
	}
	
	

	public List<RindoDTO> getRindoDTOList() {
		return rindoDTOList;
	}



	public void setRindoDTOList(List<RindoDTO> rindoDTOList) {
		this.rindoDTOList = rindoDTOList;
	}



	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
