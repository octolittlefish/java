package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.DataConnection;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class LentBook
 */
@WebServlet("/LentBook")
public class LentBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LentBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("contentType","text/html; charset=utf-8");
		Connection conn = null;
		Statement stmt = null;
		// TODO Auto-generated method stub
		String readerid = request.getParameter("readerid");
		String bookid = request.getParameter("bookid");
		String total = request.getParameter("total");

		if (readerid != null) {
			ResultSet rs = null;
			Date today = new Date();
			SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
			String nowDate = sft.format(today);
			String expect = afterNDay(30);
			Random ra = new Random();
			int id = ra.nextInt(1000000000);
			String sql = "insert into borrowRecord (recordId,bookId,readerId,expectDate,startTime,debtDays) values ("
					+ "'" + id + "'," + "'" + bookid + "'," + "'" + readerid + "'," + "'" + expect + "'," + "'" + nowDate
					+ "'," + "'" + 0 + "'" + ")";
			System.out.println(sql);
			String sql1 = "update book set isBorrowed=1 where bookId='"+bookid+"'";
			System.out.println(sql1);
			PrintWriter out = response.getWriter();
			try {
				conn = DataConnection.getConnection();
				stmt = conn.createStatement();
				stmt.execute(sql1);
				PreparedStatement preStmt = conn.prepareStatement(sql);
				preStmt.executeUpdate();
				JSONObject json = new JSONObject();
				json.put("exist", "1");
				out.println(json);
			} catch (SQLException e) {
				e.printStackTrace();
				JSONObject json = new JSONObject();
				json.put("exist", "0");
				out.println(json);
			}
			
			dealMoney(total, readerid, false);
			
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

	public static String afterNDay(int n) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(new Date());
		c.add(Calendar.DATE, n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}
	
	public void dealMoney(String money,String readerid,boolean add){
		JSONObject json = new JSONObject();
		Connection conn = null;
		Statement stmt = null;
		System.out.println(readerid);
		String sql="";
		if(add) {
			sql = "update debitCard set balance = balance +" +money+" where readerId = '"+readerid+"';";
		}else {
			sql = "update debitCard set balance = balance -" +money+" where readerId = '"+readerid+"';";
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
