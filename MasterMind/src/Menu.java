import java.util.Scanner;

public class Menu {
	
	public Menu(int length, int colors,int guesses, boolean duplicates) {
		this.length = length;
		this.colors = colors;
		this.guesses = guesses;
		this.duplicates = duplicates;
	}
	
	public Menu() {
		// Default Config
		this.length = 5;
		this.guesses = 8;
		this.colors = 5;
		this.duplicates = false;
	}
	
	private int length;
	private int colors;
	private int guesses;
	private boolean duplicates;
	

	/**
	 *  Prints the menu
	 */	
	public void printMenu() {
		System.out.println("\n\n          MASTER MIND");
        System.out.println("--------------------------------------");
	    
	    System.out.println("1- PLAY");
	    System.out.println("2- Change Code Length setting");
	    System.out.println("3- Change Number of possible Colors setting");
	    System.out.println("4- Change Limit of Guesses per game setting");
	    System.out.println("5- Change Allow Duplicates setting");
	    System.out.println("6- EXIT");
	    
	    System.out.println("Please select menu option:");
	}
	
	
	// INPUT
	/**
	 * Checks if the input entered by the suer is valid
	 * @param input: Value entered by the User
	 * @return Returns true if the value is valid
	 */	
	public boolean checkInput(int input) {
		if (input <= 0 || input > 6)
		{
			return false;
		}
		return true;		

	}
	
	

}
