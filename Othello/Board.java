/**
 * Board class
 * 
 * Class for the Board where the game is played contains Squares and functions
 * that control the state of the Board and the Game, updating accordingly
 * Square[][] is a matrix of squares that form the Board
 */
public class Board {
	
	private Square[][] table;
	
	public Board(){
		this.table=new Square[8][8];
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
			this.table[i][j]=new Square(true); 
			}
		}
		this.table[3][3].setTab(true);
		this.table[3][4].setTab(true);
		this.table[4][3].setTab(true);
		this.table[4][4].setTab(true);
		
		this.table[3][3].setColor(true);
		this.table[3][4].setColor(false);
		this.table[4][3].setColor(false);
		this.table[4][4].setColor(true);
	}
	
	/**
	 * Changes the color of the tab in indicated Square
	 * @param x Coordinate X of the Square to change
	 * @param y Coordinate Y of the Square to change
	 */
	public void changeSquare(int x, int y){
		if(validateSquareToChange(x,y)){
			if(getSquare(x,y).getColor()){
				getSquare(x,y).setColor(false);
			}else{
				getSquare(x,y).setColor(true);
			}
		}
	}
	
	/**
	 * Returns the Square (tab) of the indicated coordinates
	 * @param x Coordinate X of the Square to return
	 * @param y Coordinate Y of the Square to return
	 * @return Square, a tab on the board
	 */
	public Square getSquare(int x, int y){
		if(x>7 || y>7 || x<0 || y<0 ){
			return new Square(false);
		}else{
		return this.table[x][y];
		}
	}
		
	/**
	 * Puts a Tab in the indicated Square
	 * @param x Coordinate X of the Square to put the tab on
	 * @param y Coordinate Y of the Square to put the tab on
	 * @param color Color of the tab to put
	 */
	public void putTab(int x, int y, boolean color){
		if(validateSquareToInsert(x,y,color)){
			getSquare(x,y).setColor(color);
			getSquare(x,y).setTab(true);
		}
	}
	
	
	/**
	 * Validates that the Tab to Insert in the indicated Square
	 * can be placed there according to the game rules
	 * @param x Coordinate X of the Square to put the tab on
	 * @param y Coordinate Y of the Square to put the tab on
	 * @param turn Boolean that indicates which player is playing, hence the color that is playing
	 * @return valid Indicates if the position is valid or not
	 */
	public boolean validateSquareToInsert(int x, int y,boolean turn){
		
		boolean valid = false;
		
		//Check for out of bounds
		if(x>7 || y>7 || x<0 || y<0 ){
			return false;
		}
		
		//Check if there is already a tab placed
		if(getSquare(x,y).getTab()){
			return false;
		}
		
		//Check if the placement is valid (needs to flank opponents tabs)
		for(int i=-1;i<2;i++){
			for(int j=-1;j<2;j++){
				if(!(i==0 && j==0)){
					if(!(getSquare(x+i,y+j).getColor()==turn) && (getSquare(x+i,y+j).getTab())){
						int z=i;
						int t=j;
						while(!(getSquare(x+z,y+t).getColor()==turn) && (getSquare(x+z,y+t).getTab())){
							z=z+i;
							t=t+j;							
						}						
						if(getSquare(x+z,y+t).getColor()==turn && (getSquare(x+z,y+t).getTab())){
							return true;
						}

					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Counts the number of possible Squares to play a tab (for checking Draws or turn skips)
	 * @param turn Boolean that indicates which player is playing, hence the color that is playing
	 * @return count Amount of possible Squares to play a Tab
	 */
	public int countPosibleSquares(boolean turn){
		int count=0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(this.validateSquareToInsert(i, j, turn)){
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Validates that the Tab can be changed in the indicated Square
	 * @param x Coordinate X of the Square to put the tab on
	 * @param y Coordinate Y of the Square to put the tab on
	 * @param turn Boolean that indicates which player is playing, hence the color that is playing
	 * @return valid Indicates if the position is valid or not
	 */
	public boolean validateSquareToChange(int x, int y){	
		
		boolean valid=false;
		
		//Check for out of bounds
		if(x>7 || y>7 || x<0 || y<0 ){
			valid = false;
		}
		
		//Check if there is a tab
		valid = getSquare(x,y).getTab();
		
		return valid;
	}
	
	/**
	 * Calculates who wins by counting the tabs in the Board
	 * @return blackTabs Amount of black Tabs on the Board
	 */
	public int calculateWhoWin(){
		
		int blackTabs=0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(this.getSquare(i, j).getColor()){
					blackTabs++;
				}
			}
		}
		
		return blackTabs;
	}
	
	/**
	 * Updates the Board by changing colors to the flanked tabs
	 * @param x Coordinate X of the last played Square
	 * @param y Coordinate Y of the last played Square
	 */
	public void update(int x, int y){
		
		//Checks out of bounds
		if(!(x>7 || y>7 || x<0 || y<0 )){
			
			//Iterates all 4 directions and diagonals checking if any tab was flanked
			for(int i=-1;i<2;i++){
				for(int j=-1;j<2;j++){
					if(!(i==0 && j==0)){
						if(!(getSquare(x+i,y+j).getColor()==getSquare(x,y).getColor()) && (getSquare(x+i,y+j).getTab())){
							int z=i;
							int t=j;
							while(!(getSquare(x+z,y+t).getColor()==getSquare(x,y).getColor()) && (getSquare(x+z,y+t).getTab())){
								z=z+i;
								t=t+j;								
							}
							
							if(getSquare(x+z,y+t).getColor()==getSquare(x,y).getColor() && (getSquare(x+z,y+t).getTab())){
								z=z-i;
								t=t-j;
								while(!(z+x==x && t+y==y)){
									changeSquare(z+x,t+y);
									z=z-i;
									t=t-j;
								}
								
							}
						}
					}
				}
			}
		}			
	}
	
	/**
	  * Draws the Board
	  */ 
	 public void drawBoard(){  
	  
	  //Draw numbered heading (top)
	  System.out.print(' ');
	  System.out.print(' ');
	  
	  for (int z = 0; z < 8; z++) {
		  System.out.print(' ');
		  System.out.print(z);
	  }
	   
	  //Draw Board
	  for (int i = 0; i < 8; i++) {
		   System.out.print('\n');
		   System.out.print(' ');
		   System.out.print(i);  //Draw numered heading (left side)
		   for (int j = 0; j < 8; j++) {    
			   System.out.print(' ');    
			   if(!this.getSquare(i,j).getTab()){     
				   System.out.print('·');  //Draw Empty Square     
			   }else{     
				   if(this.getSquare(i,j).getColor() ){
					   System.out.print('@');  //Draw Black Tab 
				   }else{
					   System.out.print('O');  //Draw White Tab
				   }
			   }
		   }
	  	}    
	  
	  

	 }
	
	
	
		
}
