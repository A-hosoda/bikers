package com.hosoda.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hosoda.internous.dto.IventDTO;
import com.hosoda.internous.dto.RindoDTO;
import com.hosoda.internous.util.DBConnector;

public class SearchDAO {

	public List<IventDTO> getIventInfo(String iventName, String rindoName, String iventDate, String sponsor,
			int maxPeople) {
		IventDTO searchIventDTO;
		List<IventDTO> searchIventDTOList = new ArrayList<>();

		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();

		// 下記リストにint型を入れられないのでString型に変換する。
		String maxPeopleString = String.valueOf(maxPeople);

		// ps.setString()で使用するリストを作成する。このリストに入力された項目を格納していく。
		List<String> checkList = new ArrayList<>();

		String sql = "SELECT * FROM ivent WHERE";

		// 入力された項目をsqlに追加していく
		if (!(iventName.equals(""))) {
			sql = sql + " iventName = ? AND";
			checkList.add(iventName);
		}
		if (!(rindoName.equals(""))) {
			sql = sql + " rindoName = ? AND";
			checkList.add(rindoName);
		}
		if (!(iventDate.equals(""))) {
			sql = sql + " iventDate = ? AND";
			checkList.add(iventDate);
		}
		if (!(sponsor.equals(""))) {
			sql = sql + " sponsor = ? AND";
			checkList.add(sponsor);
		}
		if (!(maxPeopleString.equals("0"))) {
			sql = sql + " maxPeople = ? AND";
			checkList.add(maxPeopleString);
		}
		// 最後のANDを消去する------------		
		Pattern p = Pattern.compile("AND$"); //正規表現のパターンを読み込み
		Matcher m = p.matcher(sql); //文字列でマッチするものを検索
		sql = m.replaceFirst(""); //カッコ内のものと置き換える。
		
		System.out.println(sql); //確認用---------

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			// checkListの中身をps.setString()に入れていく。
			for (int i = 0; i < checkList.size(); i++) {
				ps.setString(i+1, checkList.get(i));
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				searchIventDTO = new IventDTO();
				searchIventDTO.setId(rs.getInt("id"));
				searchIventDTO.setIventName(rs.getString("iventName"));
				searchIventDTO.setIventDate(rs.getString("iventDate"));
				searchIventDTO.setRindo_id(rs.getInt("rindo_id"));
				searchIventDTO.setRindoName(rs.getString("rindoName"));
				searchIventDTO.setSponsor(rs.getString("sponsor"));
				searchIventDTO.setSponsor_id(rs.getInt("sponsor_id"));
				searchIventDTO.setMaxPeople(rs.getInt("maxPeople"));
				searchIventDTO.setCurrentPeople(rs.getInt("currentPeople"));
				searchIventDTO.setComment(rs.getString("comment"));
				searchIventDTO.setParticipant1(rs.getString("participant1"));
				searchIventDTO.setParticipant1_id(rs.getInt("participant1_id"));
				searchIventDTO.setParticipant2(rs.getString("participant2"));
				searchIventDTO.setParticipant2_id(rs.getInt("participant2_id"));
				searchIventDTO.setParticipant3(rs.getString("participant3"));
				searchIventDTO.setParticipant3_id(rs.getInt("participant3_id"));
				searchIventDTO.setCreateDate(rs.getString("createDate"));

				searchIventDTOList.add(searchIventDTO);
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

		return searchIventDTOList;

	}
	
	public List<RindoDTO> getRindoInfo(String rindoName,String rindoPlaceName , int difficulty,int id) {
		RindoDTO searchRindoDTO;
		List<RindoDTO> searchRindoDTOList = new ArrayList<>();

		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();

		// 下記リストにint型を入れられないのでString型に変換する。
		String difficultyString = String.valueOf(difficulty);
		String idString = String.valueOf(id);

		// ps.setString()で使用するリストを作成する。このリストに入力された項目を格納していく。
		List<String> checkList = new ArrayList<>();

		String sql = "SELECT * FROM rindo WHERE";

		// 入力された項目をsqlに追加していく
		if (!(rindoName.equals(""))) {
			sql = sql + " rindoName = ? AND";
			checkList.add(rindoName);
		}
		if (!(rindoPlaceName.equals(""))) {
			sql = sql + " rindoPlaceName = ? AND";
			checkList.add(rindoPlaceName);
		}
		if (!(difficultyString.equals("0"))) {
			sql = sql + " difficulty = ? AND";
			checkList.add(difficultyString);
		}
		if (!(idString.equals("0"))) {
			sql = sql + " id = ? AND";
			checkList.add(idString);
		}
		
		// 最後のANDを消去する------------		
		Pattern p = Pattern.compile("AND$"); //正規表現のパターンを読み込み
		Matcher m = p.matcher(sql); //文字列でマッチするものを検索
		sql = m.replaceFirst(""); //カッコ内のものと置き換える。
		
		System.out.println(sql); //確認用---------

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			// checkListの中身をps.setString()に入れていく。
			for (int i = 0; i < checkList.size(); i++) {
				ps.setString(i+1, checkList.get(i));
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				searchRindoDTO = new RindoDTO();
				searchRindoDTO.setId(rs.getInt("id"));
				searchRindoDTO.setRindoName(rs.getString("rindoName"));
				searchRindoDTO.setRindoPlaceName(rs.getString("rindoPlaceName"));
				searchRindoDTO.setDifficulty(rs.getInt("difficulty"));
				searchRindoDTO.setImg1(rs.getString("img1"));
				searchRindoDTO.setImg2(rs.getString("img2"));
				searchRindoDTO.setImg3(rs.getString("img3"));
				searchRindoDTO.setComment(rs.getString("comment"));
				searchRindoDTO.setLatitude(rs.getDouble("latitude"));
				searchRindoDTO.setLongitude(rs.getDouble("longitude"));
				searchRindoDTO.setUpdateDate(rs.getString("updateDate"));

				searchRindoDTOList.add(searchRindoDTO);
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

		return searchRindoDTOList;

	}
	
	public List<IventDTO> getMyIvent(String userName) {
		IventDTO searchIventDTO;
		List<IventDTO> searchIventDTOList = new ArrayList<>();

		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();

		String sql = "SELECT * FROM ivent WHERE sponsor = ? OR participant1 = ? OR participant2 = ? OR participant3 = ? ORDER BY iventDate DESC";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, userName);
			ps.setString(2, userName);
			ps.setString(3, userName);
			ps.setString(4, userName);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				searchIventDTO = new IventDTO();
				searchIventDTO.setId(rs.getInt("id"));
				searchIventDTO.setIventName(rs.getString("iventName"));
				searchIventDTO.setIventDate(rs.getString("iventDate"));
				searchIventDTO.setRindo_id(rs.getInt("rindo_id"));
				searchIventDTO.setRindoName(rs.getString("rindoName"));
				searchIventDTO.setSponsor(rs.getString("sponsor"));
				searchIventDTO.setSponsor_id(rs.getInt("sponsor_id"));
				searchIventDTO.setMaxPeople(rs.getInt("maxPeople"));
				searchIventDTO.setCurrentPeople(rs.getInt("currentPeople"));
				searchIventDTO.setComment(rs.getString("comment"));
				searchIventDTO.setParticipant1(rs.getString("participant1"));
				searchIventDTO.setParticipant1_id(rs.getInt("participant1_id"));
				searchIventDTO.setParticipant2(rs.getString("participant2"));
				searchIventDTO.setParticipant2_id(rs.getInt("participant2_id"));
				searchIventDTO.setParticipant3(rs.getString("participant3"));
				searchIventDTO.setParticipant3_id(rs.getInt("participant3_id"));
				searchIventDTO.setCreateDate(rs.getString("createDate"));

				searchIventDTOList.add(searchIventDTO);
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

		return searchIventDTOList;

	}

}
