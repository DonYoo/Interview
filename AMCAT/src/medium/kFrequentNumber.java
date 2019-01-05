package medium;

import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * @author DonYoo
 * 
 * 
https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/

Given an array of n numbers and a positive integer k. The problem is to find k numbers with most occurrences, i.e., the top k numbers having the maximum frequency. If two numbers have same frequency then the larger number should be given preference. The numbers should be displayed in decreasing order of their frequencies. It is assumed that the array consists of k numbers with most occurrences.

Examples:

Input : arr[] = {3, 1, 4, 4, 5, 2, 6, 1}, 
             k = 2
Output : 4 1
Frequency of 4 = 2
Frequency of 1 = 2
These two have the maximum frequency and
4 is larger than 1.

Input : arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9},
            k = 4
Output : 5 11 7 10

 */

class ValueComparator implements Comparator<Integer>{
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	 
    public ValueComparator(HashMap<Integer, Integer> m){
        map.putAll(m);
    }
    
    // -1 = no change, 1 = reversed.
    
	@Override
	public int compare(Integer o1, Integer o2) {
		
		// example
		// o1 = 3, o2 = 1.
		// o2 - o1 = -2.
		// so no change.
		int diff = map.get(o2)-map.get(o1);
		
		// if value is the same, depends on the key value now.
		if(diff==0){
			if(o1 > o2){
				return -1;
			}
            return 1;
        }
		
		// depends on the sub, put an order.
		else{
            return diff;
        }
	}
	
}
public class kFrequentNumber {
	
	private static void print_N_mostFrequentNumber(int[]arr, int n, int k){
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i:arr){
			if(map.containsKey(i)){
				map.replace(i, map.get(i)+1);
			}
			else{
				map.put(i, 1);
			}
		}
		
		System.out.println(map);

		int [] shorted = new int [n];
		
		int ind = 0;
		
		Map<Integer, Integer> treeMap = new TreeMap<>(new ValueComparator(map));
		treeMap.putAll(map);
		
		System.out.println(treeMap);
	}
	
	public static void main(String[] args) {
		int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
	    int k = 2;
	    print_N_mostFrequentNumber(arr, arr.length, k);
	}

}
