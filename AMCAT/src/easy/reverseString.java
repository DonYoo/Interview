package easy;

import java.util.*;

/**
 * 
 * @author DonYoo
 * 

Write a program to reverse a string

Input: PrepInsta
Output: atsnIperP

 */


public class reverseString {

	static Scanner scan;
	
	private static char[] reverse(char[] split, int index, int size){
		
		if(size/2 == index){
			return split;
		}
		
		char temp = split[index];
		
		split[index] = split[size-index];
		split[size-index] = temp;
		
		
		return reverse(split, ++index, size);
	}
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		char[] split = input.toCharArray();

		System.out.println(reverse(split, 0, input.length()-1));
		
	}

}
