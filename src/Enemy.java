import java.awt.Color;
import java.awt.Graphics;
import java.util.Currency;
import java.util.Random;


public class Enemy extends GameObject{
	public int x;
	public int y;
	Color color;
	int freq=10;
	boolean isAlive;
	
	static final int LEFT=1;
	static final int RIGHT=2;
	static final int UP=3;
	static final int DOWN=4;
	static final int SPEED=1;
	static final int FREQUENCY=5;
	int dir;
	int speed;
	
	GamePanel gamePanel;
	Random randomDir;
	int count;
	public Enemy(int x ,int y,GamePanel gamePanel){
		this.color=color.PINK;
		this.x=x;
		this.y=y;
		this.gamePanel=gamePanel;
		count=0;
		randomDir=new Random();
		this.dir=LEFT;
		this.count=0;
		this.isAlive=true;
	}

	@Override
	public void fireOnMe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Enemy";
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
		g.setColor(color);
        g.fillOval(x*GameObject.SIZE, y*GameObject.SIZE, SIZE, SIZE);
       // System.out.println("enemy is drawn");
	}


	@Override
	public boolean notFireable() {
		// TODO Auto-generated method stub
		return false;
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
		else{
			changeDirection();
			moveForwad();
		}
	}

	private void changeDirection() {
		int nextDir=randomDir.nextInt(4);
		if(nextDir+1==dir){
			changeDirection();
		}
		else{
			dir=nextDir+1;
		}
		
	}


	private void moveForwad() {
		if(dir==RIGHT){
			move(1,0);
		}
		else if(dir==LEFT){
			move(-1,0);
		}
		else if(dir==UP){
			move(0,-1);
		}
		else if(dir==DOWN){
			move(0,1);
		}
		
	}


	private boolean canWalk() {//TODO direaction.canmove yapayim

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
			return gamePanel.board.board[x-1][y].walkable();
		}
		else{ return false;}
	}
	
	public void update(){
		if(isAlive){
			if(colisionWithFire()){//TODO copied to upper class
				isAlive=false;
				System.out.println("enemy died");
			}
			else{	
		if(count>FREQUENCY){
		moveForwad();	
		count=0;
		}		
		else{
			count++;
		}
			}
		
		}
	}
	
private boolean colisionWithFire() {//TODO copied from bomber to upper calss
		
		for (int i = 0; i <gamePanel.board.fires.size(); i++) {
			if(gamePanel.board.fires.get(i).fireCollisionAt(this.x, this.y)){
				return true;
			}
		}
		return false;
	}



}
