package com.hosoda.internous.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.IventActionDAO;
import com.hosoda.internous.dao.SearchDAO;
import com.hosoda.internous.dto.IventDTO;
import com.hosoda.internous.dto.RindoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class IventAction extends ActionSupport implements SessionAware {

	private int id;
	private IventActionDAO dao = new IventActionDAO();
	private IventDTO iventDTO = new IventDTO();

	public Map<String, Object> session;

	public String execute() {
		SearchDAO searchDAO = new SearchDAO();
		
		if (id != 0) { //リンクから飛んだ時
			iventDTO = dao.getIventInfo(id);
		} else { //戻るなどで戻ってきたとき
			IventDTO checkDTO = (IventDTO) session.get("iventDTO");
			iventDTO = dao.getIventInfo(checkDTO.getId());
		}
		List<RindoDTO> getImgDTO = new ArrayList<>();
		
		getImgDTO = searchDAO.getRindoInfo("", "", 0, iventDTO.getRindo_id());
		iventDTO.setRindoImg(getImgDTO.get(0).getImg1());
		
		session.put("iventDTO", iventDTO);

		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
