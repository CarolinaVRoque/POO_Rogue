package pt.iscte.poo.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pt.iscte.poo.gui.ImageMatrixGUI;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.observer.Observed;
import pt.iscte.poo.observer.Observer;
import pt.iscte.poo.utils.Point2D;


//Fábrica de objetos
public class GameEngine implements Observer{

	//Definir dimensão da grelha
	public static final int GRID_HEIGHT = 10;
	public static final int GRID_WIDTH = 10;


	private static GameEngine INSTANCE;	

	private Hero hero;
	private int turns;

	private ImageMatrixGUI gui = ImageMatrixGUI.getInstance();//Obter instancia ativa de ImageMatrixGUI

	private static List<GameElement> elements = new ArrayList<>();
	private static List<GameElement> tileList =  new ArrayList<>();
	private static List<ImageTile> doors = new ArrayList<>();
	private static List<ImageTile> keys = new ArrayList<>();



	//private List<ImageTile> elements = new ArrayList<>();
	public GameEngine() {
		gui.setSize(GRID_WIDTH, GRID_HEIGHT+1); //Dá-nos as dimensões do mapa mais uma "linha" no final para que seja possivel adicional a barra de vida
		gui.registerObserver(this); 
		gui.go(); //lançar a GUI
	}

	//Solitão:
	public static GameEngine getInstance() {
		if(INSTANCE == null)
			INSTANCE = new GameEngine();
		return INSTANCE;

	}

	//Método que faz iniciar o jogo
	public void start() throws FileNotFoundException {
		addHero();
		createGameBoard("rooms/room0.txt");
		createElementsBoard("rooms/room0.txt");
		gui.update();
	}

	//Método que lê ficheiros 
	public void loadFile() {

		File files = new File("rooms\\");
		for(int i = 0; i < files.listFiles().length; i++);

	}

	//Método que adiciona o heroi ao jogo
	private void addHero() {

		hero = new Hero("Hero", new Point2D(1,1));
		gui.addImage(hero);
	}

	//Método que cria o mapa com as paredes e o chão
	public void createGameBoard(String roomLevel) throws FileNotFoundException {

		int y = 0;
		char[] lineElements= new char[GRID_WIDTH];
		Scanner fileScanner = new Scanner(new File(roomLevel));
		while (fileScanner.hasNextLine() && y < GRID_HEIGHT) {
			lineElements = fileScanner.nextLine().toCharArray();

			for(int x = 0; x <= lineElements.length-1;x++) {
				switch(lineElements[x]) {
				case '#': 

					tileList.add(new Wall("Wall",new Point2D(x,y)));
					break;
				case ' ':
					tileList.add(new Floor(null ,new Point2D(x,y)));
					break;
				default:
					System.out.println("ERROR");
				}
			}
			y++;
			sendImageToGui(tileList);
		}
	}

	//Método que cria os objetos no mapa
	public void createElementsBoard(String roomLevel) throws FileNotFoundException {

		try {
			Scanner s = new Scanner (new File(roomLevel));

			for(int i = 0; i<GameEngine.GRID_HEIGHT + 1;i++) 
				s.nextLine();

			while(s.hasNextLine()) {

				String [] lineObjectsString = s.nextLine().split(",");

				int x =  Integer.parseInt(lineObjectsString[1]);
				int y = Integer.parseInt(lineObjectsString[2]);


				switch(lineObjectsString[0]) {
				case "Skeleton":
					elements.add(new Skeleton("Skeleton",new Point2D(x,y)));
					break;
				case "Bat":
					elements.add(new Bat("Bat",new Point2D(x,y)));
					break;
				case "Sword":
					elements.add(new Sword("Sword",new Point2D(x,y)));
					break;
				case "HealingPotion":
					elements.add(new HealingPotion("HealingPotion",new Point2D(x,y)));
					break;
				case "Key":
					elements.add(new Key("Key",new Point2D(x,y)));
					break;
				case "Treasure":
					elements.add(new Treasure("Treasure",new Point2D(x,y)));
					break;
				case "Thug":
					elements.add(new Thug("Thug",new Point2D(x,y)));
					break;
				case "Armor":
					elements.add(new Armor("Armor",new Point2D(x,y)));
					break;
				case "Door":
					elements.add(new Door("DoorClosed",new Point2D(x,y)));
					break;
				default:
					System.out.println("Object not find");
				}
			}

			sendImageToGui(elements);

		}	catch (FileNotFoundException e) {
			System.err.println("File" + "roomX.txt" + "not found");
		}

	}
	//Método que envia as imagens para o GUI
	public void sendImageToGui(List<GameElement> elements) {
		for(ImageTile t : elements) {
			gui.addImage(t);
		}
	}


	//Método que faz adicionar os elementos 
	public void addElement(GameElement element) {
		gui.addImage(element);
		elements.add(element);
	}

	//Método que faz remver os elementos
	public void removeElement(GameElement element) {
		gui.removeImage(element); //elimina uma ImageTile da grelha do jogo
		elements.remove(element);
	}

	public List<GameElement> getTileList(){
		return tileList;
	}

	public List<GameElement> getElements(){
		return elements;
	}


	@Override
	public void update(Observed source) {

		if (ImageMatrixGUI.getInstance().wasWindowClosed())
			System.out.println("Ending");		

		int key = ((ImageMatrixGUI) source).keyPressed();


		hero.move();
		for(ImageTile element : elements) {
			if(element instanceof AbstractEnemyElements)
				((AbstractEnemyElements) element).move();

		}

		System.out.println("carregou numa tecla");
		turns++;

		gui.update();
		gui.setStatusMessage("ROGUE Starter Package - Turns:" + turns);
	}
}

