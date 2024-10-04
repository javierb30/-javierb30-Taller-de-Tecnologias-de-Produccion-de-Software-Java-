package misServlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import general.Abono;

/**
 * Servlet implementation class Estadistica
 */
public class Estadistica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Estadistica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto= request.getServletContext();
		Abono abono = (Abono) contexto.getAttribute("abono");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.append("<html><body>");
		out.append("<h1>Estadisticas</h1>");
		
		out.append("<h2>Abono de dos días: </h2>");
		out.append("<ul>");
	    out.append("<li><strong>Entradas iniciales:</strong> " + abono.getDosDiasInicial() + "</li>");
	    out.append("<li><strong>Entradas vendidas:</strong> " + abono.getCantVendidosDosDias() + "</li>");
	    out.append("<li><strong>Entradas restantes:</strong> " + abono.cantEntradasActualDosDias() + "</li>");
	    out.append("</ul>");
		
		out.append("<h2>Abono de tres días: </h2>");
		out.append("<ul>");
	    out.append("<li><strong>Entradas iniciales:</strong> " + abono.getTresDiasInicial() + "</li>");
	    out.append("<li><strong>Entradas vendidas:</strong> " + abono.getCantVendidosTresDias() + "</li>");
	    out.append("<li><strong>Entradas restantes:</strong> " + abono.cantEntradasActualTresDias() + "</li>");
	    out.append("</ul>");
		
		out.append(" </body></html> ");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
