package DynamicProgram;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author DonYoo

Egg_Dropping_Puzzle

https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle/0

answer
https://medium.com/human-in-a-machine-world/the-egg-dropping-puzzle-a23f58a59374


Dynamic Programming.

is making a 1 or 2D array and put the value for every single
array and find out the result.


https://en.wikipedia.org/wiki/Dynamic_programming#Egg_dropping_puzzle

In both contexts it refers to simplifying a complicated problem 
by breaking it down into simpler sub-problems in a recursive manner.
 


Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break. You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.There are few rules given below. 

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
For more description on this problem see wiki page

Input:
The first line of input is  T denoting the number of testcases.Then each of the T lines contains two positive integer N and K where 'N' is the number of eggs and 'K' is number of floor in building.

Output:
For each test case, print a single line containing one integer the minimum number of attempt you need in order find the critical floor.

Constraints:
1<=T<=30
1<=N<=10
1<=K<=50


Example:
Input:
1
2 10

Output:
4



time : O(nk^2)
 */


// find bottom up

public class Egg_Dropping_Puzzle {

	static Scanner sc;
	static int max_floor;

	public static int findFloor(int noEgg, int noFloor){
		
		int attempt = 0;
		
		// if there is only 2 egg left and need to find out
		// the noFloor
		
		// n + (n-1) + (n-2) + (n-3) .....
		int [][] dp = new int[noEgg+1][noFloor+1];
		
		// baseline
		// when noFloor is 1
		for(int i=1; i<=noEgg; i++){
			dp[i][1] = 1;
		}
		
		// when egg = 1
		for(int floor = 1; floor<=noFloor; floor++){			
			dp[1][floor] = floor;
		}
		
		// bottom up
		for(int egg = 2; egg<=noEgg; egg++){
			for(int floor=2; floor<=noFloor; floor++){
				
				// Keep track of the MINIMUM number of drops needed
				dp[egg][floor] = Integer.MAX_VALUE;
				
				// consider each drop from first to current noFloor
				for(int x=2; x<=floor; x++){
					// If the egg breaks on floor x, we only need to test floors up to the
			        // x-1th floor. We also have one less egg since the egg broke.
					int egg_break = dp[egg-1][x-1];
					
					// If the egg did not break on floor x, we only need to test floors 
			        // starting from the floor-xth floor onwards. The number of eggs 
			        // does not change since the egg did not break.
					int egg_not_break = dp[egg][floor-x];
					
					// Find the number of drops necessary in the WORST CASE scenario.
			        // Don't forget to add one to include the current drop.
					int drop = Math.max(egg_break, egg_not_break) +1;
					
					// Update memo[egg][floor] if we found a smaller number of needed 
			        // egg drops
					dp[egg][floor] = Math.min(drop, dp[egg][floor]);
				}
			}
		}
		return dp[noEgg][noFloor];
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
	
		int testcase = sc.nextInt();
		
		for(int i =0; i<testcase; i++){
			int noEgg = sc.nextInt();
			max_floor = sc.nextInt();
			
			System.out.println(findFloor(noEgg, max_floor));
		}
	}

}
