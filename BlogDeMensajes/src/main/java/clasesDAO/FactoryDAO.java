package clasesDAO;

import clasesDAOImpJdbc.MensajeDAOjdbc;
import clasesDAOImpJdbc.UsuarioDAOjdbc;

public class FactoryDAO {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOjdbc();
	}
	
	public static MensajeDAO getMensajeDAO() {
		return new MensajeDAOjdbc();
	}
}
