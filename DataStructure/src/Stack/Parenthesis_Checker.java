package Stack;

import java.util.*;

/**
 * 
 * @author DonYoo
 *

https://practice.geeksforgeeks.org/problems/parenthesis-checker/0

Given an expression string exp, examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

 

Input:

The first line of input contains an integer T denoting the number of test cases. 
Each test case consist of a string of expression, in a separate line.

Output:

Print 'balanced' without quotes if pair of parenthesis are balanced else print 'not balanced' in a separate line.


Constraints:

1 < T < 100
1 < |s| < 100

Example:

Input:
3
{([])}
()
()[]

Output:
balanced
balanced
balanced

 */
public class Parenthesis_Checker {

	static Scanner sc;
	
	public static String checkP(String input){
		String [] split = input.split("");
		Stack<String> que = new Stack<>();
		
		String result = "balanced";
		for(int i=0; i<split.length; i++){
			if( split[i].equals("{") ||
				split[i].equals("(") ||
				split[i].equals("[")){
				que.push(split[i]);
			}

			else if(que.isEmpty()){
				result = "not balanced";
				break;
			}
		
			if( split[i].equals("}") ){
				if(!que.pop().equals("{")){
					result = "not balanced";
					break;
				}
			}
			else if( split[i].equals(")") ){
				if(!que.pop().equals("(")){
					result = "not balanced";
					break;
				}
			}
			else if( split[i].equals("]") ){
				if(!que.pop().equals("[")){
					result = "not balanced";
					break;
				}
			}			
		}
		if(!que.isEmpty()){
			result = "not balanced";
		}
		return result;
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		// clear the next line.
		sc.nextLine();
		for(int i=0; i<testcase; i++){
			String input = sc.nextLine();
			System.out.println(checkP(input));
		}
	}
}
