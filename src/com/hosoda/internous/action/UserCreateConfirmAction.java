package com.hosoda.internous.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.hosoda.internous.dao.UserCreateCompleteDAO;
import com.hosoda.internous.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
	private String userName;
	private String userPassword1;
	private String userPassword2;
	private int userAge;
	private String userGender;
	private String userMail;
	private String result;

	public Map<String, Object> session;
	private UserDTO userCreateDTO = new UserDTO();
	private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

	public String execute() {
		System.out.println(userName);
		result = SUCCESS;
		/**
		 * error1:未入力 error2:ユーザー名重複 error3:パスワードが同一ではない error4:メールアドレスに@なし
		 * 0:userAgeに関してはerrorを入れられないので、1を未入力とする。
		 */
		if (userName.equals("")) {
			userCreateDTO.setUserName("error1");
			result = ERROR;
		} else if (userCreateCompleteDAO.getUniqueUserInfo(userName)) {
			userCreateDTO.setUserName(userName);
		} else {
			userCreateDTO.setUserName("error2");
			result = ERROR;
		}

		if ((userPassword1.equals("")) || (userPassword2.equals(""))) {
			userCreateDTO.setUserPassword("error1");
			result = ERROR;
		} else if (!(userPassword1.equals(userPassword2))) {
			userCreateDTO.setUserPassword("error3");
			result = ERROR;

		} else {
			userCreateDTO.setUserPassword(userPassword1);
		}

		if (userAge == 0) {
			userCreateDTO.setUserAge(1);
			result = ERROR;
		} else {
			userCreateDTO.setUserAge(userAge);
		}

		userCreateDTO.setUserGender(userGender);

		if (userMail.equals("")) {
			userCreateDTO.setUserMail("error1");
			result = ERROR;
		} else if (!(userMail.matches(".*@.*"))) {
			userCreateDTO.setUserMail("error4");
			result = ERROR;
		} else {
			userCreateDTO.setUserMail(userMail);
		}

		session.put("userCreateDTO", userCreateDTO);

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword1() {
		return userPassword1;
	}

	public void setUserPassword1(String userPassword1) {
		this.userPassword1 = userPassword1;
	}

	public String getUserPassword2() {
		return userPassword2;
	}

	public void setUserPassword2(String userPassword2) {
		this.userPassword2 = userPassword2;
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

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public UserDTO getUserCreateDTO() {
		return userCreateDTO;
	}

	public void setUserCreateDTO(UserDTO userCreateDTO) {
		this.userCreateDTO = userCreateDTO;
	}

	public UserCreateCompleteDAO getUserCreateCompleteDAO() {
		return userCreateCompleteDAO;
	}

	public void setUserCreateCompleteDAO(UserCreateCompleteDAO userCreateCompleteDAO) {
		this.userCreateCompleteDAO = userCreateCompleteDAO;
	}
	
	

}
