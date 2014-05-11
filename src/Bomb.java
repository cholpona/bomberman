import java.awt.Graphics;




public class Bomb extends GameObject{
	public int range;
	public boolean removed;
	public Board board;
	public static final int MAXTIME=100;
	public int counter;
	public Bomb(int x, int y, Board board, int i){
		removed=false;
		this.x=x;
		this.y=y;
		this.board=board;
		this.range=i;
		this.color=color.BLACK;
		this.counter=0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
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
		return "Bomb";
	}

	@Override
	public void changeState(BlockState state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean walkable() {
		
		return false;
	}

	@Override
	public void draw(Graphics g) {
		 g.setColor(color);
	     g.fillOval(x*GameObject.SIZE, y*GameObject.SIZE, SIZE, SIZE);
		
	}

	public void update() {
		
		
	}
	

}
