package com.hosoda.internous.dto;

public class UserDTO {
	
	private int id;
	private String userName = "";
	private String userPassword = "";
	private String userMail= "";
	private int userAge ;
	private String userGender = ""; //1:男 2:女
	private String comment = "";
	private String bike1 = "";
	private String bike2 = "";
	private String bike3 = "";
	private String img = "";
	
	private boolean loginFlg = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getBike1() {
		return bike1;
	}

	public void setBike1(String bike1) {
		this.bike1 = bike1;
	}

	public String getBike2() {
		return bike2;
	}

	public void setBike2(String bike2) {
		this.bike2 = bike2;
	}

	public String getBike3() {
		return bike3;
	}

	public void setBike3(String bike3) {
		this.bike3 = bike3;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public boolean isLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
	
	
	

}
