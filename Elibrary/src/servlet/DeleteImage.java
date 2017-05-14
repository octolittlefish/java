package servlet;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import conn.DataConnection;

/**
 * Servlet implementation class DeleteImage
 */
@WebServlet(name = "DeleteImageServlet", urlPatterns = { "/DeleteImageServlet" })
public class DeleteImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection conn = null;
	Statement stmt = null;
    public DeleteImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		conn=(Connection) DataConnection.getConnection();
		String name = request.getParameter("name");
		System.out.println(name);
		try {
			stmt = conn.createStatement();
			String sql = "delete from adv where path='"+name+"'";
			System.out.println(sql);
			stmt.execute(sql);
			stmt.close();
			conn.close();
			response.sendRedirect(request.getHeader("Referer"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
