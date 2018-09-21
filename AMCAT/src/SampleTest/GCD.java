package SampleTest;

import java.util.*;

public class GCD {

	private static boolean cal(int answer, int[] arr, int num){
        for(int i=0; i<num; i++){
            if(arr[i]%answer != 0){
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		int [] arr = {2,3,4,5,6};
		
		int min = arr[0];
        
		for(int i=min;i>0;i--){
            if(cal(i, arr, arr.length)){
                min = i;
                break;
            }
        }
        System.out.println(min);
	}

}
