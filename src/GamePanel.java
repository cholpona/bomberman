
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;



public class GamePanel extends JPanel{
	public boolean completed;
	public boolean running;
	public static final int WIDTH=500;
	public static final int HEIGHT=500;
	public static final int SPEED=GameObject.SIZE;
	public Bomber bomber;
	public Board board;
	KeyboardHandler keyboardHandler;
	LevelLoader levelLoader;
	public GamePanel() throws FileNotFoundException{
		board=new Board();
		keyboardHandler=new KeyboardHandler();
		addKeyListener(keyboardHandler);
		this.bomber =new Bomber(1,1,keyboardHandler, this);
		this.running=bomber.isAlive;
		this.completed=false;
		levelLoader=new LevelLoader(this);
		
		setLevel();
		
	}
	private void setLevel() throws FileNotFoundException {
		Scanner scanner=new Scanner("level1.txt");
		for (int i = 0; i < WIDTH/SPEED; i++) {
			System.out.println(scanner.nextLine());
			for (int j = 0; j < HEIGHT/SPEED; j++) {
				Block block=new Block(i,j);
				if((i%2==0&&j%2==0)||i==0||j==0||i==(WIDTH/SPEED-1)||j==(WIDTH/SPEED-1)){
					block.changeState(new HardBlock());
				}
				else{
					if(i>=3&&j>=4&&i<23&&j<23){//need parametrize magic numbers here
						block.changeState(new SoftBlock());
					}
				}
				board.board[i][j]=block;
			}
		}
		

		Enemy enemy=new Enemy(board.board.length-2,board.board.length-2, this);
		board.enemies.add(enemy);
		scanner.close();
		
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
		if(bomber.isAlive&&!board.allEnemiesRemoved){
		keyboardHandler.update();//update Keyboard
		board.update();
		bomber.update();
		//call draw
		draw();
		}
		else{
			this.running=false;
			//System.out.println("game is over");
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

	
	
	

}
