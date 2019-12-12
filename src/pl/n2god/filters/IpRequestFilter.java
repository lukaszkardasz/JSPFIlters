package pl.n2god.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author n2god on 12/12/2019
 * @project filterts
 */

/*Klasa IpRequestFilter implementuje interfejs javax.servlet.Filter. W metodzie init() pobieramy z parametrów początkowych
wzorzec adresu IP, z którym będzie musiał być zgodny adres IP urządzenia,
które wyśle żądanie do naszej aplikacji. Metoda doFilter() bardzo przypomina metodę doGet() z tą różnicą, że jako parametry
posiada obiekty typu ServletRequest i ServletResponse a nie HttpServletRequest i HttpServletResponse, przez co mają ograniczoną funkcjonalność.
Pobieramy adres IP znaną nam już metodą request.getRemoteAddr() i weryfikujemy, czy adres pasuje do naszego wzorca przy
pomocy metody matches() z klasy String.
Jeżeli adres IP jest zgodny z naszym wzorcem przesyłamy żądania dalej w naszym łańcuchu odpowiedzialności z użyciem metody
chain.doFilter(request, response), gdzie obiekt chain jest trzecim parametrem naszej metody dostarczonym przez kontener.
Jeżeli adres IP nie pasuje do naszego wzorca, odsyłamy w odpowiedzi komunikat błędu 403.
Wcześniej musimy zrzutować obiekt response na typ HttpServletResponse w związku z ograniczoną funkcjonalnością klasy ServletResponse.*/

/*
@WebFilter(
    urlPatterns = "/*",
    initParams = { @WebInitParam(name = "ipPattern", value = "192\\.168\\.1\\.[0-9]{1,3}")
*/
public class IpRequestFilter implements Filter {
	private String ipPattern;

	public void init(FilterConfig config) throws ServletException {
		ipPattern = config.getInitParameter("ipPattern");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		String requestIp = req.getRemoteAddr();
		System.out.println("IP filter " + requestIp);

		if (requestIp.matches(ipPattern)){
			System.out.println("IP ok!");
			chain.doFilter(req, resp);
		} else {
			System.out.println("IP not ok!");
			HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
			httpServletResponse.sendError(403); //access forbidden
		}
	}
}
