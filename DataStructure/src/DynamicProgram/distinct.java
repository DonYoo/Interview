package DynamicProgram;

import java.util.Arrays;

/**
 * 
 * @author DonYoo

https://www.geeksforgeeks.org/ways-transforming-one-string-removing-0-characters/

Ways of transforming one string to other by removing 0 or more characters
Given two sequences A, B, find out number of unique ways in sequence A, to form a subsequence of A that is identical to the sequence B. Transformation is meant by converting string A (by removing 0 or more characters) to string B.

Examples:

Input : A = "abcccdf", B = "abccdf"
Output : 3
Explanation : Three ways will be -> "ab.ccdf", 
"abc.cdf" & "abcc.df" .
"." is where character is removed. 

Input : A = "aabba", B = "ab"
Output : 4
Expalnation : Four ways will be -> "a.b..",
 "a..b.", ".ab.." & ".a.b." .
"." is where characters are removed.

The idea to solve this problem is using Dynamic Programming. Construct a 2D DP matrix of m*n size, where m is size of string B and n is size of string A.
dp[i][j] gives the number of ways of transforming string A[0…j] to B[0…i].

Case 1 : dp[0][j] = 1, since placing B = “” with any substring of A would have only 1 solution which is to delete all characters in A.
Case 2 : when i > 0, dp[i][j] can be derived by two cases:
Case 2.a : if B[i] != A[j], then the solution would be to ignore the character A[j] and align substring B[0..i] with A[0..(j-1)]. Therefore, dp[i][j] = dp[i][j-1].
Case 2.b : if B[i] == A[j], then first we could have the solution in case a), but also we could match the characters B[i] and A[j] and place the rest of them (i.e. B[0..(i-1)] and A[0..(j-1)]. As a result, dp[i][j] = dp[i][j-1] + dp[i-1][j-1].


 */


public class distinct {

	public static int subsequence(String aStr, String bStr){
		int sizeA = aStr.length();
		int sizeB = bStr.length();
		
		char[] a = aStr.toCharArray();
		char[] b = bStr.toCharArray();
		
		// size B and size A
		int[][] dp = new int [sizeB+1][sizeA+1];
		
		// base line
		// when b size is 0. ""
		if(sizeB == 0){
			return 1;
		}
				
		for(int[] iArray:dp)
		{
			Arrays.fill(iArray,0);
		}

		// bottom up
		// iterate through size B
		for(int i = 1; i<sizeB; i++){
			// Traverse all charaters of a[] for b[i]
			for(int j=i; j<sizeA; j++){
				// Filling the first row of the dp
				// matrix.
				if(i == 1){
					if (a[j] == b[i] && j == 1)
						dp[i][j] = 1;
						else if (a[j-1] == b[i-1])
						dp[i][j] = dp[i][j - 1] + 1;
						else
						dp[i][j] = dp[i][j - 1];
				}
				// Filling other rows.
				else{
					if (a[j-1] == b[i-1])
						dp[i][j] = dp[i][j - 1] + 
						dp[i - 1][j - 1];
					else
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[sizeB-1][sizeA-1];
	}
	
	public static void main(String[] args) {
		String a = "abcccfd", b = "abccfd";
		
		System.out.println(subsequence(a, b));
	}

}
