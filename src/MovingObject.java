import java.awt.Graphics;


public class MovingObject extends GameObject{
	static final int LEFT=1;
	static final int RIGHT=2;
	static final int UP=3;
	static final int DOWN=4;
	static final int SPEED=1;
	public int dir;
	public int speed;
	public boolean isAlive;
	public GamePanel gamePanel;
	//TODO constructor ile yapmaya dene
	
	
	
	@Override
	public void fireOnMe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean walkable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean notFireable() {
		// TODO Auto-generated method stub
		return false;
	}
protected boolean colisionWithFire() {//TODO copied from bomber to upper calss
		
		for (int i = 0; i <gamePanel.board.fires.size(); i++) {
			if(gamePanel.board.fires.get(i).fireCollisionAt(this.x, this.y)){
				return true;
			}
		}
		return false;
	}

}
