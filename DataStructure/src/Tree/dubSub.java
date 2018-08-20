package Tree;

/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1


Given a Binary Tree, the task is to complete the function dupSub which takes the root of the tree as the only argument and returns true if the Binary tree contains a duplicate sub-tree of size two or more.

Input :  Binary Tree 
               A
             /    \ 
           B        C
         /   \       \    
        D     E       B     
                     /  \    
                    D    E
Output : Yes

Note: Two same leaf nodes are not considered as subtree as size of a leaf node is one.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains a string s representing the binary tree.
For example the string : (a(b()())(c()()) represents the below binary tree
       a
    /     \
  b       c

Output:
For each test case output will be 1 if the binary tree contains duplicate sub-tree of size two or more else 0.

Constraints:
1<=T<=50
1<=length of string<=100

Example(To be used only for expected output) :
Input:
2
(a(b(d()())(e()()))(c()(b(d()())(e()()))))
(a(b()())(c()()))

Output:
1
0


Big O(n)

time : O(n)
space : O(n)

 */

public class dubSub {
	
	static String storage;
	
	// left root right
	private static void inorder(Node<String> node) {
		if(node == null){
			return;
		}
		inorder(node.leftchild);
		storage = storage.concat(node.data);
		inorder(node.rightchild);		
	}
	
	static int duplicate(Node<String> node){
		inorder(node);
		System.out.println(storage);
		for(int i=0; i<storage.length()-2; i++){
			String temp = storage.substring(i, i+3);
			if(storage.substring(i+2).contains(temp)){
				return 1;
			}
		}
		return 0;
	}

	

	public static void main(String[] args) {
		Node<String> temp = new Node<>("a");
		temp.leftchild = new Node<String>("b");
		temp.rightchild = new Node<String>("c");
		temp.rightchild.rightchild = new Node<String>("b");
		temp.leftchild.leftchild= new Node<String>("d");
		temp.leftchild.rightchild = new Node<String>("e");
		
		temp.rightchild.rightchild.leftchild= new Node<String>("d");
		temp.rightchild.rightchild.rightchild = new Node<String>("e");
		
		storage = "";
		System.out.println(duplicate(temp));
		
	}

}
