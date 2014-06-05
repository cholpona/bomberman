
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
	private LevelLoader levelLoader;

	public static void main(String[] args) {
		BomberGame bomberGame=new BomberGame();
	}

	public BomberGame(){
		setLayout(new BorderLayout());
		setSize(520, 540); //      
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game = new GamePanel();
		levelLoader=new LevelLoader(game);
		this.levelNo=1;
		levelLoader.loadLevel(levelNo);
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
}
