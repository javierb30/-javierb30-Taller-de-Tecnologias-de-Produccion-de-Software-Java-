package misFilters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import general.Abono;

import java.io.IOException;

/**
 * Servlet Filter implementation class FiltroEntradasAgotadas
 */
public class FiltroEntradasAgotadas extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroEntradasAgotadas() {
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
		// Datos del contexto
		
		ServletContext contexto= request.getServletContext();
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		Abono abono = (Abono) contexto.getAttribute("abono");
		
		// Datos ingresados por el cliente
		HttpServletRequest req = (HttpServletRequest) request;
		int dosDias = Integer.parseInt(req.getParameter("cantidad2d"));
		int tresDias = Integer.parseInt(req.getParameter("cantidad3d"));
		
		if (dosDias == 0 && tresDias == 0)
			httpResponse.sendRedirect("ingreso_invalido.html");
		else if (!(abono.hayCuponesDosDiasDisponibles(dosDias)) && !(abono.hayCuponesTresDiasDisponibles(tresDias))) 
			httpResponse.sendRedirect("entradas_agotadas.html");
		else if(!(abono.hayCuponesDosDiasDisponibles(dosDias)) || !(abono.hayCuponesTresDiasDisponibles(tresDias))) 
			httpResponse.sendRedirect("abono_agotado.html");
		else 
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
