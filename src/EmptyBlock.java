import java.awt.Color;
import java.awt.Graphics;


public class EmptyBlock extends BlockState{
	public Color color;
	public EmptyBlock(){
		color=color.GRAY;
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
		
		return "Empty Block";
	}

	@Override
	boolean walkAble() {
		
		return true;
	}

	
	@Override
	Color getColor() {
		
		return color;
	}

}