import java.awt.Color;


public class SoftBlock extends BlockState{
	Color color;
	public SoftBlock(){
		this.color=color.gray.darker();
	}
	@Override
	Color getColor() {
		return color;
	}

	@Override
	public boolean burnable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean solid() {
		// TODO Auto-generated method stub
		return true;
	}



}
