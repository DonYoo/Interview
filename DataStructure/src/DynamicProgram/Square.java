package DynamicProgram;

import java.util.*;

/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/min-cut-square/0

Min cut Square
Submissions: 2534 Accuracy: 20.11% Difficulty: Medium

Given a paper of size A x B. Task is to cut the paper into squares of any size. Find the minimum number of squares that can be cut from the paper.
Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two integer A and B denoting the two size of the paper.

Output:
Print the minimum number of squares that can be cut from the paper.

Constraints:
1<=T<=10^5
1<=A<=10^5
1<=B<=10^5

Example:
Input:
2
13 29
30 35

Output:
9
5


We have already discussed the Greedy approach to solve this problem in previous article. But the previous approach doesn’t always work. For example, it fails for the above first test case. So, in this article we solve this problem using Dynamic Programming.



We know that if we want to cut minimum number of squares from the paper then we would have to cut largest square possible from the paper first and largest square will have same side as smaller side of the paper. For example if paper have the size 13 x 29, then maximum square will be of side 13. so we can cut 2 square of size 13 x 13 (29/13 = 2). Now remaining paper will have size 3 x 13. Similarly we can cut remaining paper by using 4 squares of size 3 x 3 and 3 squares of 1 x 1. So minimum 9 squares can be cut from the Paper of size 13 x 29.

Explanation:
minimumSquare is a function which tries to split the rectangle at some position. The function is called recursively for both parts. Try all possible splits and take the one with minimum result. The base case is when both sides are equal i.e the input is already a square, in which case the result is 1. We are trying to find the cut which is nearest to the center which will lead us to our minimum result.

Assuming we have a rectangle with width is N and height is M.

if (N == M), so it is a square and nothing need to be done.
Otherwise, we can divide the rectangle into two other smaller one (N – x, M) and (x, M), so it can be solved recursively.
Similarly, we can also divide it into (N, M – x) and (N, x)
Below is the implementation of above idea using Dynamic Programming.

 */



public class Square {

	static Scanner scan;
	static int [][] dp;
	
	// calculate the minimum number of square that fit in the
	// paper size of width and length
	
	private static int minimumSquare(int width, int length){
		
		int vertical_min = Integer.MAX_VALUE;
		int horizontal_min = Integer.MAX_VALUE;
		
		// if given is already a square.
		if(width == length){
			return 1;
		}
		
		// If the answer for the given 
        // rectangle is previously 
        // calculated return that answer
        if (dp[width][length] != 0)
                return dp[width][length];
         
        /* The rectangle is cut horizontally
        and vertically into two parts and 
        the cut with minimum value is found
        for every recursive call. 
        */
     
        for (int i = 1; i <= width / 2; i++)
        {
            // Calculating the minimum answer 
            // for the rectangles with width 
            // equal to length and length less than
            // width for finding the cut point for 
            // the minimum answer
            horizontal_min = Math.min(
                            minimumSquare(i, length) + 
                            minimumSquare(width-i, length),
                            horizontal_min); 
        }
     
        for (int j = 1; j <= length / 2; j++)
        {
            // Calculating the minimum answer 
            // for the rectangles with width 
            // less than length and length equal to
            // width for finding the cut point for
            // the minimum answer
            vertical_min = Math.min(
                           minimumSquare(width, j) + 
                           minimumSquare(width, length-j),
                           vertical_min);
        }
        
        // Minimum of the vertical cut or 
        // horizontal cut to form a square
        // is the answer
        dp[width][length] = Math.min(vertical_min,
                         horizontal_min); 
         
        return dp[width][length];
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int testcase = scan.nextInt();
		
		for(int i=0;i<testcase;i++){
			int width = scan.nextInt();
			int length = scan.nextInt();
			dp = new int [width+1][length+1];
			System.out.println(minimumSquare(width, length));
		}
	}

}
