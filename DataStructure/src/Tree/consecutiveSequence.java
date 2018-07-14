package Tree;

/**
 * 
 * @author DonYoo



https://www.geeksforgeeks.org/longest-consecutive-sequence-binary-tree/
https://practice.geeksforgeeks.org/problems/longest-consecutive-sequence-in-binary-tree/1

Given a n-ary tree. Find the longest path (top to down) with consecutive integers in increasing order

	1
     2
      4
       5
        6
         7
          8

 */

class aNode{
	int data;
	aNode left;
	aNode right;
	
	public aNode(int input){
		this.data = input;
		this.left = null;
		this.right = null;
	}
}

public class consecutiveSequence {

	public static aNode insert(aNode node, int data){
		if(node == null){
			node = new aNode(data);
			return node;
		}
		if(node.data < data){
			node.right = insert(node.right, data);
		}
		else if(node.data > data){
			node.left = insert(node.left, data);
		}
		return node;
	}
	
	public static int longestConsecutive(aNode node){
		int[] max = {0};
		int result = longSequence(node, Integer.MIN_VALUE, max);
		if(result == 0){
		    result = -1;
		}
		else{
		    result ++;
		}
		return result;
	}
	
	public static int longSequence(aNode node, int prev, int[] max){
		if(node == null){
			return 0;
		}
		
		int lh = longSequence(node.left, node.data, max);
		int rh = longSequence(node.right, node.data, max);
		
		int compare = 0;
		if(prev + 1 == node.data){
			compare = Math.max(lh, rh) + 1;
			if(compare >= max[0]){
				max[0] = compare;
				return max[0];
			}
		}
		else{
			if(prev == Integer.MIN_VALUE){
				return max[0]; 
			}
			return 0;
		}
		return compare;
	}
	
	public static void main(String[] args) {
		aNode input = new aNode(0);
		
		input.left = new aNode(1);
		input.right = new aNode(2);
		input.left.left = new aNode(3);
		input.left.right = new aNode(4);
		
		input.right.left = new aNode(5);
		input.right.right = new aNode(6);
		
		/*
		input.right.right = new aNode(10);
		input.right.right.right = new aNode(11);
		*/
		
		int result = longestConsecutive(input);
		System.out.println(result);
	}
}
