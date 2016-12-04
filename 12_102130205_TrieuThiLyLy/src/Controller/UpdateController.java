package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Member;
import DAO.UpdateDAO;
import DB.DBConnection;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		if(request.getCharacterEncoding()== null){
			request.setCharacterEncoding("UTF-8");
		}
		
		int memberid= Integer.parseInt(request.getParameter("memberid"));
		String memberdiem=request.getParameter("memberdiem");
		String membername=request.getParameter("membername");
		String memberpass=request.getParameter("memberpass");
		
		
		Member member= new Member(memberid, membername, memberpass, 1 , memberdiem);
		
		boolean kt = UpdateDAO.UpdateAccount(conn, member);
		
		if(kt){
			request.setAttribute("msgUpdate", "Nhập điểm thành công");
			RequestDispatcher rd= request.getRequestDispatcher("AdminFwd");
			rd.forward(request, response);
		}
		else{
			request.setAttribute("msgUpdate", "Nhập điểm thất bại");
			RequestDispatcher rd= request.getRequestDispatcher("Admin/Update.jsp");
			rd.forward(request, response);
		}
	}

}
