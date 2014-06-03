//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//
//public class Menu extends JFrame{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//
//	public Menu()  {
//		drawMenuScreen();
//	}
//
//	private static  JPanel openningPicturePanel;
//	private static JLabel openingPictureLabel;
//	public KeyboardHandler keyboardHandler;
//	
//
//	private  void drawMenuScreen() {
//		openningPicturePanel = new JPanel();
//		openningPicturePanel.setLayout(null);
//
//		openingPictureLabel = new JLabel(new ImageIcon(
//				"src/menu.png"));
//	
//		
//
//		JButton newButton = new JButton("New Game");
//		newButton.setSize(120, 25);
//		newButton.setLocation(600, 250);
//		newButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				openningPicturePanel.setVisible(false);
//				repaint();
//				revalidate();
//				System.out.println("gekd");
//			//	System.out.println(board.toString());
//				GamePanel game = null;
//				
//					game = new GamePanel("");
//				
//				add(game);
//				//game.startIt();
//			}
//		});
//		openningPicturePanel.add(newButton);
//
//
//		// Exit
//		JButton exitButton = new JButton("Exit");
//		exitButton.setSize(120, 25);
//		exitButton.setLocation(600,400 );
//		exitButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				System.exit(0);
//			}
//		});
//		openningPicturePanel.add(exitButton);
//		openningPicturePanel.setBackground(Color.BLUE);
//
//		openingPictureLabel.setSize(900, 550);
//		openingPictureLabel.setLocation(0, 0);
//		openningPicturePanel.add(openingPictureLabel);
//		add(openningPicturePanel); // Add panel to frame
//		setSize(900, 550);
//		
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setResizable(false);
//		setVisible(true);
//		setFocusable(true);
//		
//
//	}
//}
