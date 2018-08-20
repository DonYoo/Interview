package BinarySerach;

import java.util.Random;

/**
 * 
 * @author DonYoo

https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/

Maximum Path Sum in a Binary Tree
Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

Example:

Input: Root of below tree
       1
      / \
     2   3
Output: 6

See below diagram for another example.
1+2+3
tree

Recommended: Please try your approach on {IDE} first, before moving on to the solution.


For each node there can be four ways that the max path goes through the node:
1. Node only
2. Max path through Left Child + Node
3. Max path through Right Child + Node
4. Max path through Left Child + Node + Max path through Right Child

The idea is to keep trace of four paths and pick up the max one in the end. 
An important thing to note is, root of every subtree need to return maximum path sum 
such that at most one child of root is involved. This is needed for parent function call. 
In below code, this sum is stored in ‘max_single’ and returned by the recursive function.


 */

class newNode extends Node<Integer>{

	public newNode(int data) {
		super(data);
	}
	
}

class Result{
	int value;
	
	public Result(){
		value = Integer.MIN_VALUE;
	}
}

public class MaximumPath {
	
	public static int findMaxSum(Node<Integer> root, Result res){
		if(root == null){
			return 0;
		}
		
		
		int left = findMaxSum(root.leftchild, res);
		
		int right = findMaxSum(root.rightchild, res);
		
		// Max path for parent call of root. This path must
        // include at-most one child of root
		int leftORright = Math.max(root.data + Math.max(left, right),
				root.data);
		
		// Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
		int sum = Math.max(root.data + left + right, leftORright);
		
		// Store the Maximum Result.
		res.value = Math.max(sum, res.value);
		
		return leftORright;
	}
	
	public static void main(String[] args) {
		newNode tree = new newNode(10);
        tree.leftchild = new Node<Integer>(2);
        tree.rightchild = new Node<Integer>(10);
        tree.leftchild.leftchild = new Node<Integer>(100);
        tree.leftchild.rightchild = new Node<Integer>(1000);
        tree.rightchild.rightchild = new Node<Integer>(-25);
        tree.rightchild.rightchild.leftchild = new Node<Integer>(3);
        tree.rightchild.rightchild.rightchild = new Node<Integer>(4);
        
        Result res = new Result();
        findMaxSum(tree, res);
        
        System.out.println("maximum path sum is : " + res.value);
	}

}
