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

public class Exist extends HttpServlet {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String readerId = null;
	boolean flag;
	String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		conn = (Connection) DataConnection.getConnection();
		readerId = request.getParameter("readerId");
		System.out.println(readerId);
		flag = false;
		try {
			stmt = conn.createStatement();
			String sql = "select readerName from reader where readerId='" + readerId + "'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if ((rs.getString("readerName")) != null || (rs.getString("readerName")) != "") {
					flag = true;
					System.out.println(rs.getString("readerName"));
				}
			}
			PrintWriter out = response.getWriter();
			if (flag) {
				result = "success";
			} else {
				result = "fail";
			}
			out.print(result);
			System.out.println(result);
			out.close();
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
