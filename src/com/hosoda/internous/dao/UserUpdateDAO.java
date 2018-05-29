package com.hosoda.internous.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hosoda.internous.dto.UserDTO;
import com.hosoda.internous.util.DBConnector;

public class UserUpdateDAO {
	private UserDTO userDTO = new UserDTO();
	
	public UserDTO getUserInfo(int id,String userMail, String comment, String bike1, String bike2, String bike3, String img){
		Connection con = null;
		DBConnector db = new DBConnector();
		con = db.getConnection();
		
		

		// ps.setString()で使用するリストを作成する。このリストに入力された項目を格納していく。
		List<String> checkList = new ArrayList<>();
		
		String sql = "UPDATE userlogindata SET";
		
		if(!(userMail.equals(""))){
			sql+= " userMail=?,";
			checkList.add(userMail);
		}
		if(!(comment.equals(""))){
			sql+= " comment=?,";
			checkList.add(comment);
		}
		if(!(bike1.equals(""))){
			sql+= " bike1=?,";
			checkList.add(bike1);
		}
		if(!(bike2.equals(""))){
			sql+= " bike2=?,";
			checkList.add(bike2);
		}
		if(!(bike3.equals(""))){
			sql+= " bike3=?,";
			checkList.add(bike3);
		}
		if(!(img.equals(""))){
			sql+= " img=?,";
			checkList.add(img);
		}
		
		// 最後の,を消去する------------		
				Pattern p = Pattern.compile(",$"); //正規表現のパターンを読み込み
				Matcher m = p.matcher(sql); //文字列でマッチするものを検索
				sql = m.replaceFirst(""); //カッコ内のものと置き換える。
				
		sql +=" WHERE id = ?";
		
		System.out.println(sql); //確認用---------
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			
			// checkListの中身をps.setString()に入れていく。
			for (int i = 0; i < checkList.size(); i++) {
				ps.setString(i+1, checkList.get(i));
			}
			ps.setInt(checkList.size()+1,id);
			
			 int count = ps.executeUpdate();
			 System.out.println("アップデート件数"+count);
			
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
