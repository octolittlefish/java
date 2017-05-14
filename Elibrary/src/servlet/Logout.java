package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet(name = "LogoutServlet", urlPatterns = { "/LogoutServlet" })
public class Logout extends HttpServlet {
	HttpSession session;
	private static final long serialVersionUID = 1L;
    public Logout() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		session.removeAttribute("readerName");
		session.removeAttribute("readerId");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
