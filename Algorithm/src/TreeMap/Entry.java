package TreeMap;

import java.util.*;

public class Entry {

	public static void main(String[] args) {
		TreeMap<Integer, String> employees = new TreeMap<>();
		
		employees.put(1003, "Rajeev");
        employees.put(1001, "James");
        employees.put(1002, "Sachin");
        employees.put(1004, "Chris");

        System.out.println("Employees map : " + employees);
        
        // finding a size.
        System.out.println("Total number of employees : " + employees.size());
        
        // check if given key is exist.
        
        Integer id = 1004;
        
        if(employees.containsKey(id)){
        	// get value
        	String name = employees.get(id);
        	
        	System.out.println("Employee with id " + id + " : " + name);
        }
        else{
        	System.out.println("Employee with id " + id +"does not exist");
        }

        // first entry
        System.out.println("First Entry in employees map : " + employees.firstEntry());
        
        // last entry
        System.out.println("Last Entry in employees map : " + employees.lastEntry());
        
        // entry whose key is just less than the given key.
        Map.Entry<Integer, String> employeeJustBelow = employees.lowerEntry(1002);
        System.out.println(employeeJustBelow);
        
        
        // entry whose key is just higher than the given key.
        Map.Entry<Integer, String> employeeJustHigher = employees.higherEntry(1002);
        System.out.println(employeeJustHigher);
	}

}
