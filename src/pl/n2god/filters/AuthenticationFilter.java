package pl.n2god.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author n2god on 12/12/2019
 * @project filterts
 */

/*Drugi filtr służy do weryfikacji, czy użytkownik jest zalogowany. W tym celu z obiektu request (rzutowanego na typ HttpServletRequest)
pobieramy sesję przy pomocy metody getSession(). Ponownie jako jej argument podajemy argument false, aby zapobiec utworzeniu sesji.
Następnie weryfikujemy, czy w sesji znajduje się zapisany atrybut "username" - jeżeli tak jest, potwierdza to, że
użytkownik zalogował się wcześniej (poprzez serwlet LoginServlet). W przypadku, gdy użytkownik nie jest zalogowany,
czyli nie posiada sesji lub nie przeszedł procesu logowania, odsyłamy go do strony login.jsp poprzez przekierowanie.
Metoda doFilter() przekazuje obiekty żądania i odpowiedzi do kolejnego filtra lub już konkretnego serwletu / strony JSP,
jeżeli inny filtr nie został zdefiniowany.*/

//@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {

	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		System.out.println("Auth filter");
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpSession session = httpRequest.getSession(false);

		//użytkownik ma aktywną sesję i jest zalogowany

		if (session != null && session.getAttribute("username") != null ){
			System.out.println("Session + user valid");
			chain.doFilter(req, resp);
		} else {
			System.out.println("Session or user not valid!");
			HttpServletResponse httpResponse = (HttpServletResponse) resp;
			httpResponse.sendRedirect("login.jsp");
		}
	}
	@Override
	public void destroy() {
	}
}
