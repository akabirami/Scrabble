package scrabble;

import java.util.ArrayList;

public class Tile {
	
	private char character;
	private ArrayList<Character> matches;
	
	private static final int[] CHARACTER_VALUE  = new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 1, 5, 4, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
		
	public Tile(char character){
		this.character = character;
		matches = new ArrayList<Character>();
		if(this.character == '-') {
			for(char c='A'; c<'Z'; c++) {
				matches.add(new Character(c));
			}
		} else {
			matches.add(new Character(this.character));
		}
	}
	
	public char getChar() {
		return this.character;
	}
	
	public ArrayList<Character> getMatchChars() {
		return this.matches;
	}
	
	public static int getVal(char c){
		System.out.println(c);
		if(c>='a' && c<='z') c = (char)(c - 'a' + 'A');
		System.out.println((int)(c)- 65);
		return CHARACTER_VALUE[(int)(c)- 65];
	}
	
	public int getValue(){
		System.out.println(this.character);
		System.out.println((int)(this.character) - 65);
		return CHARACTER_VALUE[(int)(this.character) - 65];
	}
	
}