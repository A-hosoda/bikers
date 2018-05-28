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
import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private List<IventDTO> myIventDTOList = new ArrayList<>();
	private List<IventDTO> notAchievedIventList = new ArrayList<>();
	private List<IventDTO> oldIventList = new ArrayList<>();

	public String execute() {
		
//		ログインしていない場合はエラーを返す
		UserDTO checkDTO = (UserDTO) session.get("loginDTO");
		if(!(checkDTO.isLoginFlg())){
			session.put("errorMessage","ログインしていません");
			return ERROR;
		}
		
		SearchDAO dao = new SearchDAO();

		UserDTO loginDTO = (UserDTO) session.get("loginDTO");
		myIventDTOList = dao.getMyIvent(loginDTO.getUserName());
		// 未達成のイベントと終了しているイベントを開催日時と現在の日時で判定する。
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (IventDTO dto : myIventDTOList) {
			try {
				Date iventDate = sdf.parse(dto.getIventDate());
				if (today.compareTo(iventDate) <= 0) {
					notAchievedIventList.add(dto); // 未達成のイベント
				} else {
					oldIventList.add(dto); // 終了しているイベント
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		session.put("notAchievedIventList", notAchievedIventList);
		session.put("oldIventList", oldIventList);
		
		return SUCCESS;
	}

	public List<IventDTO> getMyIventDTOList() {
		return myIventDTOList;
	}

	public void setMyIventDTOList(List<IventDTO> myIventDTOList) {
		this.myIventDTOList = myIventDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<IventDTO> getNotAchievedIventList() {
		return notAchievedIventList;
	}

	public void setNotAchievedIventList(List<IventDTO> notAchievedIventList) {
		this.notAchievedIventList = notAchievedIventList;
	}

	public List<IventDTO> getOldIventList() {
		return oldIventList;
	}

	public void setOldIventList(List<IventDTO> oldIventList) {
		this.oldIventList = oldIventList;
	}

}
