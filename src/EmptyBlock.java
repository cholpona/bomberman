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
	Color getColor() {
		
		return color;
	}
	

	
	@Override
	public boolean solid() {
		return false;//TODO look
	}
	@Override
	public boolean burnable() {
		// TODO Auto-generated method stub
		return false;
	}

}
