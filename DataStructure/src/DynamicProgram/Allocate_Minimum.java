package DynamicProgram;

import java.util.*;

/**
 * 
 * @author DonYoo


https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages/0

You are given N number of books. Every ith book has Pi number of pages. 
You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations, and print this minimum value. 

Each book will be allocated to exactly one student. Each student has to be allocated atleast one book.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see explanation for better understanding).

Input:

The first line contains 'T' denoting the number of testcases. Then follows description of T testcases:
Each case begins with a single positive integer N denoting the number of books.
The second line contains N space separated positive integers denoting the pages of each book.
And the third line contains another integer M, denoting the number of students.


Output:
For each test case, output a single line containing minimum number of pages each student has to read for corresponding test case.


Constraints:
1<= T <=70
1<= N <=50
1<= A [ i ] <=250
1<= M <=50

Example:
Input:
1
4
12 34 67 90
2

Output:
113

Explanation: Allocation can be done in following ways:

{12} and {34, 67, 90}     Maximum Pages = 191

{12, 34} and {67, 90}     Maximum Pages = 157

{12, 34, 67} and {90}     Maximum Pages = 113

Therefore, the minimum of these cases is 113, which is selected as output.

 */


public class Allocate_Minimum {
	static Scanner scan;
	static int[][] matrix;
	
	private static int sum(int[] input, int from, int to){
		
		int result = 0;
		
		for(int i=from; i<to; i++){
			result += input[i];
		}
		
		return result;
	}
	
	private static int allocate(int numberInput, int[] input, int student){
		
		matrix = new int[student +1][numberInput +1];
		
		// if there is only 1 student
		for(int i=1; i<=numberInput; i++){
			matrix[1][i] = sum(input, 0, i);
		}
		
		// if there is only 1 numberInput
		for(int i=1; i<=student; i++){
			matrix[i][1] = input[0];
		}
		
		for(int i=2; i<=student; i++){
			for(int j=2; j<=numberInput; j++){
				
				int min = Integer.MAX_VALUE;
				
				for(int each=1; each<=j; each++){
					// first half, 1 less student.
					// this is from previous check.
					int firsthalf = matrix[i-1][each];
					
					// get another half
					// each to j.
					int secondhalf = sum(input, each, j);
					
					int max = Math.max(firsthalf, secondhalf);
					
					min = Math.min(min, max);
				}
				matrix[i][j] = min;
			}
		}
		return matrix[student][numberInput];
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int testcase = scan.nextInt();
		
		for(int i=0; i<testcase; i++){
			int numberInput = scan.nextInt();
			
			int[] input = new int[numberInput];
			
			for(int j=0; j<numberInput; j++){
				input[j] = scan.nextInt();
			}
			int student = scan.nextInt();
			
			System.out.println(allocate(numberInput, input, student));

		}
		
	}
}