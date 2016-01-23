package ro.alex.test;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ro.alex.model.GameBoard;


public class GameBoardTest {

	@Test
	public void initGameBoardTest() {
		int size = 3;
		GameBoard gameBoard = new GameBoard(size);
		assertTrue(gameBoard!=null);
		
	}
	
	
	
	
	

}
