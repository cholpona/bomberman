import java.awt.Graphics;
import java.util.ArrayList;




public class Board {
public static final int BLOCKNUMBER=GamePanel.HEIGHT/GameObject.SIZE;
GameObject[][] board=new GameObject[BLOCKNUMBER][BLOCKNUMBER];
public ArrayList<Bomb> bombs;
public ArrayList<Enemy> enemies;
public ArrayList<Fire> fires;
public boolean allEnemiesRemoved;



public Board(){
	for (int i = 0; i < BLOCKNUMBER; i++) {
		for (int j = 0; j < BLOCKNUMBER; j++) {
			board[i][j]=new Block(i,j);
		}
	}
	enemies=new ArrayList<Enemy>();
	bombs=new ArrayList<Bomb>();
	fires=new ArrayList<Fire>();
	allEnemiesRemoved=false;
	//board[2][2].changeState(new HardBlock());
	//board[3][3].changeState(new SoftBlock());
	
	
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
		removeDiedEnemies();	
		if(enemies.size()==0){
			allEnemiesRemoved=true;
		}
		
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();
		}
		
		for (int i = 0; i < bombs.size(); i++) {
			bombs.get(i).update();
			
		}
		for (int i = 0; i < fires.size(); i++) {
			fires.get(i).update();//TODO is added in the right place
		}
		
}
private void removeDiedEnemies() {
	for (int i = 0; i < enemies.size(); i++) {
			if(!(enemies.get(i).isAlive)){
				enemies.remove(i);
			}
	}
	
}
public void draw(Graphics g) {
	
	for (int i = 0; i < BLOCKNUMBER; i++) {
		for (int j = 0; j < BLOCKNUMBER; j++) {
			board[i][j].draw(g);
		}
	}
	for (int i = 0; i < enemies.size(); i++) {
		enemies.get(i).draw(g);
		//System.out.println("enemi is drawn");
	}
	
}

public void readLevel(){
	//TODO will read level from txt file
}
public void addEnemy(Enemy gameObj) {
	enemies.add(gameObj);
	
}


}
