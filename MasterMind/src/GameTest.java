import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class GameTest {
	
	/**
	 * Checks if the code Length entered is valid
	 * @return Returns true if the value is valid
	 */	
	@Test
	public void testValidCodeLength() {
		
		//Initialize a game with valid Settings, allowed duplicates
		Game game = new Game(5,5,3,true);
		
		//Test modifying Code Length Setting, Game Rules set to allow the range 4-10 as values	
		//Equivalent Partition -inf to 3 -> Invalid input
		boolean res_0 = game.validCodeLength(-29);
		assertFalse(res_0);
		
		boolean res_1 = game.validCodeLength(-1);
		assertFalse(res_1);
		
		boolean res_2 = game.validCodeLength(0);
		assertFalse(res_2);
		
		boolean res_3 = game.validCodeLength(1);
		assertFalse(res_3);
		
		boolean res_4 = game.validCodeLength(3);
		assertFalse(res_4);
		
		//Equivalent Partition 4 to 10 -> valid input
		boolean res_5 = game.validCodeLength(4);
		assertTrue(res_5);
		
		boolean res_6 = game.validCodeLength(5);
		assertTrue(res_6);
		
		boolean res_7 = game.validCodeLength(8);
		assertTrue(res_7);
		
		boolean res_8 = game.validCodeLength(9);
		assertTrue(res_8);
		
		boolean res_9 = game.validCodeLength(10);
		assertTrue(res_9);
		
		//Equivalent Partition 10 to inf -> Invalid input
		boolean res_10 = game.validCodeLength(11);
		assertFalse(res_10);
		
		boolean res_11 = game.validCodeLength(25);
		assertFalse(res_11);	
		
		//Initialize a game with valid Settings, disallowed duplicates (Check case length > colors, invalid input)
		// Having Length > Colors as initial values
		game = new Game(8,5,4,false);
		
		//Test modifying Code Length Setting		
		//Equivalent Partition -inf to 3 -> Invalid input
		boolean res_12 = game.validCodeLength(-29);
		assertFalse(res_12);
		
		boolean res_13 = game.validCodeLength(-1);
		assertFalse(res_13);
		
		boolean res_14 = game.validCodeLength(0);
		assertFalse(res_14);
		
		boolean res_15 = game.validCodeLength(1);
		assertFalse(res_15);
		
		boolean res_16 = game.validCodeLength(3);
		assertFalse(res_16);
		
		//Equivalent Partition 4 to 5 (colors) -> valid input
		boolean res_17 = game.validCodeLength(4);
		assertTrue(res_17);
		
		boolean res_18 = game.validCodeLength(5);
		assertTrue(res_18);		
		
		//Equivalent Partition 5 (colors) to 10 -> Invalid input
		boolean res_19 = game.validCodeLength(6);
		assertFalse(res_19);
		
		boolean res_20 = game.validCodeLength(9);
		assertFalse(res_20);
		
		//Equivalent Partition 10 to inf -> Invalid input
		boolean res_21 = game.validCodeLength(10);
		assertFalse(res_21);
		
		boolean res_22 = game.validCodeLength(11);
		assertFalse(res_22);
		
		boolean res_23 = game.validCodeLength(25);
		assertFalse(res_23);
		
		//Initialize a game with valid Settings, disallowed duplicates (Check case length > colors, invalid input)
		// Having Length = Colors as initial values
		Game game2 = new Game(5,5,10,false);
		
		//Equivalent Partition -inf to 3 -> Invalid input
		boolean res_41 = game2.validCodeLength(-15);
		assertFalse(res_41);
		
		boolean res_42 = game2.validCodeLength(-1);
		assertFalse(res_42);
		
		boolean res_43 = game2.validCodeLength(0);
		assertFalse(res_43);
		
		boolean res_44 = game2.validCodeLength(1);
		assertFalse(res_44);
		
		boolean res_45 = game2.validCodeLength(3);
		assertFalse(res_45);
		
		//Equivalent Partition 4 to colors (5) -> valid input
		boolean res_24 = game2.validCodeLength(4);
		assertTrue(res_24);
		
		boolean res_25 = game2.validCodeLength(5);
		assertTrue(res_25);
		
		//Equivalent Partition colors to 10 -> Invalid input
		boolean res_26 = game2.validCodeLength(6);
		assertFalse(res_26);
		
		boolean res_27 = game2.validCodeLength(7);
		assertFalse(res_27);
		
		boolean res_28 = game2.validCodeLength(10);
		assertFalse(res_28);
		
		//Equivalent Partition 10 to inf -> Invalid input
		boolean res_46 = game2.validCodeLength(11);
		assertFalse(res_46);
		
		boolean res_47 = game2.validCodeLength(35);
		assertFalse(res_47);
		
		//Initialize a game with valid Settings, disallowed duplicates (Check case length > colors, invalid input)
		// Having Length < Colors as initial values
		Game game3 = new Game(5,8,10,false);
		
		//Equivalent Partition -inf to 3 -> Invalid input
		boolean res_36 = game3.validCodeLength(-15);
		assertFalse(res_36);
		
		boolean res_37 = game3.validCodeLength(-1);
		assertFalse(res_37);
		
		boolean res_38 = game3.validCodeLength(0);
		assertFalse(res_38);
		
		boolean res_39 = game3.validCodeLength(1);
		assertFalse(res_39);
		
		boolean res_40 = game3.validCodeLength(3);
		assertFalse(res_40);
		
		//Equivalent Partition 4 to colors (8) -> valid input
		boolean res_29 = game3.validCodeLength(4);
		assertTrue(res_29);
		
		boolean res_30 = game3.validCodeLength(7);
		assertTrue(res_30);
		
		boolean res_31 = game3.validCodeLength(8);
		assertTrue(res_31);
		
		//Equivalent Partition colors (8) to 10 -> valid input
		boolean res_32 = game3.validCodeLength(9);
		assertFalse(res_32);
		
		boolean res_35 = game3.validCodeLength(10);
		assertFalse(res_35);
		
		//Equivalent Partition 10 to inf -> Invalid input
		boolean res_33 = game3.validCodeLength(11);
		assertFalse(res_33);
		
		boolean res_34 = game3.validCodeLength(200);
		assertFalse(res_34);

	}
	
	@Test
	public void testValidAmountColors() {
		
		//Initialize a game with valid Settings, allowed duplicates
		Game game = new Game(5,5,10,true);
		
		//Test modifying Amount of Colors Setting, Game Rules set to allow the range 5-8 as values	
		//Equivalent Partition -inf to 4 -> Invalid input		
		boolean res_0 = game.validAmountColors(-29);
		assertFalse(res_0);
		
		boolean res_1 = game.validAmountColors(-1);
		assertFalse(res_1);
		
		boolean res_2 = game.validAmountColors(0);
		assertFalse(res_2);
		
		boolean res_3 = game.validAmountColors(1);
		assertFalse(res_3);
		
		boolean res_13 = game.validAmountColors(2);
		assertFalse(res_13);
		
		boolean res_4 = game.validAmountColors(4);
		assertFalse(res_4);
		
		//Equivalent Partition 4 to 8 -> valid input
		boolean res_5 = game.validAmountColors(5);
		assertTrue(res_5);
		
		boolean res_6 = game.validAmountColors(6);
		assertTrue(res_6);
		
		boolean res_7 = game.validAmountColors(7);
		assertTrue(res_7);
		
		boolean res_8 = game.validAmountColors(8);
		assertTrue(res_8);
		
		//Equivalent Partition 8 to inf -> Invalid input
		boolean res_9 = game.validAmountColors(9);
		assertFalse(res_9);
		
		boolean res_10 = game.validAmountColors(26);
		assertFalse(res_10);	

		//Initialize a game with valid Settings, disallowed duplicates (Check case length > colors, invalid input)
		// Having Length = Colors as initial values
		Game game2 = new Game(6,6,10,false);
		
		//Equivalent Partition -inf to 5 -> Invalid input
		boolean res_33 = game2.validAmountColors(-29);
		assertFalse(res_33);
		
		boolean res_34 = game2.validAmountColors(-1);
		assertFalse(res_34);
		
		boolean res_35 = game2.validAmountColors(0);
		assertFalse(res_35);
		
		boolean res_36 = game2.validAmountColors(1);
		assertFalse(res_36);
		
		boolean res_37 = game2.validAmountColors(4);
		assertFalse(res_37);		
				
		boolean res_24 = game2.validAmountColors(5);
		assertFalse(res_24);
		
		//Equivalent Partition 6 to 8 -> Invalid input
		boolean res_25 = game2.validAmountColors(6);
		assertTrue(res_25);
		
		boolean res_26 = game2.validAmountColors(7);
		assertTrue(res_26);
		
		boolean res_27 = game2.validAmountColors(8);
		assertTrue(res_27);
		
		//Equivalent Partition 9 to inf -> Invalid input
		boolean res_39 = game2.validAmountColors(9);
		assertFalse(res_39);
		
		boolean res_40 = game2.validAmountColors(26);
		assertFalse(res_40);
	
		//Initialize a game with valid Settings, disallowed duplicates (Check case length > colors, invalid input)
		// Having Length > Colors as initial values
		Game game3 = new Game(9,8,10,false);
		
		//Equivalent Partition -inf to 5 -> Invalid input
		boolean res_41 = game3.validAmountColors(-29);
		assertFalse(res_41);
		
		boolean res_42 = game3.validAmountColors(-1);
		assertFalse(res_42);
		
		boolean res_43 = game3.validAmountColors(0);
		assertFalse(res_43);
		
		boolean res_44 = game3.validAmountColors(1);
		assertFalse(res_44);
		
		boolean res_45 = game3.validAmountColors(4);
		assertFalse(res_45);		
				
		boolean res_46 = game3.validAmountColors(5);
		assertFalse(res_46);
		
		//Equivalent Partition 6 to 8 -> Invalid input
		boolean res_30 = game3.validAmountColors(6);
		assertFalse(res_30);
		
		boolean res_31 = game3.validAmountColors(7);
		assertFalse(res_31);
		
		boolean res_32 = game3.validAmountColors(8);
		assertFalse(res_32);
		
		//Equivalent Partition 8 to inf -> Invalid input
		boolean res_47 = game3.validAmountColors(9);
		assertFalse(res_47);
		
		boolean res_48 = game3.validAmountColors(26);
		assertFalse(res_48);
		
		//Initialize a game with valid Settings, disallowed duplicates (Check case length > colors, invalid input)
		// Having Length < Colors as initial values
		Game game4 = new Game(6,8,10,false);
		
		//Equivalent Partition -inf to 5 -> Invalid input
		boolean res_49 = game4.validAmountColors(-29);
		assertFalse(res_49);
		
		boolean res_50 = game4.validAmountColors(-1);
		assertFalse(res_50);
		
		boolean res_51 = game4.validAmountColors(0);
		assertFalse(res_51);
		
		boolean res_52 = game4.validAmountColors(1);
		assertFalse(res_52);
		
		boolean res_53 = game4.validAmountColors(3);		
		assertFalse(res_53);
		
		boolean res_55 = game4.validAmountColors(4);
		assertFalse(res_55);
		
		//Equivalent Partition 6 to 8 -> valid input		
		boolean res_54 = game4.validAmountColors(6);
		assertTrue(res_54);
		
		boolean res_56 = game4.validAmountColors(7);
		assertTrue(res_56);
		
		boolean res_57 = game4.validAmountColors(8);
		assertTrue(res_57);
		
		//Equivalent Partition 8 to inf -> Invalid input
		boolean res_58 = game4.validAmountColors(9);
		assertFalse(res_58);
		
		boolean res_59 = game4.validAmountColors(26);
		assertFalse(res_59);
		
	}
	
	@Test
	public void testValidAllowDuplicates() {
		
		//Initialize a game with valid Settings, allowed duplicates
		Game game = new Game(5,5,10,true);
		
		//Test modifying the allowance of Duplicates, Game Rules set to either allow (1) or disallow (0)	
		//Equivalent Partition -inf to -1 -> Invalid input			
		boolean res_0 = game.validAllowDuplicates(-29);
		assertFalse(res_0);
		
		boolean res_1 = game.validAllowDuplicates(-1);
		assertFalse(res_1);
		
		//Equivalent Partition 0 to 1 -> valid input	
		boolean res_2 = game.validAllowDuplicates(0);
		assertTrue(res_2);
		
		boolean res_3 = game.validAllowDuplicates(1);
		assertTrue(res_3);
		
		//Equivalent Partition 2 to inf -> Invalid input
		boolean res_4 = game.validAllowDuplicates(2);
		assertFalse(res_4);
		
		boolean res_5 = game.validAllowDuplicates(35);
		assertFalse(res_5);		
		
		//Initialize a game with valid Settings, allowed duplicates (Check case length > colors, invalid input)
		// Having Length = Colors as initial values
		Game game2 = new Game(5,5,10,false);
		
		//Equivalent Partition -inf to -1 -> Invalid input			
		boolean res_6 = game2.validAllowDuplicates(-29);
		assertFalse(res_6);
		
		boolean res_7 = game2.validAllowDuplicates(-1);
		assertFalse(res_7);
		
		//Equivalent Partition 0 to 1 -> valid input
		boolean res_8 = game2.validAllowDuplicates(0);
		assertTrue(res_8);
		
		boolean res_9 = game2.validAllowDuplicates(1);
		assertTrue(res_9);

		//Equivalent Partition 2 to inf -> Invalid input
		boolean res_10 = game2.validAllowDuplicates(2);
		assertFalse(res_10);
		
		boolean res_11 = game2.validAllowDuplicates(35);
		assertFalse(res_11);	
		
		//Initialize a game with valid Settings, allowed duplicates (Check case length > colors, invalid input)
		// Having Length > Colors as initial values
		Game game3 = new Game(7,5,10,true);
		
		//Equivalent Partition -inf to -1 -> Invalid input			
		boolean res_12 = game3.validAllowDuplicates(-29);
		assertFalse(res_12);
		
		boolean res_13 = game3.validAllowDuplicates(-1);
		assertFalse(res_13);
		
		//Equivalent Partition 0 -> invalid input
		boolean res_14 = game3.validAllowDuplicates(0);
		assertFalse(res_14);
		
		//Equivalent Partition 1 -> valid input
		boolean res_15 = game3.validAllowDuplicates(1);
		assertTrue(res_15);

		//Equivalent Partition 2 to inf -> Invalid input
		boolean res_16 = game3.validAllowDuplicates(2);
		assertFalse(res_16);
		
		boolean res_17 = game3.validAllowDuplicates(35);
		assertFalse(res_17);
		
		//Initialize a game with valid Settings, allowed duplicates (Check case length > colors, invalid input)
		// Having Length < Colors as initial values
		Game game4 = new Game(5,6,10,true);
		
		//Equivalent Partition -inf to -1 -> Invalid input			
		boolean res_18 = game4.validAllowDuplicates(-29);
		assertFalse(res_18);
		
		boolean res_19 = game4.validAllowDuplicates(-1);
		assertFalse(res_19);
		
		//Equivalent Partition 0 to 1 -> valid input
		boolean res_20 = game4.validAllowDuplicates(0);
		assertTrue(res_20);
		
		boolean res_21 = game4.validAllowDuplicates(1);
		assertTrue(res_21);

		//Equivalent Partition 2 to inf -> Invalid input
		boolean res_22 = game4.validAllowDuplicates(2);
		assertFalse(res_22);
		
		boolean res_23 = game4.validAllowDuplicates(35);
		assertFalse(res_23);
	}

	
	@Test
	public void testValidAmountGuesses() {
		
		//Initialize a game
		Game game = new Game();
		
		//Test modifying the amount of Guesses/tries, Game Rules set for a range between 6 and 12	
		//Equivalent Partition -inf to 5 -> Invalid input		
		boolean res_0 = game.validAmountGuesses(-29);
		assertFalse(res_0);
		
		boolean res_1 = game.validAmountGuesses(-1);
		assertFalse(res_1);
		
		boolean res_2 = game.validAmountGuesses(0);
		assertFalse(res_2);
		
		boolean res_3 = game.validAmountGuesses(1);
		assertFalse(res_3);
		
		boolean res_4 = game.validAmountGuesses(3);
		assertFalse(res_4);
		
		boolean res_13 = game.validAmountGuesses(5);
		assertFalse(res_13);
		
		//Equivalent Partition 6 to 12 -> valid input
		boolean res_14 = game.validAmountGuesses(6);
		assertTrue(res_14);
		
		boolean res_5 = game.validAmountGuesses(7);
		assertTrue(res_5);
		
		boolean res_6 = game.validAmountGuesses(9);
		assertTrue(res_6);
		
		boolean res_7 = game.validAmountGuesses(11);
		assertTrue(res_7);
		
		boolean res_8 = game.validAmountGuesses(12);
		assertTrue(res_8);
		
		//Equivalent Partition 13 to inf -> Invalid input
		boolean res_9 = game.validAmountGuesses(13);
		assertFalse(res_9);
		
		boolean res_10 = game.validAmountGuesses(26);
		assertFalse(res_10);
		
	}


	@Test
	public void testCreateCode() {
		
		//Initialize a game and an array of int which will be the testCode with a value of 0 (default error message)
		Game game = new Game();			
		int[] testCode = {0};	
		
		// Valid Ranges: Length 4-10, Colors 5-8, Duplicates True/False
		//Test for creating random generated codes to break by the players, tests if the method creates valid codes	
		
		// Allow Duplicates = True
		//Equivalent Partition -inf to 3,4 -> Invalid input	
		int[] res_16 = game.createCode(-23, -40, true);
		assertArrayEquals(res_16, testCode);
		
		int[] res_17 = game.createCode(-1, -1, true);
		assertArrayEquals(res_17, testCode);
		
		int[] res_0 = game.createCode(0, 0, true);
		assertArrayEquals(res_0, testCode);
		
		int[] res_18 = game.createCode(2, 2, true);
		assertArrayEquals(res_18, testCode);		
		
		int[] res_1 = game.createCode(3, 4, true);		
		assertArrayEquals(res_1, testCode);		
		
		//Equivalent Partition 4,5 to 10,8 -> valid input
		int[] res_2 = game.createCode(4, 5, true);		
		assertThat(res_2, not(testCode));		
		
		int[] res_3 = game.createCode(5, 6, true);		
		assertThat(res_3, not(testCode));		
		
		int[] res_4 = game.createCode(7, 7, true);		
		assertThat(res_4, not(testCode));		
		
		int[] res_5 = game.createCode(9, 7, true);		
		assertThat(res_5, not(testCode));
		
		int[] res_19 = game.createCode(10, 8, true);		
		assertThat(res_19, not(testCode));
		
		//Equivalent Partition 10,8 to inf -> invalid input
		int[] res_7 = game.createCode(11, 9, true);		
		assertArrayEquals(res_7, testCode);		
		
		int[] res_8 = game.createCode(20, 18, true);		
		assertArrayEquals(res_8, testCode);	
		
		//More Possible problematic combinations
		int[] res_21 = game.createCode(3, 5, true);		
		assertArrayEquals(res_21, testCode);
		
		int[] res_22 = game.createCode(3, 8, true);		
		assertArrayEquals(res_22, testCode);
		
		int[] res_23 = game.createCode(3, 9, true);		
		assertArrayEquals(res_23, testCode);
		
		int[] res_24 = game.createCode(4, 4, true);		
		assertArrayEquals(res_24, testCode);
		
		int[] res_25 = game.createCode(4, 5, true);		
		assertThat(res_25, not(testCode));
		
		int[] res_26 = game.createCode(4, 8, true);		
		assertThat(res_26, not(testCode));	
		
		int[] res_27 = game.createCode(4, 9, true);		
		assertArrayEquals(res_27, testCode);
		
		int[] res_28 = game.createCode(10, 4, true);		
		assertArrayEquals(res_28, testCode);
		
		int[] res_29 = game.createCode(10, 5, true);		
		assertThat(res_29, not(testCode));
		
		int[] res_30 = game.createCode(10, 8, true);		
		assertThat(res_30, not(testCode));	
		
		int[] res_31 = game.createCode(10, 9, true);		
		assertArrayEquals(res_31, testCode);
		
		int[] res_32 = game.createCode(11, 4, true);		
		assertArrayEquals(res_32, testCode);
		
		int[] res_33 = game.createCode(11, 5, true);		
		assertArrayEquals(res_33, testCode);
		
		int[] res_34 = game.createCode(11, 8, true);		
		assertArrayEquals(res_34, testCode);			
		
		// Allow Duplicates = false
		//Equivalent Partition -inf to 3,4 -> Invalid input	
		int[] res_35 = game.createCode(-23, -40, false);
		assertArrayEquals(res_35, testCode);
		
		int[] res_36 = game.createCode(-1, -1, false);
		assertArrayEquals(res_36, testCode);
		
		int[] res_37 = game.createCode(0, 0, false);
		assertArrayEquals(res_37, testCode);
		
		int[] res_38 = game.createCode(2, 2, false);
		assertArrayEquals(res_38, testCode);		
		
		int[] res_39 = game.createCode(3, 4, false);		
		assertArrayEquals(res_39, testCode);		
		
		//Equivalent Partition 4,5 to 8,8 (while length < colors) -> valid input
		int[] res_40 = game.createCode(4, 5, false);		
		assertThat(res_40, not(testCode));		
		
		int[] res_41 = game.createCode(5, 6, false);		
		assertThat(res_41, not(testCode));		
		
		int[] res_42 = game.createCode(7, 7, false);		
		assertThat(res_42, not(testCode));		
		
		int[] res_43 = game.createCode(8, 8, false);		
		assertThat(res_43, not(testCode));
		
		//Equivalent Partition 9,8 to 10,8 -> invalid input
		int[] res_44 = game.createCode(9, 8, false);		
		assertArrayEquals(res_44, testCode);
		
		int[] res_61 = game.createCode(10, 8, false);		
		assertArrayEquals(res_61, testCode);
		
		//Equivalent Partition 10,8 to inf -> invalid input
		int[] res_45 = game.createCode(11, 9, false);		
		assertArrayEquals(res_45, testCode);		
		
		int[] res_46 = game.createCode(20, 18, false);		
		assertArrayEquals(res_46, testCode);	
		
		//More Possible problematic combinations
		int[] res_47 = game.createCode(3, 5, false);		
		assertArrayEquals(res_47, testCode);
		
		int[] res_48 = game.createCode(3, 8, false);		
		assertArrayEquals(res_48, testCode);
		
		int[] res_49 = game.createCode(3, 9, false);		
		assertArrayEquals(res_49, testCode);
		
		int[] res_50 = game.createCode(4, 4, false);		
		assertArrayEquals(res_50, testCode);
		
		int[] res_51 = game.createCode(4, 5, false);		
		assertThat(res_51, not(testCode));
		
		int[] res_52 = game.createCode(4, 8, false);		
		assertThat(res_52, not(testCode));	
		
		int[] res_53 = game.createCode(4, 9, false);		
		assertArrayEquals(res_53, testCode);
		
		int[] res_54 = game.createCode(10, 4, false);		
		assertArrayEquals(res_54, testCode);
		
		int[] res_55 = game.createCode(10, 5, false);		
		assertArrayEquals(res_55, testCode);	
		
		int[] res_57 = game.createCode(10, 9, false);		
		assertArrayEquals(res_57, testCode);
		
		int[] res_58 = game.createCode(11, 4, false);		
		assertArrayEquals(res_58, testCode);
		
		int[] res_59 = game.createCode(11, 5, false);		
		assertArrayEquals(res_59, testCode);
		
		int[] res_60 = game.createCode(11, 8, false);		
		assertArrayEquals(res_60, testCode);	
		
	}

	
	@Test
	public void testCompareCodes() {		
		
		//Initialize a game with valid options and allowing duplicates 		
		Game game = new Game(6,8, 10, true);
		
		// For each test, initializa an array of int which will be the result of comparing the usercode and the code to break
		// This one will be tested with our manually added result		
		// array indicates number of: {Correct, Wrong Position, Wrong Number}
		
		// And 2 arrays for the codes to be compared with the method to get the array of comparison we want to test
		
		// Duplicates allowed
		// Need to check that duplicates aren't counted more than they should
		int[] compared0 = {0,0,6};			
		int[] testCode0_0 = {6,6,6,6,6,6};	
		int[] testCode0_1 = {1,1,1,1,1,1};
		int[] res_0 = game.compareCodes(testCode0_0, testCode0_1);		
		assertArrayEquals(res_0, compared0);
		
		int[] compared1 = {6,0,0};		
		int[] testCode1_0 = {6,1,6,5,6,3};	
		int[] testCode1_1 = {6,1,6,5,6,3};
		int[] res_1 = game.compareCodes(testCode1_0, testCode1_1);		
		assertArrayEquals(res_1, compared1);
		
		int[] compared2 = {0,6,0};		
		int[] testCode2_0 = {1,2,3,4,5,6};	
		int[] testCode2_1 = {6,5,4,3,2,1};
		int[] res_2 = game.compareCodes(testCode2_0, testCode2_1);		
		assertArrayEquals(res_2, compared2);
		
		int[] compared3 = {3,3,0};		
		int[] testCode3_0 = {3,5,4,2,7,6};	
		int[] testCode3_1 = {3,7,4,5,2,6};
		int[] res_3 = game.compareCodes(testCode3_0, testCode3_1);		
		assertArrayEquals(res_3, compared3);
		
		int[] compared4 = {3,0,3};		
		int[] testCode4_0 = {1,2,3,4,5,6};	
		int[] testCode4_1 = {1,2,3,3,2,1};
		int[] res_4 = game.compareCodes(testCode4_0, testCode4_1);		
		assertArrayEquals(res_4, compared4);
		
		int[] compared5 = {0,3,3};		
		int[] testCode5_0 = {1,2,3,4,5,6};	
		int[] testCode5_1 = {2,1,5,1,1,1};
		int[] res_5 = game.compareCodes(testCode5_0, testCode5_1);		
		assertArrayEquals(res_5, compared5);
		
		int[] compared6 = {2,2,2};		
		int[] testCode6_0 = {1,2,3,4,5,6};	
		int[] testCode6_1 = {1,2,4,3,7,8};
		int[] res_6 = game.compareCodes(testCode6_0, testCode6_1);		
		assertArrayEquals(res_6, compared6);
		
		int[] compared14 = {2,4,0};		
		int[] testCode14_0 = {2,2,3,3,5,6};	
		int[] testCode14_1 = {5,2,6,3,2,3};
		int[] res_14 = game.compareCodes(testCode14_0, testCode14_1);		
		assertArrayEquals(res_14, compared14);
		
		// Duplicates disallowed		
		Game game2 = new Game(6,8, 10, false);
		
		int[] compared7 = {0,4,2};		
		int[] testCode7_0 = {1,2,3,4,5,6};	
		int[] testCode7_1 = {8,7,4,3,2,1};
		int[] res_7 = game2.compareCodes(testCode7_0, testCode7_1);		
		assertArrayEquals(res_7, compared7);
		
		int[] compared8 = {2,4,0};		
		int[] testCode8_0 = {6,1,8,5,7,3};	
		int[] testCode8_1 = {6,1,5,8,3,7};
		int[] res_8 = game2.compareCodes(testCode8_0, testCode8_1);		
		assertArrayEquals(res_8, compared8);
		
		int[] compared9 = {2,2,2};		
		int[] testCode9_0 = {1,2,3,4,5,6};	
		int[] testCode9_1 = {1,2,4,3,8,7};
		int[] res_9 = game2.compareCodes(testCode9_0, testCode9_1);		
		assertArrayEquals(res_9, compared9);
		
		int[] compared10 = {4,0,2};		
		int[] testCode10_0 = {3,5,4,2,7,6};	
		int[] testCode10_1 = {3,5,4,2,1,8};
		int[] res_10 = game2.compareCodes(testCode10_0, testCode10_1);		
		assertArrayEquals(res_10, compared10);
		
		int[] compared11 = {4,2,0};		
		int[] testCode11_0 = {1,2,3,4,5,6};	
		int[] testCode11_1 = {1,2,3,4,6,5};
		int[] res_11 = game2.compareCodes(testCode11_0, testCode11_1);		
		assertArrayEquals(res_11, compared11);
		
		int[] compared12 = {1,3,2};		
		int[] testCode12_0 = {1,2,3,4,5,6};	
		int[] testCode12_1 = {1,3,4,2,7,8};
		int[] res_12 = game2.compareCodes(testCode12_0, testCode12_1);		
		assertArrayEquals(res_12, compared12);
		
		int[] compared13 = {1,4,1};		
		int[] testCode13_0 = {1,2,3,4,5,6};	
		int[] testCode13_1 = {1,3,4,5,2,8};
		int[] res_13 = game2.compareCodes(testCode13_0, testCode13_1);		
		assertArrayEquals(res_13, compared13);

		
	}
	
	@Test
	public void testValidCode() {
		Game game = new Game();					
		
		// Length 4-10, Colors 5-8, Duplicates True/False
		
		//Invalid Options Valid Codes Test		
		//Equivalent Partition -inf to 3,4 -> invalid code
		int[] testCode22 = {-1};		
		boolean res_22 = game.validCode(testCode22, -12, -14, true);		
		assertFalse(res_22);
		
		int[] testCode23 = {-1};		
		boolean res_23 = game.validCode(testCode23, -1, -1, true);		
		assertFalse(res_23);
		
		int[] testCode0 = {-1};		
		boolean res_0 = game.validCode(testCode0, 0, 0, true);		
		assertFalse(res_0);
		
		int[] testCode1 = {-1};		
		boolean res_1 = game.validCode(testCode1, 2, 2, true);		
		assertFalse(res_1);
		
		int[] testCode2 = {-1};		
		boolean res_2 = game.validCode(testCode2, 3, 4, true);		
		assertFalse(res_2);
		
		//Equivalent Partition 4,5 to 10,8 -> valid code
		int[] testCode3 = {2,2,3,5};		
		boolean res_3 = game.validCode(testCode3, 4, 5, true);		
		assertTrue(res_3);
		
		int[] testCode4 = {2,2,3,3,6};		
		boolean res_4 = game.validCode(testCode4, 5, 6, true);		
		assertTrue(res_4);
		
		int[] testCode5 = {2,2,3,3,6,6,7};	
		boolean res_5 = game.validCode(testCode5, 7, 7, true);		
		assertTrue(res_5);
		
		int[] testCode6 = {1,2,2,3,3,6,7,7,7};		
		boolean res_6 = game.validCode(testCode6, 9, 7, true);		
		assertTrue(res_6);
		
		int[] testCode7 = {2,2,3,3,6,7,8,8,8,8};		
		boolean res_7 = game.validCode(testCode7, 10, 8, true);		
		assertTrue(res_7);
		
		//Equivalent Partition 11,9 to inf -> invalid code
		int[] testCode8 = {-1};		
		boolean res_8 = game.validCode(testCode8, 11, 9, true);		
		assertFalse(res_8);
		
		int[] testCode9 = {-1};		
		boolean res_9 = game.validCode(testCode9, 23, 34, true);		
		assertFalse(res_9);
		
		
		//Equivalent Partition Same options different codes	-> valid code
		int[] testCode10 = {5,5,5,5,5};		
		boolean res_10 = game.validCode(testCode10, 5, 5, true);		
		assertTrue(res_10);
		
		int[] testCode11 = {1,2,3,4,5};		
		boolean res_11 = game.validCode(testCode11, 5, 5, false);		
		assertTrue(res_11);
		
		
		//Equivalent Partition Valid Options Invalid Code Test	-> invalid code (wrong length, colors or duplicates)
		int[] testCode17 = {1,2,3,4,5,6};		
		boolean res_17 = game.validCode(testCode17, 4, 5, true);		
		assertFalse(res_17);
		
		int[] testCode18 = {1,2,3,4,5,6};		
		boolean res_18 = game.validCode(testCode18, 5, 6, true);		
		assertFalse(res_18);
		
		int[] testCode19 = {-1,0,1,5,7,8,9};		
		boolean res_19 = game.validCode(testCode19, 7, 7, true);		
		assertFalse(res_19);
		
		int[] testCode20 = {1,2,3};		
		boolean res_20 = game.validCode(testCode20, 9, 7, true);		
		assertFalse(res_20);
		
		int[] testCode21 = {-1,0,1,5,5,7,8,9};		
		boolean res_21 = game.validCode(testCode21, 10, 8, false);		
		assertFalse(res_21);		

	}

}
