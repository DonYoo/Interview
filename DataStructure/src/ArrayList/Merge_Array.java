package ArrayList;

/**
 * 
 * @author DonYoo
 *
 *

https://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/

Q1. There are 2 arrays . Smaller is of size m and has m elements in sorted order. The bigger array is
of size m+n, where there are only n elements in initial n positions in sorted order. So, last m
positions are empty in the bigger array.Insert smaller array’s m elements in m+n array has has all numbers in sorted order.

Example : 
Input Array    N[]={5, 9, 15, 20,,,,,, }  n=4
               M[]={1, 3, 6, 8, 19, 35}  m=6
Output array   N[]={1, 3, 5, 6, 8, 9, 15, 19, 20, 35}

 */


public class Merge_Array {
	
	public void movetoEnd(int [] one){
		int index = one.length-1;
		for(int i=one.length-1; i>=0; i--){
			if(one[i] != -1){
				one[index] = one[i];
				if(index != i){
					one[i] = -1;
				}
				index --;
			}
		}
	}
	
	public void Merge(int[] one, int[] two){
		int oneIndex = 0;
		int twoIndex = 0;
		
		// make oneIndex to the location where digit start first
		for(int i = 0; i<one.length; i++){
			if(one[i] != -1){
				oneIndex = i;
				break;
			}
		}
		
		for(int i=0; i<one.length; i++){
			if(twoIndex == two.length){
				one[i] = one[oneIndex];
				oneIndex++;
			}
			
			else if(oneIndex == one.length){
				one[i] = two[twoIndex];
				twoIndex++;
			}
			
			else if(one[oneIndex] < two[twoIndex]){
				one[i] = one[oneIndex];
				oneIndex++;
			}
			else{
				one[i] = two[twoIndex];
				twoIndex++;
			}
		}
	}

	public static void main(String[] args) {
		int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        
        Merge_Array test = new Merge_Array();
        
        test.movetoEnd(mPlusN);
        
        for(int i=0; i<mPlusN.length; i++){
        	System.out.print(mPlusN[i] + " ");
        }
        
        
        test.Merge(mPlusN, N);
        
        System.out.println();
        
        for(int i=0; i<mPlusN.length; i++){
        	System.out.print(mPlusN[i] + " ");
        }
        
	}

}
