import static org.junit.Assert.*;



import org.junit.Test;

public class MenuTest {

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
		
		//Equivalent Partition 1 to 5 -> Valid input
		boolean res_3 = menu.checkInput(1);
		assertTrue(res_3);
		
		boolean res_4 = menu.checkInput(2);
		assertTrue(res_4);
		
		boolean res_5 = menu.checkInput(4);
		assertTrue(res_5);
		
		boolean res_6 = menu.checkInput(5);
		assertTrue(res_6);
		
		//Equivalent Partition 6 to inf -> Invalid input
		boolean res_7 = menu.checkInput(6);
		assertFalse(res_7);
		
		boolean res_8 = menu.checkInput(25);
		assertFalse(res_8);	
		
		
		
	}
		

}
