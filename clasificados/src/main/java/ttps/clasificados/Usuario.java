package ttps.clasificados;

public class Usuario {
	private String nombre;
	private String clave;
	private String perfil;
	
	public Usuario(String nombre, String clave, String perfil) {
		this.nombre = nombre;
		this.clave = clave;
		this.perfil = perfil;
	}

	public boolean validar(String usuario, String clave) {
		return (this.nombre.equals(usuario) && this.clave.equals(clave));
	}

	public boolean esPublicador() {
		return (this.perfil == "Publicador");
	}

}
