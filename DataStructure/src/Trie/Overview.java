package Trie;

import java.util.*;

/**
 * 
 * @author DonYoo

https://examples.javacodegeeks.com/core-java/trie-tutorial-java/


 */

class TrieNode{
	private HashMap<Character, TrieNode> children;
	private String text;
	private boolean isWord;
	
	// initialize the class	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		text = "";
		isWord = false;
	}
	
	public TrieNode(String text){
		this();
		this.text=text;
	}
	
	public HashMap<Character, TrieNode> getChildren(){
		return children;
	}
	
	public String getText(){
		return text;
	}
	
	public boolean isWord(){
		return isWord;
	}
	
	public void setIsWord(boolean word){
		isWord = word;
	}
	
	//@Override
	public String toString(){
		return text;
	}
}

class Trie{
	private TrieNode root;
	private int size;
	
	public Trie(){
		root = new TrieNode();
		size = 0;
	}
	
	public TrieNode insertChar(TrieNode trie, Character c){
		if(trie.getChildren().containsKey(c)){
			return null;
		}
		
		TrieNode next = new TrieNode(trie.getText() + c.toString());
		trie.getChildren().put(c, next);
		return next;
	}
	
	public TrieNode getChild(TrieNode trie, Character c){
		return trie.getChildren().get(c);
	}
	
	
	/** 
	1. Set current node to root node. The root node does not contain any letter (initialized to the null character for convenience).
	
	2. Convert the word to a char array.
	
	3. Set the current letter to the first letter in the word.
	
	4. If the current node already has an existing reference to the current letter 
	(through one of the elements in the “children” field) then set current node to that referenced node.
	 Otherwise, create a new node, set the letter to current letter, and set current node to this new node. 
	 Repeat step 3 until all letters in the current word has been processed.
	*/
	
	public boolean add(String word){
		TrieNode trie = root;

		if(trie == null || word == null){
			return false;
		}
		
		char[] chars = word.toCharArray();
		int counter = 0;
		
		while(counter < chars.length){
			// get all the key list
			Set childs = trie.getChildren().keySet();
			
			if (!childs.contains(chars[counter])){
				insertChar(trie, chars[counter]);
				if(counter == chars.length - 1){
					getChild(trie, chars[counter]).setIsWord(true);
					size++;
					return true;
				}
			}
			trie = getChild(trie, chars[counter]);
			if(trie.getText().equals(word) && !trie.isWord()){
				trie.setIsWord(true);
				size++;
				return true;
			}
			counter++;
		}
		return false;	
	}
	
	public boolean find(String str){
		Map<Character, TrieNode> children = root.getChildren();
		TrieNode t = null;
		for( int i=0; i< str.length(); i++){
			char c = str.charAt(i);
			if( children.containsKey(c)){
				t = children.get(c);
				children = t.getChildren();
			}
			else{
				return false;
			}
		}
		return true;
	}
	
}

public class Overview {

	public static void main(String[] args) {
		
		// setup
		Trie trie = new Trie();
		trie.add("GEEKS");
		trie.add("FOR");
		trie.add("GO");
		trie.add("QUIZ");
		
		System.out.println(trie.find("ats"));
		System.out.println(trie.find("at"));
	}

}
