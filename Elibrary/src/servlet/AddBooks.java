package servlet;


import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.DataConnection;




/**
 * Servlet implementation class AddBooks
 */
@WebServlet("/AddBooks")
public class AddBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private java.sql.Statement stmt;
    private java.sql.Connection connect;
    private int itemNum = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBooks() {
        super();
    	try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			// Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ELibrary?characterEncoding=utf8", "root", "19951109yg");
			// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

			System.out.println("Success connect Mysql server!");
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book");
			// user 为你表的名称
			
			while (rs.next()) {
				String id = rs.getString("bookId");
				StringTokenizer st = new StringTokenizer(id, "-");
				st.nextToken();
				st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (num > itemNum)
					itemNum = num;
			}
		} catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("contentType", "text/html; charset=utf-8");
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
		if (request.getParameter("title") != null
				&& request.getParameter("title") != "") {
			String title = URLDecoder.decode(request.getParameter("title"),
					"UTF-8");
			String author = URLDecoder.decode(request.getParameter("author"),
					"UTF-8");
			String pubyear = URLDecoder.decode(request.getParameter("pubyear"),
					"UTF-8");
			String publisher = URLDecoder.decode(
					request.getParameter("publisher"), "UTF-8");
			String price = URLDecoder.decode(request.getParameter("price"),
					"UTF-8");
			int amount = 0;
			if (request.getParameter("amount") != null
					&& request.getParameter("amount") != "") {
				amount = Integer.parseInt(URLDecoder.decode(
						request.getParameter("amount"), "UTF-8"));
			}
			String isbn = request.getParameter("isbn");
			String idS = request.getParameter("idS");
			System.out.println(idS);

			if (author == null || author.equals(""))
				author = "unknown";
			if (publisher == null || publisher.equals(""))
				publisher = "unknown";
			if (pubyear == null || pubyear.equals(""))
				pubyear = "unknown";
			if (price == null || price.equals(""))
				price = "unknown";
			price = price.substring(0, price.length() - 1);
			Pattern p = Pattern.compile("(\\d+)");
			Matcher m = p.matcher(price);
			if (m.find()) {
				price = m.group(1);
			}
			String result = idS.substring(0, idS.length() - 1);
			if (isbn != null) {
				Calendar c = Calendar.getInstance();
				String date = c.get(Calendar.YEAR) + "-"
						+ c.get(Calendar.MONTH) + "-" + c.get(Calendar.DATE);
				for (int i = 0; i < amount; i++) {
					String sql = "INSERT INTO Book (bookId,bookName,author,publisher,pubTime,ISBN,bookPrice,addTime) VALUES('"
							+ result
							+ i
							+ "','"
							+ title
							+ "','"
							+ author
							+ "','"
							+ publisher
							+ "','"
							+ pubyear
							+ "','"
							+ isbn + "','" + price + "','" + date + "')";
					// insert(sql);
					Connection conn = DataConnection.getConnection();
					Statement stmt;
					try {
						stmt = conn.createStatement();
						stmt.execute(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(sql);
				}
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

	public int insert(String sql)  
	{ 
		int i = 0;
	    try{  
	    	  System.out.println("success哈哈哈哈");
	    	  Connection conn = DataConnection.getConnection();
	    	  Statement stmt = conn.createStatement();
	    	  stmt.execute(sql);
//	        PreparedStatement preStmt =connect.prepareStatement(sql);  
//	        preStmt.executeUpdate();  
	        System.out.println("success哈哈哈哈");
	    }  
	    catch (SQLException e)  
	    {  
	        e.printStackTrace();  
	    }  
	    return i;//返回影响的行数，1为执行成功  
	}  

	public int getItemNum(){
		int num = 1;
		return num;
	}
}
