package codigo;


import acm.graphics.GImage;

public class Cursor2 extends GImage{

	public Cursor2(String name, double x, double y) {
		super(name, x, y);
		// TODO Auto-generated constructor stub
	}

	//void que sirve para indicar la zona de movimiento del cursor
	public void muevete(int anchoPantalla, int posX){
		if (posX + getWidth() <anchoPantalla-335 && posX>20){
			setLocation(posX, getY());
		}
	}

}