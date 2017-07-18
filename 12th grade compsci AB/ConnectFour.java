import java.io.*;
import java.util.Random;
import TerminalIO.KeyboardReader;

public class ConnectFour
{

	static final int BOARD_ROWS = 6;
	static final int BOARD_COLUMNS = 7;
	static final String EMPTY = " ";
	static final String RED = "O";
	static final String BLACK = "X";
	static String[][] board = new String[BOARD_ROWS][BOARD_COLUMNS];
	
	public static void main(String[] args)
	{
		
		boolean gameRunning = true;
		int turnNumber = 0;
		KeyboardReader reader = new KeyboardReader();
		initializeArray();
		int playerCol = 0;
		int dropRow;
		String compColor = RED;
		
		//asks for how many players
		int numberOfPlayers = reader.readInt("1 or 2 players: ");
		
		if (numberOfPlayers == 2) {
			System.out.println();
			System.out.println("RED is 'O'");
			System.out.println("BLACK is 'X'");
			System.out.println("RED goes first.");
			System.out.println();
			while (gameRunning) {
				drawBoard();
				if (checkForWin(RED)) {
						System.out.println("RED PLAYER WINS!");
						break; } 
				if (checkForWin(BLACK)) {
						System.out.println("BLACK PLAYER WINS!");
						break; }
				dropRow = -1;
				if (turnNumber % 2 == 0) {
					while (dropRow == -1) {
						playerCol = 0;
						while (playerCol < 1 || playerCol > BOARD_COLUMNS)
							playerCol = reader.readInt("Red Player's Column: ");
						dropRow = dropForColumn(playerCol-1);
					}
					board[dropRow][playerCol-1] = RED;
				}
				else {
					while (dropRow == -1) {
						playerCol = 0;
						while (playerCol < 1 || playerCol > BOARD_COLUMNS)
							playerCol = reader.readInt("Black Player's Column: ");
						dropRow = dropForColumn(playerCol-1);
					}
					board[dropRow][playerCol-1] = BLACK;
				}	
				turnNumber++;
				System.out.println();				
			}
		}
		
		if (numberOfPlayers == 1) {
			System.out.println();
			System.out.println("Computer is RED 'O'");
			System.out.println("You are BLACK 'X'");
			System.out.println("RED goes first.");
			System.out.println();
			while (gameRunning) {
				if (checkForWin(RED)) {
					drawBoard();
					System.out.println("RED PLAYER WINS!");
					break; } 
				if (checkForWin(BLACK)) {
					drawBoard();
					System.out.println("BLACK PLAYER WINS!");
					break; }
				playerCol = 0;
				dropRow = -1;
				if (turnNumber % 2 == 0) {
					while (dropRow == -1) {
						playerCol = bestMove(compColor);
						dropRow = dropForColumn(playerCol);
					}
					board[dropRow][playerCol] = RED;
				}
				else {	
					drawBoard();
					while (dropRow == -1) {
						playerCol = 0;
						while (playerCol < 1 || playerCol > BOARD_COLUMNS)
							playerCol = reader.readInt("Black Player's Column: ");
						dropRow = dropForColumn(playerCol-1);
					}
					board[dropRow][playerCol-1] = BLACK;
				}	
				turnNumber++;
				System.out.println();				
			}
		}
					
	}//end of main method
	
	public static void initializeArray()
	{
	
		for (int i = 0; i < BOARD_ROWS; i++)
			for (int j = 0; j < BOARD_COLUMNS; j++)
				board[i][j] = EMPTY;
	}
	
	public static void drawBoard()
	{
		for (int i = 0; i < BOARD_ROWS; i++) {
			System.out.print("| ");
			for (int j = 0; j < BOARD_COLUMNS; j++)
				System.out.print(board[i][j] + " | ");
			System.out.println();
		}
		
	}
	
	public static int dropForColumn(int col)
	{
		if(col<0 || col>BOARD_COLUMNS-1)
			return -1;
		int i;
		for (i = BOARD_ROWS - 1; i >= 0; i--){
			if (board[i][col].equals(EMPTY))
				break;
		}
		if(i == -1)
			return -1;
		return i;
	}
	
	public static boolean checkForWin(String color)
	{
		if (checkForHorizontal(color) ||
			checkForVertical(color) ||
			checkForDiagonalDown(color) ||
			checkForDiagonalUp(color))
			return true;
		return false;
	}
	
