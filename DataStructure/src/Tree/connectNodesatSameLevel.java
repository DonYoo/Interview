package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DonYoo
 * 

https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1

Write a function to connect all the adjacent nodes at the same level in a binary tree. Structure of the given Binary Tree node is like following.
 
struct Node{
  int data;

  Node* left;

  Node* right;

  Node* nextRight;
}


Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.

Example:

Input Tree
       10
      / \
     3   5
    / \   \
   4   1   2


Output Tree
       10--->NULL
      / \
     3-->5-->NULL
    / \   \   
   4-->1-->2-->NULL
 

Input:

The task is to complete the method which takes one argument, root of Binary Tree. There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should update nextRight pointers of all nodes.

Constraints:
1 <=T<= 30
1 <=Number of nodes<= 100
1 <=Data of a node<= 1000

Example:
Input:
2
2
3 1 L 3 2 R
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
3 1 2
1 3 2
10 20 30 40 60
40 20 60 10 30

There are two test casess.  First case represents a tree with 3 nodes and 2 edges where root is 3, left child of 3 is 1 and right child of 3 is 2.   Second test case represents a tree with 4 edges and 5 nodes.

The output contains level order and inorder traversals of the modified tree.  Level order traversal is done using nextRight pointers.

 *
 */

class thisNode {
	int data;
	
	thisNode leftNode;
	thisNode rightNode;
	thisNode nextRight;
	
	public thisNode(int data){
		this.data = data;
		
		leftNode = null;
		rightNode = null;
		nextRight = null;
	}
}

public class connectNodesatSameLevel {

	static Queue<thisNode> queue;
	
	static void levelorder(thisNode root){
		queue = new LinkedList<thisNode>();
		
		if(root != null){
			queue.add(root);
		}
		
		int size = 0;
		while(!queue.isEmpty()){
			// important set up the size of the que.
			if(size ==0){
				size = queue.size();
			}
			thisNode temp = queue.poll();
			size -= 1;
			System.out.print(temp.data +" ");
			if(size == 0){
				temp.nextRight = null;
			}
			else{
				temp.nextRight = queue.peek();
			}
			
			// check if its null otherwise it throw exception
			if(temp.leftNode != null)
				queue.add(temp.leftNode);
			if(temp.rightNode != null)
				queue.add(temp.rightNode);
		}
	}
	
	// left root right
	static void inorder(thisNode root){
		if(root == null){
			return;
		}
		inorder(root.leftNode);
		System.out.print(root.data +" ");
		inorder(root.rightNode);
	}
	
	static void connect(thisNode root){
		levelorder(root);
		System.out.println();
		inorder(root);
	}
	
	public static void main(String[] args) {
		thisNode test = new thisNode(1);
		test.leftNode = new thisNode(3);
		test.rightNode = new thisNode(2);
		
		connect(test);
		
		System.out.println();
		
		test = new thisNode(10);
		test.leftNode = new thisNode(20);
		test.rightNode = new thisNode(30);
		test.leftNode.leftNode = new thisNode(40);
		test.leftNode.rightNode = new thisNode(60);
		
		connect(test);
	}

}
