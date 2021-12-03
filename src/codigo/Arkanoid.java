package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram {

	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA = 485;
	static final int espacioMarcador = 190;
	int vidas = 2;

	Bola bola1 = new Bola(10, 10, Color.GREEN);
	//imagen del cursor
	Cursor miCursor = new Cursor("imagenes/cursor.png");
	// imagen de inicio
	GImage inicio = new GImage("imagenes/inicio.jpg");
	//imagen de fondo
	GImage fondo = new GImage("imagenes/fondo.png");
	GRect fondoMarcador = new GRect(250, 500);
	Marcador miMarcador = new Marcador(20, 50);
	//imagen vidas
	GImage corazonRojo = new GImage("imagenes/vidas.jpg");
	//imagen victoria magistral cuando ganas
	GImage victoriaMagistral = new GImage("imagenes/win.jpg");
	//imagen cuando pierdes
	GImage eresMalisimo = new GImage("imagenes/gameover.jpg");

	public void init() {
		//Añadimos el fondo inicial.
		add(inicio);
		//Cuando pulsemos click en el raton se eliminara la pantalla y pasaremos al fondo del juego.
		waitForClick();
		remove(inicio);
		//Añadimos el fondo del juego.
		add(fondo);
		//Añadimos el fondo del marcador.
		fondoMarcador.setFilled(true);
		add(fondoMarcador, ANCHO_PANTALLA - 30, 0);
		addMouseListeners();
		//Añadimos la bola 1.
		add(bola1, 50, 100);
		add(miCursor, 0, 400);
		setSize(ANCHO_PANTALLA + 200, 500);
	}

	public void run() {
		//Creamos la primera tanda de ladrillos.
		creaAnaIbis1();
		miMarcador.addMarcador(this);
		while (true) {
			bola1.muevete(this); // paso el objeto arkanoid que se está ejecutando.
			pause(5);
			miCursor.muevete(ANCHO_PANTALLA - 100, (int) bola1.getX());
			if(miMarcador.puntuacion == 103){	
			}
			//Si la puntuacion es igual a 309 significa que has ganado, aparecera la imagen de victoria magistral.
			if (miMarcador.puntuacion == 91){
				add(victoriaMagistral);
			}
			//Cuando la bola toque el suelo has perdido, aparece la imagen de gameover.
			if (bola1.getY() == 420){
				add(eresMalisimo);
			}
		}
	}

	public void mouseMoved(MouseEvent evento) {
		miCursor.muevete(evento.getX(), getWidth());
	}
	//private void creando la piramide de ladrillos.
	private void creaAnaIbis1() {
		int numeroLadrillos = 13;
		int desplazamiento_inicial_X = 20;
		int desplazamiento_inicial_Y = 15;
		// Dibujamos el nivel 1.
		for (int j = 0; j < numeroLadrillos; j++) {
			for (int i = j; i < numeroLadrillos; i++) {
				Ladrillo miLadrillo = new Ladrillo("imagenes/ladrillo.jpg");

				add(miLadrillo, ANCHO_LADRILLO * i - ANCHO_LADRILLO / 2 * j + desplazamiento_inicial_X, // pos
						// X
						ALTO_LADRILLO * j + desplazamiento_inicial_Y); // pos Y

			}
		}

	}


}

