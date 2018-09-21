package Recursion;
import java.util.*;

/**
 * 
 * @author DonYoo

https://www.geeksforgeeks.org/alphanumeric-abbreviations-of-a-string/

 Given a string of characters of length less than 10. We need to print all the alpha-numeric abbreviation of the string.

The alpha-numeric abbreviation is in the form of characters mixed with the digits which is equal to the number of skipped characters of a selected substring. So, whenever a substring of characters is skipped, you have to replace it with the digit denoting the number of characters in the substring. There may be any number of skipped substrings of a string. No two substrings should be adjacent to each other. Hence, no two digits are adjacent in the result. For a clearer idea, see the example.

Examples:

Input : ANKS 
Output :
ANKS (nothing is replaced)
ANK1 (S is replaced) 
AN1S (K is replaced)
AN2  (KS is replaced)
A1KS (N is replaced)
A1K1 (N and S are replaced)
A2S (NK is replaced)
A3 (NKS is replaced)
1NKS (A is replaced)
1NK1 (A and S are replaced)
1N1S (A and N is replaced)
1N2 (A and KS are replaced)
2KS (AN is replaced)
2K1 (AN and S is replaced)
3S (ANK is replaced)
4 (ANKS is replaced)

Input : ABC
Output : 
ABC
AB1 
A1C 
A2 
1BC 
1B1 
2C 
3
Note: 11C is not valid because no two digits should be adjacent, 
2C is the correct one because AB is a substring, not A and B individually


 */

public class abbreviations {

	
	private static void get_abbreviations(String str, String answer){
		int size = str.length();
		

		if(size == 0){
			System.out.println(answer);
			return;
		}
		
		char first = str.charAt(0);
		String nextStr = str.substring(1);
		
		// start with original value
		get_abbreviations(nextStr, answer + first);
		
		// if answer is empty.
		if(answer.isEmpty()){
			get_abbreviations(nextStr, answer+"1");
			return;
		}
		
		char last = answer.charAt(answer.length()-1);
		
		// if prev value was a number add 1.
		if(Character.isDigit(last)){
			int number = Integer.parseInt(String.valueOf(last));
			number++;
			char newlast = (char)(number+'0');
			get_abbreviations(nextStr, answer.replace(last, newlast));
		}
		else{
			get_abbreviations(nextStr, answer+"1");
		}
		return;
	}
	
	public static void main(String[] args) {
		String str = "ABC";
		String answer = "";
	    get_abbreviations(str, answer);
	}

}
