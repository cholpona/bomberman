import java.awt.BorderLayout;
import java.io.FileNotFoundException;

import javax.swing.JFrame;




public class BomberGame {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException{
		
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

	        // Forever keep moving
	        // This is the best way to do what we want,
	        // but we'll use it for its simplicity 
	        while(game.running||!game.completed) {//player is alive
	            game.update();
	            Thread.currentThread().sleep(100);
	        }
	        
		
	}
}
