package LinkedList;
import java.util.*;

/**
 * 
 * 
 * @author DonYoo


https://practice.geeksforgeeks.org/problems/word-break-part-2/0

    
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "snakesandladder",
dict = ["snake", "snakes", "and", "sand", "ladder"].

A solution is ["snakes and ladder",
           "snake sand ladder"].

Input:
The first line contains an integer T, denoting the number of test cases.
Every test case has 3 lines.
The first line contains an integer N, number of words in the dictionary.
The second line contains N strings denoting the words of the dictionary.
The third line contains a string s.

Output:
For each test case, print all possible strings in one line. Each string is enclosed in (). See Example.
If no string possible print "Empty" (without quotes).

Constraints:
1<=T<=100
1<=N<=20
1<=Length of each word in dictionary <=15
1<=Length of s<=1000
 

Note: Make sure the strings are sorted in your result.

Exapmle:
Input:
1
5
lr m lrm hcdar wk
hcdarlrm

Output:
(hcdar lr m)(hcdar lrm)


time process

Big O(n)


** For More Input/Output Examples Use 'Expected Output' option **
*
 */


public class WordBreak {

	static Scanner scan;
    
	public static void check(LinkedList <String>que, HashMap<String, Integer> map, String input){
		String word = "";

		for(int i=0; i<input.length(); i++){
            word += Character.toString(input.charAt(i));
            
            if(map.containsKey(word)){

            	que.add(word);
            	
            	if(i == input.length()-1){

            		System.out.print("(");
            		
            		LinkedList<String> temp = new LinkedList<>(que);
            		
            		// print the first one.
                	System.out.print(temp.poll());
                	while(!temp.isEmpty()){
                		System.out.print(" " + temp.poll());
                	}

        			System.out.print(")");
        		}
            	
                check(que, map, input.substring(i+1, input.length()));
            }
        }
		// take the most right one out. 
		if(!que.isEmpty()){
			que.removeLast();
		}
	}
    
	public static void main (String[] args)	{
	    scan = new Scanner(System.in);
	    
	    int testcase = scan.nextInt();
	    
	    while(testcase-->0){
	        int noItem = scan.nextInt();
	        scan.nextLine();
	        String [] dic = scan.nextLine().split(" ");

            HashMap<String, Integer> map = new HashMap<>();
            
            // putting each word in the dictionary.
	        for(String word : dic){
	            map.put(word, 1);
	        }
	        
	        String input = scan.nextLine();

	        LinkedList<String> que = new LinkedList<>();
	        check(que, map, input);
	        System.out.println();
	    }
	}
}