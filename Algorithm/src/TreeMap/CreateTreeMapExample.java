package TreeMap;

import java.util.*;

/**
 * 
 * @author DonYoo
 * 

https://www.callicoder.com/java-treemap/


The SortedMap interface provides functionalities to maintain the ordering of keys. And the NavigableMap interface provides functionalities to navigate through the map. For example, finding the entry just greater than or just less than the given key, finding the first and last entry in the TreeMap etc.

Since a TreeMap implements NavigableMap interface, it has the functionalities of both the NavigableMap as well as the SortedMap.

Following are few key points to note about TreeMap in Java -

A TreeMap is always sorted based on keys. The sorting order follows the natural ordering of keys. You may also provide a custom Comparator to the TreeMap at the time of creation to let it sort the keys using the supplied Comparator.

A TreeMap cannot contain duplicate keys.

TreeMap cannot contain the null key. However, It can have null values.

TreeMap is not synchronized. Access to TreeMaps must be synchronized explicitly in a multi-threaded environment.


 */

public class CreateTreeMapExample {

	public static void main(String[] args) {
		
		// create treeMap
		Map<String, String> fileExtensions = new TreeMap<>();
		
		// add key-value pair.
		fileExtensions.put("python", ".py");
        fileExtensions.put("c++", ".cpp");
        fileExtensions.put("kotlin", ".kt");
        fileExtensions.put("golang", ".go");
        fileExtensions.put("java", ".java");

        System.out.println(fileExtensions);       
	}

}
