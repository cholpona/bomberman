import java.awt.Color;


public class SoftBlock extends BlockState{
	Color color;
	public SoftBlock(){
		this.color=color.gray.darker();
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

	@Override
	public boolean fireable() {
		
		return true;
	}

	@Override
	public boolean notFireable() {
		
		return false;
	}

	
}
