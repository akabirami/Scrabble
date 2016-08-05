package scrabble;

import java.util.ArrayList;

public class Rack {

	private ArrayList<Tile> rack;
	private static int score = Integer.MIN_VALUE;
	
	public Rack(ArrayList<Tile> rack) {
		this.rack = rack;
	}
	

	int getScore(int[] data) {
		int score = 0;
		
		
		return score;
	}
	 
	void combinationUtil(int arr[], int data[], int start, int end, int index, int r)  {
	        // Current combination is ready to be printed, print it
	        if (index == r) {
	        	score = Integer.max(score, getScore(data));
	        	return;
	        }
	        for (int i=start; i<=end && end-i+1 >= r-index; i++)  {
	            data[index] = arr[i];
	            combinationUtil(arr, data, i+1, end, index+1, r);
	        }
	    }
		 
		void getMax(int arr[], int n, int r) 	{
		    int data[]=new int[r];
		    ArrayList<Tile> substr = new ArrayList<Tile>();
		    ArrayList<Integer> score = new ArrayList<Integer>();
		    combinationUtil(arr, data, 0, n-1, 0, r);
		}
		
		
		public int getScore() {
			int score = 0;
			
			return score;
		}
	private String getString() {
		String s = "";
		for(Tile t: rack) {
			s += String.valueOf(t.character);
		}
		return s;
	}
	
	private static void permutation(String str) {
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
		
	public int maxValue() {
		String seq = getString();
		int score = 0;
		
		return score;
	}
}
