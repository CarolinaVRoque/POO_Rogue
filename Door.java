package pt.iscte.poo.example;

import pt.iscte.poo.utils.Point2D;


public class Door extends AbstractDoors{

	private String key;
	private String room;
	private Point2D nextPosition;


	public Door(String name,Point2D position){//,String room,Point2D nextPosition, String key) {
		super(name,position);

		this.key = key;
		this.nextPosition = nextPosition;
	}

	@Override
	public int getLayer() {
		return 1;
	}

	@Override
	public void setIDunlockedDoor(int ID) {
		super.setIDunlockedDoor(ID);
	}

	@Override
	public void setDestinationDoor(Point2D destination) {
		super.setDestinationDoor(destination);
	}

	@Override
	public void lockDoor() {
		super.lockDoor();
	}

	@Override
	public void unlockDoor() {
		super.unlockDoor();
	}


}
