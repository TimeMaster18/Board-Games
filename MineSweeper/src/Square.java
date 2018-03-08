
public class Square {
	
	private boolean mined;
	private boolean open;
	private boolean marked;
	private int numAdjacentMines;
	
	public Square() {
		mined=false;
		open=false;
		marked=false;
		numAdjacentMines=0;
	}
	
	public boolean isMined(){
		return this.mined;
	}
	
	public boolean isMarked(){
		return this.marked;
	}
	
	public boolean isOpen(){
		return this.open;
	}
	
	public int getNumAdjacentMines(){
		return this.numAdjacentMines;
	}
	
	
	public void setMined(boolean mined){
		this.mined=mined;
	}
	
	public void setMarked(boolean marked){
		this.marked=marked;
	}

	public void setOpen(boolean open){
		this.open=open;
	}

	public void setNumAdjacentMines(int numAdjacentMines){
		this.numAdjacentMines=numAdjacentMines;
	}

	public boolean Equals(Square square) {
		boolean result = true;
		if(!(this.mined == square.isMined()) || !(this.open == square.isOpen()) ||
				!(this.marked == square.isMarked()) || !(this.numAdjacentMines == square.getNumAdjacentMines())) {
			result = false;
		}
			
		return result;
	}
}
