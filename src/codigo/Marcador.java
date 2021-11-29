package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect{

	GLabel texto= new GLabel("");
	int puntuacion=0;
	GLabel puntos=new GLabel("");
	
	public Marcador(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.BLACK);
		puntos.setLabel("tu puntuacion actual es: ");
		puntos.setColor(Color.RED);
		puntos.setFont(new Font("Arial", Font.BOLD, 20));
		texto.setLabel("0");
		texto.setFont(new Font("Arial", Font.BOLD, 25));
		texto.setColor(Color.RED);
		
	}
	public void incrementaMarcador(int puntos){
		puntuacion = puntuacion + puntos;
		texto.setLabel("" + puntuacion);//puntuacion += puntos;
	}
	
	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(this, arkanoid.getWidth()-300, 150);
		arkanoid.add(puntos, arkanoid.getWidth()-280,190);
		arkanoid.add(texto, arkanoid.getWidth()-150, 220);
	}

}
