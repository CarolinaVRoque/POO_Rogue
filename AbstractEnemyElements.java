package pt.iscte.poo.example;

import java.util.List;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

//Classe abstrata que vai tratar dos objetos que se identificam como inimigos do herói
public abstract class AbstractEnemyElements extends GameElement implements Movable{

	private List<GameElement> tileList = GameEngine.getInstance().getTileList();
	public AbstractEnemyElements(String name, Point2D position) {
		super(name,position);
	}

	//class abstrata que trata dos elementos que são inimigos 
	public boolean heroClosed(Direction direction) {

		for (ImageTile lists1 : tileList) {
			if(lists1.getName().equals("Hero")) {
				if(lists1.getPosition().equals(position.plus((direction.asVector())))) {
					System.out.println("Hero closed !!");
					return true;
				}
			}
		}	
		return false;	
	}

	//Método que faz com que os inimigos se movam aleatóriamente
	public void move() {

		Direction dir = Direction.random();
		Point2D posicao = position.plus(dir.asVector());

		if(AbstractCharacter.canMove(posicao)) {
			this.position = posicao; 

		}

	}
}