	public static boolean checkForHorizontal(String color)
	{
		int counter = 0;
		for (int i = BOARD_ROWS - 1; i >= 0; i--) {
			for (int j = 0; j < BOARD_COLUMNS; j++) {
				counter = 0;	
				for (int m = j; m < BOARD_COLUMNS; m++) {
					if (board[i][m].equals(color)) {
						counter++;
						if (counter == 4)
						return true;
					}
					else
						counter = 0;	
				}
			}	
		}
			
		return false;
	}
	
	public static boolean checkForVertical(String color)
	{
		int counter = 0;
		for (int i = 0; i < BOARD_COLUMNS; i++) {
			for (int j = 0; j < BOARD_ROWS; j++) {
				counter = 0;	
				for (int m = j; m < BOARD_ROWS; m++) {
					if (board[m][i].equals(color))
						counter++;
					else
						counter = 0;
					if (counter == 4)
						return true;
				}
			}
		}
			
		return false;
	}
	
	public static boolean checkForDiagonalDown(String color)
	{
		int counter = 0;
		int checkRow;
		int checkCol;
		for (int currRow = 0; currRow < 3; currRow++) {
			for (int currCol = 0; currCol < 4; currCol++) {
				checkRow = currRow;	
				checkCol = currCol;
				while (checkCol < BOARD_COLUMNS && checkRow < BOARD_ROWS) {		
					if (board[checkRow][checkCol].equals(color)) {
						counter++;
						checkRow++;
						checkCol++;
					}
					if (counter == 4)
						return true;
					else {
						counter = 0;
						break;
					}
				}
			}
		}
		return false;
	}
	//------------------------------------------------------------------------------
	public static boolean checkForDiagonalUp(String color)
	{
		int counter = 0;
		int checkRow;
		int checkCol;
		for (int currRow = 3; currRow < BOARD_ROWS; currRow++) {
			for (int currCol = 0; currCol < 4; currCol++) {
				checkRow = currRow;	
				checkCol = currCol;
				while (checkCol < BOARD_COLUMNS && checkRow < BOARD_ROWS) {		
					if (board[checkRow][checkCol].equals(color)) {
						counter++;
						checkRow--;
						checkCol++;
					}
					if (counter == 4)
						return true;
					else {
						counter = 0;
						break;
					}
				}
			}
		}
		return false;
	}
	//------------------------------------------------------------------------------
	public static int bestMove(String color)
	{
		
		//constructs a string that contains enemy's color
		String enemyColor = BLACK;
		
		//if there is a best move, return it
		int bestMove = CheckPossibleWin();
		if (bestMove != -1)
			return bestMove;
		bestMove = checkPossibleBlock();
		if (bestMove != -1)
			return bestMove;
		
		// if there is no return yet, return a random number between [0, 7)
		Random random = new Random();
		int randomCol = random.nextInt(7);
		return randomCol;
				
	}
	
