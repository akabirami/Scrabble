package scrabble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rack {

	private ArrayList<Tile> rack;
	private static int score = Integer.MIN_VALUE;
	private static Map<String, String> anagram;

	public Rack(String s) {
		ArrayList<Tile> rack = new ArrayList<Tile>();
		for (int i = 0; i < s.length(); i++) {
			Tile tile = new Tile(s.charAt(i));
			rack.add(tile);
		}
	}

	private int getScore(int[] index) {
		int score = 0;
		for (int i = 0; i < index.length; i++) {
			score += rack.get(i).getValue();
		}
		return score;
	}

	private void getSubScore(int arr[], int data[], int start, int end, int index, int r) {
		// Current combination is ready to be printed, print it
		if (index == r) {
			for (int i = 0; i < r; i++)
				System.out.print(data[i] + " ");
			System.out.println();
			// score = Integer.max(score, getScore(data));
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
