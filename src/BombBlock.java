import java.awt.Color;
import java.awt.Graphics;


public class BombBlock extends BlockState{
	
	Color color;
	public BombBlock(){
	this.color=color.BLACK;
	
	}

	@Override
	Color getColor() {
		return color;
	}

	@Override
	public boolean solid() {
		
		return false;
	}

	@Override
	public boolean burnable() {
		// TODO Auto-generated method stub
		return true;
	}

	
	

	
}
