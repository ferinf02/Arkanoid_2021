package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval{
	int dx =1; //velocidad del eje x
	int dy =1; //velocidad del eje y

	public Bola(double width, double height) {
		super(width, height);
	}
	public Bola(double width, double height, Color c) {
		super(width, height);
		setFillColor(c);
		setFilled(true);
	}
	
	public void muevete(Arkanoid ark){
		//rebote con el techo y suelo 
		if (getY()>ark.getHeight()-getHeight()|| getY()<0){
			dy = dy * -1;
		}
		//rebote con las paredes 
		if (getX()>ark.getWidth()-getWidth()|| getX()<0){
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
	
	private boolean chequeaColision(double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;
		
		GObject auxiliar;
		
		auxiliar = ark.getElementAt(posx,posy);
		if (auxiliar == ark.miCursor){//si entra aqui es que choca con el cursor
			dy= dy*-1;
			noHaChocado=false;
		}
		else if (auxiliar==null){//si vale null es que no habia nada 
			
		}
		else{//suponemos que es un ladrillo
			ark.remove(auxiliar);
			dy=dy*-1;
			dx=dx*-1;
			noHaChocado=false;
		}
		
		
		return noHaChocado;
	}

}
