import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	
	public Game(int length,int colors,int guesses,boolean duplicates) {
		this.length = length;
		this.colors = colors;
		this.guesses = guesses;
		this.duplicates = duplicates;		
	}
	
	// Default settings
	public Game() {
		this.length = 5;
		this.colors = 5;
		this.guesses = 7;
		this.duplicates = false;		
	}
	
	private int length;
	private int colors;
	private int guesses;
	private boolean duplicates;
	
	private boolean optionsConflict = false;
	
	// CODE LENGTH
	/**
	 * Changes the Code Length by asking the user to enter a new value
	 */	
	public void setCodeLength() {
		
		int value = -1;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			if(this.optionsConflict == true) {
				System.out.println("Settings Conflict: The length is higher than the possible colors/numbers and duplicates aren't allowed");
				this.optionsConflict = false;
			}
			System.out.println("Please Enter the desired code Length (Number between 4 and 10)");
			if(!scanner.hasNextInt()) {
				System.out.println("Invalid Input");
				scanner.next();
			}else {				
			    value = scanner.nextInt();
			}

	    
		}while(!validCodeLength(value));
		
		this.length = value;
		
		
	}
	
	/**
	 * Checks if the code Length entered is valid
	 * @return Returns true if the value is valid
	 */	
	public boolean validCodeLength(int input) {
		
		if(this.duplicates == false && input > this.colors)
		{
			this.optionsConflict = true;
			return false;
		}
		
		if (input < 4 || input > 10)
		{
			return false;
		}
		return true;
	}
	
	// DUPLICATES
	/**
	 * Changes the Allowing of Duplicates by asking the user to enter a new value
	 */	
	public void setAllowDuplicates() {
		
		boolean allowed = false;
		int value=-1;
		Scanner scanner = new Scanner(System.in);
		
		do {
			if(this.optionsConflict == true) {
				System.out.println("Settings Conflict: The length is higher than the possible colors/numbers and duplicates aren't allowed");
				this.optionsConflict = false;
			}
			System.out.println("Please Enter 1  for Allowed or 0 for Not allowed duplicates");			
			if(!scanner.hasNextInt()) {
				System.out.println("Invalid Input");
				scanner.next();
			}else {	
				
			    value = scanner.nextInt();
			}
			
		}while(!validAllowDuplicates(value));
		
		if (value == 1) {
			allowed = true;
		}		
		
		this.duplicates = allowed;
	}
	
	/**
	 * Checks if the value for Allowed Duplicates entered is valid
	 * @return Returns true if the value is valid
	 */	
	public boolean validAllowDuplicates(int input) {
		
		if(input == 0 && this.length > this.colors)
		{
			this.optionsConflict = true;
			return false;
		}
		
		if (input < 0 || input > 1)
		{
			return false;
		}
		return true;
	}
	
	
	//COLORS
	/**
	 * Changes the Amount of Colors by asking the user to enter a new value
	 */	
	public void setAmountOfColors() {
		int value=-1;
		
		Scanner scanner = new Scanner(System.in);
		
		do {	
			if(this.optionsConflict == true) {
				System.out.println("Settings Conflict: The length is higher than the possible colors/numbers and duplicates aren't allowed");
				this.optionsConflict = false;
			}
			System.out.println("Please Enter the desired Amount of Possible Colors (Number between 5 and 8)");
			if(!scanner.hasNextInt()) {
				System.out.println("Invalid Input");
				scanner.next();
			}else {	
				
			    value = scanner.nextInt();
			}
	    
		}while(!validAmountColors(value));		
		
		this.colors = value;
	}
	
	/**
	 * Checks if the amount of Colors entered is valid
	 * @return Returns true if the value is valid
	 */	
	public boolean validAmountColors(int input) {
		
		if(this.duplicates == false && this.length > input)
		{
			this.optionsConflict = true;
			return false;
		}
		
		if (input < 5 || input > 8)
		{
			return false;
		}
		return true;
	}
	
	
	// GUESSES
	/**
	 * Changes the Amount of Guesses by asking the user to enter a new value
	 */	
	public void setAmountOfGuesses() {
		int value=-1;
		
		Scanner scanner = new Scanner(System.in);
		
		do {			
			System.out.println("Please Enter the desired limit of Guesses (Number between 6 and 12)");
            			
			if(!scanner.hasNextInt()) {
				System.out.println("Invalid Input");
				scanner.next();
			}else {	
				
			    value = scanner.nextInt();
			}
	    
		}while(!validAmountGuesses(value));		
		
		this.guesses = value;
	}
	
	/**
	 * Checks if the amount of Guesses entered is valid
	 * @return Returns true if the value is valid
	 */	
	public boolean validAmountGuesses(int input) {
		
		if (input < 6 || input > 12)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Starts the Game
	 */	
	public void start() {		
		
		System.out.print("\nActual config: Code Length: " + this.length + "\nPossible numbers: 0-" + this.colors + "\nNumber of Guesses: " + this.guesses + "\nDuplicates allowed: " + this.duplicates + "\n\n");
			
		int[] winCode = {};	
		int turns = 0;
		boolean win = false;
		
		do {
			winCode = createCode(this.length, this.colors, this.duplicates);
		}while(!validCode(winCode, this.length, this.colors, this.duplicates));
		
		boolean gameOver = false;
		do {			
			win = turn (winCode);
			int turnsRemaining = this.guesses - 1 - turns;
			
			turns++;
			
			if (win == true || turns == this.guesses) {				
				gameOver = true;				
			}else {			
				System.out.print("\n\nTurns remaining: "+ turnsRemaining + ", ");
			}	
			
		}while(!gameOver);
		
		if (win == true) {
			System.out.print("\n\nVICTORY!!");
		}else {
			System.out.print("\n\\nCode Was:");
		    for (int j = 0; j < this.length; j++) {
		        System.out.print(winCode[j] + " ");
		    }
			
			System.out.print("\n\nGAME OVER");
			System.out.print("\nYOU LOSE");
		}
		
			
	}
	
	/**
	 * Generates the code to be broken
	 * @param length: Length of the code to check
	 * @param colors: Possible numbers of each value in the code
	 * @param duplicates: Allowed or not duplicates
	 * @return Returns the code entered by the user as an array
	 */	
	public int[] createCode(int length, int colors, boolean duplicates ) {
		
		int randomNum = 0;
		int[] createdCode = {};	
		int[] errorCode = {0};
			
		
		if (length > 10 || length < 4 || colors > 8 || colors < 5 ||(length>colors && duplicates==false)) {							
			return errorCode;
		}else {
			createdCode = new int[length];
			
			for (int i =0; i<length; i++) {
				
				randomNum = ThreadLocalRandom.current().nextInt(1, colors + 1);
				createdCode[i] = randomNum;	
				
			}
			return createdCode;
		}			
		
		
	}
	
	/**
	 * Asks the user for the Code to compare with the Code Generated
	 * @return Returns the code entered by the user as an array
	 */	
	public int[] askCode() {		
		
		int[] code = new int[this.length];

	    @SuppressWarnings("resource")
		Scanner chopper = new Scanner(System.in).useDelimiter("\\s"); 
	    System.out.println("Enter your code: (Example: 1 2 3)");

	    int number;
	    int i = 0;

	    while (chopper.hasNextInt()) {
	        number = chopper.nextInt();
	        code[i] = number;
	        i++;
	    }

	    for (int j = 0; j < this.length; j++) {
	        System.out.print(code[j] + " ");
	    }
		
	    
		
		return code;
	}
	
	/**
	 * Plays a turn of the game
	 * @param winCode: Code Entered by the user to check against the Generated Code.
	 * @return Return true in case of matching codes, win game.
	 */	
	public boolean turn(int[] winCode) {
				
		int[] userCode = {};
		boolean win = false;
		
		do {
			userCode = askCode();
		}while(!validCode(userCode, this.length, this.colors, this.duplicates));
		
		int[] hint = compareCodes(userCode, winCode);
		
		System.out.print("\nResult: " + hint[0] + " Correct Position, " + hint[1] + " Wrong position, " + hint[2] + " Wrong Number");
			
		if(hint[0] == this.length)
		{
			win = true;
		}
		
		return win;
	}
	
	/**
	 * Compares the user and the generated Code
	 * @param userCode: Code Entered by the user to check against the Generated Code.
	 * @param winCode: Code Generated to be broken
	 * @return Return results of the comparison, array with the amount of correct, wrong position and wrong numbers.
	 */	
	public int[] compareCodes(int[] userCode, int[] winCode)
	{
		int[] compared = {0,0,0};
		
		int [] tempUserCode = new int[this.length];
		int [] tempWinCode = new int[this.length];
		
		System.arraycopy(userCode, 0, tempUserCode, 0, this.length);
		System.arraycopy(winCode, 0, tempWinCode, 0, this.length);
		
		for(int i = 0; i<this.length ; i++) {
			if(tempUserCode[i] == tempWinCode[i] ) {
				compared[0]++;
				tempUserCode[i] = 0;
				tempWinCode[i] = 0;
			}
		}
		
		for(int i = 0; i<this.length ; i++) {	
			for(int j=0; j<this.length;j++) {
				if(tempUserCode[j] != 0 && tempWinCode[i] != 0 && tempUserCode[j] == tempWinCode[i]) {
					compared[1]++;
					tempUserCode[j] = 0;
					tempWinCode[i] = 0;	
			
				}
			}
		}
		
		compared[2] = this.length - compared[0] - compared[1];
		
		return compared;
	}
	
	/**
	 * Compares the user and the generated Code
	 * @param codeToCheck: Code to check if is valid.
	 * @param length: Length of the code to check
	 * @param colors: Possible numbers of each value in the code
	 * @param duplicates: Allowed or not duplicates
	 * @return Return true if the code is valid.
	 */
	public boolean validCode (int[] codeToCheck, int length, int colors, boolean duplicates ) {
		
		boolean valid = true;
		
		if (codeToCheck.length != length)
		{
			valid = false;
		}
		
					
		for (int j=0; j<codeToCheck.length; j++) {
			if (codeToCheck[j] > colors || codeToCheck[j] <= 0)
			{
				valid = false;
				
			}
			
			if (duplicates == false) {				
				for (int k=j+1 ;k<codeToCheck.length; k++) {
					if (k!=j && codeToCheck[k] == codeToCheck[j]) {					
						valid=false;
					}				      
				}
			}		
		}		
		
		return valid;
	}
}
