package com.hosoda.internous.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.RindoDAO;
import com.hosoda.internous.dao.SearchDAO;
import com.hosoda.internous.dto.IventDTO;
import com.hosoda.internous.dto.RindoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class RindoAction extends ActionSupport implements SessionAware {

	private int id;
	private RindoDTO rindoDTO = new RindoDTO();
	private List<IventDTO> iventDTOList = new ArrayList<>();
	private Map<String,Object> session;
	
	public String execute(){
		RindoDAO dao = new RindoDAO();
		
		if(id != 0){ //リンクなどから飛んできたとき
			rindoDTO = dao.getRindoInfo(id);
		}else{ //戻るなどで戻ってきたとき
			RindoDTO checkDTO = (RindoDTO) session.get("rindoDTO");
			rindoDTO = dao.getRindoInfo(checkDTO.getId());
		}
		session.put("rindoDTO", rindoDTO);
		
		SearchDAO searchDAO = new SearchDAO();
		iventDTOList = searchDAO.getIventInfo("", rindoDTO.getRindoName(), "", "", 0);
		session.put("iventDTOList",iventDTOList);
		
		return SUCCESS;
	}
	
	

	public List<IventDTO> getIventDTOList() {
		return iventDTOList;
	}



	public void setIventDTOList(List<IventDTO> iventDTOList) {
		this.iventDTOList = iventDTOList;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RindoDTO getRindoDTO() {
		return rindoDTO;
	}

	public void setRindoDTO(RindoDTO rindoDTO) {
		this.rindoDTO = rindoDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
