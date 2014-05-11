import java.awt.Graphics;
import java.util.ArrayList;

import listener.KeyboardHandler;




public class Board {
public static final int BLOCKNUMBER=GamePanel.HEIGHT/GameObject.SIZE;
GameObject[][] board=new GameObject[BLOCKNUMBER][BLOCKNUMBER];
public ArrayList<Bomb> bombs;
public ArrayList<Enemy> enemies;
public boolean completed;



public Board(){
	for (int i = 0; i < BLOCKNUMBER; i++) {
		for (int j = 0; j < BLOCKNUMBER; j++) {
			board[i][j]=new Block(i,j);
		}
	}
	enemies=new ArrayList<Enemy>();
	bombs=new ArrayList<Bomb>();
	completed=false;
	board[2][2].changeState(new HardBlock());
	board[3][3].changeState(new SoftBlock());
	
	
}
public String toString(){
	String str="";
	for (int i = 0; i < BLOCKNUMBER; i++) {
		for (int j = 0; j < BLOCKNUMBER; j++) {
			str=str+board[i][j].toString();
		}
		str=str+"\n";
	}
	return str;
	
}
public void update() {
		if(enemies.size()==0){
			completed=true;
		}
		
		for (int i = 0; i < bombs.size(); i++) {
			bombs.get(i).update();
		}
		
}
public void draw(Graphics g) {
	for (int i = 0; i < BLOCKNUMBER; i++) {
		for (int j = 0; j < BLOCKNUMBER; j++) {
			board[i][j].draw(g);
		}
	}
	
}

public void readLevel(){
	//TODO will read level from txt file
}


}
