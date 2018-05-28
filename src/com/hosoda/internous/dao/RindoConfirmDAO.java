package com.hosoda.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hosoda.internous.dto.RindoDTO;
import com.hosoda.internous.util.DBConnector;

public class RindoConfirmDAO {

	public void insertRindoInfo(RindoDTO rindoDTO) {
		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();

		String sql = "INSERT INTO rindo (rindoName,rindoPlaceName,difficulty,comment,img1,latitude,longitude) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, rindoDTO.getRindoName());
			ps.setString(2, rindoDTO.getRindoPlaceName());
			ps.setInt(3, rindoDTO.getDifficulty());
			ps.setString(4, rindoDTO.getComment());
			ps.setString(5, rindoDTO.getImg1());
			ps.setDouble(6, rindoDTO.getLatitude());
			ps.setDouble(7, rindoDTO.getLongitude());

			ps.execute();
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
	}

}
