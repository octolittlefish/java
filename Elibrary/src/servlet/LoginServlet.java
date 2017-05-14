package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import conn.DataConnection;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		String readerId = request.getParameter("readerId");
		System.out.println(readerId);
		String password = request.getParameter("password");
		System.out.println(password);
		String sql = "select * from administrator where adminId=" + "'" + readerId
				+ "'";
		System.out.println(sql);
		try {
			conn = (Connection) DataConnection.getConnection();
			stmt = (Statement) conn.createStatement();
			rs = (ResultSet) stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("password").equals(password)) {
					session.setAttribute("readerId", readerId);
					session.setAttribute("readerName",rs.getString("adminName"));
					request.getRequestDispatcher("main1.jsp").forward(
							request, response);
				} else {
					request.getRequestDispatcher("index.jsp").forward(request,
							response);
				}
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}
}
