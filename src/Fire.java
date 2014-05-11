import java.awt.Color;
import java.awt.Graphics;


public class Fire extends GameObject {
public int range;
private int rightBreakable;
private int r;
private int leftBreakable;
private int downBreakable;
private int upBreakable;
private int l;
private int d;
private int u;
public Color color;


public Fire(int x, int y, int range){
	this.x=x;
	this.y=y;
	this.range=range;
	this.color=color.ORANGE;
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
		// TODO Auto-generated method stub
		return "fire";
	}

	@Override
	public void changeState(BlockState state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean walkable() {
		
		return true;
	}
	public boolean fireCollision(int x, int y){
		
		for(int i = 1; i < range; i++) {
			if(x==this.x&&y==this.y) {
				return true;
			}
			if(r >= i || rightBreakable >= i) {
				if(x == this.x + i  && y == this.y) {
					return true;
				}
			}
			if(l >= i || leftBreakable >= i) {
				if(x == this.x- i && y == this.y ) {
					return true;
				}
			}
			if(d >= i || downBreakable >= i) {
				if(x == this.x  && y == this.y + i) {
					return true;
				}
			}
			if(u >= i || upBreakable >= i) {
				if(x == this.x  && y ==this.y - i) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
        g.fillOval(x, y, SIZE, SIZE);
	
		
	}

}
