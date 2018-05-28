package com.hosoda.internous.dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hosoda.internous.util.DBConnector;
import com.hosoda.internous.dto.RindoDTO;

public class RindoAllDAO {
	private List<RindoDTO> rindoDTOList = new ArrayList<>();
	private RindoDTO rindoDTO;
	
	public List<RindoDTO> getAllRindo(){
		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();
		
		String sql = "SELECT * FROM rindo";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
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
				
				rindoDTOList.add(rindoDTO);
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
		return rindoDTOList;
	}

}
