package ttps.clasificados;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private List<Usuario> usuarios; --> Inciso 2
    /**
     * Default constructor. 
     */
    public Login() {
    	//Inciso 2
    	/*
    	this.usuarios = new ArrayList<Usuario>();
    	this.usuarios.add(new Usuario("user1","1234","Administrador"));
    	this.usuarios.add(new Usuario("user2","4567","Publicador"));*/
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
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Menú");
		dispatcher.forward(request, response);
		//Inciso 2
		/*Usuario usuario = this.existe(request, response);
		if (usuario != null) 
			if (usuario.esPublicador())
				response.sendRedirect("/clasificados/menu_publicador.html");
			else
				response.sendRedirect("/clasificados/menu_administrador.html");
		else
			response.sendRedirect("/clasificados/error.html");*/
	}
	//Inciso 2
	/*
	private Usuario existe(HttpServletRequest request, HttpServletResponse response) {
		return this.usuarios.stream()
				.filter(u -> u.validar(request.getParameter("usuario"),request.getParameter("clave")))
				.findFirst().orElse(null);
	}*/
}
