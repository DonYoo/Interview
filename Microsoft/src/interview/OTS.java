package interview;

import java.util.*;

/**
 * 
 * @author DonYoo
 *
 *

process time : O(n)
space : O(1)


 */


public class OTS {

	public static String lookandsee(String input){
		String answer = "";
		
		String [] inputArray = input.split("");
		
		for(int i =0; i<inputArray.length; i++){
			int count = 1;
			String current = inputArray[i];
			
			i++; // pointer for next one
			
			// if the current is same as next one.
			if(i<inputArray.length &&
					inputArray[i].equals(current)){
				count++;
				i++; // if is the same value, go to next point
			}
			i--; // return the pointer.
			answer += count + current;
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String one = "1";
		String two = "11";
		String three = "21";
		String four = "3113";
		
		System.out.println(lookandsee(four));		
	}

}
