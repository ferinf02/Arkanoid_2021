package codigo;

import java.awt.Color;

import acm.graphics.GRect;

public class Cursor extends GRect{

	public Cursor(double x, double y, double width, double height, Color c) {
		super(x, y, width, height);
		setFilled(true);
		setFillColor(Color.GREEN);
	}

	public void muevete(int anchoPantalla, int posX){
		if (posX + getWidth() <anchoPantalla-310){
			setLocation(posX, getY());
		}
	}

}
