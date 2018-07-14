package Tree;

/**
 * 
 * @author DonYoo
 *
 * @param <T>
 * 

	1
  2   3 

	10
  20  30
40  60	

	10
      20
  		30
		  40
		  	60

Example:
Input:
2
2
1 2 L 1 3 R
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
3
4

Time Complexity: O(n)

https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1

https://www.geeksforgeeks.org/diameter-of-a-binary-tree/

In this post a new simple O(n) method is discussed. Diameter of a tree can be calculated by 
only using the height function, because the diameter of a tree is nothing but maximum value of 
(left_height + right_height + 1) for each node. So we need to calculate this value (left_height + right_height + 1) 
for each node and update the result. Time complexity – O(n)

 * 
 */

class myNode<T>{
	myNode<T> leftchild;
	myNode<T> rightchild;
	T data;
	
	public myNode(T data){
		leftchild = null;
		rightchild = null;
		this.data = data;
	}
}

public class diameterTree {

	public static myNode<Integer> insert(myNode<Integer> node, int data){
		if(node == null){
			node = new myNode<>(data);
			return node;
		}
		if(data < node.data){
			node.leftchild = insert(node.leftchild, data);
		}
		else if(data > node.data){
			node.rightchild = insert(node.rightchild, data);
		}
		return node;
	}
	
	
	public static int findDiameter(myNode<Integer> node, int[] height){
		/* lh --> Height of left subtree
        rh --> Height of right subtree */
		int[] lh = {0};
		int[] rh = {0};
		
		// baseline
		if(node == null){
			height[0] = 0;
			return 0;
		}
		/* ldiameter  --> diameter of left subtree
        rdiameter  --> Diameter of right subtree */ 
		
		/* Get the heights of left and right subtrees in lh and rh
      	And store the returned values in ldiameter and rdiameter */
		int ldiameter = findDiameter(node.leftchild, lh);
		int rdiameter = findDiameter(node.rightchild, rh);
		
		/* Height of current node is max of heights of left and
        right subtrees plus 1*/
		// updating as reference 
		height[0] = Math.max(lh[0], rh[0]) + 1;
		
		// first return is sum of left and right +1 diameter. second is comparing diameter of left and right
		return Math.max(lh[0] + rh[0] +1, Math.max(ldiameter, rdiameter));
	}
	
	
	public static void main(String[] args) {
		myNode <Integer>node = new myNode<>(10);
		
		int arr[] = {20,30,40,60};
		/*
		for(int i=0; i<arr.length; i++){
			insert(node, arr[i]);
		}
		*/
		node = new myNode(1);
		node.leftchild = new myNode(2);
		node.rightchild = new myNode(3);
		
		int [] height = {0};
		
		System.out.println(findDiameter(node, height));
		
	}

}
