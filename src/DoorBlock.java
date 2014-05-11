import java.awt.Color;
import java.awt.Graphics;


public class DoorBlock extends BlockState {
	Color color;
	public DoorBlock(){
		this.color=color.YELLOW;
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
		return "Door Block";
	}

	@Override
	boolean walkAble() {
		return true;
	}

	

	@Override
	Color getColor() {
		return color;
	}

	@Override
	public boolean fireable() {
		
		return false;
	}

	@Override
	public boolean notFireable() {
		// TODO Auto-generated method stub
		return true;
	}

}
