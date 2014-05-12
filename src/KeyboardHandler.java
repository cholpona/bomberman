

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
	public KeyboardHandler(){
		System.out.println("listener added!");
	}
	
	private boolean[] keys = new boolean[120];//there are 120 keys
	public boolean up, down, left, right, space;
	
	public void update() {
		up = keys[KeyEvent.VK_UP] ;
		down = keys[KeyEvent.VK_DOWN] ;
		left = keys[KeyEvent.VK_LEFT] ;
		right = keys[KeyEvent.VK_RIGHT] ;
		space = keys[KeyEvent.VK_SPACE];
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;			
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}

