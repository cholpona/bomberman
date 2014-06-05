import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Enemy extends MovingObject{
	int freq=10;
	int frequency=5;
	Random randomDir;
	int count;
	public Enemy(int x ,int y,Board board){
		super(x,y,Color.pink,board);
		this.board=board;
		count=0;
		randomDir=new Random();
		this.dir=LEFT;
		this.count=0;
		this.speed=1;
		this.frequency=randomDir.nextInt(7)+1;
		System.out.println(this.frequency);
	}

	public void moveOtherwise(){
		changeDirection();
		moveForwad();
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

	private void moveForwad() {//TODO try to use goleft
		if(dir==RIGHT){
			goRight();
		}
		else if(dir==LEFT){
			goLeft();
		}
		else if(dir==UP){
			goUp();
		}
		else if(dir==DOWN){
			goDown();
		}
		
		move(xd, yd);

	}

	public void update(){
		if(isAlive){
			if(colisionWithFire()){
				isAlive=false;
			}
			else{	
				if(count>frequency){
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
