package HashTables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author DonYoo
 *

HashMap

Process O(1),
Space O(n)


https://practice.geeksforgeeks.org/problems/finding-the-numbers/0

You are given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the other two number occur exactly once and are distinct. You need to find the other two numbers and print them in ascending order.

Input :
The first line contains a value T, which denotes the number of test cases. Then T test cases follow .The first line of each test case contains a value N. The next line contains 2*N+2 space separated integers.

Output :
Print in a new line the two numbers in ascending order.

Constraints :
1<=T<=100
1<=N<=10^6
1<=A[i]<=5*10^8

Example:
Input :
2
2
1 2 3 2 1 4
1
2 1 3 2

Output :
3 4
1 3

process O(n)
space O(n)
 */

public class FindingtheNumber {

	static Scanner s;
	
	public static void findnum(int[] input){
		Map<Integer, Integer> base = new HashMap<Integer, Integer>();
		int [] result = new int[2];
		int index =0;
		
		for(int i=0; i<input.length; i++){
			int key = input[i];
			if(base.containsKey(key)){
				int value = base.get(key);
				base.replace(key, ++value);
			}
			else{
				base.put(key, 1);
			}
		}
		
		// get value from the key.
		for(int key:base.keySet()){
			if(base.get(key)%2 != 0){
				result[index++] = key;
			}
		}
		Arrays.sort(result);
		System.out.println(result[0] +" " + result[1]);
	}
	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		
		int testcase = s.nextInt();
		
		for(int i=0; i<testcase; i++){
			int numinput = s.nextInt() * 2 + 2;
			
			int [] input = new int[numinput];
			for(int j=0; j<numinput; j++){
				input[j] = s.nextInt();
			}
			findnum(input);
		}
	}
}
