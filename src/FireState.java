import java.awt.Color;


public class FireState extends BlockState{
	Color color;
	public FireState(){
		this.color=color.orange;
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
		
		return "Fire";
	}

	@Override
	boolean walkAble() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	Color getColor() {
		
		return color;
	}

	@Override
	public boolean fireable() {
		// TODO Auto-generated method stub
		return false;
	}

}
