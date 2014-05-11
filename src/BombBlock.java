import java.awt.Color;
import java.awt.Graphics;


public class BombBlock extends BlockState{
	Color color;
	public BombBlock(){
	this.color=color.BLACK;
	}

	@Override
	void playerOnMe(Block block) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void drawMe(Block block) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void fireOnMe(Block block) {
		// TODO Auto-generated method stub
		
	}

	@Override
	String ToString() {
		// TODO Auto-generated method stub
		return "Bomb Block";
	}

	@Override
	boolean walkAble() {
		
		return false;
	}

	

	@Override
	Color getColor() {
		return color;
	}

	
}
