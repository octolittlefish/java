package filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SingleFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();

		boolean isLogin = session.getAttribute("readerName") != null;
		System.out.println("----SingleFilter.isLogin = " + isLogin);
		if (isLogin) {
			String readerName = (String) session.getAttribute("readerName");
			String 	readerId = (String) session.getAttribute("readerId");
			
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
