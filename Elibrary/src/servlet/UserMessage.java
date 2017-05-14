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
import javabean.Reader;

public class UserMessage extends HttpServlet {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		conn = (Connection) DataConnection.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "select readerId,idCard,readerName,readerPhone,readerEmail from reader";
			rs = stmt.executeQuery(sql);
			Reader reader = new Reader();
			String json = "[";
			while (rs.next()) {
				reader.setReaderId(rs.getString("readerId"));
				reader.setIdCard(rs.getString("idCard"));
				reader.setReaderName(rs.getString("readerName"));
				reader.setReaderPhone(rs.getString("readerPhone"));
				reader.setEmail(rs.getString("readerEmail"));
				json += reader.toString() + ",";
			}
			json = json.substring(0, json.length() - 1);
			json += "]";
			System.out.println(json.toString());
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
