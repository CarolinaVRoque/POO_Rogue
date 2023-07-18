package pt.iscte.poo.example;

import pt.iscte.poo.gui.ImageMatrixGUI;
import pt.iscte.poo.utils.Point2D;

public abstract class AbstractDoors extends GameElement  {

	public boolean lock;
	public Point2D destination;
	public int IDunlocked;

	private ImageMatrixGUI gui = ImageMatrixGUI.getInstance();	
	protected static GameEngine engine = GameEngine.getInstance();


	public AbstractDoors(String name,Point2D position) {
		super(name,position);
	}
	public void lockDoor() { //caso a porta esteja trancada
		this.lock = true;
	}

	public void unlockDoor() {//caso a porta não esteja trancada
		this.lock = false;
	}

	public void setIDunlockedDoor(int ID) {//ID que faz destrancar a porta 
		this.IDunlocked = ID;
	}

	public void setDestinationDoor(Point2D destination) {//destino origem da porta "atual"
		this.destination = destination;
	}

}
