package servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabean.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.DataConnection;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetBookCatalog
 */
@WebServlet("/GetBookCatalog")
public class GetBookCatalog extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private java.sql.Statement stmt;
    private java.sql.Connection connect;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookCatalog() {
        super();
        // TODO Auto-generated constructor stub
    	try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			// Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("contentType","text/html; charset=utf-8");
		String method = request.getParameter("method");
		String input = request.getParameter("input");
		if(method==null||method.equals("")||input==null||input.equals("")){
			
		}else{
			if(method.substring(0,1).equals("S")){
				PrintWriter out = response.getWriter();
				JSONObject json = new JSONObject();
				json.put("flag", "0");
				out.print(json);
			}else{
				if(method.substring(0,1).equals("I")){
					method="ISBN";
				}else if(method.substring(0,1).equals("T")){
					method="bookName";
				}else if(method.substring(0,1).equals("A")){
					method="author";
				}else if(method.substring(0,1).equals("B")){
					method="bookId";
				}
				try {
					  connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ELibrary?characterEncoding=utf8", "root", "19951109yg");
					// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

					stmt = connect.createStatement();
					String sql="";
					sql="select * from Book where "+method+" like '%"+input+"%'";
					if(method.equals("bookId")){
						sql="select * from Book where "+method+" = '"+input+"'";
					}
					System.out.println(sql);
					ResultSet rs = stmt.executeQuery(sql);
					// user 为你表的名称
					PrintWriter out = response.getWriter();
					out.println(getJSON(rs));
					
				} catch (Exception e) {
					System.out.print("get data error!");
					e.printStackTrace();
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
	
	private JSONObject getJSON(ResultSet rs) throws SQLException{
		List<String> isbns = new ArrayList<String>();
		List<Integer> bookNums = new ArrayList<Integer>();
		List<List<Book>> books = new ArrayList<List<Book>>();
		JSONObject json = new JSONObject();
		Connection conn1 = DataConnection.getConnection();
		while (rs.next()) {
			if(!isBorrowed(rs.getString("bookId"),conn1)){
				boolean isAppoint = false;
				if(rs.getString("isAppoint").equals("0")) isAppoint = false;
				else isAppoint = true;
				String isbn = rs.getString("ISBN");
				int ISBNPosition = getISBNPositon(isbns, isbn);
				//如果ISBNS数组中没有此ISBN，新建一个
				if(ISBNPosition==isbns.size()){
					isbns.add(isbn);
					bookNums.add(0);
					books.add(new ArrayList<Book>());
				}
				//新建BOOK 获取数据
				Book book = new Book(rs.getString("bookId"),
						rs.getString("bookName"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getString("pubTime"),
						isbn,
						rs.getString("bookPrice"),
						rs.getString("addTime"),isAppoint);	
				//将新book添加入ArrayList中
				bookNums.set(ISBNPosition, bookNums.get(ISBNPosition)+1);
				List<Book> tempBooks = books.get(ISBNPosition);
				tempBooks.add(book);
				books.set(ISBNPosition, tempBooks);
			}
			
		}
		
		String isbnStr = "";
		String bookStr = "";
		String bookNumsStr = "";
		//System.out.println(books.get(0).size()+bookNums.get(0));
		for(int i = 0; i < books.size(); i++){
			isbnStr+=isbns.get(i)+"^";
			bookNumsStr+=bookNums.get(i)+"^";
			for(int j = 0; j < books.get(i).size(); j++){
				bookStr+=books.get(i).get(j).getId()+
						"$"+books.get(i).get(j).getTitle()+
						"$"+books.get(i).get(j).getAuthor()+
						"$"+books.get(i).get(j).getPublisher()+
						"$"+books.get(i).get(j).getPubTime()+
						"$"+books.get(i).get(j).getIsbn()+
						"$"+books.get(i).get(j).getPrice()+
						"$"+books.get(i).get(j).getAddTime()+
						"$"+books.get(i).get(j).isAppoint();
				
				stmt = connect.createStatement();
				String sql="select * from borrowRecord where bookId = '"+books.get(i).get(j).getId()+"'";
				System.out.print(sql);

				ResultSet isBorrowed = stmt.executeQuery(sql);
				
				boolean flag = false;
				while(isBorrowed.next()) {
					if(isBorrowed.getString("isBack").equals("0")){
						bookStr+="$"+"1"+"^";
						flag = true;
						break;
					}
				}
				if(flag == false) bookStr+="$"+"0"+"^";
				isBorrowed.first();
			}
		}
		json.put("itemnum", books.size());
		json.put("isbns", isbnStr);
		json.put("books", bookStr);
		json.put("nums", bookNumsStr);
		json.put("flag", "1");
		return json;
	}
	
	public int getISBNPositon(List<String> isbns,String isbn){
		for(int i = 0; i < isbns.size();i++){
			if(isbns.get(i).equals(isbn)) return i;
		}	
		return isbns.size();
	}
	
	private boolean isBorrowed(String bookid,Connection conn) throws SQLException {
		// TODO Auto-generated method stub	
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		String sql = "select * from borrowRecord where bookId = '"+bookid+"'";
		try {
			
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
