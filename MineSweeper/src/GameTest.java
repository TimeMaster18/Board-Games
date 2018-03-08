import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class GameTest {
	
	public class MockGame extends Game{
		
		public int mineDensity;
		public int posX;
		public int posY;
		public int op;
		public int count;
		
		
		public int askInt() {
			return mineDensity;
		}
		
		public int[] askPlayer(){
			int input[]={posX,posY,op};
			return input;
		}
	}
	
	@Test
	public void testSetMineDensity() {
		
		MockGame mockGame=new MockGame();
		Game game=new Game(5,5,10);
		mockGame.mineDensity=50;
		mockGame.setMineDensity();
		//mockGame.mineDensity=90;
		//mockGame.setMineDensity();
		
				
		
	}
	
	@Test
	public void testTurn() {
		MockGame mockGame=new MockGame();
		Game game=new Game(5,5,10);
		Board board=new Board(5,5);
		board.getTable()[2][2].setMined(true);
		mockGame.posX=2;
		mockGame.posY=1;
		mockGame.op=1;
		boolean res1=mockGame.turn(board);
		assertFalse(res1);
		
		mockGame.posX=2;
		mockGame.posY=1;
		mockGame.op=2;
		boolean res2=mockGame.turn(board);
		assertFalse(res2);
		
		mockGame.posX=2;
		mockGame.posY=2;
		mockGame.op=1;
		boolean res3=mockGame.turn(board);
		assertTrue(res3);
		
		//Square already open	
		mockGame.posX=2;
		mockGame.posY=1;
		mockGame.op=1;
		boolean res4=mockGame.turn(board);
		assertFalse(res4);
		
		Board board2=new Board(5,5);
		
		mockGame.posX=0;
		mockGame.posY=0;
		mockGame.op=1;
		boolean res5=mockGame.turn(board2);
		assertTrue(res5);
		
		
	}
	
	
	@Test
	public void testAskPlayer() {
		
		MockGame mockGame=new MockGame();
		Game game=new Game(5,5,10);
		mockGame.posX=2;
		mockGame.posY=2;
		mockGame.op=1;
		mockGame.askPlayer();
		
		mockGame.posX=12;
		mockGame.posY=2;
		mockGame.op=1;
		mockGame.askPlayer();
		
		mockGame.posX=2;
		mockGame.posY=12;
		mockGame.op=1;
		mockGame.askPlayer();
		
		mockGame.posX=2;
		mockGame.posY=2;
		mockGame.op=4;
		mockGame.askPlayer();
				
		
	}

	
	/**
	 * Checks if the difficulty entered is valid
	 * @return Returns true if the difficulty is valid
	 */	
	@Test
	public void testOpenBoard() {
		Game game = new Game(3,3,10);
		Board board = new Board(3,3);		
		game.openBoard(board);
		assertTrue(board.getTable()[0][0].isOpen());
		assertTrue(board.getTable()[0][1].isOpen());
		assertTrue(board.getTable()[0][2].isOpen());
		assertTrue(board.getTable()[1][0].isOpen());
		assertTrue(board.getTable()[1][1].isOpen());
		assertTrue(board.getTable()[1][2].isOpen());
		assertTrue(board.getTable()[2][0].isOpen());
		assertTrue(board.getTable()[2][1].isOpen());
		assertTrue(board.getTable()[2][2].isOpen());
		
		Game game2 = new Game(4,3,75);
		Board board2 = new Board(4,3);		
		game2.openBoard(board2);
		assertTrue(board2.getTable()[0][0].isOpen());
		assertTrue(board2.getTable()[0][1].isOpen());
		assertTrue(board2.getTable()[0][2].isOpen());
		assertTrue(board2.getTable()[1][0].isOpen());
		assertTrue(board2.getTable()[1][1].isOpen());
		assertTrue(board2.getTable()[1][2].isOpen());
		assertTrue(board2.getTable()[2][0].isOpen());
		assertTrue(board2.getTable()[2][1].isOpen());
		assertTrue(board2.getTable()[2][2].isOpen());
		assertTrue(board2.getTable()[3][0].isOpen());
		assertTrue(board2.getTable()[3][1].isOpen());
		assertTrue(board2.getTable()[3][2].isOpen());
		
		Game game3 = new Game(10,3,75);
		Board board3 = new Board(10,3);		
		game3.openBoard(board3);
		assertTrue(board3.getTable()[0][0].isOpen());
		assertTrue(board3.getTable()[0][1].isOpen());
		assertTrue(board3.getTable()[0][2].isOpen());
		assertTrue(board3.getTable()[1][0].isOpen());
		assertTrue(board3.getTable()[1][1].isOpen());
		assertTrue(board3.getTable()[1][2].isOpen());
		assertTrue(board3.getTable()[2][0].isOpen());
		assertTrue(board3.getTable()[2][1].isOpen());
		assertTrue(board3.getTable()[2][2].isOpen());
		assertTrue(board3.getTable()[3][0].isOpen());
		assertTrue(board3.getTable()[3][1].isOpen());
		assertTrue(board3.getTable()[3][2].isOpen());
		assertTrue(board3.getTable()[4][0].isOpen());
		assertTrue(board3.getTable()[4][1].isOpen());
		assertTrue(board3.getTable()[4][2].isOpen());
		assertTrue(board3.getTable()[5][0].isOpen());
		assertTrue(board3.getTable()[5][1].isOpen());
		assertTrue(board3.getTable()[5][2].isOpen());
		assertTrue(board3.getTable()[6][0].isOpen());
		assertTrue(board3.getTable()[6][1].isOpen());
		assertTrue(board3.getTable()[6][2].isOpen());
		assertTrue(board3.getTable()[7][0].isOpen());
		assertTrue(board3.getTable()[7][1].isOpen());
		assertTrue(board3.getTable()[7][2].isOpen());
		assertTrue(board3.getTable()[8][0].isOpen());
		assertTrue(board3.getTable()[8][1].isOpen());
		assertTrue(board3.getTable()[8][2].isOpen());
		assertTrue(board3.getTable()[9][0].isOpen());
		assertTrue(board3.getTable()[9][1].isOpen());
		assertTrue(board3.getTable()[9][2].isOpen());
		
	}
	
	/**
	 * Checks if the difficulty entered is valid
	 * @return Returns true if the difficulty is valid
	 */	
	@Test
	public void testChangeGameDifficulty() {
		
		// EASY
		int difficulty1 = 1;
		
		Game game1 = new Game(4,4,10);
		Game game2 = new Game();
		game2.changeGameDifficulty(difficulty1);		
		assertTrue(game1.Equals(game2));
		
		Game game3 = new Game(3,3,10);
		Game game4 = new Game();
		game4.changeGameDifficulty(difficulty1);
		assertFalse(game3.Equals(game4));
		
		// NORMAL
		int difficulty2 = 2;
		
		Game game5 = new Game(5,5,15);
		Game game6 = new Game();
		game6.changeGameDifficulty(difficulty2);
		assertTrue(game5.Equals(game6));
		
		Game game7 = new Game(3,3,10);
		Game game8 = new Game();
		game8.changeGameDifficulty(difficulty2);
		assertFalse(game7.Equals(game8));
		
		// HARD
		int difficulty3 = 3;
		
		Game game9 = new Game(7,7,25);
		Game game10 = new Game();
		game10.changeGameDifficulty(difficulty3);
		assertTrue(game9.Equals(game10));
		
		Game game11 = new Game(10,3,10);
		Game game12 = new Game();
		game12.changeGameDifficulty(difficulty3);
		assertFalse(game11.Equals(game12));
		
		// EXTREME
		int difficulty4 = 4;
		
		Game game13 = new Game(8,8,50);
		Game game14 = new Game();
		game14.changeGameDifficulty(difficulty4);
		assertTrue(game13.Equals(game14));
		
		Game game15 = new Game(3,3,10);
		Game game16 = new Game();
		game16.changeGameDifficulty(difficulty4);
		assertFalse(game15.Equals(game16));
		
		// Default
		int difficulty5 = 5;
	
		Game game18 = new Game();
		game18.changeGameDifficulty(difficulty5);

		Game game20 = new Game();
		game20.changeGameDifficulty(difficulty5);
	
	}

	/**
	 * Checks if the board Dimensions entered are valid
	 * @return Returns true if the dimensions are valid
	 */	
	@Test
	public void testValidMineDensity() {
		
		//Initialize a game with valid Settings
		Game game = new Game(5,5,15);
		
		//Test modifying Bomb Density, Game Rules set to allow the range of 10-75 (%) as values	
		//Equivalent Partition -inf to 10 -> Invalid input
		boolean res_0 = game.validMineDensity(-29);
		assertFalse(res_0);
		
		boolean res_1 = game.validMineDensity(-1);
		assertFalse(res_1);
		
		boolean res_2 = game.validMineDensity(0);
		assertFalse(res_2);
		
		boolean res_3 = game.validMineDensity(4);
		assertFalse(res_3);
		
		boolean res_4 = game.validMineDensity(9);
		assertFalse(res_4);
		
		//Equivalent Partition 10 to 75 -> valid input
		boolean res_5 = game.validMineDensity(11);
		assertTrue(res_5);
		
		boolean res_6 = game.validMineDensity(25);
		assertTrue(res_6);
		
		boolean res_7 = game.validMineDensity(48);
		assertTrue(res_7);
		
		boolean res_8 = game.validMineDensity(74);
		assertTrue(res_8);
		
		boolean res_9 = game.validMineDensity(75);
		assertTrue(res_9);
		
		//Equivalent Partition 75 to inf -> Invalid input
		boolean res_10 = game.validMineDensity(76);
		assertFalse(res_10);
		
		boolean res_11 = game.validMineDensity(125);
		assertFalse(res_11);			
	
	}

	/**
	 * Checks if the difficulty entered is valid
	 * @return Returns true if the difficulty is valid
	 */	
	@Test
	public void testValidDifficulty() {
		
		//Initialize a game with valid Settings
		Game game = new Game(5,5,15);
		
		//Test modifying Bomb Density, Game Rules set to allow the range of 10-75 (%) as values	
		//Equivalent Partition -inf to 0 -> Invalid input
		boolean res_0 = game.validDifficulty(-29);
		assertFalse(res_0);
		
		boolean res_1 = game.validDifficulty(-1);
		assertFalse(res_1);
		
		boolean res_2 = game.validDifficulty(0);
		assertFalse(res_2);
		
		//Equivalent Partition 1 to 4 -> valid input
		boolean res_3 = game.validDifficulty(1);
		assertTrue(res_3);
		
		boolean res_4 = game.validDifficulty(2);
		assertTrue(res_4);
		
		boolean res_5 = game.validDifficulty(3);
		assertTrue(res_5);
		
		boolean res_6 = game.validDifficulty(4);
		assertTrue(res_6);
		
		//Equivalent Partition 5 to inf -> Invalid input
		boolean res_7 = game.validDifficulty(5);
		assertFalse(res_7);
		
		boolean res_8 = game.validDifficulty(15);
		assertFalse(res_8);			
	
	}

	/**
	 * Checks if the board Dimensions entered are valid
	 * @return Returns true if the dimensions are valid
	 */	
	@Test
	public void testValidCorX() {
		
		//Initialize a game with Dimensions 5x5 (X goes from 0 to 4)
		Game game = new Game(5,5,15);
		
		//Test checking if selected Square X Coordinate is valid
		//Equivalent Partition -inf to -1 -> Invalid input
		boolean res_0 = game.validCorX(-29);
		assertFalse(res_0);
		
		boolean res_1 = game.validCorX(-1);
		assertFalse(res_1);		
		
		//Equivalent Partition 0 to 4 -> valid input
		boolean res_2 = game.validCorX(0);
		assertTrue(res_2);
		
		boolean res_3 = game.validCorX(1);
		assertTrue(res_3);
		
		boolean res_4 = game.validCorX(2);
		assertTrue(res_4);
		
		boolean res_5 = game.validCorX(3);
		assertTrue(res_5);
		
		boolean res_6 = game.validCorX(4);
		assertTrue(res_6);
		
		//Equivalent Partition 4 to inf -> Invalid input		
		boolean res_7 = game.validCorX(5);
		assertFalse(res_7);
		
		boolean res_8 = game.validCorX(19);
		assertFalse(res_8);
		
		
		
		//Initialize a game with Dimensions 10x10 (X goes from 0 to 9)
		Game game2 = new Game(10,10,15);
		
		//Test checking if selected Square X Coordinate is valid
		//Equivalent Partition -inf to -1 -> Invalid input
		boolean res_10 = game2.validCorX(-29);
		assertFalse(res_10);
		
		boolean res_11 = game2.validCorX(-1);
		assertFalse(res_11);		
		
		//Equivalent Partition 0 to 9 -> valid input
		boolean res_12 = game2.validCorX(0);
		assertTrue(res_12);
		
		boolean res_13 = game2.validCorX(1);
		assertTrue(res_13);
		
		boolean res_14 = game2.validCorX(6);
		assertTrue(res_14);
		
		boolean res_15 = game2.validCorX(8);
		assertTrue(res_15);
		
		boolean res_16 = game2.validCorX(9);
		assertTrue(res_16);
		
		//Equivalent Partition 10 to inf -> Invalid input		
		boolean res_17 = game2.validCorX(10);
		assertFalse(res_17);
		
		boolean res_18 = game2.validCorX(39);
		assertFalse(res_18);
		
		
		//Initialize a game with Dimensions 3x3 (X goes from 0 to 2)
		Game game3 = new Game(3,3,15);
		
		//Test checking if selected Square X Coordinate is valid
		//Equivalent Partition -inf to -1 -> Invalid input
		boolean res_20 = game3.validCorX(-29);
		assertFalse(res_20);
		
		boolean res_21 = game3.validCorX(-1);
		assertFalse(res_21);		
		
		//Equivalent Partition 0 to 2 -> valid input
		boolean res_22 = game3.validCorX(0);
		assertTrue(res_22);
		
		boolean res_23 = game3.validCorX(1);
		assertTrue(res_23);
		
		boolean res_24 = game3.validCorX(2);
		assertTrue(res_24);
		
		//Equivalent Partition 3 to inf -> Invalid input		
		boolean res_27 = game3.validCorX(3);
		assertFalse(res_27);
		
		boolean res_28 = game3.validCorX(32);
		assertFalse(res_28);
	
	}

	/**
	 * Checks if the board Dimensions entered are valid
	 * @return Returns true if the dimensions are valid
	 */	
	@Test
	public void testValidCorY() {
		
		//Initialize a game with Dimensions 5x5 (Y goes from 0 to 4)
		Game game = new Game(5,5,15);
		
		//Test checking if selected Square Y Coordinate is valid
		//Equivalent Partition -inf to -1 -> Invalid input
		boolean res_0 = game.validCorY(-29);
		assertFalse(res_0);
		
		boolean res_1 = game.validCorY(-1);
		assertFalse(res_1);		
		
		//Equivalent Partition 0 to 4 -> valid input
		boolean res_2 = game.validCorY(0);
		assertTrue(res_2);
		
		boolean res_3 = game.validCorY(1);
		assertTrue(res_3);
		
		boolean res_4 = game.validCorY(2);
		assertTrue(res_4);
		
		boolean res_5 = game.validCorY(3);
		assertTrue(res_5);
		
		boolean res_6 = game.validCorY(4);
		assertTrue(res_6);
		
		//Equivalent Partition 4 to inf -> Invalid input		
		boolean res_7 = game.validCorY(5);
		assertFalse(res_7);
		
		boolean res_8 = game.validCorY(19);
		assertFalse(res_8);
		
		
		
		//Initialize a game with Dimensions 10x10 (Y goes from 0 to 9)
		Game game2 = new Game(10,10,15);
		
		//Test checking if selected Square Y Coordinate is valid
		//Equivalent Partition -inf to -1 -> Invalid input
		boolean res_10 = game2.validCorY(-29);
		assertFalse(res_10);
		
		boolean res_11 = game2.validCorY(-1);
		assertFalse(res_11);		
		
		//Equivalent Partition 0 to 9 -> valid input
		boolean res_12 = game2.validCorY(0);
		assertTrue(res_12);
		
		boolean res_13 = game2.validCorY(1);
		assertTrue(res_13);
		
		boolean res_14 = game2.validCorY(6);
		assertTrue(res_14);
		
		boolean res_15 = game2.validCorY(8);
		assertTrue(res_15);
		
		boolean res_16 = game2.validCorY(9);
		assertTrue(res_16);
		
		//Equivalent Partition 10 to inf -> Invalid input		
		boolean res_17 = game2.validCorY(10);
		assertFalse(res_17);
		
		boolean res_18 = game2.validCorY(39);
		assertFalse(res_18);
		
		
		//Initialize a game with Dimensions 3x3 (Y goes from 0 to 2)
		Game game3 = new Game(3,3,15);
		
		//Test checking if selected Square Y Coordinate is valid
		//Equivalent Partition -inf to -1 -> Invalid input
		boolean res_20 = game3.validCorY(-29);
		assertFalse(res_20);
		
		boolean res_21 = game3.validCorY(-1);
		assertFalse(res_21);		
		
		//Equivalent Partition 0 to 2 -> valid input
		boolean res_22 = game3.validCorY(0);
		assertTrue(res_22);
		
		boolean res_23 = game3.validCorY(1);
		assertTrue(res_23);
		
		boolean res_24 = game3.validCorY(2);
		assertTrue(res_24);
		
		//Equivalent Partition 3 to inf -> Invalid input		
		boolean res_27 = game3.validCorY(3);
		assertFalse(res_27);
		
		boolean res_28 = game3.validCorY(32);
		assertFalse(res_28);
	
	}

	/**
	 * Checks if the board Dimensions entered are valid
	 * @return Returns true if the dimensions are valid
	 */	
	@Test
	public void testValidOption() {
		
		//Initialize a game 
		Game game = new Game(2,5,25);
		
		//Test checking if selected Square Y Coordinate is valid
		//Equivalent Partition -inf to 0 -> Invalid input
		boolean res_0 = game.validOption(-29);
		assertFalse(res_0);
		
		boolean res_1 = game.validOption(-1);
		assertFalse(res_1);		
		
		boolean res_2 = game.validOption(0);
		assertFalse(res_2);
		
		//Equivalent Partition 1 to 2 -> valid input
		boolean res_3 = game.validOption(1);
		assertTrue(res_3);		
		
		boolean res_4 = game.validOption(2);
		assertTrue(res_4);
		
		//Equivalent Partition 3 to inf -> Invalid input		
		boolean res_7 = game.validOption(3);
		assertFalse(res_7);
		
		boolean res_8 = game.validOption(22);
		assertFalse(res_8);
		
	}

	/**
	 * Checks if the board Dimensions entered are valid
	 * @return Returns true if the dimensions are valid
	 */	
	@Test
	public void testValidBoardDimensions() {
		
		//Initialize a game with valid Settings
		Game game = new Game(5,5,15);
		
		//Test modifying Board Dimensions, Game Rules set to allow the range 3-10 as values	for each dimension
		//Equivalent Partition -inf to 2 -> Invalid input
		boolean res_0 = game.validBoardDimension(-29);
		assertFalse(res_0);
		
		boolean res_1 = game.validBoardDimension(-1);
		assertFalse(res_1);
		
		boolean res_2 = game.validBoardDimension(0);
		assertFalse(res_2);
		
		boolean res_3 = game.validBoardDimension(1);
		assertFalse(res_3);
		
		boolean res_4 = game.validBoardDimension(2);
		assertFalse(res_4);
		
		//Equivalent Partition 3 to 10 -> valid input
		boolean res_5 = game.validBoardDimension(4);
		assertTrue(res_5);
		
		boolean res_6 = game.validBoardDimension(5);
		assertTrue(res_6);
		
		boolean res_7 = game.validBoardDimension(8);
		assertTrue(res_7);
		
		boolean res_8 = game.validBoardDimension(9);
		assertTrue(res_8);
		
		boolean res_9 = game.validBoardDimension(10);
		assertTrue(res_9);
		
		//Equivalent Partition 10 to inf -> Invalid input
		boolean res_10 = game.validBoardDimension(11);
		assertFalse(res_10);
		
		boolean res_11 = game.validBoardDimension(25);
		assertFalse(res_11);			

	}
	
	

	
	
	
	}


