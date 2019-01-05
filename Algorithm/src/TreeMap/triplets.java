package TreeMap;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1

Given an array A of N elements. The task is to complete the function which returns true if triplets exists in array A whose sum is zero else returns false.

Input Format:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N, denoting the number of elements in array. The second line of each test case contains N space separated values of the array.

Output:
For each test case, output will be 1 if triplet exists else 0.

Your Task:
Your task is to only complete the function to find triplets.

Constrains:
1 <= T <= 100
1 <= N <= 103
-103 <= A <= 103

Example:
Input:
2
5
0 -1 2 -3 1
3
1 2 3

Output:
1
0


Time Complexity : O(n2)
Auxiliary Space : O(n)

 */

public class triplets {

	// find triplets a whose sum is zero. return 1 else 0
	public static boolean findTriplets(int arr[] , int n)
	{
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i<n; i++){
			for(int k= i+1; k<n; k++){
				map.put((arr[i]+arr[k])*-1, 1);
				int check = k+1;
				if(check < n){
					if(map.containsKey(arr[check])){
						return true;
					}
				}
			}
			// clear the map.
			map = new HashMap<>();
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = {0, -1, 2, -3, 1};
		int n = 5;
		
		System.out.println(findTriplets(arr, n));
	}

}
