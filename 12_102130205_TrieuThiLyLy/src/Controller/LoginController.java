package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Member;
import DAO.HomeDAO;
import DAO.LoginDAO;
import DB.DBConnection;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		if(request.getCharacterEncoding()== null){
			request.setCharacterEncoding("UTF-8");
		}
		
		String membername=request.getParameter("membername");
		String memberpass=request.getParameter("memberpass");
		
		Member member= new Member();
		member.setMembername(membername);
		member.setMemberpass(memberpass);
		
//		String name= LoginDAO.Exportmember(member, request, conn);
		
		boolean authentication =LoginDAO.Authenticationmember(member, request, conn);
		if(authentication){
			int authorization= LoginDAO.Authorizationmember(member, request, conn);
			if(authorization == 1){
				HttpSession session = request.getSession();
				
				request.getSession().setAttribute("sessionuser", membername);
				List<Member> list= HomeDAO.DisplayAccount(conn, membername);
				request.setAttribute("listAccount", list);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("Student/Home.jsp");
				rd.forward(request, response);
			}
			else{
				HttpSession session = request.getSession();
				
				request.getSession().setAttribute("sessionadmin", membername);
				
				RequestDispatcher rd = request.getRequestDispatcher("AdminFwd");
				rd.forward(request, response);
			}
		}
		else{
			request.setAttribute("msglogin", "Đăng nhập thất bại- thử lại");
			RequestDispatcher rd = request.getRequestDispatcher("View/Login.jsp");
			rd.forward(request, response);
		}
	}

}
