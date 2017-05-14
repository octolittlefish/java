package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import conn.DataConnection;

/**
 * Servlet implementation class Check
 */
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		conn = DataConnection.getConnection();
		String bookId = request.getParameter("bookId");
		System.out.println(bookId);
		try {
			stmt = conn.createStatement();
			PrintWriter out = response.getWriter();
			JSONObject json = new JSONObject();
			String sql = "select isBorrowed from book where bookId='" + bookId
					+ "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int a = Integer.parseInt(rs.getString("isBorrowed"));
				if (a == 1) {
					json.put("msg", "fail");
				} else {
					json.put("msg", "success");
				}
			}
			out.println(json);
			out.close();
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

