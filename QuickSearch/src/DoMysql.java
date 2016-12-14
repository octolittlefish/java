import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoMysql {
	protected static String dbClassName = "com.mysql.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://localhost:3306/quicksearch";
	protected static String dbUser = "root";
	protected static String dbPwd = "zzy123456";
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	private DoMysql() {
		try {
			if (conn == null) {
				Class.forName(dbClassName).newInstance();
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			} else
				return;
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}

	private static ResultSet executeQuery(String sql) {
		try {
			if (conn == null)
				new DoMysql();
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public static List selectserch(String a,int i) {
		List list=new ArrayList();
		String sql=null;
		if (i==1) {
			 sql = "select * from quicksearch where `absolutePath`='"+a+"'"; 
		}else if (i==2) {
			 sql = "select * from quicksearch where `folder`='"+a+"'";
		}else if (i==3) {
			 sql = "select * from quicksearch where `fileName`='"+a+"'";
		}else{
			 sql = "select * from quicksearch where `suffix`='"+a+"'";
		}
		
		ResultSet s = DoMysql.executeQuery(sql);
		try {
			while (s.next()) {
				MyFile myFile=new MyFile();
				myFile.setAbsolutePathName(s.getString("absolutePath"));
				
				list.add(myFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static int Insert(String a,String b,String c,String d){
		int i=0;
		try{
			String sql="insert into quicksearch values('"+a+"','"+b+"','"+c+"','"+d+"')";
			i=DoMysql.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	 private static int executeUpdate(String sql) {
			
			try {
				if(conn==null)
					new DoMysql();
				return conn.createStatement().executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
					
				return -1;
			} finally {
			}
		}
	 public static int delete(){
		 int i=0;
			try{
				String sql="truncate table quicksearch";
				i=DoMysql.executeUpdate(sql);
			}catch(Exception e){
				e.printStackTrace();
			}
			return i;
		}
	 
}
