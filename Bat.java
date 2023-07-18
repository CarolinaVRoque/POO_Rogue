package pt.iscte.poo.example;

import pt.iscte.poo.utils.Point2D;

public class Bat extends AbstractEnemyElements {

	public Bat(String name,Point2D position) {
		super("Bat",position);
	}

	public int getLayer() {
		return 1;
	}

}
