import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;




public class BomberGame {
	static String level="";
	static final int MAX_LEVEL=1;
	public static void main(String[] args) throws InterruptedException, FileNotFoundException{
		
		readNextLevel();
		
		JFrame frame = new JFrame("BomberMan");
		frame.setLayout(new BorderLayout());
		frame.setSize(520, 540); //      
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel game = new GamePanel(level);

		frame.add(game, BorderLayout.CENTER);
		frame.setVisible(true);
		// This is needed to make the game panel respond
		// to key strokes
		game.requestFocusInWindow();
		
		while(game.getLevel()<=MAX_LEVEL){
		while(game.isRunning()&&!game.isCompleted()) {//player is alive
			game.update();
			Thread.currentThread().sleep(100);
		}
		if(game.isCompleted()){
			//game
		}else{
			System.out.println("you lose!");
			break;
		}
		
		}
		System.out.println("you have passed all degrees!");

	}

	private static void readNextLevel() throws FileNotFoundException {
		Scanner scanner =new Scanner(new File("level1.txt"));
		while(scanner.hasNextLine()){
		level=level+scanner.nextLine()+"\n";	
		}
		scanner.close();
	}
}
