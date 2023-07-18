package pt.iscte.poo.example;
import pt.iscte.poo.utils.Point2D;

public class Floor extends GameElement{


	public Floor (String name, Point2D position) {
		super("Floor", position);
	}
	@Override
	public String getName() {
		return "Floor";
	}


	@Override
	public Point2D getPosition() {
		return position;
	}


	@Override
	public int getLayer() {
		return 0;
	}

}