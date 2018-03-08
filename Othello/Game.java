import java.util.Scanner;

/**
 * Menu class
 * 
 * Class for the Game, contains the Board and has the functions start and turn 
 * that allow the game to be played.
 */
public class Game {
	
	
	public Game(){
		turnojugador=false;
		turnos=0;
		table = new Board();
	}
	
	public boolean turnojugador;
	public Board table;
	public int turnos=0;
	public int fichas=4;
	public int blancas;
	public int win;
	public boolean gameOver;
	
	
	/**
	 * Getter of the Board, returns the Board of the current match
	 */
	public Board getBoard(){
		return this.table;
	}
		
	/**
	 * Starts the match of this Game
	 */
	public void start(){
		
		gameOver=false;
		
		do{			
			turnojugador=!turnojugador;
			//Checks if the player can make a move
			if(this.table.countPosibleSquares(turnojugador)>0){
				gameOver=turn(turnojugador);
				fichas++;
			}else{
				turnojugador=!turnojugador;
				if(this.table.countPosibleSquares(turnojugador)>0){
					gameOver=turn(turnojugador);
					fichas++;
				}else{
					gameOver=true;
				}
			}			
		}while(!gameOver);
		
		//Game Over -> Checks who won
		win=table.calculateWhoWin();
		blancas=fichas-win;
		
		if(blancas==win){
			System.out.println("\n\n          IT'S A DRAW \n\n");
		}
		else if (win>blancas) {
			System.out.println("\n\n          BLACK WINS \n\n");
		}else{
			System.out.println("\n\n          WHITE WINS \n\n");
		}
		
		//Draws finished match Board
		table.drawBoard();
		
	}
	
	
	/**
	 * Returns the Board of the current match
	 * @param turno Indicates whos turn is, black or white tabs
	 * @return gameOver Indicates if the game is over or not
	 */
	public boolean turn(boolean turno){
		
		getBoard().drawBoard();		
		boolean gameOver=false;
		
		if(turno){
			System.out.println("\n\n BLACK TURN ");
		}else{
			System.out.println("\n\n WHITE TURN ");
		}
		int coor[];
		
		do{
			coor=askPlayer();

			if(!table.validateSquareToInsert(coor[0], coor[1],turno)){
				System.out.println("Square already occupied or out of bounds");
				System.out.println("Insert valid coordinates");
			}
		}while(!table.validateSquareToInsert(coor[0], coor[1],turno));
		
		int x=coor[0];
		int y=coor[1];	
		
		table.putTab(x,y,turno);
		table.update(x,y);
		turnos++;
		
		if(turnos==60){
			gameOver=true;
		}
		return gameOver;
	}

	
	/**
	  * Gets integer input from the user
	  * @return int input from the user
	  */
	 public int askInt() {
	  Scanner scanner = new Scanner(System.in);
	  int asked=-1;
	  
	  while(!scanner.hasNextInt()) {
		  scanner.next(); // next input is not an int, so consume it and move on
	      System.out.println("Invalid Input");
	  }
	  
	  asked = scanner.nextInt();
	 
	  return asked;  
	 }
	
	/**
	 * Asks the player what is their next turn coordinates
	 * @return int[] action and coordinates of the turn
	 */
	public int[] askPlayer(){
				
		int coordinates[]={-1,-1};			
			do {
				System.out.println("\nEnter coordinate X");	
				coordinates[1] = askInt();			    	    
			}while(!validCoor(coordinates[1]));			
			
			do {		
				System.out.println("\nEnter coordinate Y");					
				coordinates[0] = askInt();			   
			}while(!validCoor(coordinates[0]));

		return coordinates;
	}
	
	/**
	 * Checks if the Coordinate entered is valid
	 * @param input Coordinate value entered by the user
	 * @return Returns true if the value is valid
	 */	
	public boolean validCoor(int input){
		if (input < 0 || input > 7) 
		{
			return false;
		}
		return true;
	}
	
	
}
