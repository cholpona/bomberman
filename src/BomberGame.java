
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;




public class BomberGame extends JPanel{
	static final int FREQ=60;
	public static final int LASTLEVEL=2;
	public static final int WIDTH=500;
	public static final int HEIGHT=500;
	private int levelNo;
	private Timer gameTimer;
	private LevelLoader levelLoader;
	private boolean completed;
	private  boolean running;
	Bomber bomber;
	public Board board;
	private KeyboardHandler keyboardHandler;

	public static void main(String[] args) {
		BomberGame bomberGame=new BomberGame();
		JFrame frame=new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setSize(bomberGame.getSize());      
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(bomberGame, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	public BomberGame(){
		setSize(HEIGHT+20, WIDTH+40);
		setVisible(true);
		board=new Board();
		
		this.bomber =new Bomber(1,1,keyboardHandler,board);
		keyboardHandler=new KeyboardHandler(bomber);
		addKeyListener(keyboardHandler);
		this.running=false;
		this.completed=true;
		this.levelNo=1;
		levelLoader=new LevelLoader(this);
		levelLoader.loadLevel(levelNo);
		run();
	}

	private void run(){
		ActionListener listener = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				requestFocusInWindow();
				if (running) {
					update();
				} else {
					gameTimer.stop();
					if(completed){
						if(nextLevelExist()){
							levelNo++;
							levelLoader.loadLevel(levelNo);
							run();
						}
						else{
							printVictoryMessage();
						}
					}
					else{
						printByeMessage();
					}
				}
			}

			private void printVictoryMessage() {
				System.out.println("Yaaaaay you passed all levels");

			}
			private void printByeMessage() {
				System.out.println("Sorry you lose!");
			}
		};
		gameTimer = new Timer(FREQ, listener);
		gameTimer.start();
	}

	public boolean nextLevelExist() {
		if(levelNo<LASTLEVEL){
			return true;
		}
		else return false;
	}

	private void draw() {
		repaint();
	}

	void update() {
		if(bomber.isAlive){
			if(!board.allEnemiesRemoved){
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

	

	public void addEnemy(Enemy gameObj) {
		board.addEnemy(gameObj);
	}

	public void setBlockAt(int x, int y,Block block ){
		board.setBlockBlockAt(x,y,block);
	}

	public	Block getBlockAt(int x,int y){
		return board.getBlockAt(x,y);
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		board.draw(g);
		bomber.draw(g);
	}

}
