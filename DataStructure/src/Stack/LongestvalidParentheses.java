package Stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author DonYoo
 *

https://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0

answer
https://leetcode.com/articles/longest-valid-parentheses/

  
Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.

Examples:

Input : ((()
Output : 2
Explanation : ()

Input: )()())
Output : 4
Explanation: ()()

Input:  ()(()))))
Output: 6
Explanation:  ()(())

Input:
First line contains the test cases T.  1<=T<=500
Each test case have one line string S of character'(' and ')' of length  N.  1<=N<=10000

Example:
Input:
2
((()
)()())

Output:
2
4

 */
public class LongestvalidParentheses {
	
	static Scanner s;

	// using stack
	// time O(n)
	// space O(n)
	public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
	
	// use only one space.
	// time O(n)
	// space O(1)
	private static int oneSpace(String input) {
		int leftlongest = 0;
		int rightlongest = 0;
		int leftparen = 0;
		int rightparen = 0;
		
		//left to right
		for(int i=0; i<input.length(); i++){
			char parenthesis = input.charAt(i);
			if(parenthesis == '('){
				leftparen++;
			}
			else{
				rightparen++;
				if(rightparen > leftparen){
					rightparen = 0;
					leftparen = 0;
				}
			}
			if(leftparen == rightparen){
				if(leftlongest < leftparen*2){
					leftlongest = leftparen*2;
				}
			}
		}
		
		//right to left
		leftparen = 0;
		rightparen = 0;
		
		for(int i= input.length()-1; i >=0; i--){
			char parenthesis = input.charAt(i);
			if(parenthesis == ')'){
				rightparen++;
			}
			else{
				leftparen++;
				if(rightparen < leftparen){
					rightparen = 0;
					leftparen = 0;
				}
			}
			if(leftparen == rightparen){
				if(rightlongest < leftparen*2){
					rightlongest = leftparen*2;
				}
			}
		}
		return Math.max(leftlongest, rightlongest);
	}
	
	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		
		int testcase = s.nextInt();
		s.nextLine();
		
		for(int i=0; i<testcase; i++){
			String input = s.nextLine();
			System.out.println(oneSpace(input));
		}
	}
}
