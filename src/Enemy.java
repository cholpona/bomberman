import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Enemy extends MovingObject{
	int freq=10;
	static final int FREQUENCY=5;
	Random randomDir;
	int count;
	public Enemy(int x ,int y,Board board){
		super(x,y,Color.pink);
		this.board=board;
		count=0;
		randomDir=new Random();
		this.dir=LEFT;
		this.count=0;
	}

	public void move(int xa, int ya) {//TODO template method
		if(xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		//is this neccessary?
		if(xa > 0) dir = RIGHT;
		if(xa < 0) dir = LEFT;
		if(ya > 0) dir = DOWN;
		if(ya < 0) dir = UP;
		//check whether reachable
		if(canWalk()){
			this.setX(this.getX()+xa);
			this.setY(this.getY()+ya);
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

	private void moveForwad() {//TODO try to make an analogy of state
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

	public void update(){
		if(isAlive){
			if(colisionWithFire()){
				isAlive=false;
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

}
