package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval{
	//creo varias variables 
	int dx =0; //velocidad del eje x
	int dy =0; //velocidad del eje y
	boolean c=false;

	//este es el constructo que sirve para generar la bola en la clase arkanoid
	public Bola(double width, double height, Color c) {
		super(width, height);
		setFillColor(c);
		setFilled(true);
	}
	//public void que sirve para que la vola empiece a moverse cuando pulse 
	public void bolac(Arkanoid ark){
		if(c==false){
			ark.waitForClick();
			c=true;
			dx=1;
			dy=-1;
		}
		if(c==true){
			muevete(ark);
		}
	}

	//public void que sirve para especificar el movimiento de la bola, la forma en la que rebota
	public void muevete(Arkanoid ark){
		//rebote con el techo y suelo 
		if (getY()>ark.getHeight()){
			dy = dy * -1;
			ark.continuas=false;
		}
		if(getY()-10<10){
			dy=dy*-1;
		}
		//rebote con las paredes 
		if (getX()>ark.ANCHO_PANTALLA-350|| getX()-10<10){
			dx = dx*-1;
		}
		//chequeo la esquina superior iz 
		if(chequeaColision(getX(),getY(),ark)){
			if(chequeaColision(getX()+getWidth(),getY(),ark)){
				if(chequeaColision(getX(),getY()+getHeight(),ark)){
					if(chequeaColision(getX()+getWidth(),getY()+getHeight(),ark)){

					}
				}
			}
		}
		//movimiento 
		move(dx,dy);
	}

	//private void que comprueba la colision con los objetos 
	private boolean chequeaColision(double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;

		GObject auxiliar;
		//sacas la posicion del elemento auxiliar
		auxiliar = ark.getElementAt(posx,posy);
		if (auxiliar == ark.miCursor){//si entra aqui es que choca con el cursor
			dy= dy*-1;
			noHaChocado=false;
		}
		//comprueba la colision con el ladrillo y la forma en la que deberia rebotar
		else if (auxiliar instanceof Ladrillo){//si es un ladrillo 
			//para arreglar el rebote hay que modificar este rebote
			if(auxiliar.getY()+auxiliar.getHeight() == posy || auxiliar.getY()==posy){
				dy=dy*-1;
			}
			else if(auxiliar.getX()+auxiliar.getWidth()== posx || auxiliar.getX()==posx){
				dx=dx*-1;
			}
			noHaChocado=false;
			((Ladrillo) auxiliar).contador(ark);
		}
		return noHaChocado;
	}

}