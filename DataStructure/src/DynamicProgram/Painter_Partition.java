package DynamicProgram;

/**
 * 
 * @author DonYoo

https://www.geeksforgeeks.org/painters-partition-problem/

We have to paint n boards of length {A1, A2…An}. There are k painters available and each takes 1 unit time to paint 1 unit of board. The problem is to find the minimum time to get
this job done under the constraints that any painter will only paint continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.

Examples:

Input : k = 2, A = {10, 10, 10, 10} 
Output : 20.
Here we can divide the boards into 2
equal sized partitions, so each painter 
gets 20 units of board and the total
time taken is 20. 

Input : k = 2, A = {10, 20, 30, 40} 
Output : 60.
Here we can divide first 3 boards for
one painter and the last board for 
second painter.


2) Overlapping subproblems:
Following is the partial recursion tree for T(4, 3) in above equation.

      T(4, 3)
     /    /    \ ..         
T(1, 2)  T(2, 2) T(3, 2) 
          /..      /..     
      T(1, 1)    T(1, 1) 
We can observe that many subproblems like T(1, 1) in the above problem are being solved again and again. Because of these two properties of this problem, we can solve it using dynamic programming, either by top down memoized method or bottom up
tabular method. Following is the bottom up tabular implementation:

 */


public class Painter_Partition {
	
	// function to calculate sum between two indices
	// in array
	private static int sum(int[] arr, int from, int to) {
		int sum = 0;
		for(int i=from; i<=to; i++){
			sum += arr[i];
		}
		return sum;
	}
	
	// bottom up dp
	private static int partition(int[] arr, int size, int painter) {
		
		// initialiaze
		
		int dp[][] = new int[painter+1][size+1];
		
		// base case
		// when there is only one painter
		for(int i=1; i<=size; i++){
			
			int total = sum(arr, 0, i-1);
			dp[1][i] = total;
		}
		
		// when there is only one board
		for(int i=1; i<=painter; i++){
			dp[i][1] = arr[0];
		}
		
		for(int i=2; i<=painter;i++){
			for(int board=2; board<=size; board++){
				
				int min = Integer.MAX_VALUE;
				
				// each board
				// start from 1 since 1 is baseline
				for(int eachboard=1; eachboard<=board; eachboard++){
					
					// first half without one painter from previous value
					int firsthalf = dp[i-1][eachboard];
					
					// second half. 
					int secondhalf = sum(arr, eachboard, board-1);
					
					// get bigger one
					int big = Math.max(firsthalf, secondhalf);
					min = Math.min(min , big);
					
				}
				dp[i][board] = min;
			}
		}
		return dp[painter][size];
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 60, 50, 30, 40 };

	    // Calculate size of array.
		int size = arr.length;
	    int painter = 3;
	    System.out.println(partition(arr, size, painter));
	}


}
