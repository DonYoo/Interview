package TreeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class compare {

	public static void main(String[] args) {
		  /*
         * Custom Comparator
         * Descending Order
         * 
         * format
        	new Comparator<>(){
        		@Override
				public int compare(String o1, String o2) {
	        	}
         */
        
        Map<String, String> descending = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				int test = o2.compareTo(o1);
				
				//System.out.println(o1 + " " + o2);
				//System.out.println(test);
				
				return test;
			}
        });
        
        descending.put("python", ".py");
        descending.put("c++", ".cpp");
        descending.put("kotlin", ".kt");
        descending.put("golang", ".go");
        descending.put("java", ".java");
        
        System.out.println(descending);
	}

}
