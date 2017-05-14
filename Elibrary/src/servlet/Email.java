package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.SendFailedException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.Mail;

public class Email extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println(name);
		String email = request.getParameter("email");
		System.out.println(email);
		String bookName = request.getParameter("bookName");
		String message = "尊敬的"+name+"先生,您好,您在图书馆借的名为\""+bookName+"\"的书已经逾期，为了避免您支付逾期金额，请您尽快归还。";
		System.out.println(message);
		Mail m = new Mail();
		try {
			m.sendMail(email,name,message);
			request.getRequestDispatcher("SEmail.jsp").forward(request,
					response);
		} catch (SendFailedException e) {
			e.printStackTrace();
		}
	}
}
