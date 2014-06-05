import java.awt.Graphics;
import java.util.ArrayList;




public class Board {
	
	public static final int BLOCKNUMBER=BomberGame.HEIGHT/GameObject.SIZE;
	GameObject[][] board;
	public ArrayList<Bomb> bombs;
	public ArrayList<Enemy> enemies;
	public ArrayList<Fire> fires;
	public boolean allEnemiesRemoved;

	public Board(){
		board=	new GameObject[BLOCKNUMBER][BLOCKNUMBER];
		for (int i = 0; i < BLOCKNUMBER; i++) {
			for (int j = 0; j < BLOCKNUMBER; j++) {
				board[i][j]=new Block(i,j,this);
			}
		}
		enemies=new ArrayList<Enemy>();
		bombs=new ArrayList<Bomb>();
		fires=new ArrayList<Fire>();
		allEnemiesRemoved=false;
	}

	public void update() {
		removeDiedEnemies();	
		updateFires();//TODO is added in the right place
		updateBombs();
		updateEnemies();
		removedDiedBombsAndFires();
		
	}

	private void updateEnemies() {
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();
		}
	}

	private void updateBombs() {
		for (int i = 0; i < bombs.size(); i++) {
			bombs.get(i).update();
		}
	}

	private void updateFires() {
		for (int i = 0; i < fires.size(); i++) {
			fires.get(i).update();
		}
	}
	private void removeDiedEnemies() {
		for (int i = 0; i < enemies.size(); i++) {
			if(!(enemies.get(i).isAlive)){
				enemies.remove(i);
			}
		}
		if(enemies.size()==0){
			allEnemiesRemoved=true;
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
		}

	}

	public void readLevel(){
		//TODO will read level from txt file
	}
	
	public void addEnemy(Enemy gameObj) {
		enemies.add(gameObj);
	}
	
	public void reset() {
		board=new GameObject[BLOCKNUMBER][BLOCKNUMBER];
		enemies=new ArrayList<Enemy>();
		bombs=new ArrayList<Bomb>();
		fires=new ArrayList<Fire>();
		allEnemiesRemoved=false;

	}
	
	public void setBlockBlockAt(int x, int y, Block block) {
		board[y][x]=block;
	}

	public Block getBlockAt(int x, int y) {
		return (Block)board[x][y];
		
	}
	private void removedDiedBombsAndFires() {
		for (int i = 0; i <bombs.size(); i++) {
			if(bombs.get(i).removed){
				//board.board[board.bombs.get(i).x][board.bombs.get(i).y].changeState(new EmptyBlock());
				bombs.remove(i);
			}
		}
		for (int i = 0; i < fires.size(); i++) {
			if(fires.get(i).removed){
				//board.board[board.fires.get(i).x][board.fires.get(i).y].changeState(new EmptyBlock());
				fires.remove(i);
			}
		}
	}


}
