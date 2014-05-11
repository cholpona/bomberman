
import java.awt.Graphics;

import listener.KeyboardHandler;


public class Bomber extends GameObject{
	static final int LEFT=1;
	static final int RIGHT=2;
	static final int UP=3;
	static final int DOWN=4;
	static final int SPEED=1;
	KeyboardHandler keyboardHandler;
	boolean moving;
	int dir;
	int speed;
	boolean isAlive;
	Board board;
	public Bomber(int x,int y, KeyboardHandler keyboardHandler, Board board){
		this.color=color.green;
		this.x=x;
		this.y=y;
		this.keyboardHandler=keyboardHandler;	
		this.moving=false;
		this.dir=RIGHT;
		this.speed=SPEED;
		this.isAlive=true;
		//this.picture=Picture.bomber;
		this.board=board;


	}


	@Override
	public void playerOnMe() {
		// TODO Auto-generated method stub

	}

	
	public void move(int xa, int ya) {
		if(xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
// some bug here!!! DONE
		if(xa > 0) dir = RIGHT;
		if(xa < 0) dir = LEFT;
		if(ya > 0) dir = DOWN;
		if(ya < 0) dir = UP;
		//check whether reachable
		if(canWalk()){
			x += xa;
			y += ya;
		}
	}

	private boolean canWalk() {

		if(dir==RIGHT){
			return board.board[x+1][y].walkable();
		}
		else if(dir==DOWN){
			return board.board[x][y+1].walkable();
		}
		else if(dir==UP){
			return board.board[x][y-1].walkable();
		}
		else if(dir==LEFT){
			return board.board[x-1][y].walkable();
		}
		else{ return false;}
	}

	@Override
	public void fireOnMe() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Bomber";
	}

	@Override
	public void changeState(BlockState state) {
		// TODO Auto-generated method stub

	}

	public void update() {
		int xd=0;
		int yd=0;
		if(keyboardHandler.up){
			//System.out.println("called up");
			yd=yd-speed;
		}
		if(keyboardHandler.down){
			//System.out.println("called down");
			yd=yd+speed;
		}
		if(keyboardHandler.right){
			//System.out.println("called right");
			xd=xd+speed;
		}
		if(keyboardHandler.left){
			xd=xd-speed;
		}
		if(keyboardHandler.space){
			if(BlockAvailable()){
			putBomb();
			}
			System.out.println("bomb is planted at "+this.x+" "+this.y);
		}
		if(xd!=0||yd!=0){
			moving=true;
			move(xd,yd);
		}
		else{
			moving=false;
		}
		updateBombs();
		//colision with enemy
		if(colisionWithEnemy()){
			isAlive=false;
		}
		//colision with fire
		if(colisionWithFire()){
			isAlive=false;
		}

	}

	private boolean BlockAvailable() {
		for(int i = 0; i < board.bombs.size(); i++) {
			if((x) == board.bombs.get(i).x &&(y) == board.bombs.get(i).y) return false;
			}
		
		return true;
	}

	private void putBomb() {
		Bomb bomb = new Bomb(x, y, board, 4);
		board.bombs.add(bomb);
		board.board[x][y].changeState(new BombBlock());
		
	}

	private boolean colisionWithFire() {
		//TODO
		return false;
	}

	private boolean colisionWithEnemy() {
		
			for(int i = 0; i < board.enemies.size(); i++) {
				if(x == board.enemies.get(i).x && y == board.enemies.get(i).y ) return true;
				}
		
		return false;
	}

	private void updateBombs() {
		for (int i = 0; i <board.bombs.size(); i++) {
			if(board.bombs.get(i).removed){
				board.board[board.bombs.get(i).x][board.bombs.get(i).y].changeState(new EmptyBlock());
				board.bombs.remove(i);
			}
		}
		
	}

	@Override
	public boolean walkable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
        g.fillOval(x*GameObject.SIZE, y*GameObject.SIZE, SIZE, SIZE);
	}


	@Override
	public boolean fireable() {
		
		return true;
	}


}


