import java.util.Scanner;
/**
 * Menu class
 * 
 * Class for the Menu, where the game is exited or a match is started
 */
public class Menu {
		Game game;
	public Menu() {
		game=new Game();
	}
	

	/**
	 *  Prints the menu
	 */	
	public void printMenu() {
		System.out.println("\n\n          OTHELLO");
        System.out.println("--------------------------------------");
	    
	    System.out.println("1- PLAY");
	    System.out.println("2- EXIT");	    
	    
	    System.out.println("Please select menu option:");
	}
	
	
	// INPUT
	/**
	 * Checks if the input entered by the user is valid
	 * @param input: Value entered by the User
	 * @return Returns true if the value is valid
	 */	
	public boolean checkInput(int input) {
		if (input <= 0 || input > 2)
		{
			return false;
		}
		return true;		

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
	
	public void start(){
		int op;
		do{
			this.printMenu();
			do{
				op=askInt();
				if(!this.checkInput(op)){
				System.out.println("Invalid Input");
				}
			}while(!this.checkInput(op));
				
			if(op==1){
				startGame();
				game=new Game();
			}
		}while(!(op==2));
	}
	
	public void startGame(){
		this.game.start();
	}
}
	
	


