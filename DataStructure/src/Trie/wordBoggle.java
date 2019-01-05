package Trie;

import java.util.*;

/**
 * 
 * @author DonYoo

Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.

Example:

Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G','I','Z'},
                       {'U','E','K'},
                       {'Q','S','E'}};

Output:  Following words of dictionary are present
         GEEKS, QUIZ

Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an integer x denoting the no of words in the dictionary. Then in the next line are x space separated strings denoting the contents of the dictinory. In the next line are two integers N and M denoting the size of the boggle. The last line of each test case contains NxM space separated values of the boggle.

Output:
For each test case in a new line print the space separated sorted distinct words of the dictionary which could be formed from the boggle. If no word can be formed print -1.

Constraints:
1<=T<=10
1<=x<=10
1<=n,m<=7

Example:
Input:
1
4
GEEKS FOR QUIZ GO
3 3
G I Z U E K Q S E

Output:
GEEKS QUIZ

 */

class myTrieNode{
	private HashMap<Character, myTrieNode> children;
	private String text;
	private boolean isWord;
	
	public myTrieNode(){
		children = new HashMap<>();
		text = "";
		isWord = false;
	}
	// initial with input string
	public myTrieNode(String text){
		this();
		this.text = text;
	}
	
	public HashMap<Character, myTrieNode> getChildren(){
		return children;
	}
	
	public String getText(){
		return text;
	}
	
	public boolean isWord(){
		return isWord;
	}
	
	public void setWord(boolean bool){
		isWord = bool;
	}
	// Println
	@Override
	public String toString(){
		return text;
	}
}

class myTrie{
	// the root doesn't not contain any hashmap.
	// children does.
	private myTrieNode root;
	
	public myTrie(){
		root = new myTrieNode();
	}
	
	public myTrieNode getNode(){
		return root;
	}
	
	public void insertWord(String word){
		char[] splitChar = word.toCharArray();
		
		myTrieNode temp = root;
		
		for(char eachword:splitChar){
			// if each char already exist
			if(temp.getChildren().containsKey(eachword)){
				// go to next child
				temp = temp.getChildren().get(eachword);
			}
			// char is not exist
			else{
				myTrieNode child = new myTrieNode(temp.getText() + eachword);
				// make a new children
				temp.getChildren().put(eachword, child);
				// go into next child
				temp = temp.getChildren().get(eachword);
			}
		}
		// after putting all the char, make it as a word
		temp.setWord(true);
	}
}

class coordination{
	private int max_row;
	private int max_col;
	
	private int current_row;
	private int current_col;
	
	private char[][] matrix;
	private boolean[][] visited;
	private myTrieNode trie;
	
	public coordination(int max_row, int max_col, int current_row, int current_col, char[][]matrix, boolean[][]visited, myTrieNode trie){
		this.max_row = max_row;
		this.max_col = max_col;
		
		this.current_row = current_row;
		this.current_col = current_col;
		
		this.matrix = matrix;
		this.visited = visited;
		this.trie = trie;
	}
	
	public myTrieNode getTrie(){
		return trie;
	}
	
	public int getRow(){
		return current_row;
	}
	
	public int getCol(){
		return current_col;
	}
	
	public boolean isValid(){
		// if coordi is within a range
		if(current_row >= 0 && current_row < max_row){
			if(current_col >= 0 && current_col < max_col){
				char letter = matrix[current_row][current_col];
				// if it is not visited
				if(visited[current_row][current_col] == false){
					if(trie.getChildren().containsKey(letter)){
						// set trie to the next one.
						trie = trie.getChildren().get(letter);
						return true;
					}
				}
			}
		}
		return false;
	}
}

public class wordBoggle {

    static Scanner scan;
    
