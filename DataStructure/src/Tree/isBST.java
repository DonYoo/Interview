package Tree;

/**
 * 
 * @author DonYoo
 *
Given a binary tree, return true if it is BST, else false. For example,
the following tree is not BST, because 11 is in left subtree of 10.

        10
     /     \
   7       39
     \
      11



https://practice.geeksforgeeks.org/problems/check-for-bst/1

process time : O(n)
space : O(1)

 */
public class isBST {
	
	public static boolean isit(Node<Integer> node, int min, int max){
		
		// if tree is empty
		if(node == null){
			return true;
		}
		
		// if node violates the min/max
		if(node.data <= min || node.data >= max){
			return false;
		}
		
		// check subtrees recursively
		return isit(node.leftchild, min, node.data) &&
				isit(node.rightchild, node.data, max);
	}
	
	public static boolean isthisBST(Node<Integer> node)  
    {
		return isit(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(10);
		myBST.insert(root, 7);
		myBST.insert(root, 39);
		root.leftchild.rightchild = new Node<Integer>(9);
		root.leftchild.leftchild = new Node<Integer>(6);
		
		myBST.inorder(root);
		System.out.println();
		System.out.println(isthisBST(root));
	}

}
