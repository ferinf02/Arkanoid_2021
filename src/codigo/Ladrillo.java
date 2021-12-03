package codigo;

import java.awt.Color;

import acm.graphics.GRect;

public class Ladrillo extends GRect{
	//genero una variable para hacer el contador de golpes
	int golpes=0;

	public Ladrillo(double x, double y, double width, double height, Color c) {
		super(x, y, width, height);
		//forma y color de los ladrillos
		setFillColor(Color.DARK_GRAY);
		setFilled(true);
		setColor(Color.magenta);
	}
	//contador de golpes de los ladrillos
	public void contador(Arkanoid ark){
		//cuando es el primer golpe suma 1 al contador y los cambia de color
		if(golpes==0){
			golpes++;
			setFillColor(Color.gray);
		}
		else if (golpes==1){
			//cuando el ladrillo tiene dos golpes se elimina el ladrillo y se incrementa en 1 el contador
			ark.remove(this);
			ark.miMarcador.incrementaMarcador(1);
		}

	}
}