package ArrayList;

import java.util.*;

/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/peak-element/1

Given an array of integers. The task is to find a peak element in it. An array element is peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor. For example, for input array {5, 10, 20, 15}, 20 is the only peak element. For input array {10, 20, 15, 2, 23, 90, 67}, there are two peak elements: 20 and 90. 

Note: There may be multiple peak element possible, in that case you may return any valid index.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N. Then in the next line are N space separated values of the array.

Output:
For each test case output will be 1 if the index returned by the function is an peak index.

Constraints:
1<=T<=100
1<=N<=100
1<=A[]<=1000

Example:
Input:
2
3
1 2 3
2
3 4
Output:
1
1

 */

public class Peak_element {

	static Scanner sc;
	
	static int peakElement(int [] input, int inputsize){
		
		// if input is less than 2
		if(inputsize == 1){
			return 0;
		}
		else if(inputsize <= 2){
			if(input[0] > input[1]){
				return 0;
			}
			return 1;
		}
		
		// if first element is peak
		if(input[0] > input[1]){
			return 0;
		}

		
		// input bigger than 2
		for(int index = 1; index + 2 < inputsize; index++){
			if((input[index-1]<input[index] &&
					input[index] < input[index+1])){
				return index;
			}
		}
		// if last element is peak
		return inputsize -1;
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		for(int i=0; i<testcase; i++){
			int inputsize = sc.nextInt();
			int[] input = new int[inputsize];
			for(int j =0; j<inputsize; j++){
				input[j] = sc.nextInt();
			}
			System.out.println(peakElement(input, inputsize));
		}
	}

}
