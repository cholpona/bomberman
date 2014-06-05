
import java.awt.Color;
import java.awt.Graphics;




public class Bomber extends MovingObject{
	KeyboardHandler keyboardHandler;
	
	public Bomber(int x,int y, KeyboardHandler keyboardHandler, Board board){
		super(x,y,Color.green);
		this.keyboardHandler=keyboardHandler;	
		this.speed=SPEED;
		this.board=board;
	}

	public void move(int xd, int yd) {
		if(xd != 0 && yd != 0) {
			move(xd, 0);
			move(0, yd);
			return;
		}

		if(xd > 0) dir = RIGHT;
		if(xd < 0) dir = LEFT;
		if(yd > 0) dir = DOWN;
		if(yd < 0) dir = UP;
		//check whether next block walkable
		if(canWalk()){
			this.setX(this.getX()+xd);
			this.setY(this.getY()+yd);	
		}
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
				//System.out.println("bomb is planted at "+this.x+" "+this.y);
			}
		}
		if(xd!=0||yd!=0){
			move(xd,yd);
		}
		else{
			
		}
		updateBombsAndFires();// TODO niye burda niye bombs da deil?
		//colision with enemy
		if(colisionWithEnemy()){
			isAlive=false;
		}
		//colision with fire
		if(colisionWithFire()){
			isAlive=false;
			System.out.println("you died");
		}
	}

	private boolean BlockAvailable() {
		for(int i = 0; i < board.bombs.size(); i++) {
			if((x) == board.bombs.get(i).x &&(y) == board.bombs.get(i).y) return false;
		}
		return true;
	}

	private void putBomb() {
		Bomb bomb = new Bomb(x, y, board, 3);
		board.bombs.add(bomb);
		board.board[x][y].changeState(new BombBlock());
	}

	private boolean colisionWithEnemy() {		
		for(int i = 0; i < board.enemies.size(); i++) {
			if(x == board.enemies.get(i).x && y == board.enemies.get(i).y ) return true;
		}
		return false;
	}

	private void updateBombsAndFires() {
		for (int i = 0; i <board.bombs.size(); i++) {
			if(board.bombs.get(i).removed){
				board.board[board.bombs.get(i).x][board.bombs.get(i).y].changeState(new EmptyBlock());
				board.bombs.remove(i);
			}
		}
		for (int i = 0; i < board.fires.size(); i++) {
			if(board.fires.get(i).removed){
				board.board[board.fires.get(i).x][board.fires.get(i).y].changeState(new EmptyBlock());
				board.fires.remove(i);
			}
		}
	}

	public void reset() {
		this.setX(1);
		this.setY(1);
	}








}


