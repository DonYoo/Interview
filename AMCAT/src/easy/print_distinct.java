package easy;

import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * @author DonYoo

http://prepinsta.com/amcat-automata-questions/


Program to print all distinct elements of given input arrays.

Also

print the total of the distinct elements.


 */


public class print_distinct {

	public static void main(String[] args) {
		
		int [] arr1 = {1,2,3,4,5};
		int [] arr2 = {2,6,8,10};
		
		Map <Integer,Integer>map = new HashMap<>();
		
		for(int i:arr1){
			map.put(i, 1);
		}
		
		for(int i:arr2){
			if(map.containsKey(i)){
				map.remove(i);
			}
			else{
				map.put(i, 1);
			}
		}
		
		for(Entry<Integer, Integer> i:map.entrySet()){
			System.out.print(i.getKey() + " ");
		}
		
		System.out.println("\n" + map.size());
		
	}

}
