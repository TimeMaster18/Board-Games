import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;



public class GameTest {

public class MockGame extends Game{
		
		List<Integer> askIntReturn = new ArrayList<Integer>();
		public int index= 0;
		public int posX;
		public int posY;		
		
		public int askInt() {			
			int intReturn = askIntReturn.get(index);	
			askIntReturn.remove(index);
			return intReturn;
		}
	}
public class MockGame2 extends Game{
	Random rn = new Random();
	
	public int askInt() {	
	return rn.nextInt() % 8;
	}
	
	public void restart(){
		turnojugador=false;
		table =new Board();
		turnos=0;
		fichas=4;
		gameOver=false;
	}
}


	@Test
	public void testGame() {
		//Initialize Game
		Game test=new Game();

		//Check that the Board initial conditions are met
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if((i==3 && j==3) || (i==4 && j==4)){
					assertTrue(test.getBoard().getSquare(i, j).getColor());
					assertTrue(test.getBoard().getSquare(i, j).getTab());
				}else if((i==3 && j==4) || (i==4 && j==3)){
					assertFalse(test.getBoard().getSquare(i, j).getColor());
					assertTrue(test.getBoard().getSquare(i, j).getTab());
				}else{
				assertFalse(test.getBoard().getSquare(i, j).getColor());
				assertFalse(test.getBoard().getSquare(i, j).getTab());
			}
		}
		}
		assertEquals(test.turnos,0);
		assertFalse(test.turnojugador);
	}
	


	@Test
	public void testStart() {
		
		//AUTOMATIZATION TEST
		
		//PLAY 100 RANDOM GAMES
		MockGame2 testAuto=new MockGame2();
		for(int i=0;i<100;i++){
			testAuto.start();
			testAuto.restart();
		}
		
		//PLAY RANDOM GAMES until DRAW
		MockGame2 testAuto2=new MockGame2();
	    do{
		     testAuto2.restart();
		     testAuto2.start();
	    }while(!(testAuto2.blancas==testAuto2.win));
	    
	    //PLAY RANDOM GAMES until BLACK WINS
		MockGame2 testAuto3=new MockGame2();
	    do{
	    	testAuto3.restart();
	    	testAuto3.start();
	    }while(!(testAuto3.blancas<testAuto3.win));
	    
	    
	    //PLAY RANDOM GAMES until WHITE WINS
		MockGame2 testAuto4=new MockGame2();
	    do{
	    	testAuto4.restart();
	    	testAuto4.start();
	    }while(!(testAuto4.blancas>testAuto4.win));
	    
	    
	    
	    // Scenarios Testing
		
		//Case where game ends because no player can move anymore
		MockGame mockGame1=new MockGame();
		mockGame1.getBoard().changeSquare(3, 4);
		mockGame1.getBoard().changeSquare(4, 3);
		mockGame1.start();
		assertTrue(mockGame1.gameOver);
		assertEquals(mockGame1.fichas,4);
		assertEquals(mockGame1.turnos,0);
		assertEquals(mockGame1.blancas,0);
		assertEquals(mockGame1.win,4);
		
		//Case where game ends and Black Tabs player wins
		MockGame mockGame2=new MockGame();
		mockGame2.askIntReturn.add(2);
		mockGame2.askIntReturn.add(4);
		mockGame2.askIntReturn.add(4);
		mockGame2.askIntReturn.add(5);
		mockGame2.askIntReturn.add(5);
		mockGame2.askIntReturn.add(4);
		mockGame2.turnos=57;
		mockGame2.start();
		assertTrue(mockGame2.gameOver);
		assertEquals(mockGame2.fichas,7);
		assertEquals(mockGame2.turnos,60);
		assertEquals(mockGame2.blancas,2);
		assertEquals(mockGame2.win,5);
		
		//Case where game ends and White Tabs player wins
		MockGame mockGame3=new MockGame();		
		mockGame3.askIntReturn.add(4);
		mockGame3.askIntReturn.add(2);		
		mockGame3.askIntReturn.add(5);
		mockGame3.askIntReturn.add(4);	
		mockGame3.askIntReturn.add(4);
		mockGame3.askIntReturn.add(5);
		mockGame3.askIntReturn.add(3);
		mockGame3.askIntReturn.add(2);
		mockGame3.turnos=56;
		mockGame3.start();
		assertTrue(mockGame3.gameOver);
		assertEquals(mockGame3.fichas,8);
		assertEquals(mockGame3.turnos,60);
		assertEquals(mockGame3.blancas,5);
		assertEquals(mockGame3.win,3);
		
		//Case where only White player can move (turn skip)
		MockGame mockGame4=new MockGame();
		mockGame4.getBoard().getSquare(3, 2).setColor(true);
		mockGame4.getBoard().getSquare(3, 2).setTab(true);
		mockGame4.getBoard().getSquare(4, 2).setColor(true);
		mockGame4.getBoard().getSquare(4, 2).setTab(true);
		mockGame4.getBoard().getSquare(5, 2).setColor(true);
		mockGame4.getBoard().getSquare(5, 2).setTab(true);
		mockGame4.getBoard().getSquare(5, 3).setColor(true);
		mockGame4.getBoard().getSquare(5, 3).setTab(true);
		mockGame4.getBoard().getSquare(5, 4).setColor(true);
		mockGame4.getBoard().getSquare(5, 4).setTab(true);
		mockGame4.getBoard().changeSquare(3, 4);
		mockGame4.askIntReturn.add(5);
		mockGame4.askIntReturn.add(4);
		mockGame4.turnos=59;
		mockGame4.start();
		assertTrue(mockGame4.gameOver);
		assertEquals(mockGame4.fichas,5);
		assertEquals(mockGame4.turnos,60);
		assertEquals(mockGame4.blancas,-2);
		assertEquals(mockGame4.win,7);
		
		//Case where only Black player can move (turn skip)
		MockGame mockGame6=new MockGame();
		mockGame6.getBoard().getSquare(5, 3).setColor(false);
		mockGame6.getBoard().getSquare(5, 3).setTab(true);
		mockGame6.getBoard().getSquare(5, 4).setColor(false);
		mockGame6.getBoard().getSquare(5, 4).setTab(true);
		mockGame6.getBoard().getSquare(3, 5).setColor(false);
		mockGame6.getBoard().getSquare(3, 5).setTab(true);
		mockGame6.getBoard().getSquare(4, 5).setColor(false);
		mockGame6.getBoard().getSquare(4, 5).setTab(true);
		mockGame6.getBoard().getSquare(5, 5).setColor(false);
		mockGame6.getBoard().getSquare(5, 5).setTab(true);
		mockGame6.getBoard().changeSquare(3, 3);
		mockGame6.askIntReturn.add(4);
		mockGame6.askIntReturn.add(2);
		mockGame6.turnos=59;
		mockGame6.start();
		assertTrue(mockGame6.gameOver);
		assertEquals(mockGame6.fichas,5);
		assertEquals(mockGame6.turnos,60);
		assertEquals(mockGame6.blancas,2);
		assertEquals(mockGame6.win,3);
		
		//Case where game ends with a draw
		MockGame mockGame5=new MockGame();
		mockGame5.askIntReturn.add(2);
		mockGame5.askIntReturn.add(4);
		mockGame5.askIntReturn.add(4);
		mockGame5.askIntReturn.add(5);
		mockGame5.turnos=58;
		mockGame5.start();
		assertTrue(mockGame5.gameOver);
		assertEquals(mockGame5.fichas,6);
		assertEquals(mockGame5.turnos,60);
		assertEquals(mockGame5.blancas,3);
		assertEquals(mockGame5.win,3);	
		
		
		// Loop Testing
		
		//Number of turns, test with initial Board setup
		//1 Turns
		MockGame mockGame7=new MockGame();
		mockGame7.askIntReturn.add(2);
		mockGame7.askIntReturn.add(4);
		mockGame7.turnos=59;
		mockGame7.start();
		assertTrue(mockGame7.gameOver);
		assertEquals(mockGame7.fichas,5);
		assertEquals(mockGame7.turnos,60);
		assertEquals(mockGame7.blancas,1);
		assertEquals(mockGame7.win,4);	
		
		//2 Turns
		MockGame mockGame8=new MockGame();
		mockGame8.askIntReturn.add(2);
		mockGame8.askIntReturn.add(4);
		mockGame8.askIntReturn.add(4);
		mockGame8.askIntReturn.add(5);
		mockGame8.turnos=58;
		mockGame8.start();
		assertTrue(mockGame8.gameOver);
		assertEquals(mockGame8.fichas,6);
		assertEquals(mockGame8.turnos,60);
		assertEquals(mockGame8.blancas,3);
		assertEquals(mockGame8.win,3);	
		
		//3 Turns
		MockGame mockGame9=new MockGame();
		mockGame9.askIntReturn.add(2);
		mockGame9.askIntReturn.add(4);
		mockGame9.askIntReturn.add(4);
		mockGame9.askIntReturn.add(5);
		mockGame9.askIntReturn.add(5);
		mockGame9.askIntReturn.add(4);
		mockGame9.turnos=57;
		mockGame9.start();
		assertTrue(mockGame9.gameOver);
		assertEquals(mockGame9.fichas,7);
		assertEquals(mockGame9.turnos,60);
		assertEquals(mockGame9.blancas,2);
		assertEquals(mockGame9.win,5);
		
		//4 Turns
		MockGame mockGame0=new MockGame();
		mockGame0.askIntReturn.add(2);
		mockGame0.askIntReturn.add(4);
		mockGame0.askIntReturn.add(4);
		mockGame0.askIntReturn.add(5);
		mockGame0.askIntReturn.add(5);
		mockGame0.askIntReturn.add(4);
		mockGame0.askIntReturn.add(2);
		mockGame0.askIntReturn.add(3);
		mockGame0.turnos=56;
		mockGame0.start();
		assertTrue(mockGame0.gameOver);
		assertEquals(mockGame0.fichas,8);
		assertEquals(mockGame0.turnos,60);
		assertEquals(mockGame0.blancas,5);
		assertEquals(mockGame0.win,3);
		

		
	}
	
	@Test
	public void testTurn() {
		
		//Initialize Set up Game
		MockGame mockGame=new MockGame();
		
		//Loop Testing
		
		//Ending turn by Black Tabs (out of movements)
		mockGame.askIntReturn.add(4);
		mockGame.askIntReturn.add(2);
		assertFalse(mockGame.turn(true));
		
		//Ending turn by White Tabs (out of movements)
		mockGame.askIntReturn.add(5);
		mockGame.askIntReturn.add(4);
		assertFalse(mockGame.turn(false));
		
		//Ending turn by Black Tabs Repeating 1 time the Insertion Loop
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(4);
		mockGame.askIntReturn.add(5);
		assertFalse(mockGame.turn(true));
		
		//Ending turn by White Tabs Repeating 2 times the Insertion Loop
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(3);
		mockGame.askIntReturn.add(2);
		assertFalse(mockGame.turn(false));
		
		//Ending turn by Black Tabs Repeating 3 times the Insertion Loop
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(0);
		mockGame.askIntReturn.add(2);
		mockGame.askIntReturn.add(4);
		assertFalse(mockGame.turn(true));
		
		//Ending turn by White Tabs (out of turns)
		mockGame.turnos=59;
		mockGame.askIntReturn.add(4);
		mockGame.askIntReturn.add(1);
		assertTrue(mockGame.turn(false));
		
		//Ending turn by Black Tabs (out of turns)
		mockGame.turnos=59;
		mockGame.askIntReturn.add(3);
		mockGame.askIntReturn.add(1);
		assertTrue(mockGame.turn(true));
	}
	@Test
	public void testValidCoor() {
		
		//Initialize a game 
		Game game = new Game();
		
		//Test checking if selected Square Coordinate is valid
		//Equivalent Partition -inf to -1 -> Invalid input
		boolean res_0 = game.validCoor(-29);
		assertFalse(res_0);
		
		boolean res_1 = game.validCoor(-1);
		assertFalse(res_1);		
		
		//Equivalent Partition 0 to 7 -> valid input
		boolean res_2 = game.validCoor(0);
		assertTrue(res_2);
		
		boolean res_3 = game.validCoor(1);
		assertTrue(res_3);
		
		boolean res_4 = game.validCoor(2);
		assertTrue(res_4);
		
		boolean res_5 = game.validCoor(6);
		assertTrue(res_5);
		
		boolean res_6 = game.validCoor(7);
		assertTrue(res_6);
		
		//Equivalent Partition 8 to inf -> Invalid input		
		boolean res_7 = game.validCoor(8);
		assertFalse(res_7);
		
		boolean res_8 = game.validCoor(19);
		assertFalse(res_8);	
	}

	
	@Test
	public void testAskPlayer() {
		
		//Initialize Game
		MockGame mockGame=new MockGame();		
		
		//Test First loop: Valid Option
		int[] res1 = {2, 1};
		mockGame.askIntReturn.clear();
		mockGame.askIntReturn.add(1);
		mockGame.askIntReturn.add(2);
		assertArrayEquals(mockGame.askPlayer(), res1);
		
		//Test First loop: Invalid Option x1
		int[] res2 = {7, 2};
		mockGame.askIntReturn.clear();
		mockGame.askIntReturn.add(15);
		mockGame.askIntReturn.add(2);
		mockGame.askIntReturn.add(7);
		assertArrayEquals(mockGame.askPlayer(), res2);
		
		//Test First loop: Invalid Option x2
		int[] res3 = {1, 1};
		mockGame.askIntReturn.clear();
		mockGame.askIntReturn.add(-2);
		mockGame.askIntReturn.add(23);
		mockGame.askIntReturn.add(1); // Valid Option
		mockGame.askIntReturn.add(1); // Valid Option
		assertArrayEquals(mockGame.askPlayer(), res3);	
		
		//Test First loop: Invalid Option x5
		int[] res4 = {2, 1};
		mockGame.askIntReturn.clear();
		mockGame.askIntReturn.add(-28);
		mockGame.askIntReturn.add(10);
		mockGame.askIntReturn.add(25);
		mockGame.askIntReturn.add(100);
		mockGame.askIntReturn.add(-1);
		mockGame.askIntReturn.add(1); // Valid Option
		mockGame.askIntReturn.add(2); // Valid Option
		assertArrayEquals(mockGame.askPlayer(), res4);
		
		//Test First loop: Invalid Option x10
		int[] res5 = {2, 2};
		mockGame.askIntReturn.clear();
		mockGame.askIntReturn.add(-28);
		mockGame.askIntReturn.add(10);
		mockGame.askIntReturn.add(25);
		mockGame.askIntReturn.add(100);
		mockGame.askIntReturn.add(-1);
		mockGame.askIntReturn.add(-28);
		mockGame.askIntReturn.add(10);
		mockGame.askIntReturn.add(25);
		mockGame.askIntReturn.add(100);
		mockGame.askIntReturn.add(-1);
		mockGame.askIntReturn.add(2); // Valid Option
		mockGame.askIntReturn.add(2); // Valid Option
		assertArrayEquals(mockGame.askPlayer(), res5);
		
		
		
		
		//Test Second loop: Valid Option
		int[] res11 = {2, 1};
		mockGame.askIntReturn.clear();
		mockGame.askIntReturn.add(1);
		mockGame.askIntReturn.add(2);
		assertArrayEquals(mockGame.askPlayer(), res11);
		
		//Test Second loop: Invalid Option x1
		int[] res12 = {3, 2};
		mockGame.askIntReturn.clear();		
		mockGame.askIntReturn.add(2);
		mockGame.askIntReturn.add(15);
		mockGame.askIntReturn.add(3);
		assertArrayEquals(mockGame.askPlayer(), res12);
		
		//Test Second loop: Invalid Option x2
		int[] res13 = {1, 1};
		mockGame.askIntReturn.clear();
		mockGame.askIntReturn.add(1); // Valid Option
		mockGame.askIntReturn.add(-2);
		mockGame.askIntReturn.add(23);		
		mockGame.askIntReturn.add(1); // Valid Option
		assertArrayEquals(mockGame.askPlayer(), res13);	
		
		//Test Second loop: Invalid Option x5
		int[] res14 = {2, 1};
		mockGame.askIntReturn.clear();
		mockGame.askIntReturn.add(1); // Valid Option
		mockGame.askIntReturn.add(-28);
		mockGame.askIntReturn.add(10);
		mockGame.askIntReturn.add(25);
		mockGame.askIntReturn.add(100);
		mockGame.askIntReturn.add(-1);		
		mockGame.askIntReturn.add(2); // Valid Option
		assertArrayEquals(mockGame.askPlayer(), res14);
		
		//Test Second loop: Invalid Option x10
		int[] res15 = {2, 2};
		mockGame.askIntReturn.clear();
		mockGame.askIntReturn.add(2); // Valid Option
		mockGame.askIntReturn.add(-28);
		mockGame.askIntReturn.add(10);
		mockGame.askIntReturn.add(25);
		mockGame.askIntReturn.add(100);
		mockGame.askIntReturn.add(-1);
		mockGame.askIntReturn.add(-28);
		mockGame.askIntReturn.add(10);
		mockGame.askIntReturn.add(25);
		mockGame.askIntReturn.add(100);
		mockGame.askIntReturn.add(-1);		
		mockGame.askIntReturn.add(2); // Valid Option
		assertArrayEquals(mockGame.askPlayer(), res15);	
		
		//Exploratory testing
		
		
				
		
	}
	
	/**
	  * Gets integer input from the user
	  * @return int input from the user
	  */
	 @Test
	 public void testAskInt() {
		 
		 // Exploratory Testing
		 
		 Game test = new Game();
		 
		 
		 String simulatedUserInput =
				//Char
				 "T" + System.getProperty("line.separator")
				 
				 //Float
				 + "4.5" + System.getProperty("line.separator")
				 
				 //String
				 + "test\ntest" + System.getProperty("line.separator")
				 
				//Length input test
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST" + System.getProperty("line.separator")
				 
				//invalid characters
				 + "'\'" + System.getProperty("line.separator")				 
				 
					//invalid characters
				 + "%" + System.getProperty("line.separator")
				 
					//invalid characters
				 + "^@" + System.getProperty("line.separator")
				 
					//invalid characters
				 + "^Z" + System.getProperty("line.separator")
				 
					//invalid characters
				 + "&$|" + System.getProperty("line.separator")
				 
				 //invalid Int
				 + "2147483648" + System.getProperty("line.separator")				 
				 
				//valid Int, invalid option
				 + "8" + System.getProperty("line.separator")
				 
				 //valid Int, valid option
		    + "1" + System.getProperty("line.separator");

		InputStream savedStandardInputStream = System.in;
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

		test.askInt();
		
		System.setIn(savedStandardInputStream);		
		
		
		
		// Exploratory testing - Overflow
		
		Game test2 = new Game();
		 
		 
		 String simulatedUserInput2 =
				   "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST" //64 each line				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST" 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST" // 10*64
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST" // 25*64
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST" //50*64
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST" //100*64
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"				 
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST" //200*64
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"		
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@123456789123456789TESTTESTTEST"
				 + "test123456testTESTtest@@@@@@@@@@@@1" //203*64 + 34 = 13026 chars makes eclipse console to stop working
				 
				 + System.getProperty("line.separator")
				 
				 //invalid 
				    + "test" + System.getProperty("line.separator")
				 	
				 
				 //valid Int, valid option
		    + "1" + System.getProperty("line.separator");

		InputStream savedStandardInputStream2 = System.in;
		System.setIn(new ByteArrayInputStream(simulatedUserInput2.getBytes()));

		test2.askInt();
		
		System.setIn(savedStandardInputStream2);		
		
	 }
	
	
	
	
}
