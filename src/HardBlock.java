import java.awt.Color;


public class HardBlock extends BlockState{
	Color color;
	public HardBlock(){
		this.color=color.blue.darker();
	}

	@Override
	Color getColor() {

		return color;
	}

	@Override
	public boolean solid() {

		return true;
	}
	@Override
	public boolean burnable() {
		// TODO Auto-generated method stub
		return false;
	}



}
