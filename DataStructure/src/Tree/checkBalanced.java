package Tree;

/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1

     
Given a binary tree, find if it is height balanced or not.  A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 

A height balanced tree
        1
     /     \
   10      39
  /
5

An unbalanced tree
        1
     /    
   10   
  /
5


Input:
The task is to complete the method which takes one argument, root of Binary Tree. The struct cNode has a data part which stores the data, pointer to left child and pointer to right child.
There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should return true if tree is height balanced, else false.

Constraints:
1 <=T<= 100
1 <=Number of nodes<= 100
0 <=Data of a cNode<= 1000

Example:
Input:
2
2
1 2 L 2 3 R
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
0
1

There are two test casess.  First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 2 and right child of 1 is 3.   Second test case represents a tree with 4 edges and 5 nodes.

 */

import java.util.*;

class cNode
{
	int data;
	cNode left,right;
	
	cNode(int d)
	{
		data = d;
		left = right = null;		
	}
}

public class checkBalanced	{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, cNode> m = new HashMap<Integer, cNode> ();
            int n = sc.nextInt();
            cNode root = null;
            while (n > 0)
            {	
			
		int n1 = sc.nextInt();
                int n2 = sc.nextInt();
		char lr= sc.next().charAt(0);
				
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                cNode parent = m.get(n1);
                if (parent == null)
                {
                    parent = new cNode(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                cNode child = new cNode(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
			
            gfg g = new gfg();
			
			//boolean res = g.isHeap(root);
			if(g.isBalanced(root) == true)
			System.out.println(1);
			else 
			System.out.println(0);
			//CLN.inorder(root);
			 t--;
			// System.out.println();
        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* A binary tree cNode class
class cNode
{
	int data;
	cNode left,right;
	
	cNode(int d)
	{
		data = d;
		left = right = null;		
	}
} */

class gfg
{
    
     /* This function should return tree if passed  tree 
     is balanced, else false.  Time complexity should
     be O(n) where n is number of nodes in tree */
    
    public static int findHeight(cNode root, int[] max, int height){
        if(root == null){
            return height-1;
        }
        
        int lefth = findHeight(root.left, max, height+1);
        int righth = findHeight(root.right, max, height+1);
        
        /*
        System.out.println("data " + root.data);
        System.out.println(lefth + "  " + righth);
        */
        
        if(Math.abs(lefth - righth) > 1){
            max[0] = 0;
        }
        return Math.max(lefth, righth);
    }
    
    boolean isBalanced(cNode root)	{
        // if the height difference is bigger than 1
        int[] height = new int[1];
        height[0] = 1;
        
    	findHeight(root, height, 0);
    	if(height[0] == 0){
    	    return false;
    	}
    	return true;
    }
}

