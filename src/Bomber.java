
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
	public void update() {
		
		if(xd!=0||yd!=0){
			move(xd,yd);
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

	void putBomb() {
		if(BlockAvailable()){
		Bomb bomb = new Bomb(x, y, board, 3);
		board.bombs.add(bomb);
		board.board[x][y].changeState(new BombBlock());}
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


