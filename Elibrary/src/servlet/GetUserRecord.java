package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import conn.DataConnection;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetUserRecord
 */
@WebServlet("/GetUserRecord")
public class GetUserRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("contentType","text/html; charset=utf-8");
		Connection conn = null;
		Statement stmt = null;
		String readerid = request.getParameter("readerid");
		if(readerid!=null){
			JSONObject json = new JSONObject();

			ResultSet rs = null;
			String sql = "select * from borrowRecord where readerId=" + "'" + readerid
					+ "'";
			System.out.println(sql);
			try {
				conn = DataConnection.getConnection();
				if(conn==null) System.out.println("null");
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				String bookids = "";
				String readerids = "";
				String expectDate = "";
				String startTime = "";
				String endTime = "";
				String debtDays = "";
				String isLost = "";
				String isBack = "";
				String debt = "";
				String bookName = "";
				String isbn = "";
				String author = "";
				while (rs.next()) {
					ResultSet bookDetail = null;
					Statement stmt2 = null;
					stmt2 = conn.createStatement();
					bookDetail = stmt2.executeQuery( "select * from book where bookId=" + "'" + rs.getString("bookId")
							+ "';");
					bookids+=rs.getString("bookId")+"^";
					readerids+=rs.getString("readerId")+"^";
					expectDate+=rs.getString("expectDate")+"^";
					startTime+=rs.getString("startTime")+"^";
					endTime+=rs.getString("endTime")+"^";
					debtDays+=rs.getString("debtDays")+"^";
					isLost+=rs.getString("isLost")+"^";
					isBack+=rs.getString("isBack")+"^";
					debt+=rs.getString("debt")+"^";
					bookDetail.next();
					bookName+=bookDetail.getString("bookName")+"^";
					isbn+=bookDetail.getString("isbn")+"^";
					author+=bookDetail.getString("author")+"^";
				}
				rs.close();
				stmt.close();
				conn.close();
				json.put("bookids", bookids);
				json.put("readerids", readerids);
				json.put("expectDate", expectDate);
				json.put("startTime", startTime);
				json.put("endTime", endTime);
				json.put("debtDays", debtDays);
				json.put("isLost", isLost);
				json.put("isBack", isBack);
				json.put("debt", debt);
				json.put("bookName", bookName);
				json.put("isbn", isbn);
				json.put("author", author);
				PrintWriter out = response.getWriter();
				out.print(json);
				System.out.println(json);
			} catch (Exception e) {
				e.printStackTrace();  
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

}
