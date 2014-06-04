
import java.awt.Graphics;




public class Bomber extends MovingObject{
	
	KeyboardHandler keyboardHandler;
	boolean moving;
	
	public Bomber(int x,int y, KeyboardHandler keyboardHandler, GamePanel gamePanel){
		this.x=x;
		this.y=y;
		this.color=color.green;
		this.keyboardHandler=keyboardHandler;	
		this.moving=false;
		this.dir=RIGHT;
		this.speed=SPEED;
		this.isAlive=true;
		//this.picture=Picture.bomber;
		this.gamePanel=gamePanel;


	}
	public void move(int xa, int ya) {
		if(xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			//return;
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
			System.out.println("bomb is planted at "+this.x+" "+this.y);
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
		Bomb bomb = new Bomb(x, y, gamePanel, 3);
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
	public boolean notFireable() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void fireOnMe() {
		// TODO Auto-generated method stub

	}


	public void reset() {
		this.x=1;
		this.y=1;
		
	}
	protected boolean canWalk() {//TODO direaction.canmove yapayim

		if(dir==RIGHT){
			return gamePanel.board.board[x+1][y].walkable();
		}
		else if(dir==DOWN){
			return gamePanel.board.board[x][y+1].walkable();
		}
		else if(dir==UP){
			return gamePanel.board.board[x][y-1].walkable();
		}
		else if(dir==LEFT){
			if(x-1>0)
				return gamePanel.board.board[x-1][y].walkable();
		}
		
		return false;
	}
	

	


}


