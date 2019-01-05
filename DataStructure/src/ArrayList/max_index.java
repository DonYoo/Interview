package ArrayList;

import java.util.*;
import java.lang.*;
import java.io.*;


/**
 * 
Input:
1
9
34 8 10 3 2 80 30 33 1

Output:
6

**/

class compare implements Comparator<mpair>{
    
    public int compare(mpair p1, mpair p2){
        if(p1.val < p2.val){
            return -1;
        }
        else if(p1.val > p2.val){
            return 1;
        }
        else{
            if(p1.pos < p2.pos){
                return -1;
            }
            else{
                return 1;
            }
        }
    }
    
}

class mpair{
    int val;
    int pos;
    
    public mpair(int val, int pos){
        this.val = val;
        this.pos = pos;
    }
}

class max_index
{
    static Scanner scan;
    
    public static int findIndex(mpair[] input, int inputSize){
        int max = 0;
        int min = input[0].pos;
        
        for(int i=1; i<inputSize; i++){
            int current = input[i].pos;
            
            //System.out.println(current);
            
            if(current<min){
                min = current;
            }
            else{
                int temp = current - min;
                max = Math.max(temp, max);
            }
        }
        return max;
    }
    
	public static void main (String[] args)
	{
	    scan = new Scanner(System.in);
	    
	    int testcase = scan.nextInt();
	    
	    while(testcase-->0){
	        int inputSize = scan.nextInt();
	        
	        mpair [] input = new mpair [inputSize];
	        
	        for(int i=0; i<inputSize; i++){
	            input[i] = new mpair(scan.nextInt(), i);
	        }
	        
	        Arrays.sort(input, new compare());
	        
	        System.out.println(findIndex(input, inputSize));
	    }
	}
}