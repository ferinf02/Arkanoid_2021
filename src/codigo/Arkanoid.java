package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram {
	
	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA=520;
	
	Bola bola1 = new Bola(10, 10, Color.PINK);
	Cursor miCursor = new Cursor(200, 400, 60, 10, Color.GREEN);
	
	GImage fondo = new GImage("imagenes/fondo.png");
	
	public void init(){
		add(fondo);
		addMouseListeners();
		add(bola1, 50, 100);
		add(miCursor);
		setSize(ANCHO_PANTALLA,500);
	}
	
	public void run(){
		creaPiramide();
		while (true){
			bola1.muevete(this); //paso el objeto arkanoid 
			pause(3);
			miCursor.muevete(getWidth(), (int)bola1.getX());
		}
	}
	
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA, evento.getX());
	}
	
	
	private void creaPiramide(){
		int numerodeladrillos=13;
		int desplazamiento_inicial_X=20;
		int desplazamiento_inicial_Y=15;
		for (int j = 0;j<numerodeladrillos;j++ ){
			for(int i=j;i<numerodeladrillos;i++){
				Ladrillo miladrillo = new Ladrillo(ANCHO_LADRILLO*i-ANCHO_LADRILLO/2*j+desplazamiento_inicial_X, 
						ALTO_LADRILLO*j+desplazamiento_inicial_Y,
						ANCHO_LADRILLO,
						ALTO_LADRILLO,
						Color.BLUE);
				add(miladrillo);
			}
		}
	}
	
	
}
