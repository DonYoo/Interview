package HashTables;

import java.util.*;

/**
 * 
 * @author DonYoo
 *

https://www.geeksforgeeks.org/number-recycled-pairs-array/


Number of recycled pairs in an array

Given an array of integers arr[], find the number of recycled pairs in the array. A recycled pair of two numbers {a, b} has the following properties :

A should be smaller than B.
Number of digits should be same.
By rotating A any number of times in one direction, we should get B.


Examples:

Input : arr[] = {32, 42, 13, 23, 9, 5, 31}
Output : 2
Explanation : Since there are two pairs {13, 31} and {23, 32}. 
By rotating 13 for first time, output is 31 and by rotating 23 once output is 32. 
Both of these pairs satisfy our criteria.

Input : arr[] = {1212, 2121}
Output : 1
Explanation : Since there are two pairs {1212, 2121}. By rotating 1212
for first time, output is 2121. This pair satisfies our criteria.
Note that if rotation id done further, rotating 1212 again output is 1212 
which is given number and 2121 which has been already counted.
So discard both of these results. 

time O(n)
space O(n)
 */


public class Recycled_Pairs {

	private static int recycledPairs(int[] a) {
		HashMap<Integer,Integer> map = new HashMap<>();
		
		// put every number in the map to look later.
		for(int dict : a){
			map.put(dict, 1);
		}
		
		int output = 0;
		
		// 
		for(int one : a){
			// rotate through one by one
			for (int temp = one; temp>0; temp/=10){
				// get first digit
				int digit = one%10;
				// get right shift number.
				String number = digit + "" + one/10;
				int find = Integer.parseInt(number);
				if(map.containsKey(find)){
					map.remove(one);
					output++;
					break;
				}
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		//int a[] = { 32, 42, 13, 23, 9, 5, 31 };
		int a[] = { 1212, 2121 };
        int result = recycledPairs(a);
        System.out.println(result);		
	}
}
