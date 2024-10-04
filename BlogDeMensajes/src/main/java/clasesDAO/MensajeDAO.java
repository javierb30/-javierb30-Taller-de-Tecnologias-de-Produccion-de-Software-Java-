package clasesDAO;

import java.util.List;

import claseDeObjetosDelSistema.Mensaje;

public interface MensajeDAO {
	
	public List<Mensaje> cargar();
	
	public int eliminar (Mensaje m);
	
	public int guardar(Mensaje m);
}
