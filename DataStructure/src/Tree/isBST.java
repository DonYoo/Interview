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

 */
public class isBST {

	private static int maximum = -1;
	private static boolean answer = true;
	
	private static int result = 1;
	
	public static void isBSTcheck(Node<Integer> node){
		if(node == null){
			return;
		}
		isBSTcheck(node.leftchild);
		if(maximum >= node.data){
			answer = false;
			return;
		}
		maximum = node.data;
		isBSTcheck(node.rightchild);
	}
	
	public static int isBST(Node node)  
    {
		if(node == null){
			return result;
		}
		isBST(node.leftchild);
		if(maximum >= node.data){
			result = 0;
		}
		maximum = node.data;
        isBST(node.rightchild);
        return result;
    }

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(10);
		myBST.insert(root, 7);
		myBST.insert(root, 39);
		root.leftchild.rightchild = new Node<Integer>(9);
		root.leftchild.leftchild = new Node<Integer>(6);
		
		
		myBST.inorder(root);
		System.out.println();
		System.out.println(isBST(root));
	}

}
