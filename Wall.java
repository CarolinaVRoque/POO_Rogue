package pt.iscte.poo.example;
import pt.iscte.poo.utils.Point2D;

public class Wall extends GameElement {


	public Wall(String name, Point2D position) {
		super("Wall", position);

	}

	@Override
	public String getName() {
		return "Wall";
	}

	@Override
	public Point2D getPosition() {
		return position;
	}

	@Override
	public int getLayer() {
		return 3;
	}

}
