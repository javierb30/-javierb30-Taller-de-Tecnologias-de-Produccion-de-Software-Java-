package ttps.clasificados;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Menú
 */
public class Menú extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menú() {
    	this.usuarios = new ArrayList<Usuario>();
    	this.usuarios.add(new Usuario("user1","1234","Administrador"));
    	this.usuarios.add(new Usuario("user2","4567","Publicador"));
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//El include para que el Encabezado me agregué el header
		RequestDispatcher rd = request.getRequestDispatcher("/Encabezado");
		rd.include(request, response);
		
		Usuario usuario = this.existe(request, response);
		if (usuario != null) 
			if (usuario.esPublicador()) {
				out.append("<h1>Bienvenido Publicador!</h1>"
						+ "	<ul>"
						+ "	<li>Actualizar datos de contacto</li>"
						+ "	<li>ABM de Publicaciones</li>"
						+ "	<li>Contestar consultas</li>"
						+ "	</ul>"
						+ "</body>"
						+ "</html>");
			}
			else {
				out.println( "<html><body>");
				out.println("<h1> Bienvenido usuario Administrador!</h1>");
				out.print(" </body></html> ");
				out.close();}
		else {
			out.println( "<html><body>");
			out.println("<h1>Clave o contraseña inválida <a href=\"/clasificados/login.html</a></h1>");
			out.print(" </body></html> ");
			out.close();}
	}
	
	private Usuario existe(HttpServletRequest request, HttpServletResponse response) {
		return this.usuarios.stream()
				.filter(u -> u.validar(request.getParameter("usuario"),request.getParameter("clave")))
				.findFirst().orElse(null);
	}

}
