
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
	Bomber bomber;
	public Board board;
	private KeyboardHandler keyboardHandler;
	

	public GamePanel(){
		board=new Board();
		keyboardHandler=new KeyboardHandler();
		addKeyListener(keyboardHandler);
		this.bomber =new Bomber(1,1,keyboardHandler,board);
		this.running=false;
		this.completed=true;
		
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


	public void setRunning(boolean running) {
		this.running = running;
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
	
	public	Block getBlockAt(int x,int y){
		return board.getBlockAt(x,y);
	}
	
	public boolean isRunning(){
		return this.running;
	}

	public boolean isCompleted(){
		return this.completed;
	}

}
