package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram {
	
	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA=820;
	boolean continuas=true;
	
	Bola bola1 = new Bola(10, 10, Color.PINK);
	Cursor miCursor = new Cursor(200, 470, 60, 10, Color.GREEN);
	
	GImage nombreP = new GImage("imagenes/nombre2.png");
	GImage fondo = new GImage("imagenes/fondo.png");
	GRect fondoMarcador = new GRect(300,600);
	Marcador miMarcador = new Marcador(200,60);
	GImage inic = new GImage("imagenes/inic.png");
	
	public void init(){
		setSize(ANCHO_PANTALLA,560);
		add(inic);
		waitForClick();
		fondoMarcador.setFilled(true);
		add(fondoMarcador,ANCHO_PANTALLA-320,0);
		add(fondo);
		add(nombreP,520,30);
		addMouseListeners();
		add(bola1, 50, 100);
		add(miCursor);
	}
	
	public void run(){
		miMarcador.addMarcador(this);
		creaPiramide();
		while(true){
			while (continuas){
				bola1.muevete(this); //paso el objeto arkanoid 
				pause(5);
				//miCursor.muevete(getWidth(), (int)bola1.getX());
			}
			if(continuas==false){
			add(inic);
			waitForClick();
			continuas=true;
			remove(inic);
			add(bola1,50,100);
			}
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
