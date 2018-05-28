package com.hosoda.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hosoda.internous.dto.UserDTO;
import com.hosoda.internous.util.DBConnector;

public class UserCreateConfirmDAO {
	
	public boolean insertUserInfo(UserDTO userCreateDTO){
		boolean result = false;
		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();
		
		String sql = "INSERT INTO userlogindata (userName,userPassword,userAge,userMail,userGender) VALUES (?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userCreateDTO.getUserName());
			ps.setString(2, userCreateDTO.getUserPassword());
			ps.setInt(3, userCreateDTO.getUserAge());
			ps.setString(4, userCreateDTO.getUserMail());
			ps.setString(5, userCreateDTO.getUserGender());
						
			int count = ps.executeUpdate();
			
			if(count != 0){
				result = true;
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
		
		return result;
	}
	
}
