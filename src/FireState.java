import java.awt.Color;


public class FireState extends BlockState{
	Color color;
	public FireState(){
		this.color=color.orange;
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
	public String toString(){
		return "FireState";
		
	}

}
