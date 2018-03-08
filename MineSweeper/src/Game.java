import java.util.Scanner;

public class Game {
	
	public Game(int boardDimensionX,int boardDimensionY,int mineDensity) {
		this.boardDimensionX = boardDimensionX;
		this.boardDimensionY = boardDimensionY;
		this.mineDensity = mineDensity;	
		this.lose=false;
	}
	
	// Default settings
	public Game() {
		this.boardDimensionX = 5;
		this.boardDimensionY = 5;
		this.mineDensity = 15;			
	}
	
	private int boardDimensionX;
	private int boardDimensionY;
	private int mineDensity;
	private boolean lose;	
		
	public void start(){
		Board board = new Board(this.boardDimensionX,this.boardDimensionY);
		board.setMines(this.mineDensity);
		boolean gameOver=false;
		
		do{
			gameOver=turn(board);
		}while(!gameOver);
		
		if(this.lose){
			System.out.println("\n\n          YOU HAVE FOUND A MINE, YOU L0SE \n\n");
		}else{
			System.out.println("\n\n          YOU HAVE AVOIDED ALL MINES; YOU WIN!! \n\n");
		}
		this.openBoard(board);
		board.drawBoard();
					
	}

	/**
	 * Asks the user to select the difficulty of the game
	 */	
	public void selectDifficulty() {
		int difficulty = -1;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n\n          SELECT DIFFICULTY");
        System.out.println("--------------------------------------");
	    
	    System.out.println("1- EASY");
	    System.out.println("2- NORMAL");
	    System.out.println("3- HARD");
	    System.out.println("4- EXTREME");
		
		do {		
			System.out.println("\n\nPlease Enter the desired Difficulty to play:");
			if(!scanner.hasNextInt()) {
				System.out.println("Invalid Input");
				scanner.next();
			}else {
				difficulty=scanner.nextInt();
			}
			this.changeGameDifficulty(difficulty);
	    
		}while(!validDifficulty(difficulty));
	}
	
	/**
	 * Changes the Difficulty of the Game	 * 
	 * @param input difficulty value entered by the user
	 */	
	public void changeGameDifficulty(int difficulty) {
		
		switch (difficulty) {
		
        case 1:		 
        	this.setBoardDimensionX(4);
        	this.setBoardDimensionY(4);
        	this.setMineDensity(10);
            break;
            
        case 2:
        	this.setBoardDimensionX(5);
        	this.setBoardDimensionY(5);
        	this.setMineDensity(15);
        	break;
        	
        case 3:		        	
        	this.setBoardDimensionX(7);
        	this.setBoardDimensionY(7);
        	this.setMineDensity(25);
            break;
            
        case 4:
        	this.setBoardDimensionX(8);
        	this.setBoardDimensionY(8);
        	this.setMineDensity(50);
            break;            
            
        default:
        	System.out.println("Invalid Option, please try again");
            break;
		}	
	}		
		
	public boolean turn(Board board){
		board.drawBoard();
		int action[]=askPlayer();
		int x=action[0];
		int y=action[1];
		int op=action[2];
		boolean gameOver=false;
		if(op==1){
			if(board.getTable()[x][y].isMined()){
				gameOver=true;
				this.lose=true;
			}else{
				if(!board.getTable()[x][y].isOpen()){
					board.openSquare(x, y);					
				}
			
			}
		}else{
			board.markSquare(x, y);
		}
		int area=board.getX()*board.getY();
		
		if(board.getNumMines()+board.getNumOpen()==area){
			gameOver=true;
		}
		return gameOver;
		}
	
	public int askInt() {
		Scanner scanner = new Scanner(System.in);
		int asked=-1;
		if(!scanner.hasNextInt()) {
			
			System.out.println("Invalid Input");
			scanner.next();
		}else {						
			asked = Integer.parseInt(scanner.nextLine());				
		}	 
		return asked;
		
	}
	
