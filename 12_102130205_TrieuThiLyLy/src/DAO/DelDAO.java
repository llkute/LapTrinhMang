package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BEAN.Member;

public class DelDAO {
public static boolean DelAccount(Connection conn, int id) {
		
		PreparedStatement ptmt= null;
		
		String sql="Delete from member where memberid = ?";
		try {
			ptmt= conn.prepareStatement(sql);
			
			ptmt.setInt(1, id);
			
			int kt= ptmt.executeUpdate();
			if(kt!=0){
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
