package com.hosoda.internous.dto;

public class RindoDTO {
	
	private int id;
	private String rindoName="";
	private String rindoPlaceName="";
	private int difficulty;
	private String img1="";
	private String img2;
	private String img3;
	private String comment;
	private double latitude;
	private double longitude;
	private String updateDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRindoName() {
		return rindoName;
	}
	public void setRindoName(String rindoName) {
		this.rindoName = rindoName;
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
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	

}
