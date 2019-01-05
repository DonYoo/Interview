package BinarySerach;

/**
 * 
 * @author DonYoo
 *
https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1

Given root of binary search tree and K as input, find K-th smallest element in BST. Your task is to return the K-th smallest element in BST from the function k_smallest_element().

Note: The Time Complexity will be O(h) where h is the height of the Tree.

Input:
The first line of input will contain the number of test cases T. Then T test cases follow. First line of every test case will be n, denoting the number of nodes in the BST. Second line of every test case will be n spaced integers denoting the Integer value of Nodes in BST. Third line of every test case will be k, denoting kth the smallest number.

Output:
For each test case, output will be the kth smallest element of BST.

Constraints:
1<=T<=100
1<=N<=100
1<=K<=N


Example(To be used only for expected output):
Input:
1
5
20 8 4 22 12
3 
Output:
12

 */

import java.io.*;
import java.util.Scanner;

class kNode{
	int data;
	kNode left, right;
	kNode(int d){
		data=d;
		left=right=null;
	}
}


/*Please note that it's Function problem i.e.
		you need to write your solution in the form of Function(s) only.
		Driver Code to call/invoke your function is mentioned above.*/

class gfg2
{   
	public static int mySmall(kNode root, int[] count, int[] result){

		// if the result is found
		if(result[0] != 0){
			return result[0];
		}
		else{
			// inorder
			// left root right

			// when left is not empty
			if(root.left != null){
				mySmall(root.left, count, result);
			}

			count[0] -= 1;
			if(count[0] == 0){
				result[0] = root.data;
			}

			if(root.right != null){
				mySmall(root.right, count, result);
			}
		}
		return result[0];
	}

	public static int kthSmallest(kNode root,int k)    {

		// important. 
		// pass by reference to keep the track.
		// array value won't change even though it goes into the function.
		int [] result = {0};
		int [] count = {k};

		return mySmall(root, count, result);
	}
}


public class k_smallest_element {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			kNode fhead=null;
			for(int i = 0; i < n; i++)
			{
				if(fhead==null)
					fhead = new kNode(sc.nextInt());
				else{
					insert(fhead,sc.nextInt());
				}
			}
			int k=sc.nextInt();
			gfg2 g=new gfg2();
			int ans=g.kthSmallest(fhead,k);
			System.out.println(ans);
		}
	}
	public static kNode insert(kNode head, int a){
		if(head==null)
			return new kNode(a);
		if(head.data>=a)
			head.left=insert(head.left,a);
		if(head.data<a)
			head.right=insert(head.right,a);
		return head;
	}
}
