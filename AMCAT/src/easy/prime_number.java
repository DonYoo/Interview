package easy;

import java.util.*;

/**
 * 
 * @author DonYoo

http://prepinsta.com/amcat-automata-questions/

Print all the prime numbers which are below the given number separated by comma

Input: 50

output: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47


 */

public class prime_number {

	static Scanner scan;
	
	private static boolean isPrime(int i){
		int [] lookup = {2,3,5,7};
		
		for(int k: lookup){
			if(i%k == 0){
				return false;
			}
		}
		return true;
	}
	
	private static void printPrime(int input){
		
		if(input > 2){
			System.out.print(2);
		}
		if(input > 3){
			System.out.print(", "+3);
		}
		if(input > 5){
			System.out.print(", "+5);
		}
		if(input > 7){
			System.out.print(", "+7);
		}
		
		for(int i = 11; i < input; i=i+2){
			if(isPrime(i)){
				System.out.print(", " + i);
			}
		}
			
		
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		
		printPrime(input);
	}

}
