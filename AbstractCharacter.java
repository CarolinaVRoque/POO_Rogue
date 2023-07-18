package pt.iscte.poo.example;

import java.util.ArrayList;
import java.util.List;

import pt.iscte.poo.gui.ImageMatrixGUI;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

//Classe abstrata para os elementos 
public abstract class AbstractCharacter extends GameElement implements Movable {

	Point2D newPosition;

	private int life;
	private int attack;


	private boolean active;

	private static List<AbstractCharacter> characters = new ArrayList<>();

	public AbstractCharacter(String name, Point2D position) {
		super(name, position);
		characters.add(this);
		this.active = false;

		this.life=life;
		this.attack=attack;

	}
	//Diz-nos se o elemento do jogo está ativo ou não, ou seja, se está vivo ou não
	public boolean toogleActive () {
		if(active == true){
			active = false;
		}
		return active = true;
	}

	//Método que vai buscar a posição dos elementos
	public static GameElement getPositionElements(Point2D pos) {

		for (ImageTile character : characters) 
			if (character.getPosition().equals(pos))
				if (character instanceof GameElement) 
					return (GameElement) character;

		return null;
	}

	//Verifica se a próxima posicao é um inimigo
	public static boolean nextPositionIsCharacter(Point2D p) {
		List<GameElement> list = GameEngine.getInstance().getElements();
		for (GameElement e : list) {
			if(e.getPosition().equals(p) && e instanceof AbstractEnemyElements ) {
				System.out.println("Found : " + e.toString());
				return true;
			}
		}

		return false;
	}

	//Método que vai buscar os objetos que são inimigos
	public GameElement getCharacterAtPosition(Point2D p) {

		List<GameElement> list = GameEngine.getInstance().getElements();

		for (ImageTile e : list) 
			if(e.getPosition().equals(p) && e instanceof AbstractEnemyElements ) {
				return ((GameElement)e);
			}
		return null;
	}

	public void move() {

		Direction dir = Direction.directionFor(ImageMatrixGUI.getInstance().keyPressed());
		Point2D posicao = position.plus(dir.asVector());

		if(nextPositionIsCharacter(posicao)) {
			GameElement e = getCharacterAtPosition(posicao);
			System.out.println("Removi o elemento");
			e.remove(e);
		}

		if(canMove(posicao)) //caso esteja dentro do mapa ele movesse 
			this.position = posicao; 

	}

	//Método que delimita o espaço na qual os elementos do jogo se podem mover
	public static boolean canMove(Point2D p) { 

		if(p.getX() <= 0 || p.getY() <= 0)
			return false;

		if(p.getX() >= GameEngine.GRID_WIDTH || p.getY() >= GameEngine.GRID_HEIGHT)
			return false;		


		List<GameElement> list = GameEngine.getInstance().getTileList();

		for (ImageTile lists : list) {
			if(lists instanceof Wall || lists instanceof AbstractCharacter )
				if (lists.getPosition().equals(p)) {
					return false;

				}
		}
		return true;
	}
}