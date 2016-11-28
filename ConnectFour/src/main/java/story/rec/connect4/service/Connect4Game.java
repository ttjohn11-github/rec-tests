package story.rec.connect4.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a game of Connect4
 * 
 * @author Admin
 *
 */
public class Connect4Game {

	private String gameId;
	private static final int columns = 7;
	private static final int rows = 6;
	private static final int winCount = 4;
	private int[][] slots = null;

	public Connect4Game(){
		slots = new int[rows][columns];
		for(int i = 0; i< rows; i++){
			for(int j =0; j< columns; j++){
				slots[i][j] = 0;
			}
		}
	}
	/**
	 * get all slots as it is. each slot contain colour of played game 0 - not
	 * played 1 - player1, 2- player2
	 * 
	 * @return
	 */
	public int[][] getSlots() {
		return slots;
	}

	/**
	 * 
	 * @return all columns available now to play
	 */
	public List<Integer> getAvailableColumns() {
		return new ArrayList<Integer>();
	}

	/**
	 * update a move by a player
	 * 
	 * @param colum
	 * @param colour
	 */
	public void place(int colum, int colour) {
		if (slots[rows - 1][colum] != 0) {// if column full,
			throw new IllegalArgumentException("Illegal move ..");
		}
		int availableRow = 0;
		while (availableRow < rows && slots[availableRow][colum] != 0) {
			availableRow++;
		}
		slots[availableRow][colum] = colour;

	}

	/**
	 * check if game is Draw
	 * 
	 * @return
	 */
	public boolean isDraw() {
		for (int i = 0; i < columns; i++) {// if top of all columns are filled
											// and no win, its a draw
			if (slots[rows-1][i] != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * check if its a win
	 * 
	 * @param colour
	 * @return
	 */
	public boolean isWin(int colour) {
		return isHorizontalWin(colour) || isVerticalWin(colour) || isDiagonalWin(colour);
	}

	/**
	 * check win for horizontal
	 * @param colour
	 * @return
	 */
	private boolean isHorizontalWin(int colour){
		for(int i = 0; i < rows; i++){//for all rows
			int number =0;
			for(int j =0;j<columns;j++){//if 4 in a row
				if(slots[i][j] == colour){
					number++;
					if(number == winCount){
						return true;
					}
				}else{//if not same colour count from 0
					number = 0;
				}
			}				
		}
		return false;
	}

	/**
	 * check win vertically
	 * 
	 * @param colour
	 * @return
	 */
	private boolean isVerticalWin(int colour) {
		
		return false;
	}

	/**
	 * check win diagonally
	 * 
	 * @param colour
	 * @return
	 */
	private boolean isDiagonalWin(int colour) {

		return false;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

}
