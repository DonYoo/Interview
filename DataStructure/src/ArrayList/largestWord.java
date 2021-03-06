package ArrayList;

import java.util.*;

/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/find-largest-word-in-dictionary/0

Giving a dictionary and a string �str�, your task is to find the longest string in dictionary of size x which can be formed by deleting some characters of the given �str�.

Examples:

Input : dict = {"ale", "apple", "monkey", "plea"}   
        str = "abpcplea"  
Output : apple

Input  : dict = {"pintu", "geeksfor", "geeksgeeks", 
                                        " forgeek"} 
         str = "geeksforgeeks"
Output : geeksgeeks


Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an integer x denoting the no of words in the dictionary. Then in the next line are x space separated strings denoting the contents of the dictionary.  Then in the next line is a string 'str'.

Output:
For each test case in a new line print the required output.

Constraints:
1<=T<=100
1<=x, length of str<=1000

Example:
Input:
2
4
ale apple monkey plea
abpcplea
4
pintu geeksfor geeksgeeks forgeek
geeksforgeeks
Output:
apple
geeksgeeks

Big(O)

time :
space : 

 */

public class largestWord {

	static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		for(int i =0; i<testcase; i++){
			int inputsize = sc.nextInt();
			sc.nextLine();
			String vocab = sc.nextLine();
			String [] dict = vocab.split(" ");
			String input = sc.nextLine();
			int longest = 0;
			String answer = "";
			
			// itherate through each dict.
			for(int j=0; j<inputsize; j++){
				int size = 0;
				String each = dict[j];
				String temp = input;
				
				// iterate through single word.
				for(int k=0; k<each.length(); k++){
					// check if char is exist.
					int index = temp.indexOf(each.charAt(k));
					if(index !=-1){
						size++;
						// index to next
						temp = temp.substring(index);
					}
				}
				if(size > longest){
					longest = size;
					answer = each;
				}
			}
			System.out.println(answer);
		}
	}
}
