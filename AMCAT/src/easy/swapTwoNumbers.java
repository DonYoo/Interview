package easy;

import java.util.*;

/**
 * 
 * 
 * @author DonYoo

http://prepinsta.com/amcat-automata-questions/

Write a program to swap two numbers without using third variable,

 */


public class swapTwoNumbers {

	static Scanner scan;
	
	private static String swap(int first, int second){
		first = first + second;
		second = first - second;
		first = first -second;

		String third = first + " " + second;
		return (third);
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int first = scan.nextInt();
		int second = scan.nextInt();
		
		System.out.println(first + " " + second);
		System.out.println(swap(first, second));
	}
}
