package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.DataConnection;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetBookDetail
 */
@WebServlet("/GetBookDetail")
public class GetBookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	Statement stmt = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String bookid = request.getParameter("bookid");
		if(bookid!=null){
			PrintWriter out = response.getWriter();
			JSONObject json = new JSONObject();
			if(!isBorrowed(bookid)){
				try {
					conn = DataConnection.getConnection();
					stmt = conn.createStatement();
					ResultSet rs = null;
					String sql = "Select * from book where bookId = "+bookid;
					rs = stmt.executeQuery(sql);
					System.out.println(sql);
					
					if(rs.next()){
						json.put("exist", "1");
						json.put("bookName", rs.getString("bookName"));
						json.put("bookId", rs.getString("bookId"));
						json.put("author", rs.getString("author"));
						json.put("publisher", rs.getString("publisher"));
						json.put("ISBN", rs.getString("ISBN"));
						json.put("bookPrice", rs.getString("bookPrice"));
						System.out.println(json);
						out.println(json);
					}	
					else {
						json.put("exist", "0");
						out.println(json);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				json.put("exist", "2");
				out.println(json);
			}
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
		String sql = "select * from borrowRecord where bookId = "+bookid+"";
		System.out.println(sql);
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
}
