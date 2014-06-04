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
	public GamePanel gamePanel;

	public Fire(int x, int y, int range,GamePanel gamePanel){
		this.r=-1;
		this.l=-1;
		this.u=-1;
		this.d=-1;
		this.x=x;
		this.y=y;
		this.range=range;
		this.color=color.ORANGE;
		this.counter=0;
		this.removed=false;
		this.gamePanel=gamePanel;
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
			gamePanel.board.board[x][y].changeState(new EmptyBlock());
					
			for(int i = 1; i <= range; i++) {//the same as fire need to make a method with state
				if(r>=i||rightFireable>=i){
					if(x+i<gamePanel.board.board.length-1){
					gamePanel.board.board[x+i][y].changeState(new EmptyBlock());}
						}
				if(l >= i || leftFireable >= i){
					if(x-i>0){
					gamePanel.board.board[x-i][y].changeState(new EmptyBlock());}
				}
				if(d >= i || downFireable >= i){ 
					if(y+i<gamePanel.board.board.length-1){
					gamePanel.board.board[x][y+i].changeState(new EmptyBlock());}
				}
				if(u >= i || upFireable >= i){
					if(y-i>0){
					gamePanel.board.board[x][y-i].changeState(new EmptyBlock());}
				}
	}}
		else{

			for(int i = 1; i <= range; i++) {
				if(r == -1) {
					if(gamePanel.board.board[x+1][y].notFireable()) r = i - 1;
					if(gamePanel.board.board[x+1][y].walkable()) rightFireable = i;
				}
				if(l == -1) {
					if(gamePanel.board.board[x-1][y].notFireable()) l = i - 1;
					if(gamePanel.board.board[x-1][y].walkable()) leftFireable = i;
				}
				if(d == -1) {
					if(gamePanel.board.board[x][y+1].notFireable()) d = i - 1;
					if(gamePanel.board.board[x][y+1].walkable()) downFireable = i;
				}
				if(u == -1) {
					if(gamePanel.board.board[x][y-1].notFireable()) u = i - 1;
					if(gamePanel.board.board[x][y-1].walkable()) upFireable = i;
				}

				if(i == range) {
					if(r == -1) r = i;
					if(l == -1) l = i;
					if(d == -1) d = i;
					if(u == -1) u = i;
				}
			}

			gamePanel.board.board[x][y].changeState(new FireState());
			for(int i = 1; i <= range; i++) {
				if(r>=i||rightFireable>=i){
					if(x+i<gamePanel.board.board.length-1){
					gamePanel.board.board[x+i][y].changeState(new FireState());}
						}
				if(l >= i || leftFireable >= i){
					if(x-i>0){
					gamePanel.board.board[x-i][y].changeState(new FireState());}
				}
				if(d >= i || downFireable >= i){ 
					if(y+i<gamePanel.board.board.length-1){
					gamePanel.board.board[x][y+i].changeState(new FireState());}
				}
				if(u >= i || upFireable >= i){
					if(y-i>0){
					gamePanel.board.board[x][y-i].changeState(new FireState());}
				}


				counter++;
			}}

	}

	public boolean fireCollisionAt(int x, int y){
		if(this.x==x&&this.y==y){
			return true;
		}

		for(int i = 1; i <= range; i++) {
			if(r>=i||rightFireable>=i){
				if(x+i<Board.BLOCKNUMBER){
				if(x==this.x+i&&y==this.y){
					return true;
				}}
			}
			if(l >= i || leftFireable >= i){
				if(x-i>0){
				if(x==this.x-i&&y==this.y){
					return true;
				}}
			}
			if(d >= i || downFireable >= i){ 
				if(y+i<Board.BLOCKNUMBER){
				if(x==this.x&&y==this.y+i){
					return true;
				}}
			}
			if(u >= i || upFireable >= i){
				if(y-i>0){
				if(x==this.x&&y==this.y-i){
					return true;
				}}
			}
		}
		return false;
	}


	@Override
	public boolean notFireable() {
		// TODO Auto-generated method stub
		return false;
	}

}
