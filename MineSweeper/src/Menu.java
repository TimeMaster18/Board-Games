public class Menu {
	
	public Menu() {
	}
	

	/**
	 *  Prints the menu
	 */	
	public void printMenu() {
		System.out.println("\n\n          MINESWEEPER");
        System.out.println("--------------------------------------");
	    
	    System.out.println("1- PLAY");
	    System.out.println("2- PLAY CUSTOM GAME");
	    System.out.println("3- Change Dimension of the Board");
	    System.out.println("4- Change Mines Density");
	    System.out.println("5- EXIT");	    
	    
	    System.out.println("Please select menu option:");
	}
	
	
	// INPUT
	/**
	 * Checks if the input entered by the user is valid
	 * @param input: Value entered by the User
	 * @return Returns true if the value is valid
	 */	
	public boolean checkInput(int input) {
		if (input <= 0 || input > 5)
		{
			return false;
		}
		return true;		

	}
	
	

}
