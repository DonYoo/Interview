package easy;



/**
 * 
 * @author DonYoo

http://prepinsta.com/amcat-automata-questions/

Find the occurrence of a substring in a parent string

Input:

aAbcDefabcAdf

Substring : abc

answer 1


 */

public class substring {

	public static void main(String[] args) {
		String input = "aAbcDefabcAdf";
		
		String sub = "abc";
		
		int total = 0;
		
		// find first match.
		int index = input.indexOf(sub);
		
		while(index != -1){
			total++;
			// find next match after first word
			input = input.substring(index+sub.length());
			index = input.indexOf(sub);
		}
		System.out.println(total);
	}

}
