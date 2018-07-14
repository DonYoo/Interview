package Recursion;

import java.util.Scanner;

/**
 * 
 * @author DonYoo
 *
 *

understand of recursion
https://www.codecademy.com/en/forum_questions/4f6274f6d1351500030012a0


https://practice.geeksforgeeks.org/problems/maximum-index/0

Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

Example :

A : [3 5 4 2]

Output : 2 
for the pair (3, 4)

 

Input:

The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.


Output:

Print the maximum difference of the indexes i and j in a separtate line.

Example:

Input
1
2
1 10
Output
1

For Input:
1
7
3 4 2 2 2 5 3
Output of Online Judge is:
6

 */

public class Maximum_Index {

	static Scanner s;
	public static int max_index(int [] input, int index, int max){
		
		if(index <= max){
			return max;
		}
		for(int i=0; i<index; i++){
			if(input[i] <= input[index]){
				if(max < (index-i)){
					max = index-i;
					break;
				}
			}
		}
		return max_index(input, index-1, max);
	}
	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		
		int testcase = s.nextInt();
		
		for(int i=0; i<testcase; i++){
			int numinput = s.nextInt();
			int [] input = new int [numinput];
			
			for(int j=0; j<numinput; j++){
				input[j] = s.nextInt();
			}
			System.out.println(max_index(input, input.length-1, 0));
		}
	}

}