	public static int CheckPossibleWin()
	{
		//check if there's three in a row and
		//return an empty fourth position
		//else return -1
		int bestMove = checkPossibleHorizontalWin(RED);
		if (bestMove != -1){
			System.out.println("horizontal best move: " + bestMove);
			return bestMove;
		}
		bestMove = checkPossibleVerticalWin(RED);
		if (bestMove != -1){
			System.out.println("vertical best move: " + bestMove);
			return bestMove;
		}
		bestMove = checkPossibleDiagonalWinUp(RED);
		if (bestMove != -1){
			System.out.println("diagonal up best move: " + bestMove);
			return bestMove;
		}
		bestMove = checkPossibleDiagonalWinDown(RED);
		if (bestMove != -1){
			System.out.println("diagonal down best move: " + bestMove);
			return bestMove;
		}
			
		return -1;
	}
	//---------------------------------------------------------------------------
	public static int checkPossibleHorizontalWin(String color)
	{
		int counter = 0;
		for (int i = BOARD_ROWS - 1; i >= 0; i--) {
			for (int j = 0; j < BOARD_COLUMNS; j++) {
				counter = 0;	
				for (int m = j; m < BOARD_COLUMNS; m++) {
					if (board[i][m].equals(color)) {
						counter++;
						if (counter == 3){
							if (m+1 < BOARD_COLUMNS && board[i][m+1].equals(EMPTY) && dropForColumn(m+1)==i)
								return m+1;
							if (m-3 >= 0 && board[i][m-3].equals(EMPTY) && dropForColumn(m-3)==i)
								return m-3;
						}
					}
					else
						counter = 0;
				}
			}
		}
	return -1;
	}
	//--------------------------------------------------------------------------
	public static int checkPossibleVerticalWin(String color)
	{
		int counter = 0;
		for (int i = 0; i < BOARD_COLUMNS; i++) {
			for (int j = BOARD_ROWS-1; j >= 0; j--) {
				counter = 0;	
				for (int m = j; m >= 0; m--) {
					if (board[m][i].equals(color)){
						counter++;
						if (counter == 3){
							if (dropForColumn(i) == m-1)
								return m-1;
						}
					}
					else
						counter = 0;
				}
			}
		}
		return -1;
	}
	//---------------------------------------------------------------------------
	public static int checkPossibleDiagonalWinDown(String color)
	{
		int counter = 0;
		int checkRow;
		int checkCol;
		for (int currRow = 0; currRow < 3; currRow++) {
			for (int currCol = 0; currCol < 4; currCol++) {
				checkRow = currRow;	
				checkCol = currCol;
				while (checkCol < BOARD_COLUMNS && checkRow < BOARD_ROWS) {		
					if (board[checkRow][checkCol].equals(color)) {
						counter++;
						checkRow++;
						checkCol++;
					}
					if (counter == 3 && dropForColumn(checkCol) == checkRow)
							return checkRow;
					else {
						counter = 0;
						break;
					}
				}
			}
		}
		return -1;
	}
	//---------------------------------------------------------------------------
	public static int checkPossibleDiagonalWinUp(String color)
	{
		int counter = 0;
		int checkRow;
		int checkCol;
		for (int currRow = 3; currRow < BOARD_ROWS; currRow++) {
			for (int currCol = 0; currCol < 4; currCol++) {
				checkRow = currRow;	
				checkCol = currCol;
				while (checkCol < BOARD_COLUMNS && checkRow < BOARD_ROWS) {		
					if (board[checkRow][checkCol].equals(color)) {
						counter++;
						checkRow--;
						checkCol++;
					}
					if (counter == 3 && dropForColumn(checkCol) == checkRow)
							return checkRow;
					else {
						counter = 0;
						break;
					}
				}
			}
		}
		return -1;
	}
	//---------------------------------------------------------------------------
	public static int checkPossibleBlock(){
		int block = checkPossibleHorizontalWin(BLACK);
		if(block != -1)
			return block;
		block = checkPossibleVerticalWin(BLACK);
		if(block != -1)
			return block;
		block = checkPossibleDiagonalWinDown(BLACK);
		if(block != -1)
			return block;
		block = checkPossibleDiagonalWinUp(BLACK);
		if(block != -1)
			return block;
		block = checkPossibleHorizontalBlock(BLACK);
		if(block != -1)
			return block;
		
		return -1;
	}
	//---------------------------------------------------------------------------
	
	public static int checkPossibleHorizontalBlock(String color)
	{
		
		int counter = 0;
		
		//if a row is empty except for two consecutive cells,
		//block the opponent from getting three in a row
		
		for (int currRow = BOARD_ROWS - 1; currRow >= 0; currRow--) {
			
			for (int currCol = 0; currCol < BOARD_COLUMNS; currCol++) {
				
				if (counter == 2) {
					if (board[currRow][0].equals(color) && board[currRow][1].equals(color))
						return 2;
					if (board[currRow][1].equals(color) && board[currRow][2].equals(color))
						return 3; 
					if (board[currRow][2].equals(color) && board[currRow][3].equals(color))
						return 4;
					if (board[currRow][3].equals(color) && board[currRow][4].equals(color))
						return 5;
					if (board[currRow][4].equals(color) && board[currRow][5].equals(color))
						return 6;
					if (board[currRow][5].equals(color) && board[currRow][6].equals(color))
						return 4; 
				}
					
				else if (board[currRow][currCol].equals(color))
					counter++;
				
				else
					counter = 0;	
			}
		}
		
		//if check doesn't work, return -1
		return -1;
	}
	
}//end of class ConnectFour