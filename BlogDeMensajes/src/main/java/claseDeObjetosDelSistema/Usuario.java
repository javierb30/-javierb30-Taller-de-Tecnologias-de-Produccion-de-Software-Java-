package claseDeObjetosDelSistema;

public class Usuario {
	private String nombre;
	private String email;
	private String contraseña;
	
	public Usuario(String n, String e, String c) {
		this.setNombre(n);
		this.setEmail(e);
		this.setContraseña(c);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}
