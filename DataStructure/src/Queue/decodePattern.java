package Queue;
import java.util.*;


/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/decode-the-pattern/0/?ref=self

Given a pattern as below and an integer n your task is to decode it and print nth row of it. The pattern follows as :
1
11
21
1211
111221
............

Input:
The first line of input is the number of test cases .  Then T test cases follow . The first line of each test case is an integer N.

Output:
For each test case print the required nth row of the pattern.

Constraints:
1<=T<=20
1<=N<=20

Example:
Input:
2
2
3
Output:
11
21

 */

public class decodePattern {

static Scanner scan;
    
    public static String decode(int input){
        String result = "";
        
        Queue<Integer> que = new LinkedList<>();
        
        que.add(1);
        
        while(input-->0){
            
            int count = 1;
            int current = que.poll();
            
            int que_size = que.size();
            
            while(que_size --> 0){
                int next = que.poll();
                if(current == next){
                    count++;
                }
                else{
                    que.add(count);
                    que.add(current);
                    current = next;
                    count = 1;
                }
            }
            que.add(count);
            que.add(current);
        }
        
        while(!que.isEmpty()){
            result += que.poll();
        }
        return result;
    }
    
	public static void main (String[] args) {
	    scan = new Scanner(System.in);
	    
	    int testcase = scan.nextInt();
	    
	    while(testcase-->0){
	        int input = scan.nextInt();
	        System.out.println(decode(input-1));
	    }
	}

}