	public int[] askPlayer(){
		Scanner scanner = new Scanner(System.in);
		int action[]={0,0,0};	     
			
		do {		
			System.out.println("\n\n Please Enter action to do: 1-Open Square 2-Mark Square:");
			action[2] = askInt();
		}while(!validOption(action[2]));			
		
		do {
			System.out.println("\nEnter coordinate Y");	
			action[0] = askInt();			    	    
		}while(!validCorX(action[0]));			
		
		do {		
			System.out.println("\nEnter coordinate X");					
			action[1] = askInt();			   
		}while(!validCorY(action[1]));
		
		return action;
	}
		
	public void openBoard(Board board){
		for (int i = 0; i < board.getX(); i++) {
			for (int j = 0; j < board.getY(); j++) {
				board.openSquare(i, j);
			}
		}
	}

	/**
	 * Checks if the Board Dimension entered is valid	 * 
	 * @param input Board Dimension value entered by the user
	 * @return Returns true if the value is valid
	 */	
	public boolean validBoardDimension(int input) {		
				
		if (input < 3 || input > 10)
		{
			return false;
		}
		return true;
	}

	/**
	 * Checks if the value for Mine Density entered is valid	 * 
	 * @param input Mine Density value entered by the user
	 * @return Returns true if the value is valid
	 */	
	public boolean validMineDensity(int input) {
		if (input < 10 || input > 75)
		{
			return false;
		}
		return true;
	}

	/**
	 * Checks if the difficulty entered is valid
	 * @param input difficulty value entered by the user
	 * @return Returns true if the value is valid
	 */	
	public boolean validDifficulty(int input) {
		if (input < 1 || input > 4)
		{
			return false;
		}
		return true;
	}

	public boolean validCorX(int input){
		if (input < 0 || input > this.boardDimensionX-1)
		{
			return false;
		}
		return true;
	}
	
	public boolean validCorY(int input){
		if (input < 0 || input > this.boardDimensionY-1)
		{
			return false;
		}
		return true;
	}
	
	public boolean validOption(int input){
		if (input < 1 || input > 2)
		{
			return false;
		}
		return true;
	}
	
	//// CUSTOM GAME	
		
	// BOARD DIMENSIONS
	/**
	 * Changes the Board Dimensions by asking the user to enter the desired values
	 */	
	public void setBoardDimensions() {
		
		int dimensionX = -1;
		int dimensionY = -1;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please Enter the desired Board Dimensions (Between 3x3 and 10x10, it can be uneven)");
		
		do {		
			System.out.println("Please Enter the desired Horizontal Dimension of the Board (Number between 3 and 10)");
			
			    dimensionX = askInt();

	    
		}while(!validBoardDimension(dimensionX));
		
		do {		
			System.out.println("Please Enter the desired Horizontal Dimension of the Board (Number between 3 and 10)");
			
			dimensionY = askInt();

	    
		}while(!validBoardDimension(dimensionY));
		
		this.boardDimensionX = dimensionX;
		this.boardDimensionY = dimensionY;	
	}

	// MINE DENSITY
	/**
	 * Changes the Mine Density by asking the user to enter the desired value
	 */	
	public void setMineDensity() {
		
		int mineDensity = -1;

		do {
			
			System.out.println("Please Enter the desired Mine Density (Valid numbers from 10 to 75)");			
			mineDensity = askInt();
			
		}while(!validMineDensity(mineDensity));
				
		this.mineDensity = mineDensity;
	}

	public void setBoardDimensionX (int boardDimensionX) {
		this.boardDimensionX = boardDimensionX;
	}
	
	public void setBoardDimensionY (int boardDimensionY) {
		this.boardDimensionY = boardDimensionY;
	}
	
	public void setMineDensity (int mineDensity) {
		this.mineDensity = mineDensity;	
	}
	
	public boolean Equals(Game game) {
		boolean result = true;
		if(!(this.boardDimensionX == game.getBoardDimensionX()) || !(this.boardDimensionY == game.getBoardDimensionY()) ||
				!(this.mineDensity == game.getMineDensity()) || !(this.lose == game.getLose())) {
			result = false;
		}
			
		return result;
	}
	
	public int getBoardDimensionX () {
		return this.boardDimensionX;
	}
	
	public int getBoardDimensionY () {
		return this.boardDimensionY;
	}
	
	public int getMineDensity () {
		return this.mineDensity;	
	}
	
	public boolean getLose () {
		return this.lose;
	}
}
