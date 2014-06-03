import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;




public class BomberGame {
	static String level="";
	static final int MAX_LEVEL=3;
	static final int FREQ=60;
	public static void main(String[] args) throws InterruptedException, FileNotFoundException{

		//readNextLevel();

		JFrame frame = new JFrame("BomberMan");
		frame.setLayout(new BorderLayout());
		frame.setSize(520, 540); //      
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel game = new GamePanel();
		frame.add(game, BorderLayout.CENTER);
		frame.setVisible(true);
		// This is needed to make the game panel respond
		// to key strokes
		game.requestFocusInWindow();

		while(game.getLevel()<=MAX_LEVEL){
			while(game.isRunning()&&!game.isCompleted()) {//player is alive
				Thread.currentThread();
				Thread.sleep(FREQ);
				game.update();

			}
			if(game.isCompleted()){
				
				game.readNextLevel();//read
				game.loadLevel();//load
				game.start();//start completed true->false running false-> true
				Thread.currentThread().interrupt();
				//game
			}else{
				System.out.println("you lose!");
				break;
			}

		}
		System.out.println("you have passed all degrees!");

	}
	private static void delay() {
		int numb=1;
		for (int i = 0; i < 1000; i++) {
			numb=numb*i*i;
		}

	}


}
