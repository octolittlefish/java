package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetItemNum
 */
@WebServlet("/GetItemNum")
public class GetItemNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private java.sql.Statement stmt;
    private java.sql.Connection connect;
    private int itemNum = 0;
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public GetItemNum() throws SQLException, ClassNotFoundException {
        super();
        // TODO Auto-generated constructor stub
        Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ELibrary?characterEncoding=utf8", "root", "19951109yg");
		// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

		System.out.println("Success connect Mysql server!");
		stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from book");
		// user 为你表的名称
		
		while (rs.next()) {
			String id = rs.getString("bookId");
			System.out.println("哈哈哈哈哈"+id);
			StringTokenizer st = new StringTokenizer(id, "-");
			String s[] = id.split("-");
			//System.out.println("呵呵呵呵呵"+st.nextToken());
			//System.out.println("呵呵呵呵呵呵呵呵呵呵"+st.nextToken());
			int num = Integer.parseInt(s[2]);
			if (num > itemNum)
				itemNum = num;
		}
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println(itemNum);
		itemNum++;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
