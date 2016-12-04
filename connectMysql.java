package ChatTo;
	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.sql.Statement;
	import java.sql.Timestamp;
	import java.util.ArrayList;
import java.util.List;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;


	


	public class connectMysql {
		protected static String dbClassName = "com.mysql.jdbc.Driver";
		protected static String dbUrl = "jdbc:mysql://localhost:3306/qchat";
		protected static String dbUser = "root";
		protected static String dbPwd = "zzy123456";
		private static Connection conn = null;
		private static Statement stmt=null;
		private static ResultSet rs=null;
		
		private connectMysql() {
			try {
				if (conn == null) {
					Class.forName(dbClassName).newInstance();
					conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
				}
				else
					return;
			} catch (Exception ee) {
				ee.printStackTrace();
			}

		}
public static boolean check(String name, String password) {
	           if(conn==null){
	        	   new connectMysql();
	             }
	    String sql = "select *  from user where username='" + name
			                 + "' and password='" + password+"'" ;
	try {
	      stmt = conn.createStatement();
	} catch (SQLException e2) {
		e2.printStackTrace();
	}
	try {
		  rs = (ResultSet) stmt.executeQuery(sql);
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	try {
		if (rs.next()) {
			
			return true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
       
		
		return false;
       }


public static int login(String name, String password) {
	int i=0;
    if(conn==null){
 	   new connectMysql();
      }
String sql = "insert into user  (username,password) values('"+name+"','"+password+"')";
try {
     stmt = conn.createStatement();
} catch (SQLException e2) {
e2.printStackTrace();
}
try {
   i=stmt.executeUpdate(sql);
} catch (SQLException e1) {
e1.printStackTrace();
}

return i;

}
       }
