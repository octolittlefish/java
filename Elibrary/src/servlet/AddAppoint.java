package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;
import conn.DataConnection;

public class AddAppoint extends HttpServlet {

	Connection conn = null;
	Statement stmt = null;
	String bookId;
	String readerId;
	String appointId;
	private static int id = 1;
	String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		result="";
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		bookId = request.getParameter("bookId");
		System.out.println(bookId);
		readerId = request.getParameter("readerId");
		System.out.println(readerId);
		appointId = Random(15);
		conn = (Connection) DataConnection.getConnection();
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String appointTime = format.format(date);
		String appointLastTime = getTimeByHour(48);
		System.out.println(appointLastTime);
		try {
			result = "true";
			stmt = conn.createStatement();
//			String sql = "INSERT INTO appoint VALUES ('" + appointId + "', '" + bookId + "', '" + readerId + "', '"
//					+ appointTime + "', '" + appointLastTime + "', '0')";
			String sql="INSERT INTO appoint(bookId,readerId,appointTime,appointLastTime)  VALUES ('"+bookId+"', '"+readerId+"', '"+appointTime+"', '"+appointLastTime+"')";
			System.out.println(sql);
			stmt.execute(sql);
			sql = "update book set isAppoint=1 where bookId='"+bookId+"'";
			stmt.execute(sql);
			sql = "update book set isAppoint=1 where bookId='" + bookId + "'";
			System.out.println(sql);
			stmt.execute(sql);
			PrintWriter out = response.getWriter();
			out.print(result);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String Random(int length) {

		String str = String.valueOf(id++);
		System.out.println(str);
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf((id++)));
		for (int i = str.length(); i < length; ++i) {
			int number = random.nextInt(3);
			long result = 0;
			switch (number) {
			case 0:
				result = Math.round(Math.random() * 25 + 65);
				sb.append(String.valueOf((char) result));
				break;
			case 1:
				result = Math.round(Math.random() * 25 + 97) - 32;
				sb.append(String.valueOf((char) result));
				break;
			case 2:
				sb.append(String.valueOf(new Random().nextInt(10)));
				break;
			}
		}
		return sb.toString();
	}

	public static String getTimeByMinute(int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minute);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	public static String getTimeByHour(int hour) {

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}
}
