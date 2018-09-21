package easy;

import java.util.*;

/**
 * 
 * @author DonYoo

http://prepinsta.com/amcat-automata-questions/

Program to remove all vowels from a given string using pointers

Input:

PrepInsta


 */


public class remove_all_vowels {

	static Scanner scan;
	
	private static boolean isVowel(String s){
		if(s.equals("a") ||
				s.equals("A") ||
				s.equals("e") ||
				s.equals("E") ||
				s.equals("i") ||
				s.equals("I") ||
				s.equals("o") ||
				s.equals("O") ||
				s.equals("u") ||
				s.equals("U")
				){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		
		String[] sinput = input.split("");
		
		for(String s: sinput){
			if(!isVowel(s)){
				System.out.print(s);
			}
		}
	}

}
