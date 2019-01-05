package ArrayList;

/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/maximum-index/0

Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
Example :
A : [3 5 4 2]
Output : 2 
for the pair (3, 4)

Input:
The first line contains an integer T, depicting total number of test cases.  Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.

Output:
Print the maximum difference of the indexes i and j in a separtate line.

Constraints:
1 <= t <= 100
1 <= N <= 1000
0 <= A[i] <= 100

Example:
Input:
1
2
1 10

Output:
1


 */

import java.util.*;

// p1<p2 return -1 is normal order
// p1<p2 return 1 reversed order
// p1==p2 return 0

class comp implements Comparator<pair>{
    public int compare(pair p1, pair p2){
        if(p1.value < p2. value){
            return 1;
        }
        // if they are the same value, 
        // compare with index that higher goes first.
        else if(p1.value == p2.value){
            if(p1.index < p2.index){
            	return 1;
            }
            else if(p1.index == p2.index){
            	return 0;
            }
            return -1;
        }
        else{
            return -1;
        }
    }
}

class pair{
    public int value;
    public int index;
    
    public pair(int val, int ind){
        value = val;
        index = ind;
    }
}

public class maximum_index
{
    static Scanner scan;
    
    public static int maxIndex(int[] input, int size){
        // sort by the number
        pair[] arrayPair = new pair[size];
        
        for(int i=0; i<size; i++){
            arrayPair[i] = new pair(input[i], i);
        }
        
        Arrays.sort(arrayPair, new comp());
        
        int index_max = 0;
        int highest = arrayPair[0].index;
        
        for(int i=1; i<size; i++){
            // distance btw highest and current.
            index_max = Math.max(index_max, highest - arrayPair[i].index);
            
            // compare the index position.
            highest = Math.max(arrayPair[i].index, highest);
        }
        return index_max;
    }
    
	public static void main (String[] args)
	{
	    scan = new Scanner(System.in);
	    
	    int testcase = scan.nextInt();
	    
	    while(testcase-->0){
	        int size = scan.nextInt();
	        int[] input = new int[size];
	        
	        for(int i=0; i<size; i++){
	            input[i] = scan.nextInt();
	        }
	        System.out.println(maxIndex(input, size));
	    }
	}
}