import java.awt.Color;
import java.awt.Graphics;


public class Block extends GameObject{
	public Block(int x,int y,Board board){
		super(x,y,Color.GRAY,board,false);
		this.state=new EmptyBlock();
	}

	public void changeState(BlockState state) {
		this.state=state;
	}

	@Override
	public boolean burnable() {
		return this.state.burnable();
	}
	@Override
	public boolean solid() {
		return state.solid();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(state.getColor());
		g.fillRect(x*20, y*20, SIZE, SIZE);
	}

	public void changeStateTo(char ch){
		if(ch=='s'){
			this.changeState(new SoftBlock());
		}
		else if(ch=='h'){
			this.changeState(new HardBlock());
		}
		else{
			this.changeState(new EmptyBlock());
		}
	}

	public void spreadFireAt(int x, int y, int range) {
		this.changeState(new FireState());
		board.getBlockAt(x,y+1).sendFireDown(range);
		board.getBlockAt(x+1, y).sendFireRight(range);
		board.getBlockAt(x-1, y).sendFireLeft(range);
		board.getBlockAt(x, y-1).sendFireUp(range);
	}

	private void sendFireUp(int range) {//template yapmaya calis
		if(state.solid()){
			if(state.burnable()){
				changeState(new FireState());
			}
		}
		else{
			changeState(new FireState());
			if(range>1){
				board.getBlockAt(x, y-1).sendFireUp(range-1);
			}
		}

	}

	private void sendFireLeft(int range) {
		if(state.solid()){
			if(state.burnable()){
				changeState(new FireState());
			}
		}
		else{
			changeState(new FireState());
			if(range>1){
				board.getBlockAt(x-1, y).sendFireLeft(range-1);
			}
		}

	}

	private void sendFireRight(int range) {
		if(state.solid()){
			if(state.burnable()){
				changeState(new FireState());
			}
		}
		else{
			changeState(new FireState());
			if(range>1){
				board.getBlockAt(x+1, y).sendFireRight(range-1);
			}
		}


	}

	private void sendFireDown(int range) {
		if(state.solid()){
			if(state.burnable()){
				changeState(new FireState());
			}
		}
		else{
			changeState(new FireState());
			if(range>1){
				board.getBlockAt(x, y+1).sendFireDown(range-1);
			}
		}


	}

	public void closeFireAt(int x, int y, int range) {
		changeState(new EmptyBlock());
		board.getBlockAt(x,y+1).sendCloseFireDown(range);
		board.getBlockAt(x+1, y).sendCloseFireRight(range);
		board.getBlockAt(x-1, y).sendCloseFireLeft(range);
		board.getBlockAt(x, y-1).sendCloseFireUp(range);


	}

	private void sendCloseFireDown(int range) {
		if(!state.solid()){
			changeState(new EmptyBlock());
			if(range>1){
				if(y+1<board.BLOCKNUMBER)
				board.getBlockAt(x,y+1).sendCloseFireDown(range-1);
			
		}
		}
	}

	private void sendCloseFireLeft(int range) {
		if(!state.solid()){
			changeState(new EmptyBlock());
			if(range>1){
				if(x-1>0)
					board.getBlockAt(x-1, y).sendCloseFireLeft(range-1);
			}
		
		}
	}

	private void sendCloseFireRight(int range) {
			if(!state.solid()){
			changeState(new EmptyBlock());
			if(range>1){
				if(x+1<board.BLOCKNUMBER)
					board.getBlockAt(x+1, y).sendCloseFireRight(range-1);
			
		}}
	}

	private void sendCloseFireUp(int range) {
		if(!state.solid()){
		
			changeState(new EmptyBlock());
			if(range>1){
				if(y-1>0)
					board.getBlockAt(x, y-1).sendCloseFireUp(range-1);
			
		}

	}}

}
