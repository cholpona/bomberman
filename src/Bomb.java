import java.awt.Graphics;






public class Bomb extends GameObject{
	public int range;
	public boolean removed;
	public Board board;
	public static final int MAXTIME=15;
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
		
		return true;//TODO need to check true or false?
	}

	@Override
	public void draw(Graphics g) {
		 g.setColor(color);
	     g.fillOval(x*GameObject.SIZE, y*GameObject.SIZE, SIZE, SIZE);
		
	}

	public void update() {
		if(counter>=MAXTIME){
			
			board.fires.add(new Fire(x,y,range,board));//add fire to board
			System.out.println("explode at "+this.x+" "+this.y);
			this.removed=true;
		}
		else{
			counter++;
		}
		
	}

	@Override
	public boolean fireable() {
		
		return true;//TODO check whether true or false
	}

	@Override
	public boolean notFireable() {
		// TODO Auto-generated method stub
		return false;
	}
	


}
