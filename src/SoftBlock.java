import java.awt.Color;


public class SoftBlock extends BlockState{
	Color color;
	public SoftBlock(){
		this.color=color.blue.brighter();
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
		
		return "soft ball";
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