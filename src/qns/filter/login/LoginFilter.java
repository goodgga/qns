package qns.filter.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter("/UserFilter")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		HttpSession hs = req.getSession();
		if (uri.endsWith("login.jsp") || uri.endsWith("login.do")) {
			String userKey = (String) hs.getAttribute("userKey");
			String passKey = (String) hs.getAttribute("passKey");
			if(userKey != null && userKey.length() == 36 && passKey != null && passKey.length() == 36){
				rep.sendRedirect(req.getContextPath() + "/");
			}else{
				chain.doFilter(request, response);
			}
		} else if(uri.endsWith("register.jsp") || uri.endsWith("register.do")){
			String userKey = (String) hs.getAttribute("userKey");
			String passKey = (String) hs.getAttribute("passKey");
			if(userKey != null && userKey.length() == 36 && passKey != null && passKey.length() == 36){
				rep.sendRedirect(req.getContextPath() + "/");
			}else{
				rep.sendRedirect(req.getContextPath() + "/login/login.jsp");
			}
		} else {
			String userKey = (String) hs.getAttribute("userKey");
			String passKey = (String) hs.getAttribute("passKey");
			if(userKey != null && userKey.length() == 36 && passKey != null && passKey.length() == 36){
				chain.doFilter(request, response);
			}else{
				rep.sendRedirect(req.getContextPath() + "/login/login.jsp");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
