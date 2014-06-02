import java.awt.Color;


public class HardBlock extends BlockState{
Color color;
public HardBlock(){
	this.color=color.blue.darker();
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
		
		return "HardBlock";
	}

	
	@Override
	Color getColor() {
	
		return color;
	}
	
	@Override
	boolean walkAble() {
		
		return false;
	}
	
	@Override
	public boolean fireable() {
		
		return false;
	}
	@Override
	public boolean notFireable() {
		
		return true;
	}
	
	

}
