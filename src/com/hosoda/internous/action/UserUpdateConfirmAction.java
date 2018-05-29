package com.hosoda.internous.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateConfirmAction extends ActionSupport implements SessionAware{
	
	private String userMail;
	private String bike1;
	private String bike2;
	private String bike3;
	private String comment;
	private File img;
	private String imgFileName;
	private String imgContentType;
	private String errorMessage;
	
	public Map<String, Object> session;
	
	public String execute(){
		String result = SUCCESS;
		UserDTO newUserDTO = new UserDTO();
		newUserDTO = (UserDTO) session.get("newUserDTO");
		
		if (userMail.equals("")&&bike1.equals("")&&bike2.equals("")&&bike3.equals("")&&comment.equals("")&&img==null) {
			errorMessage = "全ての項目が空欄です。";
			result = ERROR;
		} else {
			newUserDTO.setUserMail(userMail);
			newUserDTO.setBike1(bike1);
			newUserDTO.setBike2(bike2);
			newUserDTO.setBike3(bike3);
			newUserDTO.setComment(comment);
			
			final long triOrder = 1024;
			if (img != null) {
				if (img.length() > 4 * triOrder * triOrder) {
					System.out.println("ファイル容量が超えています。");
					result = ERROR;
				} else {

					String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("uploadImg");

					File fileToCreate = new File(filePath, imgFileName);

					try {
						FileUtils.copyFile(img, fileToCreate);
					} catch (IOException e) {
						e.printStackTrace();
					}
					newUserDTO.setImg(imgFileName);
				}
			}
			
			session.put("newUserDTO", newUserDTO);
			
		}
		
		return result;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
