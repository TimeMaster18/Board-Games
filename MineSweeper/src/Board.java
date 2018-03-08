
public class Board {
	
	private Square[][] table;
	private int x;
	private int y;
	private int numMinedSquares;
	private int numOpenSquares;
	public int bX;
	public int bY;
	

	
	public Board(int x, int y){
		this.setTable(new Square[x][y]);
		this.setX(x);
		this.setY(y);
		this.numOpenSquares=0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				this.getTable()[i][j]= new Square();
			}
		}
	}

	public void openSquare(int x, int y){
		if (!getTable()[x][y].isOpen()) {
			getTable()[x][y].setOpen(true);
			getTable()[x][y].setMarked(false);
			getTable()[x][y].setNumAdjacentMines(countAdjacentMines(x,y));
			this.numOpenSquares++;
			//If Square is empty and has no adjacent mines, open adjacent Squares
			if (getTable()[x][y].getNumAdjacentMines()==0){ 
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						//Prevent counting outside the board or itself again
						if(x+i<this.getX() && y+j<this.getY() && x+i>=0 && y+j>=0 && !(i==0 && j==0)){ 
							if(!getTable()[x+i][y+j].isOpen()) {
								openSquare(x+i,y+j);
							}
						}						
					}
				}
			}
		}
	}
	
	public int countAdjacentMines(int x, int y){
		int numAdjacentMines=0;
				
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				//Prevent counting outside the board or itself
				if(x+i<this.getX() && y+j<this.getY() && x+i>=0 && y+j>=0 && !(i==0&&j==0)){ 
					if (getTable()[x+i][y+j].isMined()){
						numAdjacentMines++;
					}					
				}
			}
		}
					
		return numAdjacentMines;
	}
	
	public void drawBoard(){		
		
		//Draw numbered heading (top)
		System.out.print(' ');
		System.out.print(' ');
		for (int z = 0; z < getY(); z++) {
			System.out.print(' ');
			System.out.print(z);
		}
		
		//Draw Board
		for (int i = 0; i < getX(); i++) {
			System.out.print('\n');
			System.out.print(' ');
			System.out.print(i); 	//Draw numered heading (left side)
			for (int j = 0; j < getY(); j++) {				
				System.out.print(' ');				
				if(this.getTable()[i][j].isMarked()){					
					System.out.print('!'); 	//Draw Marked Square					
				}else{					
					if(this.getTable()[i][j].isOpen() ){						
						if(this.getTable()[i][j].isMined()){
							System.out.print('X'); 	//Draw Mined Open Square
						}else{						
							if(this.getTable()[i][j].getNumAdjacentMines()==0){
								System.out.print(' ');	//Draw Empty Open Square			
							}else{
								//Draw Number of Adjacent Mines at Empty Open Square
								System.out.print(this.getTable()[i][j].getNumAdjacentMines()); 
							}
						}
					}else{
						//Draw Unopened Square
						System.out.print('?');
					}				
				}
			}			
		}
	}
	
	public boolean isMined(int x,int y) {
		return table[x][y].isMined();
	}

	public int getNumOpen(){
		return this.numOpenSquares;
	}

	public int getNumMines(){
		return this.numMinedSquares;
	}

	public Square[][] getTable() {
		return table;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setMines(int Density){

		int area =this.getX()*this.getY();
		int numMines=area*Density/100;
		this.numMinedSquares=numMines;
		while(numMines>0){
			numMines=this.setRandomBomb(numMines);
			}	
		}
	

	public int[] random(int maxX, int maxY){
		int rand[]={0,0};
		rand[0]= 0 + (int)(Math.random() * maxX-1);
		rand[1]= 0 + (int)(Math.random() * maxY-1);
		return rand;
	}
	
	public int setRandomBomb(int numMines){
		int randomNum[]={0,0};
		randomNum = random(this.getX(),this.getX());

		if(!this.getTable()[randomNum[0]][randomNum[1]].isMined()){
			this.setSquareMined(randomNum[0], randomNum[1]);
			numMines--;
		}
		return numMines;
	}
	
	public void setSquareMined(int x, int y){
		getTable()[x][y].setMined(true);
	}

	public void markSquare(int x, int y){
			if(!getTable()[x][y].isOpen()){
				getTable()[x][y].setMarked(true);
			}
	}

	public void setTable(Square[][] table) {
		this.table = table;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setNumMinedSquares(int numMinedSquares) {
		this.numMinedSquares = numMinedSquares;
	}

	public void setNumOpenSquares(int numOpenSquares) {
		this.numOpenSquares = numOpenSquares;
	}
}
	
	

