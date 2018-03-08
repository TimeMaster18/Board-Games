
import java.util.Scanner;

public class Client {	
	
	public static void main(String[] args) {				
		

		Menu menu = new Menu();	
		Game game = new Game();
		
		boolean validInput;		
		
		do {			
			menu.printMenu();
		    
		    int select;
		    
		    Scanner sc = new Scanner(System.in);
		    select = sc.nextInt();		    
		    
		    validInput = menu.checkInput(select);
	
		    switch (select) {
		        case 1:		        	
		            game.selectDifficulty();	
		            game.start();
		            break;
		        case 2:
		        	game.start();
		            break;
		        case 3:		        	
		            game.setBoardDimensions();
		            break;
		        case 4:
		        	game.setMineDensity();
		            break;
		        case 5:
		        	System.out.println("Exiting...");
		        	System.exit(0);
		            break;
		        default:
		        	System.out.println("Invalid Option, please try again");
		            break;
		    }			
		    
		}while(validInput);
		
	}
	
	
}

