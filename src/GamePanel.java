
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import listener.KeyboardHandler;


public class GamePanel extends JPanel{
	public boolean completed;
	public boolean running;
	public static final int WIDTH=500;
	public static final int HEIGHT=500;
	public static final int SPEED=GameObject.SIZE;
	public Bomber bomber;
	public Board board;
	KeyboardHandler keyboardHandler;
	public GamePanel(){
		board=new Board();
		keyboardHandler=new KeyboardHandler();
		addKeyListener(keyboardHandler);
		this.bomber =new Bomber(1,1,keyboardHandler, board);
		this.running=true;
		this.completed=false;
		
		setLevel();
		
	}
	private void setLevel() {
		for (int i = 0; i < WIDTH/SPEED; i++) {
			for (int j = 0; j < HEIGHT/SPEED; j++) {
				Block block=new Block(i,j);
				if((i%2==0&&j%2==0)||i==0||j==0||i==(WIDTH/SPEED-1)||j==(WIDTH/SPEED-1)){
					block.changeState(new HardBlock());
				}
				board.board[i][j]=block;
			}
		}
		
		//board.board[bomber.x][bomber.y]=bomber;
		
		//board.board[enemy.x][enemy.y]=enemy;
		
	}
	
	public void startIt(){
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		requestFocus();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				update();
				delta--;
			}
			
			repaint();
			
		}
	}
	private void draw() {
		repaint();
	}
	void update() {
		keyboardHandler.update();//update Keyboard
		board.update();
		bomber.update();
		//call draw
		draw();
		
	}

    public void paint(Graphics g) {
    	//System.out.println("called");
        super.paint(g);
        board.draw(g);
        bomber.draw(g);
    }

	
	
	

}
