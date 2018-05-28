package com.hosoda.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hosoda.internous.util.DBConnector;

public class UserCreateCompleteDAO {
	public boolean getUniqueUserInfo(String userName) {
		boolean result = true;
		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();

		String sql = "SELECT * FROM userlogindata WHERE userName=? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = false;
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
		return result;
	}

}
