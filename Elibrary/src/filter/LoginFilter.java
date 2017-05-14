package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	 public static final String login_page = "/Elibrary/index.jsp";  
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		String url = servletRequest.getRequestURI();
		System.out.println(url);
		String readerName = (String) session.getAttribute("readerName");
		// 登陆页面无需过滤
		if (url.equals("/Elibrary") || url.equals("/Elibrary/LogoutServlet")
				|| url.equals("/Elibrary/index.jsp")) {
			session.invalidate();
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		if ((readerName == null) || ("".equals(readerName))) {
			System.out.println("session没有值");
			servletResponse.sendRedirect("index.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
