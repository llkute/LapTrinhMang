package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.Member;

public class UpdateDAO {
	public static Member FindAccount(Connection conn, String id) {
		
		PreparedStatement ptmt= null;
		
		String sql="select * from member where memberid ='"+id+"'";
		
		try {
			ptmt= conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				String membername=rs.getString("membername");
				String memberdiem=rs.getString("memberdiem");
				String memberpass=rs.getString("memberpass");
				
				Member acc= new Member();
				
				acc.setMembername(membername);
				acc.setMemberdiem(memberdiem);
				acc.setMemberpass(memberpass);
				acc.setMemberid(Integer.parseInt(id));
				return acc;
				
			}
			rs.close();
			ptmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static boolean UpdateAccount(Connection conn, Member member) {
		
		PreparedStatement ptmt= null;
		
		String sql="Update member set memberdiem=? where memberid=? ";
		try {
			ptmt= conn.prepareStatement(sql);
			ptmt.setString(1, member.getMemberdiem());
			ptmt.setInt(2, member.getMemberid());
			
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
