package pt.iscte.poo.example;

import pt.iscte.poo.utils.Point2D;

public class Treasure extends GameElement{

	public Treasure(String name,Point2D position) {
		super("Treasure",position);
	}

	@Override
	public int getLayer() {
		return 1;
	}

}
