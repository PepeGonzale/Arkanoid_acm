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
	
	Bola bola1 = new Bola(10, 10, Color.GREEN);
	Cursor miCursor = new Cursor("imagenes/cursor.png");
	GImage inicio = new GImage("imagenes/inicio.png");
	GImage fondo = new GImage("imagenes/fondo.png");
	GRect fondoMarcador = new GRect(250, 500);
	Marcador miMarcador = new Marcador(20, 50);
	public void init(){
		add(inicio);
		waitForClick();
		remove (inicio);
		add(fondo);
		fondoMarcador.setFilled(true);
		add(fondoMarcador, ANCHO_PANTALLA- 30,0);
		addMouseListeners();
		add(bola1, 50, 100);
		add(miCursor, 0, 400);
		setSize(ANCHO_PANTALLA + 200 ,500);
	}
	
	public void run(){
		creaPiramide();
		miMarcador.addMarcador(this);
		while (true){
			bola1.muevete(this); //paso el objeto arkanoid que se está ejecutando
			pause(5);
			miCursor.muevete(ANCHO_PANTALLA - 100, (int) bola1.getX());
		}
	}
	
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(evento.getX(),getWidth());
	}

	private void creaPiramide(){
		int numeroLadrillos = 14;
		int desplazamiento_inicial_X = 20;
		int desplazamiento_inicial_Y = 15;
		
		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo ("imagenes/ladrillo.jpg");
				
						add(miLadrillo,ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X, //pos X
						ALTO_LADRILLO*j + desplazamiento_inicial_Y);  //pos Y
						
				
			}
		}
	}
	
	
	
}