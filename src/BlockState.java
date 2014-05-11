import java.awt.Color;
import java.awt.Graphics;


public abstract  class BlockState {
	abstract void playerOnMe(Block block);
	abstract void drawMe(Block block);
	abstract void fireOnMe(Block block);
	abstract String ToString();
	abstract boolean walkAble();
	abstract Color getColor();
	void setState(Block block,BlockState state){
		changeState(block, state);
	}
	void changeState(Block block,BlockState state){
		block.setState(state);
	}
	public boolean walkable() {
		
		return walkAble();
	}
	public abstract boolean fireable() ;
	
}

