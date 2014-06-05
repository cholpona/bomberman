import java.awt.Color;
import java.awt.Graphics;


public class Fire extends GameObject {
	public static final int MAXTIME_FIRE=7;
	public int range;
	private int rightFireable;
	private int r;
	private int leftFireable;
	private int downFireable;
	private int upFireable;
	private int l;
	private int d;
	private int u;
	public Color color;
	public int counter;
	public boolean removed;
	public Board board;

	public Fire(int x, int y, int range,Board board){
		super(x,y,Color.orange,board,false);
		this.range=range;
		this.counter=0;
		this.removed=false;
		this.board=board;
		board.getBlockAt(x, y).spreadFireAt(x,y,range);
	}

	@Override
	public boolean burnable() {
		return true;
	}

	@Override
	public boolean solid() {
		return false;
	}

	public void update(){
		if(counter>=MAXTIME_FIRE){
			this.removed=true;
			board.getBlockAt(x,y).closeFireAt(x,y,range);
		}
		else{
		
			counter++;
		}

	}



	private void changeFiredTo(BlockState state) {
		board.board[x][y].changeState(state);		
		for(int i = 1; i <= range; i++) {
			if(r>=i||rightFireable>=i){
				if(x+i<Board.BLOCKNUMBER-1){
					board.board[x+i][y].changeState(state);}
			}
			if(l >= i || leftFireable >= i){
				if(x-i>0){
					board.board[x-i][y].changeState(state);}
			}
			if(d >= i || downFireable >= i){ 
				if(y+i<Board.BLOCKNUMBER-1){
					board.board[x][y+i].changeState(state);}
			}
			if(u >= i || upFireable >= i){
				if(y-i>0){
					board.board[x][y-i].changeState(state);}
			}
		}
	}

	@Override
	public void changeState(BlockState state) {}

	@Override
	public void draw(Graphics g) {}

}
