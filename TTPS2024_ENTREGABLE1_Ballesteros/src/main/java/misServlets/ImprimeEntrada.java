package misServlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import general.Abono;

/**
 * Servlet implementation class ImprimeEntrada
 */
public class ImprimeEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImprimeEntrada() {
        super();
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
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		ServletContext contexto= request.getServletContext();
		// Compra de entradas
		Abono abono = (Abono) contexto.getAttribute("abono");
		abono.compraEntradasDosDias(Integer.parseInt(request.getParameter("cantidad2d")));
		abono.compraEntradasTresDias(Integer.parseInt(request.getParameter("cantidad3d")));
		
		contexto.setAttribute("abono", abono);
		
		// Determinar si gana remera
		boolean ganoRemera = new Random().nextBoolean();
		String textoQR;
		if (ganoRemera) 
			textoQR = "Entrada para " + request.getParameter("nombre") + " " + request.getParameter("apellido") + " " + request.getParameter("dni")+ ". ¡¡Felicitaciones!! Te ganaste una remera. El día del evento pasá por el Stand TTPS y retirala con el QR.";
		else
			textoQR = "Entrada para " + request.getParameter("nombre") + " " + request.getParameter("apellido") + " " + request.getParameter("dni") + ". No te ganaste una remera, pero esperamos que disfrutes mucho el show.";
		
		// Generar el código QR con Zxing
        int qrSize = 200;
        BufferedImage qrImage = generateQRImage(textoQR, qrSize, qrSize);

        // Cargar la imagen del logo
        BufferedImage logo = ImageIO.read(this.getServletContext().getResourceAsStream("/WEB-INF/quilmesRock.png"));

        // Crear la imagen final combinada (logo + QR)
        int combinedWidth = logo.getWidth() + qrSize;
        int combinedHeight = Math.max(logo.getHeight(), qrSize);
        BufferedImage combinedImage = new BufferedImage(combinedWidth, combinedHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = combinedImage.createGraphics();
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, combinedWidth, combinedHeight);

        // Dibujar el logo a la izquierda
        g.drawImage(logo, 0, 0, null);

        // Dibujar el código QR a la derecha
        g.drawImage(qrImage, logo.getWidth(), 0, null);

        // Enviar la imagen combinada como respuesta
        response.setContentType("image/png");
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(combinedImage, "png", outputStream);
        outputStream.close();
    }

    // Método para generar el QR usando Zxing
    private BufferedImage generateQRImage(String text, int width, int height) throws IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
                }
            }
            return image;
        } catch (Exception e) {
            throw new IOException("Error al generar el código QR", e);
        }
    }

}
