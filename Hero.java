package pt.iscte.poo.example;

import java.util.ArrayList;

import pt.iscte.poo.gui.ImageMatrixGUI;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Point2D;


public class Hero extends AbstractCharacter {

	private ArrayList<ImageTile> image = new ArrayList<>();

	private ImageMatrixGUI gui = ImageMatrixGUI.getInstance();

	public Hero(String name,Point2D position) {
		super("Hero",position);
	}


	@Override
	public int getLayer() {
		return 2;
	}

	public ArrayList<ImageTile> getImages(){
		return image;


	}
}