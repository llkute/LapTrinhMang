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

import BEAN.Member;
import DAO.AddDAO;
import DAO.HomeDAO;
import DB.DBConnection;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
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
		
		
		String memberdiem=request.getParameter("memberdiem");
		String membername=request.getParameter("membername");
		String memberpass=request.getParameter("memberpass");
		
		Member member= new Member();
		member.setMemberdiem(memberdiem);
		member.setMembername(membername);
		member.setMemberpass(memberpass);
		boolean test= AddDAO.InsertAccount(conn, member, request);
		
		if(test){
			
			request.setAttribute("msgAdd", "Thêm thành công");		
			RequestDispatcher rd = request.getRequestDispatcher("AddFwd");
			rd.forward(request, response);
		}
		else{
			request.setAttribute("msgAdd", "Thêm thất bại");		
			RequestDispatcher rd = request.getRequestDispatcher("AddFwd");
			rd.forward(request, response);
		}
	}

}
