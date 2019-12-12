package pl.n2god.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author n2god on 12/12/2019
 * @project filterts
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "password";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doPost");
		String userParam = request.getParameter("username");
		String passParam = request.getParameter("password");

		if (validate(userParam, passParam)){
			request.getSession(true).setAttribute("username", userParam);
		}
		response.sendRedirect("admin.jsp");
	}

	private boolean validate(String userParam, String passParam) {
		return userParam.equals(USERNAME) && passParam.equals(PASSWORD);
	}
}
