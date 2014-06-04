
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;



public class GamePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=500;
	public static final int HEIGHT=500;
	public static final int SPEED=GameObject.SIZE;
	public static final int LASTLEVEL=2;

	private boolean completed;
	private  boolean running;
	private Bomber bomber;
	public Board board;
	private KeyboardHandler keyboardHandler;
	private int levelNo;
	private String levelInStr;

	public GamePanel(){
		board=new Board();
		keyboardHandler=new KeyboardHandler();
		addKeyListener(keyboardHandler);
		this.bomber =new Bomber(1,1,keyboardHandler, this);
		this.running=false;
		this.completed=true;
		this.levelInStr="";
		this.levelNo=0;
	}


	private void draw() {
		repaint();
	}

	void update() {
		if(bomber.isAlive){
			if(!board.allEnemiesRemoved){
				keyboardHandler.update();//update Keyboard
				board.update();
				bomber.update();
				draw();}
			else{
				this.running=false;
				this.completed=true;
			}
		}
		else{
			this.running=false;
			this.completed=false;
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		board.draw(g);
		bomber.draw(g);
	}

	public void addEnemy(Enemy gameObj) {
		board.addEnemy(gameObj);
	}

	public void setBlockAt(int x, int y,Block block ){
		board.setBlockBlockAt(x,y,block);
	}

	public boolean isRunning(){
		return this.running;
	}

	public boolean isCompleted(){
		return this.completed;
	}

	public int getLevel() {
		return this.levelNo;
	}

	public void start(){
		this.running=true;
		this.completed=false;
		System.out.println("level "+ levelNo+ " is started");
	}


	
	//TODO bunlari baska yere cikarmam lazim levelLoadera
	public  void readNextLevel() throws FileNotFoundException {
		this.levelInStr="";
		levelNo++;
		Scanner scanner =new Scanner(new File("level"+levelNo+".txt"));
		while(scanner.hasNextLine()){
			levelInStr=levelInStr+scanner.nextLine()+"\n";	
		}
		scanner.close();
	}
	public boolean nextLevelExist() {
		if(levelNo<LASTLEVEL){
			return true;
		}
		else return false;
	}

	public void loadLevel() {
		board.reset();
		bomber.reset();
		String[] levelMap = levelInStr.split("\n");
		char currChar;
		for (int i = 0; i < WIDTH/SPEED; i++) {
			String row=levelMap[i];
			for (int j = 0; j < HEIGHT/SPEED; j++) {
				Block block=new Block(j,i);
				currChar=row.charAt(j);
				 if(currChar=='e'){
					Enemy enemy=new Enemy(j,i, this);
					addEnemy(enemy);
				}
				 else {
					 block.changeStateTo(currChar);
				 }
				setBlockAt(i, j, block);
			}
		}
	}






}
