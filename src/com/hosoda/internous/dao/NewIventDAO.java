package com.hosoda.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hosoda.internous.dto.IventDTO;
import com.hosoda.internous.util.DBConnector;

public class NewIventDAO {
	private ArrayList<IventDTO> iventDTOList = new ArrayList<IventDTO>();

	public ArrayList<IventDTO> getNewIvent() {
		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();

		String sql = "SELECT * FROM ivent WHERE id> ((SELECT MAX(id) FROM ivent)-5) ORDER BY id DESC";
		// もし、上記でダメだった場合はwhile文の方で対応する。count++; if(count > 5){break;}
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				IventDTO iventDTO = new IventDTO();
				iventDTO.setId(rs.getInt("id"));
				iventDTO.setIventName(rs.getString("iventName"));
				iventDTO.setIventDate(rs.getString("iventDate"));
				iventDTO.setRindo_id(rs.getInt("rindo_id"));
				iventDTO.setRindoName(rs.getString("rindoName"));
				iventDTO.setSponsor(rs.getString("sponsor"));
				iventDTO.setSponsor_id(rs.getInt("sponsor_id"));
				iventDTO.setMaxPeople(rs.getInt("maxPeople"));
				iventDTO.setCurrentPeople(rs.getInt("currentPeople"));
				iventDTO.setComment(rs.getString("comment"));
				iventDTO.setParticipant1(rs.getString("participant1"));
				iventDTO.setParticipant1_id(rs.getInt("participant1_id"));
				iventDTO.setParticipant2(rs.getString("participant2"));
				iventDTO.setParticipant2_id(rs.getInt("participant2_id"));
				iventDTO.setParticipant3(rs.getString("participant3"));
				iventDTO.setParticipant3_id(rs.getInt("participant3_id"));
				iventDTO.setCreateDate(rs.getString("createDate"));

				iventDTOList.add(iventDTO);

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

		return iventDTOList;
	}
}
