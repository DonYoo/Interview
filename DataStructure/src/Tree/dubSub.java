package Tree;

import java.util.*;
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

class Nodes
{
    char data;
    Nodes left, right;
    Nodes(char key)
    {
        data = key;
        left = right = null;
    }
}

public class dubSub {
	
    static final char MARKER = '$';
    static Set<String> subtrees = new HashSet<String>();
    public static boolean dupSub(Nodes root)
    {
        subtrees.clear();
        
        String res = dupSubUtil(root);
        if(res.compareTo("") == 0)
        return true;
        else
        return false;
    }
    
    public static String dupSubUtil(Nodes root)
    {
        String s = "";
        
        if(root == null)
         return s + MARKER;

        String lStr = dupSubUtil(root.left);
        if (lStr.compareTo(s) == 0)
            return s;
            
        String rStr = dupSubUtil(root.right);
       if (rStr.compareTo(s) == 0)
           return s;
           
        s = s + root.data + lStr + rStr;
        
         if (s.length() > 3 && subtrees.contains(s) == true)
                return "";
                
        subtrees.add(s);
 
        return s;
    }
    

	public static void main(String[] args) {
		Nodes temp = new Nodes('a');
		temp.left = new Nodes('b');
		temp.left.left = new Nodes('d');
		temp.left.right = new Nodes('e');
		temp.left.right.right = new Nodes('k');

		temp.right = new Nodes('c');
		temp.right.right = new Nodes('b');
		temp.right.right.left = new Nodes('d');
		temp.right.right.right = new Nodes('e');

		System.out.println(dupSub(temp));
		
	}

}
