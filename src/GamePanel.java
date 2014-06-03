
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;



public class GamePanel extends JPanel{
	public boolean completed;
	public  boolean running;
	public static final int WIDTH=500;
	public static final int HEIGHT=500;
	public static final int SPEED=GameObject.SIZE;
	public Bomber bomber;
	public Board board;
	KeyboardHandler keyboardHandler;
	LevelLoader levelLoader;
	String levelInStr;
	private int levelNo;
	public GamePanel(String level){
		board=new Board();
		keyboardHandler=new KeyboardHandler();
		addKeyListener(keyboardHandler);
		this.bomber =new Bomber(1,1,keyboardHandler, this);
		this.running=bomber.isAlive;
		this.completed=false;
		levelLoader=new LevelLoader(this);
		this.levelInStr=level;
		this.levelNo=1;

		setLevel();

	}
	private void setLevel() {
		String[] parts = levelInStr.split("\n");
		for (int i = 0; i < WIDTH/SPEED; i++) {
			String row=parts[i];
			//System.out.println(row);
			for (int j = 0; j < HEIGHT/SPEED; j++) {
				Block block=new Block(j,i);
				System.out.print(row.charAt(j));
				if(row.charAt(j)=='h'){
					block.changeState(new HardBlock());
				}
				else if(row.charAt(j)=='s'){
					block.changeState(new SoftBlock());
				}
				else if(row.charAt(j)=='n'){
					block.changeState(new EmptyBlock());
				}
				else if(row.charAt(j)=='e'){
				//	System.out.println("enemy at "+i+" "+j);
					block.changeState(new EmptyBlock());
					Enemy enemy=new Enemy(j,i, this);
					board.enemies.add(enemy);	
				}
				
				
				board.board[j][i]=block;
			}
			System.out.println();
		}


		

	}

	//	public void startIt(){
	//		long lastTime = System.nanoTime();
	//		final double ns = 1000000000.0 / 60.0;
	//		double delta = 0;
	//		requestFocus();
	//		
	//		while(running) {
	//			long now = System.nanoTime();
	//			delta += (now - lastTime) / ns;
	//			lastTime = now;
	//			
	//			while(delta >= 1) {
	//				update();
	//				delta--;
	//			}
	//	
	//			repaint();
	//			
	//		}
	//	}
	private void draw() {
		repaint();
	}
	void update() {
		if(bomber.isAlive){
			if(!board.allEnemiesRemoved){
			keyboardHandler.update();//update Keyboard
			board.update();
			bomber.update();
			//call draw
			draw();}
			else{
				this.running=false;
				this.completed=true;
				System.out.println("enemyleri oldurdu");
				levelNo++;//burda deil olabilir aslinda 
			}
		}
		else{
			this.running=false;
			this.completed=false;
			//System.out.println("game is over");
			System.out.println("Oldu");
		}
	}

	public void paint(Graphics g) {
		//System.out.println("called");
		super.paint(g);
		board.draw(g);
		bomber.draw(g);
	}
	public void addEnemy(Enemy gameObj) {
		board.addEnemy(gameObj);

	}
	public boolean isRunning(){
		return running;
	}
	
	public boolean isCompleted(){
		return completed;
	}
	public int getLevel() {
		
		return this.levelNo;
	}





}
