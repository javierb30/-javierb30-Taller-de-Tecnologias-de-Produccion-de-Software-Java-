package misListeners;

import general.Abono;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContadorAbonos
 *
 */
public class ContadorAbonos implements ServletContextListener, ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public ContadorAbonos() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	// Obtengo la cantidad de entradas para cada abono al iniciar el programa
    	int cantAbono2dias = Integer.parseInt(sce.getServletContext().getInitParameter("abono2Dias"));
    	int cantAbono3dias = Integer.parseInt(sce.getServletContext().getInitParameter("abono3Dias"));
    	int cantVendAbono2dias = Integer.parseInt(sce.getServletContext().getInitParameter("cantVendidosAbono2Dias"));
    	int cantVendAbono3dias = Integer.parseInt(sce.getServletContext().getInitParameter("cantVendidosAbono3Dias"));
    	
    	// Las guardo en el contexto en una instancia de la clase Abono
    	ServletContext contexto = sce.getServletContext();
    	Abono abono= new Abono(cantAbono2dias,cantAbono3dias,cantVendAbono2dias,cantVendAbono3dias);
    	contexto.setAttribute("abono", abono);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }
	
}
