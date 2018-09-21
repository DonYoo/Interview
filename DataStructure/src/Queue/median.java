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


 */



public class median {

	static Scanner scan;
	
	private static void findMedian(int[] input){
		
		// put min as reversed since queue only can poll. ********
		// 5 4 3 2 1
		Queue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
		// 6 7 8 9 10
		Queue<Integer> max = new PriorityQueue<>();
		
		int inputsize = input.length;
		
		for(int i=0; i<inputsize; i++){

			min.add(input[i]);
			if(min.size()> max.size()){
				max.add(min.poll());
			}
			if((min.size() != 0) && (min.peek() > max.peek())){
				int temp = min.poll();
				min.add(max.poll());
				max.add(temp);
			}

			// odd size
			if(i%2 ==0){
				if(min.size() > max.size()){
					System.out.println(min.peek());
				}
				else{
					System.out.println(max.peek());
				}				
			}
			// even
			else{
				System.out.println((min.peek() + max.peek())/2);
			}
		}
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int inputsize = scan.nextInt();
		
		int[] input = new int[inputsize];
		
		for(int i=0; i<inputsize; i++){
			input[i] = scan.nextInt();
		}
		
		findMedian(input);
	}

}
