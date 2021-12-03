package codigo;

import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GRect;

public class Cursor extends GImage{

	public Cursor(String name) {
		super(name);
	}

	public void muevete(int posX, int anchoPantalla){
		if (posX + getWidth() < anchoPantalla -200){
			setLocation(posX, getY());
		}
	}
	private void add(Cursor miCursor2, int i, int j, int k, int l) {


	}

}
