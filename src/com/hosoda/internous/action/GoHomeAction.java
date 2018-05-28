package com.hosoda.internous.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.NewIventDAO;
import com.hosoda.internous.dao.RindoAllDAO;
import com.hosoda.internous.dto.IventDTO;
import com.hosoda.internous.dto.RindoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoHomeAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private NewIventDAO newIventDAO = new NewIventDAO();
	private ArrayList<IventDTO> newIventDTOList = new ArrayList<IventDTO>();
	private List<RindoDTO> rindoAllDTOList = new ArrayList<>();

	public String execute() {
		RindoAllDAO rindoAllDAO = new RindoAllDAO();
		// ホーム画面に戻るたび、iventDTOの中身をクリアする。
		if (session.containsKey("iventDTO")) {
			session.remove("iventDTO");
		}

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

	public NewIventDAO getNewIventDAO() {
		return newIventDAO;
	}

	public void setNewIventDAO(NewIventDAO newIventDAO) {
		this.newIventDAO = newIventDAO;
	}

	public ArrayList<IventDTO> getNewIventDTOList() {
		return newIventDTOList;
	}

	public void setNewIventDTOList(ArrayList<IventDTO> newIventDTOList) {
		this.newIventDTOList = newIventDTOList;
	}

	public List<RindoDTO> getRindoAllDTOList() {
		return rindoAllDTOList;
	}

	public void setRindoAllDTOList(List<RindoDTO> rindoAllDTOList) {
		this.rindoAllDTOList = rindoAllDTOList;
	}

}
