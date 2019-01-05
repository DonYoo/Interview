package HashTables;

import java.util.*;

public class pickBest3duplicate {

    static Scanner scan;
	public static void main (String[] args)
	{
	    scan = new Scanner(System.in);

	    int testcase = scan.nextInt();
	    
	    while(testcase-->0){
	        int noItem = scan.nextInt();
	        int maxVol = scan.nextInt();
	        scan.nextLine();
	        
	        HashMap<Integer, Integer> map = new HashMap<>();
	        
	        String[] value = scan.nextLine().split(" ");
	        
	        String[] weight = scan.nextLine().split(" ");
	        
	        
	        
	        System.out.println(value);
	        System.out.println(weight);
	        
	    }
	}
}
