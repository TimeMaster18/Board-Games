import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SquareTest {

	@Test
	public void testSquare() {
		
		//Black Box
		
		//True		
		//Initialize Square
		Square test=new Square(true);
		assertFalse(test.getColor());
		assertFalse(test.getTab());
		assertTrue(test.getInTablero());
		
		//False
		//Initialize Square
		Square test2=new Square(false);
		assertFalse(test2.getColor());
		assertFalse(test2.getTab());
		assertFalse(test2.getInTablero());
	}
	
	@Test
	public void testSetTab() {
		
		//Black Box
		
		//Initialize Square
		Square test=new Square(true);
		
		//True
		test.setTab(true);
		assertTrue(test.getTab());
		
		//False
		test.setTab(false);
		assertFalse(test.getTab());
	}
	
	@Test
	public void testSetColor() {
		
		//Black Box
		//Initialize Square
		Square test=new Square(true);
			
		//True
		test.setColor(true);
		assertTrue(test.getColor());
			
		//False
		test.setColor(false);
		assertFalse(test.getColor());
	}
	
	@Test
	public void testSetInTablero(){
		
		//Black Box
		//Initialize Square
		Square test = new Square(true);
		
		//True
		test.setInTablero(true);
		assertTrue(test.getInTablero());
		
		//False
		test.setInTablero(false);
		assertFalse(test.getInTablero());
	}
	
	
	@Test
	public void testGetTab() {
		
		//Black Box
		//Initialize Square
		Square test=new Square(true);
		
		assertFalse(test.getTab());
		test.setTab(true);
		assertTrue(test.getTab());
	}
	
	@Test
	public void testGetColor() {
		
		//Black Box
		//Initialize Square
		Square test=new Square(true);
		
		assertFalse(test.getColor());
		test.setColor(true);
		assertTrue(test.getColor());
	}

}
