import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	
	public class MockBoard1 extends Board{
		public int bX=0,bY=0;
		
		public MockBoard1(int x, int y) {
			super(x, y);
		}
		
		public int setRandomBomb(int numMines){
			numMines--;
			return numMines;
		}
	}
	
	public class MockBoard2 extends Board{
		public int bX=0,bY=0;
		
		public MockBoard2(int x, int y) {
			super(x, y);
		}
			
		public int[] random(int x,int y){
			int randCor[]={bX,bY};
			return randCor;
		}
	}
	
	@Test
	public void testMarkSquare() {
		Board board=new Board(5,5);
		
		//Mark an not open Square
		board.markSquare(2, 2);
		assertTrue(board.getTable()[2][2].isMarked());
		
		//Mark an open Square
		board.openSquare(3, 3);
		board.markSquare(3, 3);
		assertFalse(board.getTable()[3][3].isMarked());
	}
	
	@Test
	public void testDrawBoard() {
		
		Board board=new Board(5,5);
		
		board.setSquareMined(2, 2);
		board.setSquareMined(0, 0);
		
		//Print board only with mined Squares
		board.drawBoard();
		
		board.markSquare(1, 1);
		board.markSquare(4, 4);
		
		//Print board with mined and marked Squares
		board.drawBoard();
		
		board.openSquare(3, 3);
		board.openSquare(2, 2);
		board.openSquare(0, 4);
		
		//Print board with marked and open Squares and mines and open Squares
		board.drawBoard();

	}
	
	@Test
	public void testSetMines() {
		MockBoard1 mock1=new MockBoard1(5,5);
		
		//Not enter in the loop
		mock1.setMines(0);
		
		//Make 15 times the loop
		mock1.setMines(60);
		
		//Make all times possibles the loop
		mock1.setMines(100);
				
		MockBoard1 mock2=new MockBoard1(2,2);
		
		//Only make 1 time the loop
		mock2.setMines(25);
		
		//Make 2 times the loop
		mock2.setMines(50);

	}
	
	@Test
	public void testSetRandomMine() {
		MockBoard2 mock=new MockBoard2(5,5);
		mock.bX=0;
		mock.bY=0;
		
		//Mine not mined Square
		int res1=mock.setRandomBomb(9);
		assertEquals(res1,8);
		
		//Mine mined Square
		int res2=mock.setRandomBomb(8);
		assertEquals(res2,8);		
	}
	
	@Test
	public void testIsMined() {
		
		//Medium Board 
		//Square in the middle
		Board tab1=new Board(5,5);
		tab1.setSquareMined(3, 3);
		boolean res1_1=tab1.isMined(3, 3);
		boolean res1_2=tab1.isMined(2, 3);
		assertTrue(res1_1);
		assertFalse(res1_2);
		
		//Square in the top extreme
		tab1.setSquareMined(4, 4);
		boolean res2_1=tab1.isMined(4, 4);
		boolean res2_2=tab1.isMined(1, 1);
		assertTrue(res2_1);
		assertFalse(res2_2);
		
		//Square in the bottom extreme
		tab1.setSquareMined(0, 0);
		boolean res3_1=tab1.isMined(0, 0);
		boolean res3_2=tab1.isMined(2, 3);
		assertTrue(res3_1);
		assertFalse(res3_2);
		

		
		//Smallest Board
		//Square in the middle
		Board tab2=new Board(3,3);
		tab2.setSquareMined(1, 1);
		boolean res5_1=tab2.isMined(1, 1);
		boolean res5_2=tab2.isMined(2, 2);
		assertTrue(res5_1);
		assertFalse(res5_2);
		
		//Square in the top extreme
		tab2.setSquareMined(2, 2);
		boolean res6_1=tab2.isMined(2, 2);
		boolean res6_2=tab2.isMined(1, 2);
		assertTrue(res6_1);
		assertFalse(res6_2);
		
		//Square in the bottom extreme
		tab2.setSquareMined(0, 0);
		boolean res7_1=tab2.isMined(0, 0);
		boolean res7_2=tab2.isMined(2, 1);
		assertTrue(res7_1);
		assertFalse(res7_2);
		
		
		//Biggest Board
		//Square in the middle
		Board tab3=new Board(10,10);
		tab3.setSquareMined(5, 5);
		boolean res9_1=tab3.isMined(5, 5);
		boolean res9_2=tab3.isMined(2, 3);
		assertTrue(res9_1);
		assertFalse(res9_2);
		
		//Square in the top extreme
		tab3.setSquareMined(9, 9);
		boolean res10_1=tab3.isMined(9, 9);
		boolean res10_2=tab3.isMined(1, 1);
		assertTrue(res10_1);
		assertFalse(res10_2);
		
		//Square in the bottom extreme
		tab3.setSquareMined(0, 0);
		boolean res11_1=tab3.isMined(0, 0);
		boolean res11_2=tab3.isMined(4, 3);
		assertTrue(res11_1);
		assertFalse(res11_2);
		
	}
	
	@Test
	public void testSetSquareMined() {
		
		//Medium Board 
		Board tab1=new Board(5,5);	
		Board tab2=new Board(5,5);
		
		//Set and watch medium Square
		tab1.getTable()[3][2].setMined(true);
		tab2.setSquareMined(3, 2);
		assertEquals(tab1.getTable()[3][2].isMined(),tab2.getTable()[3][2].isMined());
		assertNotEquals(tab1.getTable()[3][2].isMined(),tab2.getTable()[4][2].isMined());
		
		//Set and watch extreme top Square
		tab1.getTable()[4][4].setMined(true);
		tab2.setSquareMined(4, 4);
		assertEquals(tab1.getTable()[4][4].isMined(),tab2.getTable()[4][4].isMined());
		assertNotEquals(tab1.getTable()[4][4].isMined(),tab2.getTable()[4][2].isMined());
		
		//Set and watch extreme bottom Square
		tab1.getTable()[0][0].setMined(true);
		tab2.setSquareMined(0, 0);
		assertEquals(tab1.getTable()[0][0].isMined(),tab2.getTable()[0][0].isMined());
		assertNotEquals(tab1.getTable()[0][0].isMined(),tab2.getTable()[4][2].isMined());
	
		//Biggest Board
		Board tab3=new Board(10,10);	
		Board tab4=new Board(10,10);
		
		//Set and watch medium Square
		tab3.getTable()[3][2].setMined(true);
		tab4.setSquareMined(3, 2);
		assertEquals(tab3.getTable()[3][2].isMined(),tab4.getTable()[3][2].isMined());
		assertNotEquals(tab3.getTable()[3][2].isMined(),tab4.getTable()[1][2].isMined());
		
		//Set and watch extreme top Square
		tab3.getTable()[9][9].setMined(true);
		tab4.setSquareMined(9, 9);
		assertEquals(tab3.getTable()[9][9].isMined(),tab4.getTable()[9][9].isMined());
		assertNotEquals(tab3.getTable()[9][9].isMined(),tab4.getTable()[4][2].isMined());
		
		//Set and watch extreme bottom Square
		tab3.getTable()[0][0].setMined(true);
		tab4.setSquareMined(0, 0);
		assertEquals(tab3.getTable()[0][0].isMined(),tab4.getTable()[0][0].isMined());
		assertNotEquals(tab3.getTable()[0][0].isMined(),tab4.getTable()[4][2].isMined());
	
		//Smallest Board
		Board tab5=new Board(3,3);	
		Board tab6=new Board(3,3);
		
		//Set and watch medium Square
		tab5.getTable()[2][1].setMined(true);
		tab6.setSquareMined(2, 1);
		assertEquals(tab5.getTable()[2][1].isMined(),tab6.getTable()[2][1].isMined());
		assertNotEquals(tab5.getTable()[2][1].isMined(),tab6.getTable()[2][2].isMined());
		
		//Set and watch extreme top Square
		tab5.getTable()[2][2].setMined(true);
		tab6.setSquareMined(2,2);
		assertEquals(tab5.getTable()[2][2].isMined(),tab6.getTable()[2][2].isMined());
		assertNotEquals(tab5.getTable()[2][2].isMined(),tab6.getTable()[2][0].isMined());
		
		//Set and watch extreme bottom Square
		tab5.getTable()[0][0].setMined(true);
		tab6.setSquareMined(0, 0);
		assertEquals(tab5.getTable()[0][0].isMined(),tab6.getTable()[0][0].isMined());
		assertNotEquals(tab5.getTable()[0][0].isMined(),tab6.getTable()[1][2].isMined());
	
	
			
	}
	
	@Test
	public void testOpenSquare() {
		
		//Medium Board 
		//Open Square without bombs
		Board tab10=new Board(5,5);	
		tab10.getTable()[4][4].setOpen(true);
		tab10.getTable()[0][0].setOpen(true);
		tab10.getTable()[0][4].setOpen(true);
		tab10.getTable()[4][0].setOpen(true);
		tab10.getTable()[4][2].setOpen(true);
		tab10.getTable()[2][4].setOpen(true);
		tab10.openSquare(0, 0);						//already open
		assertTrue(tab10.getTable()[4][4].isOpen());
		assertTrue(tab10.getTable()[0][0].isOpen());
		assertTrue(tab10.getTable()[0][4].isOpen());
		assertTrue(tab10.getTable()[4][0].isOpen());
		assertTrue(tab10.getTable()[4][2].isOpen());
		assertTrue(tab10.getTable()[2][4].isOpen());
		
		//Medium Board 
		//Open Square without bombs
		Board tab1=new Board(5,5);	
		tab1.openSquare(3, 3);
		assertTrue(tab1.getTable()[4][4].isOpen());
		assertTrue(tab1.getTable()[0][0].isOpen());
		assertTrue(tab1.getTable()[0][4].isOpen());
		assertTrue(tab1.getTable()[4][0].isOpen());
		assertTrue(tab1.getTable()[4][2].isOpen());
		assertTrue(tab1.getTable()[2][4].isOpen());
		
		//Open Square with bombs not adjacent 
		Board tab2=new Board(5,5);
		tab2.setSquareMined(2, 2);
		tab2.openSquare(0,0);
		assertTrue(tab2.getTable()[4][4].isOpen());
		assertTrue(tab2.getTable()[0][4].isOpen());
		assertTrue(tab2.getTable()[4][0].isOpen());
		assertFalse(tab2.getTable()[2][2].isOpen());
		
		//Open Square with bombs adjacent 
		Board tab3=new Board(5,5);
		tab3.setSquareMined(2,2);
		tab3.openSquare(2,1);
		assertFalse(tab3.getTable()[2][2].isOpen());
		assertFalse(tab3.getTable()[2][0].isOpen());
		assertFalse(tab3.getTable()[4][0].isOpen());
		assertFalse(tab3.getTable()[2][2].isOpen());
		
		//Smallest Board
		//Open Square without bombs
		Board tab4=new Board(3,3);	
		tab4.openSquare(2, 2);
		assertTrue(tab4.getTable()[2][2].isOpen());
		assertTrue(tab4.getTable()[0][0].isOpen());
		assertTrue(tab4.getTable()[0][2].isOpen());
		assertTrue(tab4.getTable()[2][0].isOpen());

		//Open Square with bombs not adjacent 
		Board tab5=new Board(3,3);
		tab5.setSquareMined(2, 2);
		tab5.openSquare(0,0);
		assertFalse(tab5.getTable()[2][2].isOpen());
		assertTrue(tab5.getTable()[0][2].isOpen());
		assertTrue(tab5.getTable()[2][0].isOpen());
		assertTrue(tab5.getTable()[2][0].isOpen());
		
		//Open Square with bombs adjacent 
		Board tab6=new Board(3,3);
		tab6.setSquareMined(2,2);
		tab6.openSquare(2,1);
		assertFalse(tab6.getTable()[2][2].isOpen());
		assertFalse(tab6.getTable()[0][2].isOpen());
		assertFalse(tab6.getTable()[2][0].isOpen());
		assertFalse(tab6.getTable()[2][2].isOpen());
		
		//Biggest Board 
		//Open Square without bombs
		Board tab7=new Board(10,10);	
		tab7.openSquare(3, 3);
		assertTrue(tab7.getTable()[9][9].isOpen());
		assertTrue(tab7.getTable()[0][0].isOpen());
		assertTrue(tab7.getTable()[0][9].isOpen());
		assertTrue(tab7.getTable()[9][0].isOpen());
		assertTrue(tab7.getTable()[9][2].isOpen());
		assertTrue(tab7.getTable()[2][9].isOpen());
		
		//Open Square with bombs not adjacent 
		Board tab8=new Board(10,10);
		tab8.setSquareMined(2, 2);
		tab8.openSquare(0,0);
		assertTrue(tab8.getTable()[9][9].isOpen());
		assertTrue(tab8.getTable()[0][9].isOpen());
		assertTrue(tab8.getTable()[9][0].isOpen());
		assertTrue(tab8.getTable()[9][9].isOpen());
		assertFalse(tab8.getTable()[2][2].isOpen());
		
		//Open Square with bombs adjacent 
		Board tab9=new Board(10,10);
		tab9.setSquareMined(2,2);
		tab9.openSquare(2,1);
		assertFalse(tab9.getTable()[2][2].isOpen());
		assertFalse(tab9.getTable()[2][0].isOpen());
		assertFalse(tab9.getTable()[9][0].isOpen());
		assertFalse(tab9.getTable()[2][2].isOpen());
		assertFalse(tab9.getTable()[0][0].isOpen());
		assertFalse(tab9.getTable()[9][9].isOpen());
		assertTrue(tab9.getTable()[2][1].isOpen());
		
		}
	
	@Test
	public void testCountAdjacentMines() {
		
		//Mine all the possible adjacent Squares possible
		//and compare after mine everyone
		
		//Medium Board 
		//Square in the middle
		Board tab1=new Board(5,5);
		int res1 =tab1.countAdjacentMines(2, 2);
		assertEquals(res1,0);
		tab1.setSquareMined(2, 3);
		res1 =tab1.countAdjacentMines(2, 2);
		assertEquals(res1,1);
		tab1.setSquareMined(2, 1);
		res1 =tab1.countAdjacentMines(2, 2);
		assertEquals(res1,2);
		tab1.setSquareMined(1, 2);
		res1 =tab1.countAdjacentMines(2, 2);
		assertEquals(res1,3);
		tab1.setSquareMined(3, 2);
		res1 =tab1.countAdjacentMines(2, 2);
		assertEquals(res1,4);
		tab1.setSquareMined(3, 3);
		res1 =tab1.countAdjacentMines(2, 2);
		assertEquals(res1,5);
		tab1.setSquareMined(1, 1);
		res1 =tab1.countAdjacentMines(2, 2);
		assertEquals(res1,6);
		tab1.setSquareMined(1, 3);
		res1 =tab1.countAdjacentMines(2, 2);
		assertEquals(res1,7);
		tab1.setSquareMined(3, 1);
		res1 =tab1.countAdjacentMines(2, 2);
		assertEquals(res1,8);
		
		//Square in the top extreme
		Board tab2=new Board(5,5);
		int res2 =tab2.countAdjacentMines(4, 4);
		assertEquals(res2,0);
		tab2.setSquareMined(4, 3);
		res2 =tab2.countAdjacentMines(4, 4);
		assertEquals(res2,1);
		tab2.setSquareMined(3, 4);
		res2 =tab2.countAdjacentMines(4, 4);
		assertEquals(res2,2);
		tab2.setSquareMined(3, 3);
		res2 =tab2.countAdjacentMines(4, 4);
		assertEquals(res2,3);
		
		//Square in the bottom extreme
		Board tab3=new Board(5,5);
		int res3 =tab3.countAdjacentMines(0, 0);
		assertEquals(res3,0);
		tab3.setSquareMined(0, 1);
		res3 =tab3.countAdjacentMines(0, 0);
		assertEquals(res3,1);
		tab3.setSquareMined(1, 0);
		res3 =tab3.countAdjacentMines(0, 0);
		assertEquals(res3,2);
		tab3.setSquareMined(1, 1);
		res3 =tab3.countAdjacentMines(0, 0);
		assertEquals(res3,3);
		
		//Smallest Board
		//Square in the middle
		Board tab4=new Board(3,3);
		int res4 =tab4.countAdjacentMines(1, 1);
		assertEquals(res4,0);
		tab4.setSquareMined(1, 2);
		res4 =tab4.countAdjacentMines(1, 1);
		assertEquals(res4,1);
		tab4.setSquareMined(2, 1);
		res4 =tab4.countAdjacentMines(1, 1);
		assertEquals(res4,2);
		tab4.setSquareMined(0, 1);
		res4 =tab4.countAdjacentMines(1, 1);
		assertEquals(res4,3);
		tab4.setSquareMined(1, 0);
		res4 =tab4.countAdjacentMines(1, 1);
		assertEquals(res4,4);
		tab4.setSquareMined(2, 2);
		res4 =tab4.countAdjacentMines(1, 1);
		assertEquals(res4,5);
		tab4.setSquareMined(0, 0);
		res4 =tab4.countAdjacentMines(1, 1);
		assertEquals(res4,6);
		tab4.setSquareMined(0, 2);
		res4 =tab4.countAdjacentMines(1, 1);
		assertEquals(res4,7);
		tab4.setSquareMined(2, 0);
		res4 =tab4.countAdjacentMines(1, 1);
		assertEquals(res4,8);
		
		//Square in the top extreme
		Board tab5=new Board(3,3);
		int res5 =tab5.countAdjacentMines(2, 2);
		assertEquals(res5,0);
		tab5.setSquareMined(1, 2);
		res5 =tab5.countAdjacentMines(2, 2);
		assertEquals(res5,1);
		tab5.setSquareMined(2, 1);
		res5 =tab5.countAdjacentMines(2, 2);
		assertEquals(res5,2);
		tab5.setSquareMined(1, 1);
		res5 =tab5.countAdjacentMines(2, 2);
		assertEquals(res5,3);
		
		//Square in the bottom extreme
		Board tab6=new Board(3,3);
		int res6 =tab6.countAdjacentMines(0, 0);
		assertEquals(res6,0);
		tab6.setSquareMined(0, 1);
		res6 =tab6.countAdjacentMines(0, 0);
		assertEquals(res6,1);
		tab6.setSquareMined(1, 0);
		res6 =tab6.countAdjacentMines(0, 0);
		assertEquals(res6,2);
		tab6.setSquareMined(1, 1);
		res6 =tab6.countAdjacentMines(0, 0);
		assertEquals(res6,3);
		
		//Biggest Board
		//Square in the middle
		Board tab7=new Board(10,10);
		int res7 =tab7.countAdjacentMines(2, 2);
		assertEquals(res7,0);
		tab7.setSquareMined(2, 3);
		res7 =tab7.countAdjacentMines(2, 2);
		assertEquals(res7,1);
		tab7.setSquareMined(2, 1);
		res7 =tab7.countAdjacentMines(2, 2);
		assertEquals(res7,2);
		tab7.setSquareMined(1, 2);
		res7 =tab7.countAdjacentMines(2, 2);
		assertEquals(res7,3);
		tab7.setSquareMined(3, 2);
		res7 =tab7.countAdjacentMines(2, 2);
		assertEquals(res7,4);
		tab7.setSquareMined(3, 3);
		res7 =tab7.countAdjacentMines(2, 2);
		assertEquals(res7,5);
		tab7.setSquareMined(1, 1);
		res7 =tab7.countAdjacentMines(2, 2);
		assertEquals(res7,6);
		tab7.setSquareMined(1, 3);
		res7 =tab7.countAdjacentMines(2, 2);
		assertEquals(res7,7);
		tab7.setSquareMined(3, 1);
		res7 =tab7.countAdjacentMines(2, 2);
		assertEquals(res7,8);
		
		//Square in the top extreme
		Board tab8=new Board(10,10);
		int res8 =tab8.countAdjacentMines(9, 9);
		assertEquals(res8,0);
		tab8.setSquareMined(9, 8);
		res8 =tab8.countAdjacentMines(9, 9);
		assertEquals(res8,1);
		tab8.setSquareMined(8, 9);
		res8 =tab8.countAdjacentMines(9, 9);
		assertEquals(res8,2);
		tab8.setSquareMined(8, 8);
		res8 =tab8.countAdjacentMines(9, 9);
		assertEquals(res8,3);
		
		//Square in the bottom extreme
		Board tab9=new Board(10,10);
		int res9 =tab9.countAdjacentMines(0, 0);
		assertEquals(res9,0);
		tab9.setSquareMined(0, 1);
		res9 =tab9.countAdjacentMines(0, 0);
		assertEquals(res9,1);
		tab9.setSquareMined(1, 0);
		res9 =tab9.countAdjacentMines(0, 0);
		assertEquals(res9,2);
		tab9.setSquareMined(1, 1);
		res9 =tab9.countAdjacentMines(0, 0);
		assertEquals(res9,3);
		

	}
}
