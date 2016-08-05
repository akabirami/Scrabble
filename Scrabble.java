package scrabble;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Scrabble {
		
		public static void main(String[] args) {
			String S;
			int noOfTestCases;
			Scanner sc = new Scanner(System.in);
			noOfTestCases = sc.nextInt();
			for(int i = 1; i <= noOfTestCases; i++) {
				String input = sc.next();
				Rack rack = new Rack(input);
				System.out.println(rack.getMaxScore());
			}
	}

}