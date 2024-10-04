package claseDeObjetosDelSistema;

public class Mensaje {
	private int idPersona;
	private String contenido;
	
	public Mensaje(String c, int idp) {
		this.setContenido(c);
		this.setIdpersona(idp);
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getIdpersona() {
		return idPersona;
	}

	public void setIdpersona(int idpersona) {
		this.idPersona = idpersona;
	}
	
}
