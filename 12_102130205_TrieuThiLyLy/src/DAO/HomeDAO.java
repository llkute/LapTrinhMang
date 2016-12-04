package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.Member;



public class HomeDAO {
	public static List<Member> DisplayAccount(Connection conn, String name) {
		List<Member> list= new ArrayList<Member>();
		PreparedStatement ptmt= null;
		
		String sql="select * from member where membername='"+name+"'";
		
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
				list.add(acc);
			}
			rs.close();
			ptmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static List<Member> DisplayAllAccount(Connection conn) {
		List<Member> list= new ArrayList<Member>();
		PreparedStatement ptmt= null;
		
		String sql="select * from member where categorymemberid !='"+2+"'";
		
		try {
			ptmt= conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				String membername=rs.getString("membername");
				String memberdiem=rs.getString("memberdiem");
				String memberpass=rs.getString("memberpass");
				int memberid=rs.getInt("memberid");
				Member acc= new Member();
				
				acc.setMembername(membername);
				acc.setMemberdiem(memberdiem);
				acc.setMemberpass(memberpass);
				acc.setMemberid(memberid);
				list.add(acc);
			}
			rs.close();
			ptmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
