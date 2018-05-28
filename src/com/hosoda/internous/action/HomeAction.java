package com.hosoda.internous.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.NewIventDAO;
import com.hosoda.internous.dao.RindoAllDAO;
import com.hosoda.internous.dto.IventDTO;
import com.hosoda.internous.dto.RindoDTO;
import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private UserDTO loginDTO = new UserDTO();
	private NewIventDAO newIventDAO = new NewIventDAO();
	private RindoAllDAO rindoAllDAO = new RindoAllDAO();
	private ArrayList<IventDTO> newIventDTOList = new ArrayList<>();
	private List<RindoDTO> rindoAllDTOList = new ArrayList<>();

	public String execute() {
		loginDTO.setUserName("ゲスト");
		loginDTO.setId(-1);
		session.put("loginDTO", loginDTO);
		newIventDTOList = newIventDAO.getNewIvent();
		rindoAllDTOList = rindoAllDAO.getAllRindo();
		
		session.put("newIventDTOList", newIventDTOList);
		session.put("rindoAllDTOList", rindoAllDTOList);
		
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(UserDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	public ArrayList<IventDTO> getNewIventDTOList() {
		return newIventDTOList;
	}

	public void setNewIventDTOList(ArrayList<IventDTO> newIventDTOList) {
		this.newIventDTOList = newIventDTOList;
	}

	public NewIventDAO getNewIventDAO() {
		return newIventDAO;
	}

	public void setNewIventDAO(NewIventDAO newIventDAO) {
		this.newIventDAO = newIventDAO;
	}

	public RindoAllDAO getRindoAllDAO() {
		return rindoAllDAO;
	}

	public void setRindoAllDAO(RindoAllDAO rindoAllDAO) {
		this.rindoAllDAO = rindoAllDAO;
	}

	public List<RindoDTO> getRindoAllDTOList() {
		return rindoAllDTOList;
	}

	public void setRindoAllDTOList(List<RindoDTO> rindoAllDTOList) {
		this.rindoAllDTOList = rindoAllDTOList;
	}
	
	

}
