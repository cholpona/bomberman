import java.awt.Color;
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
	
public MovingObject(int x, int y,Color color){
	super(x,y,color);
	this.isAlive=true;
	
}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean burnable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean solid() {
		// TODO Auto-generated method stub
		return false;
	}

	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillOval(x*GameObject.SIZE, y*GameObject.SIZE, SIZE, SIZE);
		// System.out.println("enemy is drawn");
	}
	
public boolean colisionWithFire() {//TODO copied from bomber to upper calss
		
		for (int i = 0; i <gamePanel.board.fires.size(); i++) {
			if(gamePanel.board.fires.get(i).fireCollisionAt(this.getX(), this.getY())){
				return true;
			}
		}
		return false;
	}

protected boolean canWalk() {//TODO direaction.canmove yapayim

	if(dir==RIGHT){
		return !gamePanel.board.board[x+1][y].solid();
	}
	else if(dir==DOWN){
		return !gamePanel.board.board[x][y+1].solid();
	}
	else if(dir==UP){
		return !gamePanel.board.board[x][y-1].solid();
	}
	else if(dir==LEFT){
		if(x-1>0)
			return !gamePanel.board.board[x-1][y].solid();
	}
	
	return false;
}

}
