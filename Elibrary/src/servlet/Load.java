package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import conn.DataConnection;

/**
 * Servlet implementation class Load
 */
@WebServlet(name = "LoadServlet", urlPatterns = { "/LoadServlet" })
public class Load extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public Load() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		conn = (Connection) DataConnection.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "select * from adv";
			rs = stmt.executeQuery(sql);
			String json = "[";
			while (rs.next()) {
				json += "{\"name\":\"" + rs.getString("path") + "\"},";
			}
			json = json.substring(0, json.length() - 1);
			json+="]";
			System.out.println(json.toString());
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
