package filtros;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Servlet Filter implementation class FiltroLogDeAccesos
 */
public class FiltroLogDeAccesos extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroLogDeAccesos() {
        super();
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
		String dirIP = request.getRemoteAddr();
		LocalDateTime fechaHora = LocalDateTime.now();
		String metodoHttp = req.getMethod();
        String recursoSolicitado = req.getRequestURI();
        String versionProtocolo = req.getProtocol();
        String userAgent = req.getHeader("User-Agent");
        
        System.out.println("---- Nuevo Acceso Registrado ----");
        System.out.println("IP del cliente: " + dirIP);
        System.out.println("Fecha y hora: " + fechaHora);
        System.out.println("Método HTTP: " + metodoHttp);
        System.out.println("Recurso solicitado: " + recursoSolicitado);
        System.out.println("Versión del protocolo: " + versionProtocolo);
        System.out.println("User-Agent: " + userAgent);
        System.out.println("---------------------------------\n");
        
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
