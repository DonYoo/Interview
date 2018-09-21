package easy;

import java.util.*;

/**
 * 
 * @author DonYoo

http://prepinsta.com/amcat-automata-questions/

Write a program to find the GCD of two Integers.

 */

public class GCD {
	
	static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int first = scan.nextInt();
		int second = scan.nextInt();
		
		int shortOne = Math.min(first, second);
		int half = shortOne/2;
		int result = 1;
		
		for(int i = half; i>1; i--){
			if( (first%i == 0) && (second%i == 0 ) ){
				result = half;
				break;
			}
		}
		System.out.println("this is GCD " + result);
	}

}
