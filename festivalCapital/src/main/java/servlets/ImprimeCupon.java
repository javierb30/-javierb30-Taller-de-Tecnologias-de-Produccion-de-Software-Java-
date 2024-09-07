package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

/**
 * Servlet implementation class ImprimeCupon
 */
public class ImprimeCupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ImprimeCupon() {
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
		// Obtenemos el texto ingresado por el usuario
        String textoPersonalizado = request.getParameter("texto");
        
        // Establecemos el tipo de respuesta como imagen JPG
        response.setContentType("image/jpeg");
        
        // Leemos la imagen base desde el servidor (cupon.jpg que subiste)
        BufferedImage cuponImagen = ImageIO.read(this.getServletContext().getResourceAsStream("/WEB-INF/cupon3.jpg"));
        
        // Creamos un objeto Graphics2D para dibujar sobre la imagen
        Graphics2D graphics = cuponImagen.createGraphics();
        
        // Configuramos la fuente, el color, etc.
        graphics.setFont(new Font("SansSerif", Font.BOLD, 50));
        graphics.setColor(Color.white);
        
        // Dibujamos el texto personalizado en la parte superior
        graphics.drawString(textoPersonalizado, 600, 900);
        
        // Generamos un código de retiro aleatorio
        int codigoRetiro = ThreadLocalRandom.current().nextInt(1000000, 99999999);
        
        // Dibujamos el código de retiro en la parte inferior de la imagen
        graphics.setColor(Color.black);
        graphics.setFont(new Font("SansSerif", Font.PLAIN, 50));
        graphics.drawString("#" + codigoRetiro, 1450, 1030);
        
        // Cerramos el objeto Graphics2D
        graphics.dispose();
        
        // Enviamos la imagen resultante en la respuesta
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(cuponImagen, "jpg", outputStream);
        outputStream.close();
		}
}
