package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;

public class AddDAO {
	public static boolean InsertAccount(Connection conn, Member member, HttpServletRequest request) {
		PreparedStatement ptmt= null;
	
		String sql="insert into member(membername,memberdiem,memberpass,categorymemberid) values(?,?,?,?)";
		try {
			ptmt= conn.prepareStatement(sql);
			
			String memberdiem=member.getMemberdiem();
			String membername=member.getMembername();
			String memberpass= member.getMemberpass();
			int categorymemberid=1;
			
			ptmt.setString(1, membername);
			ptmt.setString(2, memberdiem);
			ptmt.setString(3,memberpass );
			ptmt.setInt(4, categorymemberid);
			
			int kt= ptmt.executeUpdate();
			if(kt!=0){
				return true;
			}
			ptmt.close();
		} catch (SQLException e) {
			request.setAttribute("msgAdd", e.getMessage());
		}
		return false;	
	}
}
