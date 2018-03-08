/**
 * Square class
 * 
 * Class for the squares of the Board, contains variables and their setters/getters
 * tab indicates if there is a tab in the square or not
 * color indicates the color of the tab
 * inTablero indicates if the Square is out of bounds or within the Board
 */
public class Square {
	
	private boolean tab;
	private boolean color;
	private boolean inTablero;
	
	public Square(boolean tablero){
		this.tab=false;
		this.color=false;
		this.inTablero=tablero;
	}
	
	/**
	 * Setter for the variable tab
	 */
	public void setTab(boolean tabs){
		this.tab=tabs;
	}
	
	/**
	 * Setter for the variable color
	 */
	public void setColor(boolean colors){
		this.color=colors;
	}
	
	/**
	 * Setter for the variable inTablero
	 */
	public void setInTablero(boolean tablero){
		this.inTablero=tablero;
	}
	
	/**
	 * Getter for the variable color
	 * @return color
	 */
	public boolean getTab(){
		return this.tab;
	}

	/**
	 * Getter for the variable color
	 * @return color
	 */
	public boolean getColor(){
		return this.color;
	}
	
	/**
	 * Getter for the variable inTablero
	 * @return inTablero
	 */
	public boolean getInTablero(){
		return this.inTablero;
	}
	
	
	
}
