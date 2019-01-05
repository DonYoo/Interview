package Mergesort;

import java.util.*;

/**
 * 
 * @author DonYoo
https://practice.geeksforgeeks.org/problems/merge-sort/1

The task is to complete merge() function which is used to implement Merge Sort.

Input:
First line of the input denotes number of test cases 'T'. First line of the test case is the size of array and second line consists of array elements.


Output:
Sorted array in increasing order is displayed to the user.


Constraints:
1 <=T<= 50
1 <=N<= 1000
1 <=arr[i]<= 1000


Example:

Input:
2
5
4 1 3 9 7
10
10 9 8 7 6 5 4 3 2 1

Output:
1 3 4 7 9
1 2 3 4 5 6 7 8 9 10

 */

public class myMergeSort {

	static Scanner scan;
	
	static void merge(int arr[], int l, int m, int r)
	{
		int leftsize = m-l+1;
		int rightsize = r-m;
		// left contain 1 more if number is odd
		int L[] = new int[leftsize];
		int R[] = new int[rightsize];
		
		// copy of left
		for(int i=0;i<leftsize;i++){
			L[i] = arr[l+i];	
		}
		// copy of right
		for(int i=0;i<rightsize;i++){
			R[i] = arr[i+m+1];
		}
		
		int i=0;
		int j=0;
		
		//merge first whichever lower than other.
		while(l<=m && m<r){
			if(L[i]>R[j]){
				arr[l++] = R[j++];
			}
			else{
				i++;
				l++;
			}
		}
		
		// copy remain of leftside.
		while(i<leftsize){
			arr[l++] = L[i];
			i++;
		}
		
		// copy remain of rightside.
		while(j<rightsize){
			arr[l++] = R[j];
			j++;
		}
			
	}
	
	static void sort(int arr[], int l, int r){
		if(l < r){
			int m = (l+r)/2;
			//left side
			sort(arr, l, m);
			//right side
			sort(arr, m+1, r);
			//merge
			merge(arr, l, m, r);
		}
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int testcase= scan.nextInt();
		
		
		for(int i=0;i<testcase; i++){
			int inputsize = scan.nextInt();
			
			int[] input = new int[inputsize];
			
			for(int j=0; j<inputsize; j++){
				input[j] = scan.nextInt();
			}
			sort(input, 0, input.length-1);
			
			for(int j=0; j<input.length; j++){
				System.out.print(input[j]+ " ");
			}
			System.out.println();
		}
	}

}
