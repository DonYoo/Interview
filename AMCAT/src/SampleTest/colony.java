package SampleTest;

import java.util.*;


public class colony {

    public static List<Integer> cellCompete(int[] states, int days)
    {
    	List<Integer> test = new LinkedList<>();
    	
    	int prev = 0;
    	int next = 0;
    	
    	for(int d=0; d<days; d++){    		
    		int [] temp = states.clone();
    		
    		
    		for(int i=0; i<states.length; i++){
        		if(i==0){
        			prev = 0;
        		}
        		else{
        			prev = temp[i-1];
        		}
        		if(i == 7){
        			next = 0;
        		}
        		else{
        			next = temp[i+1];
        		}
        		
        		if(prev != next){
        			states[i] = 1;
        		}
        		else{
        			states[i] = 0;
        		}
        	}
    		
    	}
    	
    	for(int i=0; i<states.length; i++){
    		test.add(states[i]);
    	}
    	
		return test;
    }
    
	public static void main(String[] args) {
		
		
		int [] states = {1,1,1,0,1,1,1,1};
		
		
		int days = 2;
		
		System.out.println(cellCompete(states, days));
	}

}
