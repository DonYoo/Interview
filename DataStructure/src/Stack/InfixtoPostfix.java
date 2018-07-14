package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * 
 * @author DonYoo

Infix expression:The expression of the form a op b. When an operator is in-between every pair of operands.

Postfix expression:The expression of the form a b op. When an operator is followed for every pair of operands.

Input:

The first line of input contains an integer T denoting the number of test cases.
The next T lines contains an infix expression.The expression contains all characters and ^,*,/,+,-.

Output:
Output the infix expression to postfix expression.

Constraints:
1<=T<=100
1<=length of expression<=30

Example:
Input:
2
a+b*(c^d-e)^(f+g*h)-i
A*(B+C)/D

Output:
abcd^e-fgh*+^*+i-
ABC+*D/

https://www.geeksforgeeks.org/amazon-interview-experience-sde-2/
https://practice.geeksforgeeks.org/problems/infix-to-postfix/0


 */

public class InfixtoPostfix {

	static Map<Character, Integer> hashmap = new HashMap<>();
	
	private static boolean isOperand(char eachInput) {
		switch (eachInput){
			case '+':
			case '-':
			case '*':
			case '/':
			case '^':
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// make a map for the ordering operand.
		Stack<Character> storage = new Stack<>();
		hashmap.put('(', 0);
		hashmap.put('-', 1);
		hashmap.put('+', 1);
		hashmap.put('*', 2);
		hashmap.put('/', 2);
		hashmap.put('^', 3);
		
		
		String input = "a+b*(c^d-e)^(f+g*h)-i";
		
		for(int i=0; i<input.length(); i++){
			char eachInput = input.charAt(i);
			
			// operand
			if(isOperand(eachInput)){
				
				// if previous operand is priority than current operand
				// print previous. 
				while(!storage.isEmpty() && (hashmap.get(eachInput) <= hashmap.get(storage.peek()) )){
					System.out.print(storage.pop());
				}
				//if not push to current operand to stack
				storage.push(eachInput);
			}
			// not operand
			else{
				if(eachInput == '('){
					storage.push(eachInput);
				}
				else if(eachInput == ')'){
					System.out.print(storage.pop());
					// print all the operand till it find '('
					while(storage.peek() != '('){
						System.out.print(storage.pop());
					}
					// get rid of '('
					storage.pop();
				}
				// alphabet variable
				else{
					System.out.print(eachInput);
				}
			}
		}
		while(!storage.isEmpty()){
			System.out.print(storage.pop());
		}
	}
}
