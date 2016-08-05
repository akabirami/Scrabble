package scrabble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rack {

	private ArrayList<Tile> rack;
	private static String str = "";
	private static int score = Integer.MIN_VALUE;
	private static Map<String, String> anagram;

	public Rack(String s) {
		rack = new ArrayList<Tile>();
		for (int i = 0; i < s.length(); i++) {
			Tile tile = new Tile(s.charAt(i));
			this.rack.add(tile);
		}
	}
	
	public String getMatch() {
		return this.str;
	}
	
	private static String sortLetters(String strLine) {
		// TODO Auto-generated method stub
		char[] chars = strLine.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars).toLowerCase();
		return sorted;
	}

	private ArrayList<String> getStrings(int[] indices, int r) {
		ArrayList<String> st = new ArrayList<String>();
		StringBuilder s = new StringBuilder();
		for(int i=0; i<r; i++) {
			ArrayList<Character> chs = this.rack.get(indices[i]).getMatchChars();
			for(char c : chs) {
				s.insert(i, c);
				st.add(sortLetters(s.toString()));
			}
		}
		return st;
	}
	
	private int getScore(int[] indices, int r) {
		int score = 0;
		ArrayList<String> st = getStrings(indices, r);
//		for(String s: st) {
//			System.out.print(s+" ");
//		}
		System.out.println();
		for(String s: st) {
//			System.out.println(s);
			if(this.anagram.containsKey(s)) {
				for (int i = 0; i < indices.length; i++) {
					score += rack.get(indices[i]).getValue();
				}
				this.str = s;
				return score;
			}
		}
		return Integer.MIN_VALUE;
	}

	private void getSubScore(int arr[], int data[], int start, int end, int index, int r) {
		// Current combination is ready to be printed, print it
		if (index == r) {
//			System.out.println(getString(data, r));
			score = Integer.max(score, getScore(data, r));
		}
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			getSubScore(arr, data, i + 1, end, index + 1, r);
		}
	}

	int getMaxScore() {
		int arr[] = { 0, 1, 2, 3, 4, 5, 6 };
		int data[] = new int[7];
		createAnagramMap();
		for (int r = 7; r >= 1; r--) {
			getSubScore(arr, data, 0, 6, 0, r);
			if (score != Integer.MIN_VALUE)
				return score;
		}
		return score;
	}

	private void createAnagramMap() {		
		anagram = AnagramUtil.getMapOfWords();
	}
}
