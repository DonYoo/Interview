package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author DonYoo
 *

https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:
Corresponding to each test case, in a new line, print the starting and ending positions of first such occuring subarray if sum equals to subarray, else print -1.
Note: Position of 1st element of the array should be considered as 1.

Expected Time Complexity: O(n)


Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10

Output:
2 4
1 5

Explanation : 
In first test case, sum of elements from 2nd position to 4th position is 12
In second test case, sum of elements from 1st position to 5th position is 15

solve : O(n)
space : O(n)
 */


public class Subarray_given_sum {

	static Queue<Integer> storage;
	static Scanner s;
	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		
		int testcase = s.nextInt();
		
		for(int numtest=0; numtest<testcase; numtest++){
			storage = new LinkedList<>();
			int inputsize = s.nextInt();
			int target = s.nextInt();
			int sum = 0;
			int start = 1;
			int end = 0;
			s.nextLine();
			String input = s.nextLine();
			String []realinput = input.split(" ");
			
			while(end<inputsize){
				int getinput = Integer.parseInt(realinput[end]);
				if(sum < target){
					storage.add(getinput);
					sum += getinput;
					end++;
				}
				// find the answer
				else if(sum == target){
					System.out.println(start +" "+end);
					break;
				}
				// if sum is bigger than target.
				else{
					while(sum > target){
						sum -= storage.poll();
						start++;
					}
				}
			}
			
			// if it went through the iterate till the end.
			while(sum != target){
				// if no match found return -1
				if(storage.isEmpty()){
					System.out.println("-1");
					break;
				}
				sum -= storage.poll();
				start++;
				// find the range.
				if(sum == target){
					System.out.println(start +" "+end);
					break;
				}
			}
		}
	}
}
