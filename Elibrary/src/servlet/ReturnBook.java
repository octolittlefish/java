package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import conn.DataConnection;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReturnBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		String bookid = request.getParameter("bookid");
		String startDate = request.getParameter("startdate");
		String cost = request.getParameter("cost");
		String refund = request.getParameter("refund");
		String readerid = request.getParameter("readerid");
		PrintWriter out = response.getWriter();

		String sql = "select * from appoint where bookId='" + bookid + "';";

		conn = DataConnection.getConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				out.print("1");
			} else {
				out.print("0");
			}

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (bookid != null) {
			// 本日日期
			Date today = new Date();
			SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
			String nowDate = sft.format(today);
			int days = 0;
			try {
				days = daysBetween(startDate, nowDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			sql = "Update borrowRecord set endTime = '" + nowDate + "', debtDays = '" + days + "',isBack = '" + 1
					+ "',debt = '" + cost + "' where bookId = '" + bookid + "';";
			System.out.println(sql);
			try {
				conn = DataConnection.getConnection();
				PreparedStatement preStmt = conn.prepareStatement(sql);
				preStmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			dealMoney(refund, readerid, true);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static int daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));

	}

	public void dealMoney(String money, String readerid, boolean add) {
		JSONObject json = new JSONObject();
		Connection conn = null;
		Statement stmt = null;
		System.out.println(readerid);
		String sql = "";
		if (add) {
			sql = "update debitCard set balance = balance +" + money + " where readerId = '" + readerid + "';";
		} else {
			sql = "update debitCard set balance = balance -" + money + " where readerId = '" + readerid + "';";
		}
		System.out.println(sql);
		try {
			conn = DataConnection.getConnection();
			PreparedStatement preStmt = conn.prepareStatement(sql);
			preStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
