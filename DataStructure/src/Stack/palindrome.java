package Stack;

import java.util.*;

/**
 * 
 * @author DonYoo

https://www.geeksforgeeks.org/longest-possible-chunked-palindrome/

Longest Possible Chunked Palindrome
Given a string, the task is to return the length of its longest possible chunked palindrome. It means a palindrome formed by substring in the case when it is not formed by characters of the string. For better understanding look at the example

Examples:

Input : ghiabcdefhelloadamhelloabcdefghi 
Output : 7
(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)

Input : merchant
Output : 1
(merchant)

Input : antaprezatepzapreanta
Output : 11
(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)

Input : geeksforgeeks
Output : 3
(geeks)(for)(geeks)


O(n) time complexity

 */


public class palindrome {
	
	/*
	 * check the first char and look for the match starting from last index.
	 */
	private static boolean look(char first, Stack<Character> stack){
		String one = ""+first;
		String two = "";
		
		while(!stack.isEmpty()){
			
			// keep add value in front for the second value.
			two = String.valueOf(stack.pop()) + two;

			if(one.equals(two)){
				return true;
			}
			
			// poll since its not match.
			if(!stack.isEmpty())
				// keep add value in last for the first value.
				one+=stack.remove(0);
		}
		return false;
	}
	
	private static int LPC(String str){
		
		Stack<Character> stack = new Stack<>();
		
		int size = str.length();
		
		// if str size is 1 return 1;
		if(size ==1){
			return 1;
		}
		
		// put all them in stack
		for(int i=0; i<size; i++){
			stack.add(str.charAt(i));
		}
		
		int count = 1;
		
		while(!stack.isEmpty()){
			// get first char
			char first = stack.remove(0);
			if(look(first, stack)){
				count +=2;
			}
		}
		return count;
	}

	public static void main(String[] args) {

	    System.out.println("V : " + LPC("V"));
	    System.out.println("VOLVO : " + LPC("VOLVO"));
	    System.out.println("VOLVOV : " + LPC("VOLVOV"));
	    System.out.println("ghiabcdefhelloadamhelloabcdefghi : " +
	                    LPC("ghiabcdefhelloadamhelloabcdefghi"));
	 
        System.out.println("ghiabcdefhelloadamhelloabcdefghik : " +
                    LPC("ghiabcdefhelloadamhelloabcdefghik"));
 
        System.out.println("antaprezatepzapreanta : " +
                    LPC("antaprezatepzapreanta"));

	}

}
