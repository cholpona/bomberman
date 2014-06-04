import java.awt.Color;
import java.awt.Graphics;



public abstract  class GameObject{
	public static final int SIZE = 20;
	int x;
	int y;
	Picture picture;
	Color color;
	BlockState state;
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	public void move(){
	}
	public abstract void fireOnMe();
	public abstract String toString();
	
	public abstract boolean walkable();
	public abstract void draw(Graphics g);
	public abstract boolean notFireable();
	public BlockState getState(){
		return state;
	}
	public static GameObject getGameObject(char tileChar, int row, int col) {
		GameObject obj;
		if (tileChar == 's'){
			obj=new Block(row,col);
			obj.changeState(new SoftBlock());
			return  obj;
			}
		else if (tileChar == 'n'){
			obj=new Block(row,col);
			obj.changeState(new EmptyBlock());
			return  obj;
			}
		else if (tileChar == 'h'){
			obj=new Block(row,col);
			obj.changeState(new HardBlock());
			return  obj;
			}
		else if (tileChar == 'e'){
			obj=new Enemy(row,col, null);
			return  obj;
			}
		else{
			return null;}
	}
	
	public void changeState(BlockState state){
		state.setState((Block)this, state);
	}
	
		
}
