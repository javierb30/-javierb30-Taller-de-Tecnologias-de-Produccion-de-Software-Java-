package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import claseDeObjetosDelSistema.Mensaje;
import clasesDAO.FactoryDAO;
import clasesDAO.MensajeDAO;

/**
 * Servlet implementation class GuardarMensaje
 */
@WebServlet("/GuardarMensaje")
public class GuardarMensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarMensaje() {
        super();
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
		
		/*RequestDispatcher rd = null;
		MensajeDAO mDAO = FactoryDAO.getMensajeDAO();
		Mensaje m = mDAO.encontrar(request.getParameter("identificacion"));
		if (m != null) {
				mensaje = u.getPerfil();
				HttpSession sesion = request.getSession();
				sesion.setAttribute("perfil", perfil);
				result ="/mostrarMenu";
			} else
				result = "/registracion.jsp";
		rd = getServletContext().getRequestDispatcher(result);
		rd.forward(request, response); */
		//guardar mensaje junto con el nombre del publicador
		HttpSession session = request.getSession(false); // Obtener la sesión, sin eliminar si ya existe una
		String email;
		if (session!=null){
			email= (String)session.getAttribute("emailUsuarioLogueado");
		}
		else {
			email= request.getParameter("email");
		}
		String mensaje= request.getParameter("mensaje");
		//operaciones de bd
		int idUsuario= FactoryDAO.getUsuarioDAO().encontrar(email);
		if(idUsuario==0) {
			response.sendRedirect("error.html");
		}
		else {
			int codigoGuardar= FactoryDAO.getMensajeDAO().guardar(new Mensaje(mensaje,idUsuario));
			session = request.getSession();
			session.setAttribute("usuarioLogueado", true); // Establecer una variable de sesión
			session.setAttribute("emailUsuarioLogueado", email);
			//lo redirecciono al servlet VisualizarMensaje
			RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/VisualizarMensajes");
			dispatcher.forward(request, response);
		}
	}
}
