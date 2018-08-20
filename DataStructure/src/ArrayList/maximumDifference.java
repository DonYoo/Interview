package ArrayList;

/**
 * 
 * @author DonYoo
 *
 *
 *
https://practice.geeksforgeeks.org/problems/maximum-difference/0

Given an array C[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number in C[].
Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9).

Input:
2
7
2 3 10 6 4 8 1
5
1 2 90 10 110

Output:
8
109

https://practice.geeksforgeeks.org/problems/maximum-difference/0

Method 2 (Tricky and Efficient)
In this method, instead of taking difference of the picked element with every other element, we take the difference with the minimum element found so far. So we need to keep track of 2 things:
1) Maximum difference found so far (max_diff).
2) Minimum number visited so far (min_element).

Time Complexity : O(n)
Auxiliary Space : O(1)

 */
public class maximumDifference {
	
	public static int maximum(int[] arr){
		int max_diff = 0;
		int minimum = 0;
		// if input array size is less than 2.
		if(arr.length < 2){
			return 0;
		}
		minimum = arr[0];
		for(int i=1; i<arr.length; i++){
			// update minimum
			if(arr[i] < minimum){
				minimum = arr[i];
			}
			// get the diff and swap if its bigger than max
			else{
				int temp = arr[i]-minimum;
				if(temp > max_diff){
					max_diff = temp;
				}
			}
		}
		return max_diff;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 90, 10, 110};
		System.out.println(maximum(arr));
	}
}
