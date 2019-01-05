package BinarySerach;

import java.util.*;

/**
 * 
 * @author DonYoo
 *
 *

Binary Search Tree, is a node-based binary tree data structure which has the following properties:

The left subtree of a node contains only nodes with keys lesser than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
The left and right subtree each must also be a binary search tree.
There must be no duplicate nodes.

 * 
 * 
 * Question 1.
 * Given some BST (binary search tree), find the nearest
 * element to some target value.
 *
 * int findNearestInBst(Node root, int target);
 *
 * tree := [1, 3, 5, 7, 10]
 *
 * findNearestInBst(tree, 7)  => 7
 * findNearestInBst(tree, 8)  => 7     abs(8-7) < abs(8-10)
 * 
 * BST FindNearest search O log(n) memory O(1)

 */


class testNode{
	public testNode left;
	public testNode right;
	int data;
	
	public testNode(int data){
		this.data = data;
		left = null;
		right = null;				
	}
	
	public testNode insert (testNode root, int data){
		if(root == null){
			root = new testNode(data);
			return root;
		}
		if(root.data < data){
			root.right = insert(root.right, data);
		}
		else if (root.data > data){
			root.left = insert(root.left, data);
		}
		return root;
	}
}



public class find_nearest {
	
	private static int findNearest(testNode root, int target){
		int current = root.data;
		if(current == target){
			return target;
		}
		
		// if target is bigger than data
		if(target > current){
			if(root.right == null){
				return current;
			}
			if(Math.abs(target - current)< Math.abs(target - root.right.data)){
				return current;
			}
			return findNearest(root.right, target);
		}

		// target is less than data
		else{
			if(root.left == null){
				return current;
			}
			if(Math.abs(target - current) < Math.abs(target - root.left.data)){
				return current;
			}
			return findNearest(root.left, target);
		}
	}

	public static void main(String[] args) {
		
		int [] input = {4,3,6,5,7,17,22,20};
		
		testNode test = new testNode(9);
		for(int i:input){
			test.insert(test, i);
		}
		
		System.out.println(findNearest(test, 23));
		
	}
}