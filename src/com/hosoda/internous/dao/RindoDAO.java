package com.hosoda.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hosoda.internous.dto.RindoDTO;
import com.hosoda.internous.util.DBConnector;

public class RindoDAO {
	private RindoDTO rindoDTO = new RindoDTO();
	
	public RindoDTO getRindoInfo(int id){
		Connection con = null;
		DBConnector db = new DBConnector();
		con =db.getConnection();
		
		String sql = "SELECT * FROM rindo WHERE id = ?";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				rindoDTO = new RindoDTO();
				rindoDTO.setId(rs.getInt("id"));
				rindoDTO.setRindoName(rs.getString("rindoName"));
				rindoDTO.setRindoPlaceName(rs.getString("rindoPlaceName"));
				rindoDTO.setDifficulty(rs.getInt("difficulty"));
				rindoDTO.setImg1(rs.getString("img1"));
				rindoDTO.setImg2(rs.getString("img2"));
				rindoDTO.setImg3(rs.getString("img3"));
				rindoDTO.setComment(rs.getString("comment"));
				rindoDTO.setLatitude(rs.getDouble("latitude"));
				rindoDTO.setLongitude(rs.getDouble("longitude"));
				rindoDTO.setUpdateDate(rs.getString("updateDate"));
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			if(con != null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		return rindoDTO;
	}
	

}
