package BinarySerach;

import java.util.*;

/**
 * 
 * @author DonYoo

Find median of BST in O(n) time and O(1) space
Given a Binary Search Tree, find median of it.

If no. of nodes are even: then median = ((n/2th node + (n+1)/2th node) /2
If no. of nodes are odd : then median = (n+1)th node.

For example, median of below BST is 12.


More Examples:

 Given BST(with odd no. of nodes) is : 
                    6
                 /    \
                3       8
              /   \    /  \
             1     4  7    9

Inorder of Given BST will be : 1, 3, 4, 6, 7, 8, 9
So, here median will 6.

Given BST(with even no. of nodes) is :  
                    6
                 /    \
                3       8
              /   \    /  
             1     4  7    

Inorder of Given BST will be : 1, 3, 4, 6, 7, 8
So, here median will  (4+6)/2 = 5.
 */


class myNode{
	
	public int data;
	public myNode right;
	public myNode left;

	public myNode(int input){
		right = null;
		left = null;
		data = input;
	}
}

class Count{
	public int count;
	
	public Count(){
		count = 0;
	}
}

class Answer{
	public int answer;
	public int odd; 
	
	public Answer(){
		answer = 0;
	}
	
}

public class median_BST {

	
	private static myNode insert(myNode node, int input){
		myNode newNode = new myNode(input);
		
		if(node == null){
			node = newNode;
			return node;
		}
		if(node.data < input){
			node.right =  insert(node.right, input);
		}
		else{
			node.left = insert(node.left, input);
		}
		return node;
	}
	
	
	private static int getSize(myNode node, Count count){
		if(node == null){
			return 0;
		}
		
		getSize(node.left, count);
		count.count += 1;
		getSize(node.right, count);
		
		return count.count;
	}
	
	private static int median(myNode node, int[] index, Answer result){
		if(node == null){
			return 0;
		}
		
		
		median(node.left, index, result);
		index[0]--;
		if(index[0] == 0){
			// odd size
			if(result.odd == 1){
				return node.data;
			}
			else{
				index[0]++;
				if(result.answer != 0){
					return (result.answer += node.data)/2;
				}
				result.answer = node.data;
				return 0;
			}
		}
		median(node.right, index, result);
		return 0;
	}
	
	private static int findMedian(myNode node){
		Count count = new Count();
		int size = getSize(node, count);
		int [] index = {size/2 + size%2};
		
		Answer result = new Answer();
		result.odd = size%2;
		
		return median(node, index, result);
	}
	
	public static void main(String[] args) {

		 
	    /* Let us create following BST
	                  50
	               /     \
	              30      70
	             /  \    /  \
	           20   40  60   80 */
		

	    myNode root = new myNode(50);
	    insert(root, 30);
	    insert(root, 20);
	    insert(root, 40);
	    insert(root, 70);
	    insert(root, 60);
	    
	 
	    System.out.println(findMedian(root));
	}

}
