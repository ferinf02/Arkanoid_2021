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
		if (getY()>ark.getHeight()-getHeight()|| getY()<10){
			dy = dy * -1;
		}
		//rebote con las paredes 
		if (getX()>ark.ANCHO_PANTALLA-330|| getX()<10){
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
		else if (auxiliar instanceof Ladrillo){//si es un ladrillo 
			//para arreglar el rebote hay que modificar este rebote
			if(auxiliar.getY()+auxiliar.getHeight() == posy || auxiliar.getY()==posy){
				dy=dy*-1;
			}
			else if(auxiliar.getX()+auxiliar.getWidth()== posx || auxiliar.getX()==posx){
				dx=dx*-1;
			}
			ark.miMarcador.incrementaMarcador(1);
			ark.remove(auxiliar);
			noHaChocado=false;
		}
		return noHaChocado;
	}

}
