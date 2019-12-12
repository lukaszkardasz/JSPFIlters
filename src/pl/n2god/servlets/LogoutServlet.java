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
@WebServlet(name = "LogoutServlet", urlPatterns = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession(false) != null) {
			/*Metodę getSession() przy sprawdzeniu warunku wywołujemy z parametrem false, co zapobiegnie utworzeniu obiektu sesji nawet,
			 gdyby ona nie istniała, a ktoś odwołałby się do adresu /LogoutServlet naszej aplikacji.*/
			System.out.println("Logout");
			request.getSession().invalidate();
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("No session found");
		}
	}
}
