package Stack;

import java.util.Stack;

/**
 * 
 * @author DonYoo
 *
 *
https://www.geeksforgeeks.org/amazon-interview-experience-sde-2/
https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/

Given a postfix expression, the task is to evaluate the expression and print the final value.

Input:
The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an postfix expression.

Output:
For each test case, evaluate the postfix expression and print the value.

https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression/0


Input:
2
231*+9-
123+*8-

Output:
-4
-3

Run Big O(n)
Space Big O(n)
 */

public class PostfixExpression {

	public static void main(String[] args) {
		Stack<Integer> numbers = new Stack<>();
		String input = "231*+9-";
		
		for(int i=0; i<input.length(); i++){
			char each = input.charAt(i);
			if(Character.isDigit(each)){
				numbers.push(Character.getNumericValue(each));
			}
			else if(each == '+'){
				int right = numbers.pop();
				int left = numbers.pop();
				numbers.push(left + right);
			}
			else if(each == '-'){
				int right = numbers.pop();
				int left = numbers.pop();
				numbers.push(left - right);
			}
			else if(each == '*'){
				int right = numbers.pop();
				int left = numbers.pop();
				numbers.push(left * right);
			}
			else if(each == '/'){
				int right = numbers.pop();
				int left = numbers.pop();
				numbers.push(left / right);
			}
		}
		System.out.println(numbers.pop());
	}

}
