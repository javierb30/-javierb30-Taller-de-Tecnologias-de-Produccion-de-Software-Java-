package clasesDAO;

import java.util.List;

import claseDeObjetosDelSistema.Usuario;

public interface UsuarioDAO {

	public int encontrar(String email);

	public String encontrar(int email);
}
