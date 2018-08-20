package Tree;

import java.util.Scanner;

/**
 * 
 * @author DonYoo

Given a Binary Search Tree (BST) and a range, count the number of nodes in the BST that lie in the given range. You are required to complete the function getCountOfNode. You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.
 

Input (only to be used for Expected Output):
The first line of the input contains an integer 'T' denoting the nummber of test cases. Then 'T' test cases follow. Each test case consists of three lines. Description of  test cases is as follows:
The First line of each test case contains an integer 'N' which denotes the no of nodes in the BST.   .
The Second line of each test case contains 'N' space separated values of the nodes in the BST.
The Third line of each test case contains two space separated integers 'l' and 'h' denoting the range, where l < h

Output:
You are required to complete the function getCountOfNode which takes three arguments. The first being the root of the tree, and then two integers l and h, denoting the range. The function returns an integer denoting the no of nodes in the given range.

Constraints:
1 <= T <= 50
1 <= N <= 50
1 <= l < h < 1000

Example:
Input
1
6
10 5 50 1 40 100
5 45

Output
3

 */

public class CountBST {

	static Scanner s;
	
	static int getCountOfNode(Node<Integer> root, int low, int high) 
    {
		int sum = 0;
		if(root == null){
			return 0;
		}
		
		int left = getCountOfNode(root.leftchild, low, high);
		if((root.data >= low) && (root.data <= high)){
			sum++;
		}
		int right = getCountOfNode(root.rightchild, low, high);

		return left+right+sum;
    }
	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		int testcase = s.nextInt();
		
		for(int i=0; i<testcase; i++){
			int numNode = s.nextInt();
			Node<Integer> BST = new Node<>(s.nextInt());
			for(int j=1; j<numNode; j++){
				myBST.insert(BST, s.nextInt());
			}
			
			int low = s.nextInt();
			int high = s.nextInt();

			System.out.println(getCountOfNode(BST, low, high));			
		}
	}
}
