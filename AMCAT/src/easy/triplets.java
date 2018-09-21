package easy;

import java.util.*;

/**
 * 
 * @author DonYoo

http://prepinsta.com/amcat-automata-questions/

Find the number of all possible triplets in the array that can form the triangle( condition is a+b>c) .


 */
public class triplets {

	static Scanner scan;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		
		int [] input = new int[size];
		
		for(int i=0; i<size; i++){
			input[i]= scan.nextInt();
		}
		
		Arrays.sort(input);
		
		/*
		 * Arrays.sort(int[]) in all Java standard library implementations that I know, 
		 * is an example of a comparison-based sort and thus must have worst-case complexity O(n log n). 
		 * In particular, Oracle Java 7 uses a dual-pivot quicksort variant for the integer overloads, 
		 * which actually has an O(n2)worst case.
		 * 
		 */
		
		for(int i=0; i<size; i++){
			int a = input[i];
			for(int j=i+1; j<size-1; j++){
				int b = input[j];
				int c = input[j+1];
				
				if((a+b)>c){
					System.out.println(a+" "+b+" "+c+" ");
				}
			}
		}
	}

}
