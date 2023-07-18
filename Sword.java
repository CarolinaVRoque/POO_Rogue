package pt.iscte.poo.example;

import pt.iscte.poo.utils.Point2D;

public class Sword extends GameElement{

	public Sword(String name,Point2D position) {
		super("Sword",position);
	}

	@Override
	public int getLayer() {
		return 0;
	}

}
