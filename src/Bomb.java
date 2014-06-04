import java.awt.Color;
import java.awt.Graphics;

public class Bomb extends GameObject{
	public int range;
	public boolean removed;
	public GamePanel gamePanel;
	public static final int MAXTIME=20;
	public int counter;
	public Bomb(int x, int y, GamePanel gamePanel, int range){
		super(x,y,Color.black);
		removed=false;
		this.gamePanel=gamePanel;
		this.range=range;
		this.counter=0;

	}


	@Override
	public boolean burnable() {
		return true;
	}

	@Override
	public boolean solid() {
		return false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x*GameObject.SIZE, y*GameObject.SIZE, SIZE, SIZE);

	}

	public void update() {
		if(counter>=MAXTIME){
			gamePanel.board.fires.add(new Fire(x,y,this.range,gamePanel));//add fire to board
			//System.out.println("explode at "+this.x+" "+this.y);
			this.removed=true;

		}
		else{
			if(colisionWithFire()){
				gamePanel.board.fires.add(new Fire(x,y,this.range,gamePanel));//add fire to board
				//System.out.println("explode at "+this.x+" "+this.y);
				this.removed=true;
			}
			else{
				counter++;
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

	@Override
	public void changeState(BlockState state) {
	}
}
