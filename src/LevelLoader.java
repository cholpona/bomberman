import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class LevelLoader {
	BomberGame game;
	
	private String levelInStr;
	public LevelLoader(BomberGame game){
		this.game=game;
	}
	public void loadLevel(int x){
		readLevel(x);
		loadLevel();
		start();
	}
	

	public  void readLevel(int level)  {
		this.levelInStr="";
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("level"+level+".txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error in reading level no "+level);
		}
		while(scanner.hasNextLine()){
			levelInStr=levelInStr+scanner.nextLine()+"\n";	
		}
		scanner.close();
	}
	

	public void loadLevel() {
		game.board.reset();
		game.bomber.reset();
		String[] levelMap = levelInStr.split("\n");
		char currChar;
		for (int i = 0; i < Board.BLOCKNUMBER; i++) {
			String row=levelMap[i];
			for (int j = 0; j < Board.BLOCKNUMBER; j++) {
				Block block=new Block(j,i);
				currChar=row.charAt(j);
				 if(currChar=='e'){
					Enemy enemy=new Enemy(j,i, game.board);
					game.addEnemy(enemy);
				}
				 else {
					 block.changeStateTo(currChar);
				 }
				game.setBlockAt(i, j, block);
			}
		}
	}
	


	public void start(){
		game.setRunning(true);
		game.setCompleted(false);
		System.out.println("level "+ " is started");
	}

}

