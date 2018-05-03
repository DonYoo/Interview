package BinarySerach;

/*
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

public class FindNearest {

	public static int findNearest(Node root, int target){
		int value = root.data;
		
		// if the value and target match
		if(value == target){
			return value;
		}
		
		// if target is bigger than root.
		if(value < target){
			if(root.rightchild == null){
				return value;
			}
			else if(Math.abs(value - target) > Math.abs(root.rightchild.data - target)){
				return findNearest(root.rightchild, target);
			}
			// root data difference is smaller than rightchild data difference
			else{
				return value;
			}
		}
		// if target is smaller than root.
		else{
			if(root.leftchild == null){
				return value;
			}
			else if(Math.abs(value - target) > Math.abs(root.leftchild.data - target)){
				return findNearest(root.leftchild, target);
			}
			// root data difference is smaller than leftchild data difference
			else{
				return value;
			}
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(9);
		int [] input = {4,3,6,5,7,17,22,20};
		
		for(int i: input){
			BinarySearchTree.insert(head, i);
		}
		int k = 12;
		
		int answer = findNearest(head, k);
		System.out.println(answer);
	}
}
