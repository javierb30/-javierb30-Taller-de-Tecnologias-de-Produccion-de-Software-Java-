package misListeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ttps.clasificados.SitioClasificado;

@WebListener
public class InicializaClasificados implements ServletContextListener{
	public void contextDestroyed(ServletContextEvent sce) {}
	
	public void contextInitialized(ServletContextEvent sce) {
		//Se leen parametros de inicializacion de la aplicacion
		String nombre = sce.getServletContext().getInitParameter("nombreSitio");
		String email = sce.getServletContext().getInitParameter("email");
		String telefono = sce.getServletContext().getInitParameter("telefono");
		System.out.println(nombre);
		System.out.println(email);
		System.out.println(telefono);
		//Se guardan en el contexto
		ServletContext contexto = sce.getServletContext();
		contexto.setAttribute("nombreSitio", nombre);
		contexto.setAttribute("email", email);
		contexto.setAttribute("telefono", telefono);
		SitioClasificado sitio= new SitioClasificado(nombre,email,telefono);
		contexto.setAttribute("sitio", sitio);
		System.out.println(contexto.getAttribute("telefono"));
		System.out.println(contexto.getAttribute("email"));
		System.out.println(contexto.getAttribute("nombreSitio"));
	}
}