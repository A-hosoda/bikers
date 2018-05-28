package com.hosoda.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hosoda.internous.util.DBConnector;

public class SankaDAO {
	
	public boolean setPaticipant(int id, String userName, int currentPeople ,int iventId) {
		boolean result = false;
		
		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();
		
		String sql = "UPDATE ivent SET participant? = ?, participant?_id = ? WHERE id = ?";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, currentPeople);
			ps.setString(2, userName);
			ps.setInt(3, currentPeople);
			ps.setInt(4,id);
			ps.setInt(5,iventId);
			System.out.println("確認用0"+id);
			
			int count = ps.executeUpdate();
			if(count != 0){				
				// 追加に成功しているのであればcurrentPeopleに１追加
				count = 0;
				sql ="UPDATE ivent SET currentPeople = ? WHERE id = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, currentPeople + 1);
				ps.setInt(2,iventId);
				count = ps.executeUpdate();
				
				if(count != 0){
					result = true;
				}
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
