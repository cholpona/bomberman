import java.awt.Color;
import java.awt.Graphics;


public abstract  class GameObject{
	public static final int SIZE = 20;
	int x;
	int y;
	Picture picture;
	Color color;
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}	
	public abstract void playerOnMe();
	public abstract void fireOnMe();
	public abstract String toString();
	public abstract void changeState(BlockState state);
	public abstract boolean walkable();
	public abstract boolean fireable();
	public abstract void draw(Graphics g);
	public abstract boolean notFireable();

		
}
