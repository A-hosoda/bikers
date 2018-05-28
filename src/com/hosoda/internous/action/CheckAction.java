package com.hosoda.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CheckAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private int id;
	private String ids;

	public String execute() {
		System.out.println("id確認用" + id);
		System.out.println("ids確認用" + ids);
		if (session.containsKey("maker_id")) {
			System.out.println("session確認用" + session.get("marker_id").toString());
		}else{
			System.out.println("sessionなし");
		}
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
