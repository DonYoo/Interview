package ArrayList;

/**
 * 
 * @author DonYoo
 * 

https://www.geeksforgeeks.org/google-interview-experience-set-7-software-engineering-intern/

Question 1: Given a string A consisting of n characters and a string B consisting of m characters, write a function that will return the number of times A must be stated such that B is a substring of the repeated A. If B can never be a substring, return -1.

Example:
A = ‘abcd’
B = ‘cdabcdab’
The function should return 3 because after stating A 3 times, getting ‘abcdabcdabcd’, B is now a substring of A.

You can assume that n and m are integers in the range [1, 1000].

 */


public class Substring {

	
	public static int isSubstring(String a, String b){
		int aSize = a.length();
		int bSize = b.length();
		
		int limit = bSize/aSize +1;
		
		String state = a;
		
		for(int i=0; i<limit; i++){
			if(state.indexOf(b) != -1){
				return i+1;
			}
			state = state.concat(a);
		}
		return -1;
	}
	public static void main(String[] args) {
		String a = "abcd";
		String b = "cdabcdab";
		
		System.out.println(isSubstring(a,b));
				
	}

}
