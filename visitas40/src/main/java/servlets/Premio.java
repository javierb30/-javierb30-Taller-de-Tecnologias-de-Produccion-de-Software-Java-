package servlets;

import java.io.IOException;import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Premio
 */
//@WebServlet("/Premio")
public class Premio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int visitas;
    /**
     * Default constructor. 
     */
    public Premio() {
    	visitas = 0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		visitas++;
		
		PrintWriter out = response.getWriter();
		
		out.println( "<html><body>");
		out.println("<h1> Felicitaciones @" + request.getParameter("nombre") + "! eres el visitante número #" + this.visitas + " de nuestro sitio y has sido seleccionado para el gran premio TTPS - Cursada APROBADA </h1>");
		out.print(" </body></html> ");
		out.close();
	}

}
