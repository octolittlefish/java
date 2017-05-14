package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import conn.DataConnection;
import javabean.AppointMessage;

public class Appoint extends HttpServlet {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String input;
	String method;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		input = request.getParameter("input");
		System.out.println(input);
		method = request.getParameter("method");
		System.out.println(method);
		conn = (Connection) DataConnection.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "select * from book where " + method + "='" + input + "'";
			// System.out.println(sql);
			String json = "[";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String BookId = rs.getString("bookId");
				String BookName = rs.getString("bookName");
				String Location = rs.getString("location");
				int isAppoint = Integer.parseInt(rs.getString("isAppoint"));
				AppointMessage e = new AppointMessage(BookId, BookName, Location, isAppoint);
				json += e.toString() + ",";
			}
			json = json.substring(0, json.length() - 1);
			json+="]";
			System.out.println(json.toString());
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.flush();
			out.close();
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
