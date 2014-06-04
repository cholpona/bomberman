
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


import javax.swing.JFrame;
import javax.swing.Timer;




public class BomberGame extends JFrame{
	static final int MAX_LEVEL=3;
	static final int FREQ=60;
	public static final int LASTLEVEL=2;
	private int levelNo;
	private GamePanel game;
	private Timer gameTimer;
	
	public static void main(String[] args) {
		BomberGame bomberGame=new BomberGame();
	}
	
	public BomberGame(){
		setLayout(new BorderLayout());
		setSize(520, 540); //      
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game = new GamePanel();
		add(game, BorderLayout.CENTER);
		setVisible(true);
		run();
	}
	
	
	private void run(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.requestFocusInWindow();
				if (game.isRunning()) {
					game.update();
				} else {
					gameTimer.stop();
					if(game.isCompleted()){
						if(game.nextLevelExist()){
						startNextLevel();}
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

			private void startNextLevel() {
				
				try {
					game.readNextLevel();
				} catch (FileNotFoundException e1) {
					System.out.println("Error in reading level "+game.getLevel());
				}
				game.loadLevel();
				game.start();
				System.out.println("running "+game.isRunning()+" completed "+game.isCompleted());
				run();
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
	
	
	
	
}
