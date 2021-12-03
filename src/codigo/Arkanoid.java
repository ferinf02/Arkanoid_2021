package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram {
	//aqui he varias variables
	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA=820;
	boolean continuas=true;
	int restantes=3;
	int s = 0;
	int z=0;
	
	//gereno los elementos como la bola, el cursor. y tambien la mayoria de las imagenes 
	Bola bola1 = new Bola(10, 10, Color.PINK);
	//Cursor miCursor = new Cursor(200, 470, 60, 10, Color.GREEN);
	Cursor2 miCursor=new Cursor2("imagenes/cursor.png", 200,470);

	GImage pierdes=new GImage("imagenes/pierdes.gif");
	GImage nombreP = new GImage("imagenes/nombre2.png");
	GImage fondo = new GImage("imagenes/fondo.png");
	GRect fondoMarcador = new GRect(300,600);
	Marcador miMarcador = new Marcador(200,60);
	GImage inic = new GImage("imagenes/inic.gif");
	GImage fondo1=new GImage("imagenes/background4.gif");
	GImage marco= new GImage("imagenes/marco.png");
	GImage pierdesV= new GImage("imagenes/spirit.gif");
	GImage fondoMarcador2=new GImage("imagenes/background5.gif");
	GImage inicio = new GImage("imagenes/inicio.gif");
	GImage win = new GImage("imagenes/jagger.gif");
	GImage winfin= new GImage("imagenes/gangster.gif");

	//void el cual se inicia antes de que se inicie el void principal en el cual añado varios elementos y ajusto la pantalla
	public void init(){
		add(inic, -300,-200);
		setSize(ANCHO_PANTALLA,555);
		waitForClick();
		remove(inic);
		fondoMarcador.setFilled(true);
		add(fondoMarcador,ANCHO_PANTALLA-320,0);
		//add(fondoMarcador2, ANCHO_PANTALLA-320,0);
		//add(fondo);
		add(fondo1);
		add(marco);
		add(nombreP,520,30);
		addMouseListeners();
		add(miCursor);
		miMarcador.vidas.setLabel(""+restantes);
	}
	//void principal el cual se esta ejecutando todo el rato gracias a un bucle while que siempre esta activo 
	public void run(){
		//creo varias variables que voy a necesitar 
		restantes=3;
		bola1.c=false;
		continuas=true;
		miMarcador.addMarcador(this);
		creaPiramide();
		//comienzo de el bucle que esta siempre activo
		while(true){
			while (continuas){
				bola1.bolac(this); //paso el objeto arkanoid 
				pause(s);
				miCursor.muevete(getWidth(), (int)bola1.getX());
				//condicion que sirve para pasar el primer nivel
				if(miMarcador.puntuacion==91&&z==0){
					add(win);
					waitForClick();
					remove(win);
					creaPiramide();
					bola1.c=false;
					z++;
				}
				//condicion para pasar el segundo nivel
				else if(miMarcador.puntuacion==182&&z==1){
					add(win);
					waitForClick();
					remove(win);
					creaPiramide();
					bola1.c=false;
					z++;
				}
				//condicion para pasar el ultimo nivel
				else if(miMarcador.puntuacion==273 &&z==2){
					removeAll();
					add(winfin);
					waitForClick();
					remove(winfin);
					z=0;
					miMarcador.puntuacion=0;
					init();
					run();
				}
				miMarcador.nivel.setLabel(""+z);
			}
			//condicion que se activa cuando la bola choca con la parte de abajo 
			if(continuas==false){
				miMarcador.pierdesVidas(this,restantes , bola1.c);
				bola1.c=false;
				remove(pierdesV);
			}
		}
	}
	//void que hace que pueda mover el raton con el cursor y hace que la bola inicie en la posicion del raton
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA, evento.getX());
		if(bola1.c==false){
			add(bola1, miCursor.getX()+(miCursor.getWidth()/2), miCursor.getY()-13);
		}
	}

	//void el cual crea una piramide con los ladrillos 
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
				/*Ladrillo2 miladrillo = new Ladrillo2("imagenes/Ladrillo.png",ANCHO_LADRILLO*i-ANCHO_LADRILLO/2*j+desplazamiento_inicial_X,
						ALTO_LADRILLO*j+desplazamiento_inicial_Y);*/
				add(miladrillo);
				pause(3);
			}
		}
	}


}