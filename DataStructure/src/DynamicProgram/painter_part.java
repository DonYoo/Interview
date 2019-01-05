package DynamicProgram;
import java.util.*;

public class painter_part {

static Scanner scan;
    
    public static int sum(int[] input, int start, int end){
        int sum =0;
        for(int i = start-1; i<=end-1; i++){
            sum += input[i];
        }
        return sum;
    }
    
    public static int findMinimum(int[] input, int painter){
        
        int size = input.length + 1;
        painter += 1;
        
        int [][] mat = new int[size][painter];
        
        // initial when painter is 1
        for(int i=1; i<size; i++){
            mat[i][1] = sum(input, 1, i);
        }
        
        // initial when size is 1
        for(int i=1; i<painter; i++){
            mat[1][i] = input[0];
        }
        
        for(int eachpaint=2; eachpaint<painter; eachpaint++){
            for(int part=2; part<size; part++){
                
                int min = Integer.MAX_VALUE;
                
                // dynamic programming
                for(int k=1; k<part; k++){
                    // get first half
                    // 1 less painter from previous
                    int first_half = mat[k][eachpaint-1];
                    
                    // get second half
                    // sum of rest 
                    int second_half = sum(input, k+1, part);
                    
                    // get bigger one comparing first half and second half
                    int max = Math.max(first_half, second_half);
                    
                    // compare min from all previous input
                    min = Math.min(max, min);
                }
                mat[part][eachpaint] = min;
            }
        }
        return mat[size-1][painter-1];
    }
    
	public static void main (String[] args)
	{
	    scan = new Scanner(System.in);
	    
	    int testcase = scan.nextInt();
	    
	    while(testcase-->0){
	        int painter = scan.nextInt();
	        int size = scan.nextInt();
	        
	        int[] input = new int[size];
	        
	        for(int i=0; i<size; i++){
	            input[i] = scan.nextInt();
	        }
	        
	        System.out.println(findMinimum(input, painter));
	    }
	}
}
