package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class ScrapBook
 */
@WebServlet("/ScrapBook")
public class ScrapBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScrapBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		String bookid = request.getParameter("bookid");
		String adminid = "2014303433";//request.getParameter("adminid");
		String readerid = request.getParameter("readerid");
		String reason = request.getParameter("reason");
		String price = request.getParameter("price");
		String title = request.getParameter("title");
		System.out.println(bookid);
		if(bookid!=null){
			JSONObject json = new JSONObject();//0-server error 1-success 2-borrowed 3-appointed
			PrintWriter out = response.getWriter();
			if(isBorrowed(bookid)){
				json.put("isSuccess", "2");
			}else if(isAppointed(bookid)){
				json.put("isSuccess", "3");
			}else {
				//��������
				Date today = new Date();
				SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
				String nowDate = sft.format(today);
				//����ʱ��
				Random ra = new Random();
				int id = ra.nextInt(1000000000);
				
				System.out.println(URLDecoder.decode(title,"UTF-8")+URLEncoder.encode(URLEncoder.encode(title,"UTF-8"),"UTF-8"));
				String sql = "insert into brokenRecord(BRecordId,adminId,readId,bookId,bookName,Reason,isCompensed,compensationPrice,compensationTime) values ('"+
						id+"','"+adminid+"','"+readerid+"','"+bookid+"','"+URLDecoder.decode(title,"UTF-8")+"','"+URLDecoder.decode(reason,"UTF-8")+"','"+1+"','"+price+"','"+nowDate+"');";
				deleteBook(bookid);
				System.out.println(sql);
				try {
					conn = DataConnection.getConnection();
					PreparedStatement preStmt = conn.prepareStatement(sql);
					preStmt.executeUpdate();
					json.put("isSuccess", "1");
				} catch (Exception e) {
					e.printStackTrace();
					json.put("isSuccess", "0");
				}	
			}
			out.println(json);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean isBorrowed(String bookid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from borrowRecord where bookId = '"+bookid+"'";
		try {
			conn = DataConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("isBack").equals("0"))
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean isAppointed(String bookid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from appoint where bookId = '"+bookid+"'";
		try {
			conn = DataConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean deleteBook(String bookid) {
		Connection conn = null;
		String sql = "delete from book where bookId='"+bookid+"'";
		System.out.println();
		System.out.println("----------------");
		System.out.println(sql);
		try {
			conn = DataConnection.getConnection();
			PreparedStatement preStmt = conn.prepareStatement(sql);
			preStmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
