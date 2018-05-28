package com.hosoda.internous.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.SearchDAO;
import com.hosoda.internous.dto.IventDTO;
import com.hosoda.internous.dto.RindoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchConfirmAction extends ActionSupport implements SessionAware {
	Map<String, Object> session;

	private String iventName;
	private String rindoName;
	private String iventDate;
	private String sponsor;
	private int maxPeople;
	private String rindoPlaceName;
	private int difficulty;
	private String searchCheck;

	public String execute() {
		String result = ERROR;
		SearchDAO searchDAO = new SearchDAO();

		if (searchCheck.equals("iventSearch")) {
			List<IventDTO> searchIventDTOList = new ArrayList<>();
			searchIventDTOList = searchDAO.getIventInfo(iventName, rindoName, iventDate, sponsor, maxPeople);
			session.put("searchIventDTOList", searchIventDTOList);
			result = SUCCESS;
		}
		
		if (searchCheck.equals("rindoSearch")) {
			List<RindoDTO> searchRindoDTOList = new ArrayList<>();
			searchRindoDTOList = searchDAO.getRindoInfo(rindoName, rindoPlaceName, difficulty,0);
			session.put("searchRindoDTOList", searchRindoDTOList);
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

	public String getIventName() {
		return iventName;
	}

	public void setIventName(String iventName) {
		this.iventName = iventName;
	}

	public String getRindoName() {
		return rindoName;
	}

	public void setRindoName(String rindoName) {
		this.rindoName = rindoName;
	}

	public String getIventDate() {
		return iventDate;
	}

	public void setIventDate(String iventDate) {
		this.iventDate = iventDate;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public String getRindoPlaceName() {
		return rindoPlaceName;
	}

	public void setRindoPlaceName(String rindoPlaceName) {
		this.rindoPlaceName = rindoPlaceName;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getSearchCheck() {
		return searchCheck;
	}

	public void setSearchCheck(String searchCheck) {
		this.searchCheck = searchCheck;
	}
	
	

}
