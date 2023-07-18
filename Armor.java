package pt.iscte.poo.example;

import pt.iscte.poo.utils.Point2D;

public class Armor extends GameElement {

	public Armor(String name,Point2D position) {
		super("Armor",position);

	}

	@Override
	public String getName() {
		return "Armor";
	}

	@Override
	public Point2D getPosition() {
		return position;
	}

	@Override
	public int getLayer() {
		return 1;
	}

}
