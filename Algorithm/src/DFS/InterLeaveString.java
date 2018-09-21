package DFS;
import java.util.*;
import java.lang.*;

/**
 * 
 * @author DonYoo
 * 

Interleaved String.

DFS, depth first search

https://en.wikipedia.org/wiki/Depth-first_search#Output_of_a_depth-first_search

space O(n)


https://practice.geeksforgeeks.org/problems/interleaved-strings/1

this is use for the disk defragmenter

Given three strings A, B and C your task is to complete the function isInterleave which returns true if C is an interleaving of A and B else returns false. C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved.

Input:
The first line of input contains an input T denoting the no of test cases. Then T test cases follow. Each test case contains three space separated strings A, B, C.

Output:
For each test case output will be 1 if C is interleaving of string A and B else 0.

Constraints:
1<=T<=100
1<=length of A, B, C <=100

Example(To be used only for expected output):
Input:
2
YX  X  XXY
XY X XXY

Output
0
1

Explanation:
1. For first test case XXY is not interleaving of YX and X
2. For the sec test case XXY is interleaving of XY and X.

 */


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

class GfG{
	
	public boolean isInterLeave(String a,String b,String c)	{
		
		
		// base line
		// gotta check the if its empty first.
		if(c.length() == 0){
			if((a.length() == 0) && (b.length() ==0)){
				return true;
			}
			return false;
		}
		else if(a.length() == 0){
			if(b.charAt(0) == c.charAt(0)){
				return isInterLeave(a, b.substring(1), c.substring(1));
			}
			return false;
		}
		else if(b.length() == 0){
			if(a.charAt(0) == c.charAt(0)){
				return isInterLeave(a.substring(1), b, c.substring(1));
			}
			return false;
		}
		
		// if any character doesn't match
		if((c.charAt(0) != a.charAt(0)) && c.charAt(0) != b.charAt(0)){
			return false;
		}
				
		
		
		// if the two char are the same
		if(a.charAt(0) == b.charAt(0)){
			if(isInterLeave(a.substring(1), b, c.substring(1))){
				return true;
			}
			// backtracking !!
			return isInterLeave(a, b.substring(1), c.substring(1));
		}
		
		else if(a.charAt(0) == c.charAt(0)){
			a = a.substring(1);
		}
		
		else if(b.charAt(0) == c.charAt(0)){
			b = b.substring(1);
		}
		
		return isInterLeave(a, b, c.substring(1));
	}
}



public class InterLeaveString {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            GfG g=new GfG();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }

}
