package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import conn.DataConnection;

public class Reg extends HttpServlet {

	String readerID;
	String idCard;
	String name;
	String password;
	String mpassword;
	String email;
	String phone;
	Connection conn = null;
	Statement stmt = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("utf-8");
		readerID = request.getParameter("readerID");
		idCard = request.getParameter("idCard");
		name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		phone = request.getParameter("phone");
		password = request.getParameter("password");
		mpassword = request.getParameter("mpassword");
		email = request.getParameter("email");
		if (password.equals(mpassword)) {
			conn = (Connection) DataConnection.getConnection();
			try {
				stmt = conn.createStatement();
				String sql = "INSERT INTO reader VALUES ('" + readerID + "', '"
						+ idCard + "', '" + password + "', '" + name + "','"+email+"', '"
						+ phone + "')";
				System.out.println(sql);
				stmt.execute(sql);
				request.getRequestDispatcher("success.jsp").forward(request,
						response);
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendRedirect(request.getHeader("Referer"));
			}
		} else {
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		}
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
