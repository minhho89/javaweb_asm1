package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = "/login.jsp"; //default
		String message = "";
		
		String initUserName = getServletContext().getInitParameter("userName");
		String initPassword =  getServletContext().getInitParameter("password");
		
		String action = request.getParameter("action");
		
		if (action == null) {
			action = "signin";
		}
		
		if (action.equals("signin")) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			User user = new User(userName, password);
			if (userName != null && password.equals(initPassword) && userName.equalsIgnoreCase(initUserName)) {
				url = "/index.jsp";
			} else if(userName == null || password == null) {
				url = "/login.jsp";
				message = "Please input user or password";
			} else {
				url = "/login.jsp";
				message = "Username or password is invalid";
			}
			request.setAttribute("user", user);
			request.setAttribute("message", message);
		}
		
		getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		
	}

}
