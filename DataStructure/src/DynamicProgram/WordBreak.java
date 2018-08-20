package DynamicProgram;

import java.util.*;

/**
 * 
 * @author DonYoo
 
https://practice.geeksforgeeks.org/problems/word-break/0

Dynamic Program

Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.

Consider the following dictionary
{ i, like, sam, sung, samsung, mobile, ice,
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung" or "i like sam sung".

Input:
First line is integer T denoting number of test cases. 1<=T<=100.
Every test case has 3 lines.
First line is N number of words in dictionary. 1<=N<=12.
Second line contains N strings denoting the words of dictionary. Length of each word is less than 15.
Third line contains a string S of length less than 1000.

Output:
Print 1 is possible to break words, else print 0.

Example:
Input:
2
12
i like sam sung samsung mobile ice cream icecream man go mango
ilike
12
i like sam sung samsung mobile ice cream icecream man go mango
idontlike
Output:
1
0

Big(O)

time O(n)
space O(n)

 */

public class WordBreak {
	static Scanner sc;
	
	static HashMap<String, Integer> map;

	
	static boolean Possible(String word){
		if(map.containsKey(word)){
			return true;
		}

		int size = Math.min(word.length(), 15);
		
		for(int j=0; j<size; j++){
			String temp = word.substring(0, j);
			if(map.containsKey(temp)){
				if(Possible(word.substring(j))){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int i=0; i<testcase; i++){
			int noDictionary = sc.nextInt();
			sc.nextLine();
			String temp = sc.nextLine();
			String[] segment = temp.split(" ");
			map = new HashMap<>();
			for(int j=0; j<noDictionary; j++){
				map.put(segment[j], 1);			
			}
			String word = sc.nextLine();
			System.out.println(Possible(word) ? 1:0);
		}
	}

}
