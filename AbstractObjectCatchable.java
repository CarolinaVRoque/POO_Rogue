package pt.iscte.poo.example;

import java.util.ArrayList;
import java.util.List;

import pt.iscte.poo.gui.ImageMatrixGUI;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Point2D;

//Classe abstrata que irá tratar dos objetos que são "apanháveis!"
public abstract class AbstractObjectCatchable implements ImageTile {

	private static final int layer = 0;
	private String name;
	public Point2D position;

	private static List<AbstractObjectCatchable> catchable = new ArrayList<>();
	private ImageMatrixGUI gui = ImageMatrixGUI.getInstance();	

	public AbstractObjectCatchable (String name,Point2D position){
		//super(name,position);
		this.name=name;
		this.position = position;
		addToGui();

	}
	public List<AbstractObjectCatchable> getElementsCatchable() {
		return catchable;
	}


	public void setPosition(Point2D position) {
		this.position = position;
	}


	@Override
	public String getName() {
		return name;
	}

	@Override
	public Point2D getPosition() {
		return position;
	}

	@Override
	public int getLayer() {
		return layer;
	}
	public void addToGui() {
		gui.addImage(this);
	}

	public void remove(GameElement element) {
		gui.removeImage(element);
	}

}

