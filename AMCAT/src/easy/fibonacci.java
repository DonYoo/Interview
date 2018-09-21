package easy;

import java.util.*;

public class fibonacci {

	static Scanner scan;
	
	// top to bottom.
	private static int fbTerm(int sample){
		if(sample == 0){
			
			return 0;
		}
		if(sample == 1){
			
			return 1;
		}
		return fbTerm(sample-1) + fbTerm(sample-2);
		
	}
	
	
	//bottom to top
	private static void fbSequence(int input){
		int first = 0;
		int second = 1;
		
		int third = first + second;
		System.out.print(0);
		while(third < input){
			System.out.print(" "+ third);
			first = second;
			second = third;
			third = first + second;
		}
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		
		//System.out.println(fbTerm(input));
		
		fbSequence(input);
	}

}
