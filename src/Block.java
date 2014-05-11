import java.awt.Color;
import java.awt.Graphics;


public class Block extends GameObject{
	public int x;
	public int y;
	public BlockState state;
	public Block(int x,int y){
		this.x=x;
		this.y=y;
		this.state=new EmptyBlock();
	}
	
	
	@Override
	public void playerOnMe() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void fireOnMe() {
		// TODO Auto-generated method stub
		
	}
	
	public void setState(BlockState state) {
		this.state=state;
		
	}
	@Override
	public String toString() {
		return this.state.ToString();
	}
	@Override
	public void changeState(BlockState state) {
		setState(state);
		
	}

	@Override
	public boolean walkable() {
		
		return this.state.walkable();
	}

	@Override
	public void draw(Graphics g) {
		if(state.ToString().equals("Bomb Block")){
			g.setColor(color.gray);
	        g.fillRect(x*20, y*20, SIZE, SIZE);
			g.setColor(state.getColor());
	        g.fillOval(x*20, y*20, SIZE, SIZE);
		}
		else{
			g.setColor(state.getColor());
	        g.fillRect(x*20, y*20, SIZE, SIZE);
		}
		
	
		
	}


	@Override
	public boolean fireable(){
		return state.fireable();
	}
	
}