	public static void main (String[] args)
	{
	    scan = new Scanner(System.in);
	    int testcase = scan.nextInt();
	    
	    // each case.
	    while(testcase-->0){
	    	
	    	int numOfWords = scan.nextInt();
	    	myTrie trie = new myTrie();
	    	
	    	// insert all the words in trie
	    	while(numOfWords-->0){
	    		String word = scan.next();
	    		
	    		trie.insertWord(word);
	    	}
	    	
	    	// get the word for the matrix.
	    	int rows = scan.nextInt();
	    	int columns = scan.nextInt();
	    	
	    	char[][] matrix = new char[rows][columns];
	    	
	    	for(int i=0; i<rows; i++){
	    		for(int j=0; j<columns; j++){
	    			matrix[i][j] = scan.next().charAt(0);
	    		}
	    	}
	    	
	    	/* 
	    	print all the input in order.
	    	for testing purpose 
	    	
	    	System.out.println();
	    	for(int i=0; i<rows; i++){
	    		for(int j=0; j<columns; j++){
	    			System.out.print(matrix[i][j] +" ");
	    		}
	    		System.out.println();
	    	}
	    	System.out.println();
	    	*/
	    	
	    	Queue<String> result = new PriorityQueue<>();
	    	
	    	// go through each word
	    	for(int start_y=0; start_y<rows; start_y++){
	    		// go each columns
	    		for(int start_x=0; start_x<columns; start_x++){
	    			// get the first word
	    			char letter = matrix[start_y][start_x];
	    			
	    			// temp visited matrix
	    			boolean[][]visited = new boolean [rows][columns];
	    			// mark current position as visited.
	    			visited[start_y][start_x] = true;
	    			
	    			myTrieNode child = trie.getNode().getChildren().get(letter);
	    			// if can't find first letter, go to next letter
	    			if(child != null){
		    	    	// new class for valid
	    				// coordination has limit row,col, and current row,col, visited and myTrieNode
		    	    	coordination coord = new coordination(rows, columns, start_y, start_x,  matrix, visited, child);
		    	    	
		    	    	// make a que and track the path.
		    			Queue <coordination> que = new LinkedList<>();
		    			que.add(coord);
		    			
		    			// keep in the loop till the que is empty.
		    			while(!que.isEmpty()){
		    				coordination current = que.poll();
		    				int temp_x = current.getCol();
		    				int temp_y = current.getRow();
		    				
		    				child = current.getTrie();
		    				// if its word, print it out and keep going.
							if(child.isWord()){
								result.add(child.getText());
								//System.out.print(child.getText() + " ");
								// this still change the original node.
								child.setWord(false);
							}
							
		    				// try 8 other ways.
		    				coordination[] diff_ways = new coordination[8];
		    				
	    					diff_ways[0] = new coordination(rows, columns, temp_y-1, temp_x-1, matrix, visited, child);
	    					diff_ways[1] = new coordination(rows, columns, temp_y, temp_x-1, matrix, visited, child);
	    					diff_ways[2] = new coordination(rows, columns, temp_y+1, temp_x-1, matrix, visited, child);
	    					diff_ways[3] = new coordination(rows, columns, temp_y-1, temp_x+1, matrix, visited, child);
	    					diff_ways[4] = new coordination(rows, columns, temp_y, temp_x+1, matrix, visited, child);
	    					diff_ways[5] = new coordination(rows, columns, temp_y+1, temp_x+1, matrix, visited, child);
	    					diff_ways[6] = new coordination(rows, columns, temp_y-1, temp_x, matrix, visited, child);
	    					diff_ways[7] = new coordination(rows, columns, temp_y+1, temp_x, matrix, visited, child);
	    					
	    					// check if they are valid
	    					for(int i=0; i<8; i++){
	    						if(diff_ways[i].isValid()){
	    							que.add(diff_ways[i]);
	    						}
	    					}
		    			}
	    			}   			
	    		}
	    	}
	    	if(result.isEmpty()){
	    		System.out.println(-1);
	    	}
	    	else{
	    		while(!result.isEmpty()){
	    			System.out.print(result.poll());
	    			if(!result.isEmpty()){
	    				System.out.print(" ");
	    			}
	    		}
	    		System.out.println();
	    	}
	    }
	}
}



