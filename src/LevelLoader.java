import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class LevelLoader {

	private int levelNo;
	private GamePanel gamePanel;
	LevelLoader(GamePanel gamePanel) {
		levelNo = 0;
		this.gamePanel=gamePanel;
		
	}

	
	public void increaseLevel(){
		levelNo++;
	}
	public void reset(){
		levelNo=0;
	}

	public GameObject[][] loadNextLevel() {
		GameObject[][] board = new GameObject[Board.BLOCKNUMBER][Board.BLOCKNUMBER];
		ArrayList<char[]> mapping=createMap();
		for (int row = 0; row < Board.BLOCKNUMBER; row++) {
			for (int col = 0; col < Board.BLOCKNUMBER; col++) {
				GameObject object = GameObject.getGameObject(mapping.get(row)[col], row, col);
				if (object == null)
					continue;
				addEntityToLevel(object, board);
			}
		}
		return null;
	}

	private ArrayList<char[]> createMap() {
		ArrayList<char[]> charList = readMapFile();
		char[][] tileChars = new char[charList.size()][];
		for (int row = 0; row < tileChars.length; row++) {
			tileChars[row] = charList.get(row);
		}
		return charList;
	}

	private ArrayList<char[]> readMapFile() {
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new File("demoStage_" + (levelNo) + ".txt"));//levelNo++
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't read stage file"+levelNo);
			System.exit(1);
		}

		return loopOverMapFile(fileScanner);
	}

	private ArrayList<char[]> loopOverMapFile(Scanner fileScanner) {
		ArrayList<char[]> charMap = new ArrayList<char[]>();
		while (fileScanner.hasNextLine()) {
			char[] tileRow = fileScanner.nextLine().toCharArray();
			charMap.add(tileRow);
		}
		return charMap;
	}

	private void addEntityToLevel(GameObject gameObj,GameObject[][] board) {
		if (gameObj instanceof Block){
			board[gameObj.x][gameObj.y]=gameObj;
		}
		else if (gameObj instanceof Enemy){
			((Enemy) gameObj).setGamePanel(gamePanel);
			gamePanel.addEnemy((Enemy) gameObj);
			}
		else
			throw new IllegalArgumentException("Unexpected entity");
	}
}

