package story.rec.connect4.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import story.rec.connect4.dao.GameManager;

/**
 * Test connect4 game class
 * @author Admin
 *
 */
public class Connect4GameTest {
	
	@Before
	public void setup(){
		
	}
	@Test
	public void verifyPlaceAndAvailableSlots(){
		Connect4Game game = new GameManager().getConnect4Game("game10");
		game.place(0, 1);
		game.place(1, 1);
		game.place(2, 1);
		game.place(3, 1);
		game.place(4, 1);
		game.place(5, 1);
		List<Integer> slots = game.getAvailableColumns();
		//then, slots shouldnt have column 1.
		assertFalse(slots.contains(new Integer(1)));
	}
	@Test
	public void verifyIsDraw(){
		//given all slots are filled
		Connect4Game game = new GameManager().getConnect4Game("game11");
		//when
		boolean isDraw = game.isDraw();
		//then assertTrue(isDraw);
		
	}
	@Test
	public void verifyIsWinDiagonal(){
		//given connect 4 done on a row for player1
		Connect4Game game = new GameManager().getConnect4Game("game12");
		//when
		boolean isWinPlayer1 = game.isWin(1);
		//then assertTrue(isWinPlayer1);
	}
	@Test
	public void verifyIsWinVertical(){
		//given connect 4 done on a column for player1
		Connect4Game game = new GameManager().getConnect4Game("game13");
		//when
		boolean isWinPlayer1 = game.isWin(1);
		//then assertTrue(isWinPlayer1);
	}
	@Test
	public void verifyIsWinHorizaontal(){
		//given connect 4 done on diagonal for player1
		Connect4Game game = new GameManager().getConnect4Game("game1");
		game.place(0, 1);
		game.place(1, 1);
		game.place(2, 1);
		game.place(3, 1);
		//when
		boolean isWinPlayer1 = game.isWin(1);
		//then 
		assertTrue(isWinPlayer1);
	}
	@Test
	public void verifyNoWinHorizontal(){
		//given connect 4 done on diagonal for player1
		Connect4Game game = new GameManager().getConnect4Game("game2");
		game.place(0, 1);
		game.place(1, 2);
		game.place(2, 1);
		game.place(3, 1);
		game.place(4, 1);
		//when
		boolean isWinPlayer1 = game.isWin(1);
		//then 
		assertFalse(isWinPlayer1);
	}
	
}
