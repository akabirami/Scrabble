package scrabble;

public class Tile {
	
	private char character;
	
	private static final int[] CHARACTER_VALUE  = new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 1, 5, 4, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
		
	public Tile(char character){
		this.character = character;	
	}
	
	public int getValue(){
		return CHARACTER_VALUE[(int)(this.character) - 65];
	}
	
}