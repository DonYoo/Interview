package DynamicProgram;

import java.util.*;

/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items/0
          
Given weights and values related to n items and the maximum capacity allowed for these items. What is the maximum value we can achieve if we can pick any weights any number of times for a total allowed weight of W?

Input:
The first line of input contains an integer denoting the no of test cases. Then T test cases follow . Each test case contains two integers N and W denoting the no of items and the total allowed weight. In the next two lines are space separated values of the array denoting values of the items (val[]) and their weights (wt[]) respectively. 

Output:
For each test case in a new line print the  maximum value which we can achieve if we can pick any weights any number of times for a bag of size W.

Constraints:
1<=T<=100
1<=N, W<=1000
1<=wt[], val[]<=100

Example:
Input:
2
2 3
1 1
2 1 
4 8
1 4 5 7
1 3 4 5
Output:
3
11
 */
public class Duplicate_item {

	static Scanner scan;
	public static void main (String[] args)
	{
	    scan = new Scanner(System.in);
	    
	    int testcase = scan.nextInt();
	    
	    while(testcase-->0){
	        int noItem = scan.nextInt();
	        int maxWei = scan.nextInt();
	        scan.nextLine();
	        
	        String[] value = scan.nextLine().split(" ");
	        String[] weight = scan.nextLine().split(" ");
	        
	        // set all value 0 on all the volumes
	        int[] dp = new int[maxWei+1];
	        
	        for(int curWei=1; curWei<=maxWei; curWei++){
	        	for(int item=0; item< noItem; item++){
	        		
	        		int intWeight = Integer.parseInt(weight[item]);
	        		int intValue = Integer.parseInt(value[item]);
	        		
	        		if(intWeight <= curWei){
	        			int latest = dp[curWei - intWeight] + intValue;
	        			
	        			// compare current value so far with latest one.
	        			dp[curWei] = Math.max(dp[curWei], latest);
	        		}
	        	}
	        }
	        System.out.println(dp[maxWei]);
	    }
	}

}
