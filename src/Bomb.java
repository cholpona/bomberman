import java.awt.Color;
import java.awt.Graphics;

public class Bomb extends GameObject{
	public int range;
	public boolean removed;
	public Board board;
	public static final int MAXTIME=20;
	public int counter;
	public Bomb(int x, int y, Board board, int range){
		super(x,y,Color.black,board,false);
		removed=false;
		this.board=board;
		this.range=range;
		this.counter=0;

	}


	@Override
	public boolean burnable() {
		return true;
	}

	@Override
	public boolean solid() {
		return false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x*GameObject.SIZE, y*GameObject.SIZE, SIZE, SIZE);

	}

	public void update() {
		if(counter>=MAXTIME){
			board.fires.add(new Fire(x,y,this.range,board));//add fire to board
			//System.out.println("explode at "+this.x+" "+this.y);
			this.removed=true;

		}
		else{
			if(colisionWithFire()){
				board.fires.add(new Fire(x,y,this.range,board));//add fire to board
				//System.out.println("explode at "+this.x+" "+this.y);
				this.removed=true;
			}
			else{
				counter++;
			}
		}

	}
	
	private boolean colisionWithFire() {//TODO copied from bomber to upper calss
		if(board.getBlockAt(x, y).state.toString().equals("FireState")){
			return true;
		}
		return false;
		
	}

	@Override
	public void changeState(BlockState state) {
	}
}
