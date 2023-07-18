package pt.iscte.poo.example;

import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Point2D;

public class Key  extends GameElement implements ImageTile{

	public int IDkey;
	private int ID;

	public Key(String name,Point2D position) {

		super("Key",position);
		this.ID=ID;	
	}

	@Override
	public int getLayer() {
		return 1;
	}

	public void keyID() {
		this.ID=ID;
	}


}
