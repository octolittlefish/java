package doMySQL;
	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
    import java.sql.Statement;
	import java.sql.Timestamp;
	import java.util.ArrayList;
import java.util.List;






	public class connectMysql {
		protected static String dbClassName = "com.mysql.jdbc.Driver";
		protected static String dbUrl = "jdbc:mysql://localhost:3306/stusystem";
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
	    String sql = "select *  from admin where name='" + name
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
			/*conn.close();*/
			return true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
       
		try {
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
       }
   private static ResultSet executeQuery(String sql) {
	try {
		if(conn==null)
		new connectMysql();
		return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	} finally {         /*1. ResultSet executeQuery(String sql); 执行SQL查询，并返回ResultSet 对象。
	                    2.int executeUpdate(String sql); 可执行增，删，改，返回执行受到影响的行数。
	                    3. boolean execute(String sql); 可执行任何SQL语句，返回一个布尔值，表示是否返回ResultSet 。*/
	}
}
    private static int executeUpdate(String sql) {
	
	try {
		if(conn==null)
			new connectMysql();
		return conn.createStatement().executeUpdate(sql);
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		//if(e.getMessage().equals("[Microsoft][SQLServer 2000 Driver for JDBC][SQLServer]DELETE 语句与 COLUMN REFERENCE 约束 'FK_TB_BORRO_REFERENCE_TB_BOOKI' 冲突。该冲突发生于数据库 'db_library'，表 'tb_borrow', column 'bookISBN'。"))
			
		return -1;
	} finally {
	}
}

  public static void close() {
	try {
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		conn = null;
	}
} public static int Insert(String sno,String name,String sex,String date,String tel,String identify){
	int i=0;
	try{
		String sql="insert into stu(sno,name,sex,date,tel,identify) values('"+sno+"','"+name+"','"+sex+"','"+date+"','"+tel+"','"+identify+"')";
		i=connectMysql.executeUpdate(sql);
	}catch(Exception e){
		e.printStackTrace();
	}
	return i;
}

public static String[] selectInfo(String s) {
	String string[]=new String[6];
	String sql = "select sno,name,sex,date,tel,class from stu where sno = '"+s+"'";
	ResultSet rs =  connectMysql.executeQuery(sql);
	try {
		while (rs.next()) {
			string[0]=rs.getString("sno");
			string[1]=rs.getString("name");
			string[2]=rs.getString("sex");
			string[3]=rs.getString("date");
			string[4]=rs.getString("tel");
			string[5]=rs.getString("class");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return string;
}

public static String[] selectInfo2(String s) {
	String string[]=new String[6];
	String sql = "select sno,name,sex,date,tel,class from stu where name = '"+s+"'";
	ResultSet rs =  connectMysql.executeQuery(sql);
	try {
		while (rs.next()) {
			string[0]=rs.getString("sno");
			string[1]=rs.getString("name");
			string[2]=rs.getString("sex");
			string[3]=rs.getString("date");
			string[4]=rs.getString("tel");
			string[5]=rs.getString("class");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return string;
}

public static int changeit(String sno,String name,String sex,String date,String tel,String identify){
	int i=0;
	try{
		String sql="UPDATE  stu set sex='"+sex+"',date='"+date+"',tel='"+tel+"',identify='"+identify+"'"+"where sno='"+sno+"'";
		i=connectMysql.executeUpdate(sql);//executeUpdate 的返回值是一个整数，指示受影响的行数（即更新计数）。对于 CREATE TABLE 或 DROP TABLE 等不操作行的语句，executeUpdate 的返回值总为零。
	}catch(Exception e){
		e.printStackTrace();
	}
	return i;
}
  
public static int Insertgrade(String s1,String s2,String s3){
	int i=0;
	try{
		String sql="insert into grad(sno,cno,grade) values('"+s1+"','"+s2+"','"+s3+"')";
		i=connectMysql.executeUpdate(sql);
	}catch(Exception e){
		e.printStackTrace();
	}
	return i;
}  
public static List selectserch(String a) {
	List list=new ArrayList();
	String sql = "select sno,grad.cno,cname,shuxing,ccredit,grade from grad,course where grad.cno=course.cno AND sno='"+a+"'";
	ResultSet s = connectMysql.executeQuery(sql);
	try {
		while (s.next()) {
			stuinfo stuinfo=new stuinfo();
			stuinfo.setSno(s.getString("sno"));
			stuinfo.setCno(s.getString("cno"));
			stuinfo.setName(s.getString("cname"));
			stuinfo.setShuxing(s.getString("shuxing"));
			stuinfo.setCcredit(s.getString("ccredit"));
			stuinfo.setGrade(s.getString("grade"));
			list.add(stuinfo);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
} 
public static List selectteaserch() {
	List list=new ArrayList();
	String sql = "select tname,tcno,tage,ttel from teacher";
	ResultSet s = connectMysql.executeQuery(sql);
	try {
		while (s.next()) {
			teacherinfo teainfo=new teacherinfo();
			teainfo.setTname1(s.getString("tname"));
			teainfo.setTcno1(s.getString("tcno"));
			teainfo.setTage1(s.getString("tage"));
			teainfo.setTtel(s.getString("ttel"));
			list.add(teainfo);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
}


       }
