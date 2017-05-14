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
import javabean.ExceedMessage;

public class Exceed extends HttpServlet {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	int num;
	String sql;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application./json");
		response.setCharacterEncoding("utf-8");
		conn = (Connection) DataConnection.getConnection();
		try {
			num = Integer.parseInt(request.getParameter("num"));
		} catch (NumberFormatException e) {
			num = 1;
		}
		try {
			stmt = conn.createStatement();
			if (num == 1000) {
				sql = "select * from reader join borrowrecord on reader.readerId=borrowrecord.readerId join book on borrowrecord.bookId=book.bookId where isBack=0 and debtDays>30";
			}else if(num == 1){
				sql = "select * from reader join borrowrecord on reader.readerId=borrowrecord.readerId join book on borrowrecord.bookId=book.bookId where isBack=0 and debtDays=31";
			}else if(num==3){
				sql = "select * from reader join borrowrecord on reader.readerId=borrowrecord.readerId join book on borrowrecord.bookId=book.bookId where isBack=0 and debtDays>30 and debtDays<34";
			}else if(num==4){
				sql = "select * from reader join borrowrecord on reader.readerId=borrowrecord.readerId join book on borrowrecord.bookId=book.bookId where isBack=0 and debtDays>34 and debtDays>30";
			}else{
				sql = "select * from reader join borrowrecord on reader.readerId=borrowrecord.readerId join book on borrowrecord.bookId=book.bookId where isBack=0 and debtDays>30 and debtDays<"+num;
			}
			System.out.println(sql);
			String json = "[";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String BookId = rs.getString("book.bookId");
				String ReaderId = rs.getString("reader.readerId");
				String ReaderName = rs.getString("reader.readerName");
				String BookName = rs.getString("book.bookName");
				String StartTime = rs.getString("borrowrecord.startTime");
				String ExpectReturnTime = rs.getString("borrowrecord.expectDate");
				String DebtDays = rs.getString("borrowrecord.debtDays");
				String Email = rs.getString("reader.readerEmail");
				ExceedMessage e = new ExceedMessage(BookId, ReaderId, ReaderName, BookName, StartTime, ExpectReturnTime,
						DebtDays, Email);
				json += e.toString() + ",";
			}
			json = json.substring(0, json.length() - 1);
			json += "]";
			PrintWriter out = response.getWriter();
			out.println(json.toString());
			System.out.println(json.toString());
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
