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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.DataConnection;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetReturnDetail
 */
@WebServlet("/GetReturnDetail")
public class GetReturnDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReturnDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(1111);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		Connection conn = DataConnection.getConnection();
	    Statement stmt;
		String bookid = request.getParameter("bookid");
		
		String sql = "Select * from borrowRecord where bookId='" + bookid + "' and isBack='0'";
		ResultSet rs = null;
		
		boolean flag = false;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				if(rs.getString("isBack").equals("0"))
				{
					flag = true;
					break;
				}
			}
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if(bookid!=null && flag){
			JSONObject json = new JSONObject();
			String sql1 = "Select * from borrowRecord where bookId = '"+bookid+"';";
			String sql2 = "Select * from book where bookId = '"+bookid+"';";
		
			
			try {
				//conn = DataConnection.getConnection();
				stmt = conn.createStatement();
				ResultSet rs1 = stmt.executeQuery(sql1);
				if(rs1.next()){
					json.put("exist", "1");
					json.put("startdates", rs1.getString("startTime"));
					json.put("expectdates", rs1.getString("expectDate"));
					System.out.println("2");
					Statement stmt2 = conn.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql2);
					rs2.next();
					json.put("titles", rs2.getString("bookName"));
					json.put("authors", rs2.getString("author"));
					json.put("publishers", rs2.getString("publisher"));
					json.put("deposits", rs2.getString("bookPrice"));
					json.put("reader", rs1.getString("readerId"));
					System.out.println(getPrice(rs2.getString("bookPrice"),rs1.getString("startTime")));
					json.put("cost", String.valueOf(getPrice(rs2.getString("bookPrice"),rs1.getString("startTime"))));
					System.out.println(sql1+"\n"+sql2);
				}	else {
					json.put("exist", "0");
				}
				PrintWriter out = response.getWriter();
				out.print(json);
				System.out.println(json);
			} catch (Exception e) {
				e.printStackTrace();  
			}
		}else if(bookid==null){
			JSONObject json = new JSONObject();
			json.put("exist", 2);
			PrintWriter out = response.getWriter();
			out.print(json);
		}else if(!flag){
			JSONObject json = new JSONObject();
			json.put("exist", 3);
			PrintWriter out = response.getWriter();
			out.print(json);
		}
	}

	private double getPrice(String string,String startDate) {
		// TODO Auto-generated method stub
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
		double v = 0;
		if(days<=30){
			v=0;
		}else if(days>30&&days<=40){
			v=0.25;
		}else if(days>40&&days<=50){
			v=0.5;
		}else {
			v=1;
		}
		return v*Integer.parseInt(string)+1;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static int daysBetween(String smdate,String bdate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);
		return Integer.parseInt(String.valueOf(between_days));
				
	}
}
