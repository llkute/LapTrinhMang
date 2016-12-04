package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;


public class LoginDAO {
	public static boolean Authenticationmember(Member member, HttpServletRequest request ,Connection conn) {
		PreparedStatement ptmt= null;
		
		String sql="select * from member";
		
		try {
			ptmt= conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				String membername= rs.getString("membername") ;
				
				String memberpass= rs.getString("memberpass") ;
				
				if(member.getMembername().equals(membername) && member.getMemberpass().equals(memberpass) ){
					return true;
				}
				
			}
			rs.close();
			ptmt.close();
			
		} catch (SQLException e) {
			request.setAttribute("msglogin", e.getMessage());
		}
		return false;
	}
	
	public static int Authorizationmember(Member member, HttpServletRequest request ,Connection conn) {
		PreparedStatement ptmt= null;
		int categorymemberid=0;
		String sql="select categorymemberid from member where membername='"+member.getMembername()+"' AND memberpass='"
				+member.getMemberpass()+"'";
		
		try {
			ptmt= conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				categorymemberid= rs.getInt("categorymemberid");
			
			}
			rs.close();
			ptmt.close();
			
		} catch (SQLException e) {
			request.setAttribute("msglogin", e.getMessage());
		}
		return categorymemberid;
	}
	public static String Exportmember(Member member, HttpServletRequest request ,Connection conn) {
		PreparedStatement ptmt= null;
		String name = null;
		String sql="select name from member where membername='"+member.getMembername()+"' AND memberpass='"
				+member.getMemberpass()+"'";
		
		try {
			ptmt= conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				name= rs.getString("name");
			
			}
			rs.close();
			ptmt.close();
			
		} catch (SQLException e) {
			request.setAttribute("msglogin", e.getMessage());
		}
		return name;
	}
	
	
}
