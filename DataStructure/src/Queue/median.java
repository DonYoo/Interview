package Queue;

import java.util.*;;


/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0
https://www.geeksforgeeks.org/median-of-stream-of-running-integers-using-stl/



Given an input stream of n integers the task is to insert integers to stream and print the median of the new stream formed by each insertion of x to the stream.

Example

Flow in stream : 5, 15, 1, 3 
5 goes to stream --> median 5 (5)
15 goes to stream --> median 10 (5, 15)
1 goes to stream --> median 5 (5, 15, 1)
3 goes to stream --> median 4 (5, 15, 1, 3)

Input:
The first line of input contains an integer N denoting the no of elements of the stream. Then the next N lines contains integer x denoting the no to be inserted to the stream.

Output:
For each element added to the stream print the floor of the new median in a new line.

Constraints:
1<=N<=105 + 7
1<=x<=105 + 7

Example:
Input:
4
5
15
1 
3
Output:
5
10
5
4

time complexity
O(n)

 */


public class median {

	static Scanner scan;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
	    int testcase = scan.nextInt();
	    
	    // need to make 2 different priority queue.
        // leftone has reversed que
        // rightone has normal que
        
        Queue<Integer> left  = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> right = new PriorityQueue<>();
        
	    while(testcase-->0){
	        int input = scan.nextInt();
	        
	        // if their size are the same.
	        if(left.size() == right.size() ||
	            left.size() < right.size()){
	            // if they are both empty.
	            if(left.size() == 0){
	                left.add(input);
	            }
	            else{
	                // least from right side
	                int min = right.peek();
	                // most from left side
	                int max = left.peek();
	                
	                // if input is bigger than rightside least, 
	                // add new input to right and move least to leftside
	                if(input > min){
	                    right.add(input);
	                    left.add(right.poll());
	                }
	                else{
	                    left.add(input);
	                }
	            }
	        }
	        // when leftone has 1 more than right one.
	        else{
	            left.add(input);
	            right.add(left.poll());
	        }
	        
            // either way, leftone would have 1 more item.
            if(left.size() > right.size()){
                System.out.println(left.peek());
            }
            // rightone has 1 more item.
            else if(right.size() > left.size()){
                System.out.println(right.peek());
            }
            // if they are same size.
	        else{
	            System.out.println( (right.peek() + left.peek())/2 );
	        }
	        
	    }
	}
}
