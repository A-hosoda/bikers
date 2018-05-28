package com.hosoda.internous.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dto.RindoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class RindoConfirmAction extends ActionSupport implements SessionAware {

	private String rindoName;
	private String rindoPlaceName;
	private int difficulty;
	private String comment;

	private File img1;
	private String img1FileName;
	private String img1ContentType;
	
	private double latitude;
	private double longitude;

	public Map<String, Object> session;

	private RindoDTO newRindoDTO = new RindoDTO();

	public String execute() {
		final long triOrder = 1024;
		String result = SUCCESS;

		if (rindoName.equals("")) {
			newRindoDTO.setRindoName("error1");
			result = ERROR;
		} else {
			newRindoDTO.setRindoName(rindoName);
		}

		if (rindoPlaceName.equals("")) {
			newRindoDTO.setRindoPlaceName("error1");
			result = ERROR;
		} else {
			newRindoDTO.setRindoPlaceName(rindoPlaceName);
		}

		if (difficulty == 0) {
			newRindoDTO.setDifficulty(-1);
			result = ERROR;
		} else {
			newRindoDTO.setDifficulty(difficulty);
		}

		if (comment.equals("")) {
			newRindoDTO.setComment("error1");
			result = ERROR;
		} else {
			newRindoDTO.setComment(comment);
		}

		if (img1 != null) {
			if (img1.length() > 4 * triOrder * triOrder) {
				System.out.println("ファイル容量が超えています。");
				newRindoDTO.setImg1("error6");
				result = ERROR;
			} else {

				String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("uploadImg");

				File fileToCreate = new File(filePath, img1FileName);

				try {
					FileUtils.copyFile(img1, fileToCreate);
				} catch (IOException e) {
					e.printStackTrace();
				}
				newRindoDTO.setImg1(img1FileName);
			}
		}
		
		if(longitude == 0 || latitude ==0){
			result = ERROR;
		}else{
			newRindoDTO.setLatitude(latitude);
			newRindoDTO.setLongitude(longitude);
		}
		
		session.put("newRindoDTO", newRindoDTO);

		return result;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public File getImg1() {
		return img1;
	}

	public void setImg1(File img1) {
		this.img1 = img1;
	}

	public String getImg1FileName() {
		return img1FileName;
	}

	public void setImg1FileName(String img1FileName) {
		this.img1FileName = img1FileName;
	}

	public String getImg1ContentType() {
		return img1ContentType;
	}

	public void setImg1ContentType(String img1ContentType) {
		this.img1ContentType = img1ContentType;
	}

	public RindoDTO getNewRindoDTO() {
		return newRindoDTO;
	}

	public void setNewRindoDTO(RindoDTO newRindoDTO) {
		this.newRindoDTO = newRindoDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

}
