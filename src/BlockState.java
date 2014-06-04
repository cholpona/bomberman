import java.awt.Color;
import java.awt.Graphics;


public abstract  class BlockState {
	abstract Color getColor();
	public abstract boolean burnable();
	public abstract boolean solid();	
}

