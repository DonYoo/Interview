package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/jumping-numbers/0

answer
https://ide.geeksforgeeks.org/TzuVQBjA0X


Given a positive number x, print all Jumping Numbers smaller than or equal to x. A number is called as a Jumping Number if all adjacent digits in it differ by 1. The difference between ‘9’ and ‘0’ is not considered as 1. All single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.

Input:
The first line of the input contains T denoting the number of testcases. Each testcase contain a positive number 'x'.
Output:
All the jumping numbers less than 'x' are generated in increasing order of the most significant digit. See example for better understanding.


Constraints:
1 <=T<= 100
1 <=N<= 100000


Example:
Input:
2
10
50
Output:
0 1 10 2 3 4 5 6 7 8 9
0 1 10 12 2 21 23 3 32 34 4 43 45 5 6 7 8 9

Here, the most significant digits of each jumping number is following increasing order, i.e., jumping numbers starting from 0, followed by 1, then 2 and so on, themselves being in increasing order 2, 21, 23.


By assigning the LinkedList<String> to a variable of type Queue<String>, you can only access the methods in the LinkedList that are available in the Queue<String> interface, which includes support for enqueuing and dequeuing elements. This would be useful if you needed to write a program that used a queue for various operations and wanted to implement that queue by using a linked list.

By assigning the LinkedList<String> to a variable of type List<String>, you can only access the methods in the LinkedList that are available in the List<String> interface, which are normal operations for maintaining a sequence of elements. This would be useful, for example, if you needed to process a list of elements that could grow and shrink anywhere.


time O(n)
space O(n)

 */

public class JumpingNumbers {

	static Scanner s;

	private static void jumping(int input){
		Queue<Integer> queue = new LinkedList<Integer>();
		System.out.print(0);
		
		for(int i =1; i<10; i++){
			queue.add(i);
			while(!queue.isEmpty()){
				int temp = queue.poll();
				if(temp <= input){
					System.out.print(" "+temp);
				}
				if(temp-1)
				queue.add(e)
				
				
			}
		}
	}

	public static void main(String[] args) {
		s = new Scanner(System.in);
		
		int testcase = s.nextInt();
		
		for(int i=0; i<testcase; i++){
			int input = s.nextInt();
			jumping(input);
		}
	}
}
