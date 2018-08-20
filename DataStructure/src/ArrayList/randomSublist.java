package ArrayList;

import java.util.Random;

/**
 * 
 * @author DonYoo

https://www.geeksforgeeks.org/google-interview-experience-set-7-software-engineering-intern/

In this phone interview I was given one question.

Question: Write a function that takes a list L and returns a random sublist of size N of that list. Assume that the indexes must be in increasing order. That is, you cannot go backwards.

Example:

L = [1, 2, 3, 4, 5]
N = 3

The function should return one of these lists:

[1, 2, 3]
[1, 2, 4]
[1, 2, 5]
[1, 3, 4]
[1, 3, 5]
[1, 4, 5]
[2, 3, 4]
[2, 3, 5]
[2, 4, 5]
[3, 4, 5]

 */

public class randomSublist {

	// this will generates a random integer between 5 (inclusive) and 10 (inclusive).
	
	public static int getRandomRanged(int min, int max){
		Random ran = new Random();

		int result = ran.nextInt((max - min) + 1) + min;
		
		return result;
	}
	
	private static String randomlist(int[] input, int n){
		
		int size = input.length;
		String result = "";
		int index = 0;
		int arrIndex = 0;
		
		for(int i=n; i>0; i--){
			int ranInt = getRandomRanged(arrIndex, size-i);
			arrIndex = ranInt+1;
			
			result += input[ranInt] + " ";
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5};
		int n =3;
		
		
		System.out.println(randomlist(input, n));
	}
}
