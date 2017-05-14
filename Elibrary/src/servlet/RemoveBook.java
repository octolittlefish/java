package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.DataConnection;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class RemoveBook
 */
public class RemoveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookid = request.getParameter("bookid");
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		if(bookid!=null){
			if(isBorrowed(request.getParameter("bookid"))){
				json.put("status", "b");
			}else {
				if(isAppointed(bookid)){
					json.put("status", "a");
				}else {
					deleteBook(request.getParameter("bookid"));
					json.put("status", "d");
				}
			}
			
		}
		out.print(json);
		System.out.println();
		System.out.println("++++++++++");
		System.out.println(json);
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
		String sql1="delete from borrowrecord where bookId='"+bookid+"'";
		String sql2="delete from appoint where bookId='"+bookid+"'";
		System.out.println();
		System.out.println("----------------");
		System.out.println(sql);
		try {
			conn = DataConnection.getConnection();
			PreparedStatement preStmt = conn.prepareStatement(sql);
			Statement stmt = conn.createStatement();
			stmt.execute(sql1);
			stmt.execute(sql2);
			preStmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
