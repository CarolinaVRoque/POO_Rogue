package pt.iscte.poo.example;

import pt.iscte.poo.utils.Point2D;

public class Thug extends AbstractEnemyElements implements Movable {

	public Thug(String name,Point2D position) {
		super("Thug",position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getLayer() {
		return 1;
	}


}
