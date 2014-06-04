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
	Color getColor() {
		return color;
	}

	@Override
	public boolean solid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean burnable() {
		// TODO Auto-generated method stub
		return false;
	}

}
