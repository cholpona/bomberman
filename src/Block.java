import java.awt.Color;
import java.awt.Graphics;


public class Block extends GameObject{
	public Block(int x,int y){
		super(x,y,Color.GRAY);
		this.state=new EmptyBlock();
	}
	
	public void changeState(BlockState state) {
		this.state=state;
	}

	@Override
	public boolean burnable() {
				return this.state.burnable();
	}
	@Override
	public boolean solid() {
		return state.solid();
	}

	@Override
	public void draw(Graphics g) {
			g.setColor(state.getColor());
	        g.fillRect(x*20, y*20, SIZE, SIZE);
	}
	
	public void changeStateTo(char ch){
		if(ch=='s'){
			this.changeState(new SoftBlock());
		}
		else if(ch=='h'){
			this.changeState(new HardBlock());
		}
		else{
			this.changeState(new EmptyBlock());
		}
	}

}
