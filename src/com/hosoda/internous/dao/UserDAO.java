package com.hosoda.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hosoda.internous.dto.UserDTO;
import com.hosoda.internous.util.DBConnector;

public class UserDAO {
	private UserDTO userDTO = new UserDTO();
	
	public UserDTO getUserInfo(int id){
		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();
		
		String sql = "SELECT * FROM userlogindata WHERE id = ?";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				userDTO.setId(rs.getInt("id"));
				userDTO.setUserName(rs.getString("userName"));
				userDTO.setUserAge(rs.getInt("userAge"));
				userDTO.setUserMail(rs.getString("userMail"));
				userDTO.setUserGender(rs.getString("userGender"));
				userDTO.setComment(rs.getString("comment"));
				userDTO.setBike1(rs.getString("bike1"));
				userDTO.setBike2(rs.getString("bike2"));
				userDTO.setBike3(rs.getString("bike3"));
				userDTO.setImg(rs.getString("img"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			if(con != null){
				try{
					con.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		return userDTO;
	}

}
