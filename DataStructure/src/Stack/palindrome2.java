package Stack;
import java.util.*;

/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/save-ironman/0

Jarvis is weak in computing palindromes for Alphanumeric characters.
While Ironman is busy fighting Thanos, he needs to activate sonic punch but Jarvis is stuck in computing palindromes.
You are given a string S containing alphanumeric characters. Find out whether the string is a palindrome or not.
If you are unable to solve it then it may result in the death of Iron Man.

Input:
The first line of the input contains T, the number of test cases. T testcases follow.  Each line of the test case contains string 'S'.

Output:
Each new line of the output contains "YES" if the string is palindrome and "NO" if the string is not a palindrome.

Constraints:
1<=T<=100
1<=|S|<=100000
Note: Consider alphabets and numbers only for palindrome check. Ignore symbols and whitespaces.

Example:
Input:
2
I am :IronnorI Ma, i
Ab?/Ba

Output:
YES
YES

 */

public class palindrome2 {
	static Scanner scan;

	public static String isPalindrome(String input){

		// change lowercase
		input = input.toLowerCase();
		// get rid of space
		input = input.replace(" ", "");
		// get rid of non alpha
		input = input.replaceAll("[^a-zA-Z0-9]", "");
		
		char [] array = input.toCharArray();
		
		
		int size = input.length();
		int half = size/2;
		int even = 0;
		// odd
		if(size%2 == 1){
			even = 1;
		}

		Stack <Character> stack = new Stack<>();

		// put them in stack
		for(int i=0; i<half; i++){
			stack.push(array[i]);
		}

		// compare other half
		for(int i=half+even; i<size; i++){
			char check = array[i];
			char comp = stack.pop();
			
			if(check != comp){
				return "NO";
			}
		}

		return "YES";
	}

	public static void main (String[] args)
	{
		scan = new Scanner(System.in);

		int testcase = scan.nextInt();
		// since we going to use nextLine, get end of line
		scan.nextLine();

		while(testcase-->0){
			String input = scan.nextLine();
			System.out.println(isPalindrome(input));
		}
	}
}
