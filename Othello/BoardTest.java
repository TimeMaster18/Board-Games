import static org.junit.Assert.*;

import org.junit.Test;


public class BoardTest {
	
	
	private class MockBoard1 extends Board{
			
		public boolean validateSquareToInsert(int x, int y,boolean turn){
			if(this.getSquare(x, y).getTab()){
				return false;
			}else{
				return true;
			}
		}
		
		public void cleanBoard(boolean color){
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					this.getSquare(i, j).setTab(false);
					this.getSquare(i, j).setColor(color);
				}
			}
		}
		
		
	}
	
	private class MockBoard2 extends Board{
		
		private Square[][] table;
		
		public MockBoard2(){
			this.table=new Square[8][8];
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					this.table[i][j]=new Square(true); 
				}
			}
		}
		
		public boolean validateSquareToInsert(int x, int y,boolean turn){
			if(this.getSquare(x, y).getTab()){
				return false;
			}else{
				return true;
			}
		}
		
		public void restartBoard(){
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					putTab(i,j,false);
					getSquare(i,j).setColor(false);
				}
			}
		}
	
		
		public void setCorners(){
			getSquare(0,0).setColor(true);
			getSquare(0,7).setColor(true);
			getSquare(7,0).setColor(true);
			getSquare(7,7).setColor(true);
		}
		
	}
	
	private class MockBoard3 extends Board{
		
			
			public void putTab(int x, int y,boolean turn){
				if(!this.getSquare(x, y).getTab()){
					getSquare(x,y).setColor(turn);
					getSquare(x,y).setTab(true);
				}
			}
		}
		
	
	@Test
	public void testBoard() {
		//Black Box
		//Initialize Board
		Board test=new Board();
		
		//Check for initial Board position with 4 tabs in the center	
		
		//Equivalent Partition outside of the board -> Invalid input
		//Equivalent Partition inside of the board -> Valid input
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=3 && i<5 && j>=3 && j<5){
					assertTrue(test.getSquare(i,j).getTab());
				}else{
					assertFalse(test.getSquare(i,j).getTab());
				}
			}
		}
				
		//Check colors are correct			
		assertTrue(test.getSquare(3,3).getColor());
		assertTrue(test.getSquare(4,4).getColor());
		assertFalse(test.getSquare(4,3).getColor());
		assertFalse(test.getSquare(3,4).getColor());
	}
	
	@Test
	public void testChangeSquare() {
		//Black Box
		//Initialize Board
		MockBoard1 test=new MockBoard1();
		
		//Equivalent Partition Black to White -> valid
		//Equivalent Partition White to Black -> valid
		
		//Equivalent Partition Black to White on the edges -> valid
		//Equivalent Partition White to Black on the edges -> valid
		
		//Equivalent Partition Black to White on the edges outside -> invalid
		//Equivalent Partition White to Black on the edges outside -> invalid
		
		//Equivalent Partition Black to White outside -> invalid
		//Equivalent Partition White to Black outside -> invalid
		
		//Change initial Tabs to color black		
		test.changeSquare(4,3);
		test.changeSquare(3,4);
		
		//Check that all tabs are black		
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=3 && i<5 && j>=3 && j<5){
					assertTrue(test.getSquare(i,j).getColor());
				}else{
					test.changeSquare(i,j);
					assertFalse(test.getSquare(i,j).getColor());	
				}
			}
		}
		
		//Place Black Tabs in the center of the Board (4x4)
		//Change to White Tabs and check color and placement
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=2 && i<6 && j>=2 && j<6){
					test.putTab(i,j,true);
					test.changeSquare(i,j);
					assertFalse(test.getSquare(i,j).getColor());
				}else{
					test.changeSquare(i,j);
					assertFalse(test.getSquare(i,j).getColor());	
				}
			}
		}
		
		//Place White Tabs in the center of the Board (6x6)
		//Change to Black Tabs and check color and placement		
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=1 && i<7 && j>=1 && j<7){
					test.putTab(i,j,false);
					test.changeSquare(i,j);
					assertTrue(test.getSquare(i,j).getColor());
				}else{
					test.changeSquare(i,j);
					assertFalse(test.getSquare(i,j).getColor());	
				}
			}
		}
		
		//Place Black Tabs in the center of the Board (whole board 8x8)
		//Change to White Tabs and check color and placement
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=0 && i<8 && j>=0 && j<8){
					test.putTab(i,j,true);
					test.changeSquare(i,j);
					assertFalse(test.getSquare(i,j).getColor());
				}else{
					test.changeSquare(i,j);
					assertFalse(test.getSquare(i,j).getColor());	
				}
			}
		}
	}
	
	@Test
	public void testPutTab() {
		//Black Box
		
		//Equivalent Partition Put Tab in center (initial setup) (2x2) -> valid		
		//Equivalent Partition Put Tab in whole board -> valid
		//Equivalent Partition Put Tab in the inner edge of the board -> valid		
		//Equivalent Partition Put Tab on the edges outside -> invalid				
		//Equivalent Partition Put Tab outside of the board -> invalid
		
		//Initialize Board with tabs in the center (4x4)	
		MockBoard1 test=new MockBoard1();
		for(int i=2;i<6;i++){
			for(int j=2;j<6;j++){
				test.putTab(i,j,true);
			}
		}		
		//Check Correct placement	
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=2 && i<6 && j>=2 && j<6){
					assertTrue(test.getSquare(i,j).getTab());
				}else{
					assertFalse(test.getSquare(i,j).getTab());
				}
			}
		}
		
		//Initialize Board with tabs in the center (6x6)
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){
				test.putTab(i,j,true);
			}
		}
		//Check Correct placement	
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=1 && i<7 && j>=1 && j<7){
					assertTrue(test.getSquare(i,j).getTab());
				}else{
					assertFalse(test.getSquare(i,j).getTab());
				}
			}
		}
		
		//Initialize Board with tabs in the whole Board (8x8)
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				test.putTab(i,j, true);
			}
		}
		//Check Correct placement
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=0 && i<8 && j>=0 && j<8){
					assertTrue(test.getSquare(i,j).getTab());
				}else{

					assertFalse(test.getSquare(i,j).getTab());
				}
			}
		}
	}
	
	@Test
	public void testCalculateWhoWin() {
		
		//Black Box		
		//Initialize Board 
		
		MockBoard2 test=new MockBoard2();
		test.restartBoard();
		int x=0;
		//Check every possible combination of Black-White Tabs
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				assertEquals(x,test.calculateWhoWin());
				test.changeSquare(i, j);	
				x++;			
			}
		}
		assertEquals(x,test.calculateWhoWin());
		assertEquals(64,test.calculateWhoWin());
	}
	
	@Test
	public void testCountPosibleSquares() {
		
		//Black Box
		
		//Initialize Board 
		Board test=new Board();
		
		//Box of 2x2 Black Tabs -> 0 White/Black possible movements
		test.changeSquare(3, 4);
		test.changeSquare(4, 3);
		assertEquals(0,test.countPosibleSquares(false));
		assertEquals(0,test.countPosibleSquares(true));
		
		//Box of 2x2 Black Tabs	with a ring around of White Tabs-> 20 Black possible movements, 0 White
		for(int i=2;i<6;i++){
			for(int j=2;j<6;j++){
				if((i==2 && j<=5 && j>=2) || (i==5 && j<=5 && j>=2)||(j==2 && i<5 && i>2) || (j==5 && i<5 && i>2)){
					test.getSquare(i, j).setTab(true);
					test.getSquare(i, j).setColor(false);
				}
			}
		}

		assertEquals(0,test.countPosibleSquares(false));
		assertEquals(20,test.countPosibleSquares(true));
		
		//Box of 2x2 Black Tabs	with a ring around of White Tabs and another ring of Black Tabs 
		//->	28 Black possible movements, 0 White	
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){
				if((i==1 && j<=6 && j>=1) || (i==6 && j<=6 && j>=1)||(j==1 && i<6 && i>1) || (j==6 && i<6 && i>1)){
					test.getSquare(i, j).setTab(true);
					test.getSquare(i, j).setColor(true);
				}
			}
		}
		
		assertEquals(28,test.countPosibleSquares(false));
		assertEquals(0,test.countPosibleSquares(true));
		
		//Box of 2x2 Black Tabs	with a ring around of White Tabs and another ring of Black Tabs and another ring of White Tabs 
		//->  0 White/Black possible movements
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if((i==0 && j<=7 && j>=0) || (i==7 && j<=7 && j>=0)||(j==0 && i<7 && i>0) || (j==7 && i<7 && i>0)){
					test.getSquare(i, j).setTab(true);
					test.getSquare(i, j).setColor(false);
				}
			}
		}
		
		assertEquals(0,test.countPosibleSquares(false));
		assertEquals(0,test.countPosibleSquares(true));
		
	}
	
	@Test
	public void testGetSquare() {
		
		//Black Box
		
		//Equivalent Partition Get Square in center (initial setup) (2x2) -> valid		
		//Equivalent Partition Get Square in whole board -> valid
		//Equivalent Partition Get Square in the inner edge of the board -> valid		
		//Equivalent Partition Get Square on the edges outside -> invalid				
		//Equivalent Partition Get Square outside of the board -> invalid
		
		//Initialize Board 		
		MockBoard1 test=new MockBoard1();
		
		//Place tabs in the wholle board except edges		
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){
				if(!((i==3 && (j==4 ||j==3))||(i==4 && (j==4 ||j==3)))){	
				test.putTab(i, j, true);
				}
			}
		}
		
		//Check that the Squares can be obtained properly and the data is correct		
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=0 && i<8 && j>=0 && j<8){
					assertTrue(test.getSquare(i, j).getInTablero());
					if(i>=1 && i<7 && j>=1 && j<7){
						assertTrue(test.getSquare(i,j).getTab());					
						if((i==3 && j==4)||(i==4 && j==3 )){	
							assertFalse(test.getSquare(i, j).getColor());
						}else{
							assertTrue(test.getSquare(i, j).getColor());
						}
					}else{
						assertFalse(test.getSquare(i,j).getTab());
					}
				}else{
					assertFalse(test.getSquare(i, j).getColor());
					assertFalse(test.getSquare(i,j).getTab());
					assertFalse(test.getSquare(i, j).getInTablero());
				}
			}
		}
		
	}
	
	@Test
	public void testValidateSquareToInsert() {
		
		//Black Box		
		
		//Equivalent Partition Insert Square next to opposite color tab, flanking -> valid		
		//Equivalent Partition Insert Square next to opposite color tab, not flanking -> invalid	
		//Equivalent Partition Insert Square next to same color tab, flanking -> valid
		//Equivalent Partition Insert Square next to same color tab, not flanking -> invalid
		//Equivalent Partition Insert Square next to no tab, not flanking -> invalid 
		//Equivalent Partition Insert Square next to no color tab, not flanking -> invalid
		//Equivalent Partition Insert Square outside Board-> invalid
		
		//Initialize Board with Tabs in the center (initial setup) (2x2)
		MockBoard3 test=new MockBoard3();
		
		test.getSquare(3, 3).setColor(false);
		test.getSquare(4, 4).setColor(false);
		
		//Half-way game state, tabs in the center (4x4) 
		for(int i=2;i<6;i++){
			for(int j=2;j<6;j++){
				test.putTab(i,j,true);
			}
		}
		
		//Check for true on the outside ring of the placed tabs and false on the rest, outside the board included.
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if((i==1 && j<=6 && j>=1) || (i==6 && j<=6 && j>=1)||(j==1 && i<6 && i>1) || (j==6 && i<6 && i>1)){
					assertTrue(test.validateSquareToInsert(i,j,false));
					assertFalse(test.validateSquareToInsert(i,j,true));
				}else{
					assertFalse(test.validateSquareToInsert(i,j,false));
					assertFalse(test.validateSquareToInsert(i,j,true));
				}
			}
		}
		
		//Very advanced game state, tabs in the center (6x6) 
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){
				test.putTab(i,j,false);
			}
		}
		
		//Check for true on the outside ring of the placed tabs and false on the rest, outside the board included.		
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if((i==0 && j<=7 && j>=0) || (i==7 && j<=7 && j>=0)||(j==0 && i<7 && i>0) || (j==7 && i<7 && i>0)){
					assertFalse(test.validateSquareToInsert(i,j,false));
					assertTrue(test.validateSquareToInsert(i,j,true));
				}else{
					assertFalse(test.validateSquareToInsert(i,j,false));
					assertFalse(test.validateSquareToInsert(i,j,true));
				}
			}
		}
		
		
		
		//Finished game state, tabs in the center (8x8) 
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				test.putTab(i,j,true);
			}
		}
		
		//Check for true on the outside ring of the placed tabs and false on the rest, outside the board included.
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				assertFalse(test.validateSquareToInsert(i,j,false));
			}
		}
	}
	
	@Test
	public void testValidateSquareToChange() {
		//Black Box		
		
		//Equivalent Partition Change Square next to opposite color tab, flanked -> valid		
		//Equivalent Partition Change Square next to opposite color tab, not flanked -> invalid	
		//Equivalent Partition Change Square next to same color tab, flanked -> valid
		//Equivalent Partition Change Square next to same color tab, not flanked -> invalid
		//Equivalent Partition Change Square next to no tab, flanked -> invalid (impossible)
		//Equivalent Partition Change Square next to no color tab, not flanked -> invalid
		//Equivalent Partition Change Square outside Board-> invalid
		
		
		//Initialize Board with Tabs in the center (initial setup) (2x2)
		MockBoard1 test=new MockBoard1();
		test.getSquare(4, 3).setColor(true);
		test.getSquare(3, 4).setColor(true);
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=3 && i<5 && j>=3 && j<5){
					assertTrue(test.validateSquareToChange(i,j));
				}else{
					assertFalse(test.validateSquareToChange(i,j));
				}
			}
		}
		
		//Half-way game state, tabs in the center (4x4) (Doughnut)
		for(int i=2;i<6;i++){
			for(int j=2;j<6;j++){
				test.putTab(i,j,true);
			}
		}
		
		//Check possible moves, inside the Doughnut false, outside true. Outside of Board false.
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=2 && i<6 && j>=2 && j<6){
					assertTrue(test.validateSquareToChange(i,j));
				}else{
					assertFalse(test.validateSquareToChange(i,j));
				}
			}
		}
		
		//Very advanced game state, tabs in the center (6x6) (Doughnut)
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){
				test.putTab(i,j,true);
			}
		}
		
		//Check possible moves, inside the Doughnut false, outside true. Outside of Board false.
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=1 && i<7 && j>=1 && j<7){
					assertTrue(test.validateSquareToChange(i,j));
				}else{
					assertFalse(test.validateSquareToChange(i,j));
				}
			}
		}
		
		//Finished game state, tabs in the center (8x8)
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				test.putTab(i,j,true);
			}
		}
		
		//Check possible moves, inside the Doughnut false, outside true. Outside of Board false.
		for(int i=-1;i<9;i++){
			for(int j=-1;j<9;j++){
				if(i>=0 && i<8 && j>=0 && j<8){
					assertTrue(test.validateSquareToChange(i,j));
				}else{
					assertFalse(test.validateSquareToChange(i,j));
				}
			}
		}
	}
	
	@Test
	public void testUpdate() {
		
		//Black Box
		
		//Initialize Board 
		MockBoard2 test=new MockBoard2();
		
		//Equivalent Partition Outside of the Board -> invalid
		
		test.restartBoard();
		test.update(8, 8);
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				assertFalse(test.getSquare(i,j).getColor());
			}
		}
		
		test.restartBoard();
		test.update(-1, -1);
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				assertFalse(test.getSquare(i,j).getColor());
			}
		}
		
		test.restartBoard();
		test.update(-1, 6);
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				assertFalse(test.getSquare(i,j).getColor());
			}
		}
		
		test.restartBoard();
		test.update(5, -1);
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				assertFalse(test.getSquare(i,j).getColor());
			}
		}
		
		test.restartBoard();
		test.update(9, -1);
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				assertFalse(test.getSquare(i,j).getColor());
			}
		}
		
		test.restartBoard();
		test.update(-1, 9);
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				assertFalse(test.getSquare(i,j).getColor());
			}
		}
		
		
		//Equivalent Partition Inside Board, maximum flank length (8) -> valid
		
		test.restartBoard();
		test.setCorners();
		test.update(0, 0);
			
		for(int i=0;i<8;i++){
			assertTrue(test.getSquare(i,0).getColor());
			assertTrue(test.getSquare(0,i).getColor());
			assertTrue(test.getSquare(i,i).getColor());
		}
		
		test.restartBoard();
		test.setCorners();
		test.update(0, 7);
		
		for(int i=0;i<8;i++){
			assertTrue(test.getSquare(i,7).getColor());
			assertTrue(test.getSquare(0,7-i).getColor());
			assertTrue(test.getSquare(0+i,7-i).getColor());
		}
		
		test.restartBoard();
		test.setCorners();
		test.update(7, 0);
		
		for(int i=0;i<8;i++){

			assertTrue(test.getSquare(7-i,0).getColor());
			assertTrue(test.getSquare(7,i).getColor());
			assertTrue(test.getSquare(7-i,i).getColor());
		}
		
		test.restartBoard();
		test.setCorners();
		test.update(7, 7);
		
		for(int i=0;i<8;i++){
			
			assertTrue(test.getSquare(7-i,7).getColor());
			assertTrue(test.getSquare(7,7-i).getColor());
			assertTrue(test.getSquare(7-i,7-i).getColor());
		}
		
		//Equivalent Partition Inside Board, mid flank length (4) -> valid
		
		test.restartBoard();
		test.changeSquare(6, 6);
		test.changeSquare(1, 6);
		test.changeSquare(6, 1);
		test.changeSquare(1, 1);
		test.update(1, 1);
			
		for(int i=0;i<6;i++){
			assertTrue(test.getSquare(i+1,1).getColor());
			assertTrue(test.getSquare(1,i+1).getColor());
			assertTrue(test.getSquare(i+1,i+1).getColor());
		}
		
		test.restartBoard();
		test.changeSquare(6, 6);
		test.changeSquare(1, 6);
		test.changeSquare(6, 1);
		test.changeSquare(1, 1);
		test.update(1, 6);
		
		
		for(int i=0;i<6;i++){
			
			assertTrue(test.getSquare(i+1,6).getColor());
			assertTrue(test.getSquare(1,6-i).getColor());
			assertTrue(test.getSquare(1+i,6-i).getColor());
			
		}
		
		test.restartBoard();
		test.changeSquare(6, 6);
		test.changeSquare(1, 6);
		test.changeSquare(6, 1);
		test.changeSquare(1, 1);
		test.update(6, 1);
		
		
		for(int i=0;i<6;i++){

			assertTrue(test.getSquare(6-i,1).getColor());
			assertTrue(test.getSquare(6,i+1).getColor());
			assertTrue(test.getSquare(6-i,i+1).getColor());
		}
		
		test.restartBoard();
		test.changeSquare(6, 6);
		test.changeSquare(1, 6);
		test.changeSquare(6, 1);
		test.changeSquare(1, 1);
		test.update(6, 6);
		
		for(int i=0;i<6;i++){
			
			assertTrue(test.getSquare(6-i,6).getColor());
			assertTrue(test.getSquare(6,6-i).getColor());
			assertTrue(test.getSquare(6-i,6-i).getColor());
		}
		
		//Equivalent Partition Inside Board, low flank length (2) -> valid
		
		test.restartBoard();
		test.changeSquare(5, 5);
		test.changeSquare(2, 5);
		test.changeSquare(5, 2);
		test.changeSquare(2, 2);
		test.update(2, 2);
		
		
		for(int i=0;i<4;i++){
			assertTrue(test.getSquare(i+2,2).getColor());
			assertTrue(test.getSquare(2,i+2).getColor());
			assertTrue(test.getSquare(i+2,i+2).getColor());
		}
		
		test.restartBoard();
		test.changeSquare(5, 5);
		test.changeSquare(2, 5);
		test.changeSquare(5, 2);
		test.changeSquare(2, 2);
		test.update(2, 5);
		
		
		for(int i=0;i<4;i++){
			
			assertTrue(test.getSquare(i+2,5).getColor());
			assertTrue(test.getSquare(2,5-i).getColor());
			assertTrue(test.getSquare(2+i,5-i).getColor());
			
		}
		
		test.restartBoard();
		test.changeSquare(5, 5);
		test.changeSquare(2, 5);
		test.changeSquare(5, 2);
		test.changeSquare(2, 2);
		test.update(5, 2);

		
		for(int i=0;i<4;i++){

			assertTrue(test.getSquare(5-i,2).getColor());
			assertTrue(test.getSquare(5,i+2).getColor());
			assertTrue(test.getSquare(5-i,i+2).getColor());
		}
		
		test.restartBoard();
		test.changeSquare(5, 5);
		test.changeSquare(2, 5);
		test.changeSquare(5, 2);
		test.changeSquare(2, 2);
		test.update(5, 5);
		
		for(int i=0;i<4;i++){
			
			assertTrue(test.getSquare(5-i,5).getColor());
			assertTrue(test.getSquare(5,5-i).getColor());
			assertTrue(test.getSquare(5-i,5-i).getColor());
		}
		
		//Equivalent Partition Inside Board, minimum flank length (0) -> valid
		
		test.restartBoard();
		test.changeSquare(4, 4);
		test.changeSquare(3, 4);
		test.changeSquare(4, 3);
		test.changeSquare(3, 3);
		test.update(3, 3);
		
		
		for(int i=0;i<2;i++){
			assertTrue(test.getSquare(i+3,3).getColor());
			assertTrue(test.getSquare(3,i+3).getColor());
			assertTrue(test.getSquare(i+3,i+3).getColor());
		}
		
		test.restartBoard();
		test.changeSquare(4, 4);
		test.changeSquare(3, 4);
		test.changeSquare(4, 3);
		test.changeSquare(3, 3);
		test.update(3, 4);
		
		
		for(int i=0;i<2;i++){
			
			assertTrue(test.getSquare(i+3,4).getColor());
			assertTrue(test.getSquare(3,4-i).getColor());
			assertTrue(test.getSquare(3+i,4-i).getColor());
			
		}
		
		test.restartBoard();
		test.changeSquare(4, 4);
		test.changeSquare(3, 4);
		test.changeSquare(4, 3);
		test.changeSquare(3, 3);
		test.update(4, 3);

		
		for(int i=0;i<2;i++){

			assertTrue(test.getSquare(4-i,3).getColor());
			assertTrue(test.getSquare(4,i+3).getColor());
			assertTrue(test.getSquare(4-i,i+3).getColor());
		}
		
		test.restartBoard();
		test.changeSquare(4, 4);
		test.changeSquare(3, 4);
		test.changeSquare(4, 3);
		test.changeSquare(3, 3);
		test.update(4, 4);
		
		for(int i=0;i<2;i++){
			
			assertTrue(test.getSquare(4-i,4).getColor());
			assertTrue(test.getSquare(4,4-i).getColor());
			assertTrue(test.getSquare(4-i,4-i).getColor());
		}
		
		
		//Equivalent Partition Inside Board, maximum flank length-1 with same color tab at the end -> valid
		
		MockBoard1 test2=new MockBoard1();
		test2.cleanBoard(false);
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){
				test2.getSquare(i, j).setColor(true);
				test2.getSquare(i, j).setTab(true);
			}
		}
		
		
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){
				test2.changeSquare(i, j);
				test2.update(i, j);
				for(int x=1;x<7;x++){
					for(int y=1;y<7;y++){
						
						if((i==x && j==y)){
						assertTrue(test2.getSquare(x,y).getTab());
						assertFalse(test2.getSquare(x,y).getColor());
						}else{
						assertTrue(test2.getSquare(x,y).getTab());	
						assertTrue(test2.getSquare(x,y).getColor());
						}
					}
				}
				test2.changeSquare(i, j);
			}
		}
		
		
		//Equivalent Partition Inside Board, maximum flank length-1  -> valid
		

		test2.cleanBoard(true);
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){
				test2.getSquare(i, j).setTab(true);
			}
		}
			
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){
				test2.changeSquare(i, j);
				test2.update(i, j);
				for(int x=1;x<7;x++){
					for(int y=1;y<7;y++){
						
						if((i==x && j==y)){
						assertTrue(test2.getSquare(x,y).getTab());
						assertFalse(test2.getSquare(x,y).getColor());
						}else{
						assertTrue(test2.getSquare(x,y).getTab());	
						assertTrue(test2.getSquare(x,y).getColor());
						}
					}
				}
				test2.changeSquare(i, j);
			}
		}
		
	}
	

	
}
