package com.hosoda.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hosoda.internous.dto.IventDTO;
import com.hosoda.internous.util.DBConnector;
import com.hosoda.internous.util.DateUtil;

public class IventConfirmDAO {
	
	public boolean insertIventInfo(IventDTO newIventDTO){
		boolean result = false;
		
		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();
		DateUtil date = new DateUtil();
		
		System.out.println(date.getDate());
		
		String sql = "INSERT INTO ivent (iventName,iventDate,rindo_id,rindoName,sponsor,sponsor_id,maxPeople,currentPeople,comment,createDate) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newIventDTO.getIventName());
			ps.setString(2, newIventDTO.getIventDate());
			ps.setInt(3, newIventDTO.getRindo_id());
			ps.setString(4, newIventDTO.getRindoName());
			ps.setString(5, newIventDTO.getSponsor());
			ps.setInt(6, newIventDTO.getSponsor_id());
			ps.setInt(7, newIventDTO.getMaxPeople());
			ps.setInt(8, newIventDTO.getCurrentPeople());
			ps.setString(9, newIventDTO.getComment());
			ps.setString(10, date.getDate());
			
			ps.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}
