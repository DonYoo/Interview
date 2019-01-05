package HashTables;
import java.util.*;

/**
 * 
 * 
 * @author DonYoo

Find triplets with zero sum

time : O(n^2 + n)
space : O(n)

https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1

Given an array A[] of n elements. The task is to complete the function which returns true if triplets exists in array A[] whose sum is zero else returns false.

Input:
The first line of input contains an integer T, denoting the no of test cases. Then T test cases follow. The first line of each test case contains an integer N, denoting the number of elements in array. The second line of each test case contains N space separated values of the array A[].
 

Output:
For each test case in a new line output will be 1 if triplet exists else 0.

Constrains:
1<=T<=100
1<=N<=1000
-1000<=A[]<=1000
 

Example(To be used only for expected output) :
Input:
2
5
0 -1 2 -3 1
3
1 2 3
Output:
1
0
 */


// which of the following sorting algorithms has the best asymptotic runtime complexity?
// O(n^2 + n)

class GfG
{
	public boolean findTriplets(int arr[] , int n)
	{
		Map<Integer, Integer> map = new HashMap<>();
		
		// Basically make it distinct
		// put them in the map. map<key, value>
		//						map<input, frequency>

		for(int i:arr){
			
			// if key is already exist, increment the value.
			if(map.containsKey(i)){
				map.replace(i, map.get(i)+1);
			}
			// if its new, add to map
			else{
				map.put(i, 1);
			}
		}

		for(int i=0; i<n; i++){
			// take out first one. decrease value.
			int first = arr[i];
			map.replace(first, map.get(first)-1);
			
			for(int j=i+1; j<n; j++){
				// take out second one. decrease value.
				int second = arr[j];
				map.replace(second, map.get(second)-1);
				
				// find negative number of sum.
				int sum = (first + second) * -1;
				// if map has the negative value that sum of first and second.
				// and if that value has not used
				if(map.containsKey(sum) && map.get(sum) > 0){
					return true;
				}
				// replace back one that i uses
				map.replace(second, map.get(second)+1);
			}
			map.replace(first, map.get(first)+1);
		}
		return false;
	}
}


public class Triplets {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			
			
			GfG g=new GfG();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
		}
		sc.close();
	}
}
