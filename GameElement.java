package pt.iscte.poo.example;
import pt.iscte.poo.gui.ImageMatrixGUI;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Point2D;


//Classe abstrata que trata de todos os objetos que existem no jogo 
public abstract class GameElement implements ImageTile {

	private static final int layer = 0;
	private String name;
	public Point2D position;

	private ImageMatrixGUI gui = ImageMatrixGUI.getInstance();	
	protected static GameEngine engine = GameEngine.getInstance();


	public GameElement(String name,Point2D position){
		this.name=name;
		this.position = position;
		addToGui();
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
