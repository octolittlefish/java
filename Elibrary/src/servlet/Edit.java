package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import conn.DataConnection;
import javabean.BorrowRecord;
import javabean.ReaderMessage;

public class Edit extends HttpServlet {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	ReaderMessage readerMessage;
	List<BorrowRecord> lists = new ArrayList<BorrowRecord>();
	String readerID;
	String idCard ;
	String name ;
	String phone ;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		lists.clear();
		String readerId = request.getParameter("readerId");
		System.out.println(readerId);
		conn = (Connection) DataConnection.getConnection();
		try {
			
			stmt = conn.createStatement();
			String sql = "select * from reader join borrowrecord on reader.readerId=borrowrecord.readerId join book on borrowrecord.bookId=book.bookId where reader.readerId='"
					+ readerId + "'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				String BookId = rs.getString("book.bookId");
				String BookName = rs.getString("book.bookName");
				String StartTime = rs.getString("borrowrecord.startTime");
				String ExpectReturnTime = rs.getString("borrowrecord.expectDate");
				String IsLost;
				String IsBack;
				if (Integer.parseInt(rs.getString("borrowrecord.isLost")) == 0) {
					IsLost = "未丢失";
				} else {
					IsLost = "丢失";
				}
				if (Integer.parseInt(rs.getString("borrowrecord.isBack")) == 1) {
					IsBack = "已归还";
				} else {
					IsBack = "未归还";
				}
				String debt = rs.getString("borrowrecord.debt");
				BorrowRecord b = new BorrowRecord(BookId, BookName, StartTime, ExpectReturnTime, IsLost,
						IsBack, debt);
				lists.add(b);
			}
			sql = "select * from reader where readerId='"+readerId+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				 readerID = rs.getString("readerId");
				 idCard = rs.getString("idCard");
				 name = rs.getString("readerName");
				 phone = rs.getString("readerPhone");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		readerMessage = new ReaderMessage(readerID,idCard,name,phone);
		session.setAttribute("readerMessage", readerMessage);
		session.setAttribute("lists", lists);
		request.getRequestDispatcher("introduce.jsp").forward(request, response);
	}
}
