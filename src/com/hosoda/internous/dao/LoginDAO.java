package com.hosoda.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hosoda.internous.dto.UserDTO;
import com.hosoda.internous.util.DBConnector;

public class LoginDAO {
	UserDTO loginDTO = new UserDTO();

	public UserDTO getLoginUserInfo(String userName, String userPassword) {
		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();

		String sql = "SELECT * FROM userlogindata where userName = ? AND userPassword = ?";

		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				loginDTO.setId(rs.getInt("id"));
				loginDTO.setUserName(rs.getString("userName"));
				loginDTO.setUserPassword(rs.getString("userPassword"));
				loginDTO.setUserAge(rs.getInt("userAge"));
				loginDTO.setUserMail(rs.getString("userMail"));
				loginDTO.setUserGender(rs.getString("userGender"));
				loginDTO.setComment(rs.getString("comment"));
				loginDTO.setBike1(rs.getString("bike1"));
				loginDTO.setBike2(rs.getString("bike2"));
				loginDTO.setBike3(rs.getString("bike3"));
				loginDTO.setImg(rs.getString("img"));

				loginDTO.setLoginFlg(true);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return loginDTO;
	}

}
