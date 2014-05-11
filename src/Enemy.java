import java.awt.Color;
import java.awt.Graphics;


public class Enemy extends GameObject{
	public int x;
	public int y;
	Color color;
	
	public Enemy(int x ,int y){
		this.color=color.PINK;
		this.x=x;
		this.y=y;
	}


	@Override
	public void playerOnMe() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void fireOnMe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Enemy";
	}

	@Override
	public void changeState(BlockState state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean walkable() {
		return true;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
        g.fillOval(x, y, SIZE, SIZE);
	
	}


	@Override
	public boolean fireable() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean notFireable() {
		// TODO Auto-generated method stub
		return false;
	}

}
