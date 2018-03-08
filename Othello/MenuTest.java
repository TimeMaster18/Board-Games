import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MenuTest {

	
public class MockMenu extends Menu{
		
		List<Integer> askIntReturn = new ArrayList<Integer>();
		public int index= 0;
		public int partidas=0;
		
		
		public int askInt() {			
			int intReturn = askIntReturn.get(index);	
			askIntReturn.remove(index);
			return intReturn;
		}
		
		public void startGame(){
			partidas++;
		}
	}
	
	/**
	 * Checks if the input entered is valid
	 * @return Returns true if the value is valid
	 */	
	@Test
	public void testCheckInput() {
		
		//Initialize a menu
		Menu menu = new Menu();
		
		//Equivalent Partition -inf to 0 -> Invalid input
		boolean res_0 = menu.checkInput(-23);
		assertFalse(res_0);
		
		boolean res_1 = menu.checkInput(-1);
		assertFalse(res_1);
		
		boolean res_2 = menu.checkInput(0);
		assertFalse(res_2);
		
		//Equivalent Partition 1 to 2 -> Valid input
		boolean res_3 = menu.checkInput(1);
		assertTrue(res_3);
		
		boolean res_4 = menu.checkInput(2);
		assertTrue(res_4);
		
		//Equivalent Partition 3 to inf -> Invalid input
		boolean res_7 = menu.checkInput(3);
		assertFalse(res_7);
		
		boolean res_8 = menu.checkInput(25);
		assertFalse(res_8);	
		
		
		
	}
	
	@Test
	public void testStart() {
		MockMenu test1=new MockMenu();
		
		//Path Coverege
		//El valor es correcto a la primera y es un uno
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,1);
		//El valor es correcto a la primera y es un dos
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,1);
		//El valor no es correcto a la primera y es un uno
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,2);
		//El valor no es correcto a la primera y es un dos
		test1.askIntReturn.add(6);
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,2);
		
		//LoopTest
		//while(!this.checkInput(op));
		//0 times
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,2);
		//1 times
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,2);
		//2 times
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,2);
		//3 times
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,2);
		//7 times
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(4);
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,2);

		//while(!(op==2));
		//0 times
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,2);
		//1 times
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,3);
		//2 times
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,5);
		//3 times
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,8);
		//7 times
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(1);
		test1.askIntReturn.add(2);
		test1.start();
		assertEquals(test1.partidas,15);
		
	}
	
	
	/**
	  * Gets integer input from the user
	  * @return int input from the user
	  */
	 @Test
	 public void testAskInt() {
		 
		 // Exploratory Testing
		 
		 Menu test = new Menu();
		 
		 
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
		
		 Menu test2 = new Menu();
		 
		 
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
