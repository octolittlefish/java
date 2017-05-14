package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import conn.DataConnection;

public class DeleteAppoint extends HttpServlet {

	Connection conn = null;
	Statement stmt = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String appointId = request.getParameter("appointId");
		System.out.println(appointId);
		conn = (Connection) DataConnection.getConnection();
		try {
			stmt =conn.createStatement();
			String sql="delete from appoint where appointId='"+appointId+"'";
			System.out.println(sql);
			stmt.execute(sql);
			stmt.close();
			conn.close();
			response.sendRedirect(request.getHeader("Referer"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

