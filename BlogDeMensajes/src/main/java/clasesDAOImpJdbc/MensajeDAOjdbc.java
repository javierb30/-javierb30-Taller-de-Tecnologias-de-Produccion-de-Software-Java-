package clasesDAOImpJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import claseDeObjetosDelSistema.Mensaje;
import claseDeObjetosDelSistema.Usuario;
import clasesDAO.MensajeDAO;
import dataSource.MiDataSource;

public class MensajeDAOjdbc implements MensajeDAO{
	
	//elimina un mensaje en la bd, el cual es recibido por parametro
		public int eliminar(Mensaje m){
			int res= 0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_de_mensajes","root","root");
				Statement st= con.createStatement();
				//aca usar la conexion para peticiones o cosas
				res= st.executeUpdate("delete from mensajes where contenido='" + m.getContenido() + "' AND idusuario= "+ m.getIdpersona()+ ";");
				//cerramos conexion
				st.close();
				con.close();
			} catch (ClassNotFoundException e) {
				 System.out.println("no se encontró el driver");
			} catch (SQLException e) {
				System.out.println("hubo un error con la bd: codigo "+ e.getErrorCode() + ",  "+ e.getMessage());
			}
			return res;
		}
		
		//guarda un mensaje en la bd, el cual es recibido por parametro
		public int guardar(Mensaje m){
			int res= 0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_de_mensajes","root","root");
				Statement st= con.createStatement();
				//aca usar la conexion para peticiones o cosas
				res= st.executeUpdate("insert into mensajes(contenido, idusuario) values('" + m.getContenido() + "', "+ m.getIdpersona()+ ")");
				//cerramos conexion
				st.close();
				con.close();
			} catch (ClassNotFoundException e) {
				 System.out.println("no se encontró el driver");
			} catch (SQLException e) {
				System.out.println("hubo un error con la bd: codigo "+ e.getErrorCode() + ",  "+ e.getMessage());
			}
			return res;
		}
		
		//obtiene todos los mensajes
		public List<Mensaje> cargar(){
			List<Mensaje> lista= new ArrayList<Mensaje>(); 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_de_mensajes","root","root");
				Statement st= con.createStatement();
				ResultSet resultados= st.executeQuery("select * from mensajes");
				while(resultados.next()) {
					lista.add(new Mensaje(resultados.getString(2),resultados.getInt(3)));
				}
			} catch (ClassNotFoundException e) {
				 System.out.println("no se encontró el driver");
			} catch (SQLException e) {
				System.out.println("hubo un error con la bd: codigo "+ e.getErrorCode() + ",  "+ e.getMessage());
			}
			return lista;
		}
}
