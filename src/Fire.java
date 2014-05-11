import java.awt.Color;
import java.awt.Graphics;


public class Fire extends GameObject {
	public static final int MAXTIME_FIRE=15;
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
		this.r=-1;
		this.l=-1;
		this.u=-1;
		this.d=-1;
		this.x=x;
		this.y=y;
		this.range=range;
		this.color=color.ORANGE;
		this.counter=10;
		this.removed=false;
		this.board=board;
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

	@Override
	public void draw(Graphics g) {




	}
	public void update(){
		if(counter>=MAXTIME_FIRE){
			this.removed=true;
			board.board[x][y].changeState(new EmptyBlock());
			//change states of softblocks
			for (int i = 0; i < range; i++) {
				if(rightFireable > i) {board.board[x+1][y].changeState(new EmptyBlock());}
				if(leftFireable >i) {board.board[x-1][y].changeState(new EmptyBlock());}
				if(downFireable > i){board.board[x][y+1].changeState(new EmptyBlock());}
				if(upFireable>i) {board.board[x][y-1].changeState(new EmptyBlock());}

			}

		}
		else{
			
			for(int i = 1; i <= range; i++) {
				if(r == -1) {
					if(board.board[x+1][y].notFireable()) r = i - 1;
					if(board.board[x+1][y].fireable()) rightFireable = i;
				}
				if(l == -1) {
					if(board.board[x-1][y].notFireable()) l = i - 1;
					if(board.board[x-1][y].fireable()) leftFireable = i;
				}
				if(d == -1) {
					if(board.board[x][y+1].notFireable()) d = i - 1;
					if(board.board[x][y+1].fireable()) downFireable = i;
				}
				if(u == -1) {
					if(board.board[x][y-1].notFireable()) u = i - 1;
					if(board.board[x][y-1].fireable()) upFireable = i;
				}

				if(i == range) {
					if(r == -1) r = i;
					if(l == -1) l = i;
					if(d == -1) d = i;
					if(u == -1) u = i;
				}
			}
			board.board[x][y].changeState(new FireState());
			for(int i = 1; i <= range; i++) {
				if(r>i||rightFireable>=i){
					board.board[x+1][y].changeState(new FireState());
				}
				if(l > i || leftFireable >= i){
					board.board[x-1][y].changeState(new FireState());
				}
				if(d > i || downFireable >= i){ 
					board.board[x][y+1].changeState(new FireState());
				}
				if(u > i || upFireable >= i){
					board.board[x][y-1].changeState(new FireState());
				}

			}
			counter++;


		}


	}

	@Override
	public boolean fireable() {

		return false;// TODO check fireable or not
	}

	@Override
	public boolean notFireable() {
		// TODO Auto-generated method stub
		return false;
	}

}
