package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect{
	//genero todos los textos que van a salir en el marcador y el marcador es un fondo negro 
	//genero una variable para guardar el numero de puntos
	int puntuacion=0;
	GLabel texto= new GLabel("");
	GLabel puntos=new GLabel("");
	GImage vida1=new GImage("imagenes/bluevidas.gif");
	GImage vida2=new GImage("imagenes/bluevidas.gif");
	GImage vida3=new GImage("imagenes/bluevidas.gif");
	GLabel vidas=new GLabel("");
	GLabel nivel=new GLabel("");
	GLabel nivel2=new GLabel("NIVEL:");
	//establezco la fuente, el tamaño y lo que va a llevar el texto 
	public Marcador(double width, double height) {
		super(width, height);
		puntos.setLabel("SCORE");
		puntos.setColor(Color.RED);
		puntos.setFont(new Font("Arial", Font.BOLD, 20));
		texto.setLabel("0");
		texto.setFont(new Font("Arial", Font.BOLD, 25));
		texto.setColor(Color.RED);
		vidas.setLabel("3");
		vidas.setFont(new Font("Arial", Font.BOLD, 25));
		vidas.setColor(Color.RED);
		nivel.setLabel("0");
		nivel.setFont(new Font("Arial", Font.BOLD, 25));
		nivel.setColor(Color.RED);
		nivel2.setFont(new Font("Arial", Font.BOLD, 25));
		nivel2.setColor(Color.RED);

	}
	//void en el cual entras si has golpeado la parte inferior de la pantalla
	public void pierdesVidas(Arkanoid ark,int restantes, boolean c){
		//condicion en la que entras si tienes 3 vidas restantes
		if(restantes==3){
			ark.add(ark.pierdesV);
			ark.waitForClick();
			ark.remove(vida1);
			ark.restantes--;
			ark.continuas=true;
			c=true;
		}
		//condicin en la que entras si te quedan 2 vidas
		else if(restantes==2){
			ark.add(ark.pierdesV);
			ark.waitForClick();
			ark.remove(vida2);
			ark.restantes--;
			ark.continuas=true;
			c=true;
		}
		//condicion en la que entras si te queda 1 vida
		else if(restantes==1){
			ark.remove(vida3);
			ark.add(ark.pierdesV);
			ark.waitForClick();
			ark.restantes--;
			ark.continuas=true;
			c=true;
		}
		//condicion en la que entras sino te quedan vidas
		else{
			ark.removeAll();
			ark.add(ark.pierdes,0,-300);
			ark.waitForClick();
			ark.remove(ark.pierdes);
			ark.restantes=3;
			puntuacion=0;
			ark.z=0;
			texto.setLabel(""+puntuacion);
			//reinicio de la partida
			ark.init();
			ark.run();
		}
		//sacas en pantalla un contador de las vidas restantes
		vidas.setLabel("" + ark.restantes);
	}
	//void en el cual se encarga de incrementar el marcador cuando rompes un ladrillo
	public void incrementaMarcador(int puntos){
		puntuacion = puntuacion + puntos;
		texto.setLabel("" + puntuacion);//puntuacion += puntos;
	}
	//void encargado de sacar por pantalla los textos de los marcadores, las vidas y las imagenes de las vidas 
	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(this, arkanoid.getWidth()-300, 150);
		arkanoid.add(puntos, arkanoid.getWidth()-280,190);
		arkanoid.add(texto, arkanoid.getWidth()-150, 190);
		arkanoid.add(vidas, arkanoid.getWidth()-300, 280);
		arkanoid.add(vida1, arkanoid.getWidth()-150, 250);
		arkanoid.add(vida2, arkanoid.getWidth()-175, 250);
		arkanoid.add(vida3, arkanoid.getWidth()-200, 250);
		arkanoid.add(nivel, arkanoid.getWidth()-200, 350);
		arkanoid.add(nivel2, arkanoid.getWidth()-300, 350);
	}

}