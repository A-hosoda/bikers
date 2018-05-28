package com.hosoda.internous.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.SearchDAO;
import com.hosoda.internous.dto.IventDTO;
import com.hosoda.internous.dto.RindoDTO;
import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class IventConfirmAction extends ActionSupport implements SessionAware {

	private String iventName;
	private String iventDate;
	private int rindo_id;
	private int maxPeople;
	private String comment;

	public Map<String, Object> session;
	private IventDTO newIventDTO = new IventDTO();

	public String execute() {
		String result = SUCCESS;

		if (iventName.equals("")) {
			newIventDTO.setIventName("error1");
			result = ERROR;
		} else {
			newIventDTO.setIventName(iventName);
		}

		if (!(iventDate.equals(""))) {
			iventDate = iventDate.substring(0, 10); // 入力内容をyyyy-MM-ddに加工する。
		} else {
			newIventDTO.setIventDate("error1");
			result = ERROR;
		}

		// 入力した日付が過去ではないかチェックする。
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date checkDate = sdf.parse(iventDate);

			if (!(today.compareTo(checkDate) <= 0)) {
				newIventDTO.setIventDate("error5");
				result = ERROR;
			} else {
				newIventDTO.setIventDate(iventDate);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (rindo_id == 0) {
			newIventDTO.setRindo_id(-1);// 未選択の場合は-1を入れる
			result = ERROR;
		} else {
			// rindo_idからrindoNameを取得する。
			SearchDAO dao = new SearchDAO();
			List<RindoDTO> rindoDTOList = new ArrayList<>();
			rindoDTOList = dao.getRindoInfo("", "", 0, rindo_id);
			newIventDTO.setRindo_id(rindo_id);
			newIventDTO.setRindoName(rindoDTOList.get(0).getRindoName());

		}

		if (maxPeople == 0) {
			newIventDTO.setMaxPeople(-1);// 未選択の場合は-1を入れる
			result = ERROR;

		} else {
			newIventDTO.setMaxPeople(maxPeople);
		}

		if (comment.equals("")) {
			newIventDTO.setComment("error1");
			result = ERROR;

		} else {
			newIventDTO.setComment(comment);
		}

		// その他の項目を入れていく
		UserDTO loginDTO = (UserDTO) session.get("loginDTO");
		newIventDTO.setSponsor(loginDTO.getUserName());
		newIventDTO.setSponsor_id(loginDTO.getId());
		newIventDTO.setCurrentPeople(1);

		session.put("newIventDTO", newIventDTO);

		return result;

	}

	public String getIventName() {
		return iventName;
	}

	public void setIventName(String iventName) {
		this.iventName = iventName;
	}

	public String getIventDate() {
		return iventDate;
	}

	public void setIventDate(String iventDate) {
		this.iventDate = iventDate;
	}

	public int getRindo_id() {
		return rindo_id;
	}

	public void setRindo_id(int rindo_id) {
		this.rindo_id = rindo_id;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
