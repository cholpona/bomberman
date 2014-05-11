import javax.swing.JFrame;
import javax.swing.JPanel;

import listener.KeyboardHandler;


public class GameGui extends JFrame{
	static final int WIDTH=600;
	static final int LENGTH=900;
	Board board;
	JPanel gamePanel;
	public GameGui(Board board){
		this.board=board;
		setSize(WIDTH, LENGTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new KeyboardHandler());	
	}
	
	 
	
}
