package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import conn.DataConnection;
import javabean.ReserveMessage;

public class Reserve extends HttpServlet {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		conn = (Connection) DataConnection.getConnection();
		try {
			stmt = conn.createStatement();
			String sql ="select * from appoint";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			String json="[";
			while(rs.next()){
				String appointId = rs.getString("appointId");
				String BookId  =rs.getString("bookId");
				String ReaderName = rs.getString("readerId");
				String AppointTim = rs.getString("appointTime");
				String AppointLastTime = rs.getString("appointLastTime");
				String isSucceed;
				if(Integer.parseInt(rs.getString("isSucceed")) == 1){
					 isSucceed = "成功";
				}else{
					 isSucceed = "失败";
				}
				ReserveMessage e = new ReserveMessage(appointId,BookId,ReaderName,AppointTim,AppointLastTime,isSucceed);
				json +=e.toString()+",";
			}
			json = json.substring(0, json.length()-1);
			json+="]";
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			System.out.println(json.toString());
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
