
import java.awt.Color;
import java.awt.Graphics;




public class Bomber extends MovingObject{
	KeyboardHandler keyboardHandler;
	boolean moving;

	public Bomber(int x,int y, KeyboardHandler keyboardHandler, GamePanel gamePanel){
		super(x,y,Color.green);
		this.keyboardHandler=keyboardHandler;	
		this.moving=false;
		this.speed=SPEED;
		this.gamePanel=gamePanel;
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
			moving=true;
			move(xd,yd);
		}
		else{
			moving=false;
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
		for(int i = 0; i < gamePanel.board.bombs.size(); i++) {
			if((x) == gamePanel.board.bombs.get(i).x &&(y) == gamePanel.board.bombs.get(i).y) return false;
		}
		return true;
	}

	private void putBomb() {
		Bomb bomb = new Bomb(x, y, gamePanel.board, 3);
		gamePanel.board.bombs.add(bomb);
		gamePanel.board.board[x][y].changeState(new BombBlock());
	}

	private boolean colisionWithEnemy() {		
		for(int i = 0; i < gamePanel.board.enemies.size(); i++) {
			if(x == gamePanel.board.enemies.get(i).x && y == gamePanel.board.enemies.get(i).y ) return true;
		}
		return false;
	}

	private void updateBombsAndFires() {
		for (int i = 0; i <gamePanel.board.bombs.size(); i++) {
			if(gamePanel.board.bombs.get(i).removed){
				gamePanel.board.board[gamePanel.board.bombs.get(i).x][gamePanel.board.bombs.get(i).y].changeState(new EmptyBlock());
				gamePanel.board.bombs.remove(i);
			}
		}
		for (int i = 0; i < gamePanel.board.fires.size(); i++) {
			if(gamePanel.board.fires.get(i).removed){
				gamePanel.board.board[gamePanel.board.fires.get(i).x][gamePanel.board.fires.get(i).y].changeState(new EmptyBlock());
				gamePanel.board.fires.remove(i);
			}
		}
	}

	public void reset() {
		this.setX(1);
		this.setY(1);
	}








}


