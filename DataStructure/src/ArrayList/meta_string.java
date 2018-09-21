package ArrayList;

import java.util.*;

/**
 * 
 * @author DonYoo


https://practice.geeksforgeeks.org/problems/meta-strings/0


Given two strings, the task is to check whether these strings are meta strings or not. Meta strings are the strings which can be made equal by exactly one swap in any of the strings. Equal string are not considered here as Meta strings.

Examples:

Input : A = "geeks" 
        B = "keegs"
Output : 1
By just swapping 'k' and 'g' in any of string, 
both will become same.

Input : A = "rsting"
        B = "string
Output : 0


Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line denoting string A and the second line denoting string B.

Output:
For each test case in a new line print 1 if A and B are meta strings, else print 0.

Constraints:
1<=T<=100
1<=Length of strings<=1000

Example:
Input:
2
geeks
keegs
geeks
geeks

Output:
1
0


geekks
keegks


keekggs
geekgks


 */

public class meta_string {
	
	public static Scanner scan;

	
	private static int meta(String first, String second){
		int size = first.length();
		int swap = 0;
		
		char prvf = '\n';
		char prvs = '\n';
		
		for(int i =0; i<size; i++){
			
			char fst = first.charAt(i);
			char scd = second.charAt(i);
			
			
			// if the character doesnt match.
			if(fst != scd){

				swap++;
			
				// if there more than 2 different char
				if(swap > 2){
					return 0;
				}
				else if(swap == 2){
					if((prvf != scd) ||
							(prvs != fst)){
						return 0;
					}
				}
				else if(swap == 1){
					prvf = fst;
					prvs = scd;
				}
			}
		}
		if(swap == 2){
			return 1;
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int testcase = scan.nextInt();
		
		scan.nextLine();
		
		for(int i=0; i<testcase; i++){
			String first = scan.nextLine();
			String second = scan.nextLine();
			
			System.out.println(meta(first, second));
		}
	}

}
