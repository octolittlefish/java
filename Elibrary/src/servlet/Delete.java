package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import conn.DataConnection;

public class Delete extends HttpServlet {

	Connection conn = null;
	Statement stmt = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		String readerId = request.getParameter("readerId");
		conn = (Connection) DataConnection.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "delete from reader where readerId=" + readerId;
			stmt.execute(sql);
			//request.getRequestDispatcher("").forward(request, response);
			response.sendRedirect(request.getHeader("Referer"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
