import static org.junit.Assert.*;



import org.junit.Test;

public class MenuTest {

	@Test
	public void testCheckInput() {
		
		Menu menu = new Menu();
		
		boolean res_0 = menu.checkInput(-23);
		assertFalse(res_0);
		
		boolean res_1 = menu.checkInput(-1);
		assertFalse(res_1);
		
		boolean res_2 = menu.checkInput(0);
		assertFalse(res_2);
		
		boolean res_3 = menu.checkInput(1);
		assertTrue(res_3);
		
		boolean res_4 = menu.checkInput(3);
		assertTrue(res_4);
		
		boolean res_5 = menu.checkInput(6);
		assertTrue(res_5);
		
		boolean res_6 = menu.checkInput(7);
		assertFalse(res_6);
		
		boolean res_7 = menu.checkInput(25);
		assertFalse(res_7);	
		
		
		
	}
		

}
