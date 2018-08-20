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

class GfG
{
	public boolean findTriplets(int arr[] , int n)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			if(map.containsKey(arr[i])){
				map.replace(arr[i], map.get(arr[i]++));
			}
			else{
				map.put(arr[i], 1);
			}
		}

		for(int k =0; k<arr.length; k++){
			map.replace(arr[k], (map.get(arr[k]))-1);
			for(int j=k+1; j<arr.length; j++){
				map.replace(arr[j], map.get(arr[j])-1);
				if(map.containsKey((arr[k]+arr[j])*-1) && (map.get((arr[k]+arr[j])*-1) >0) ){
					return true;
				}
				map.replace(arr[j], map.get(arr[j])+1);
			}
			map.replace(arr[k], map.get(arr[k])+1);
		}
		return false;
	}
}