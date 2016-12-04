package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DelDAO;
import DB.DBConnection;

/**
 * Servlet implementation class DelFwd
 */
@WebServlet("/DelFwd")
public class DelFwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelFwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		if(request.getCharacterEncoding()== null){
			request.setCharacterEncoding("UTF-8");
		}
		int id= Integer.parseInt(request.getParameter("id"));
		boolean kt= DelDAO.DelAccount(conn, id);
		if(kt){
			request.setAttribute("msgDel", "Xóa thành công");
			RequestDispatcher rd= request.getRequestDispatcher("AdminFwd");
			rd.forward(request, response);
		}
		else{
			request.setAttribute("msgDel", "Xóa thất bại");
			RequestDispatcher rd= request.getRequestDispatcher("AdminFwd");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
