package qns.servlet.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qns.tools.mail.QnsMail;

/**
 * Servlet implementation class Core
 */
@WebServlet("/Core")
public class Core extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Core() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		HttpSession hs = request.getSession();
		if(uri.endsWith("login.do")){
			String username = request.getParameter("uname");
			String password = request.getParameter("upwd");
			if(username != null && !username.equals("") && password != null && !password.equals("")){
				boolean loginStatus = QnsMail.check(username, password);
				if(loginStatus){
					hs.setAttribute("userKey", "");
					hs.setAttribute("passKey", "");
					response.sendRedirect(request.getContextPath() + "/");
				}else{
					response.sendRedirect(request.getContextPath() + "/login/login.jsp?uname=" + username);
				}
			}else{
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
