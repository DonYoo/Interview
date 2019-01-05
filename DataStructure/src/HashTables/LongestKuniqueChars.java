package HashTables;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map.Entry;

class LongestKuniqueChars
{
    static Scanner scan;
    
    public static int findmax(HashMap <Character, Integer>map, int max){
    	int sum = 0;
        // go over the map
        for(Entry<Character, Integer> each:map.entrySet()){
            sum += each.getValue();
        }
        // compare with max value
        if(max<sum){
            max = sum;
        }
        return max;
    }
    
    public static int LongestK(String input, int k){
        int max = 0;
        int size = input.length();
        
        HashMap <Character, Integer> map = new HashMap<>();
        
        int lastindex = 0;
        char startChar = '\0';
        
        for(int i=0; i<size; i++){
            char indv = input.charAt(i);
            
            if(map.containsKey(indv)){
                map.replace(indv, map.get(indv) +1);
            }
            else{
                int mapSize = map.size();
                if(mapSize == 0){
                	startChar = indv;
                	// start from current index
                	lastindex = i;
                }
                if(mapSize == k){
                    max = findmax(map, max);
                    map = new HashMap<>();
                    // this is starting character
                    i = lastindex;
                }
                // just add another one.
                else{
                    map.put(indv, 1);
                }
            }
        }
        if(map.size() != k){
        	return -1;
        }
        else{
        	max = findmax(map, max);
        }
        return max;
    }
    
	public static void main (String[] args)
	{
	    scan = new Scanner(System.in);
	    
	    int testcase = scan.nextInt();
	    scan.nextLine();
	    
	    while(testcase-->0){
	        String input = scan.nextLine();
	        int k = Integer.parseInt(scan.nextLine());
	        System.out.println(LongestK(input, k));
	    }
	}
}