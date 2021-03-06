package Tree;


/**
 * 
					Access		search		insert		delete		space
BinarySearchTree	O(log n)	O(log n)	O(log n)	O(log n)	O(n)

binary search trees (BST), sometimes called ordered or sorted binary trees, 

sample input

	10
  3    12
2  7 11  14	  
*/

class Node<T>{
	Node<T> leftchild;
	Node<T> rightchild;
	T data;
	
	public Node(T data){
		leftchild = null;
		rightchild = null;
		this.data = data;
	}
}

public class myBST {
	
	// recursive.
	public static Node<Integer> insert(Node<Integer> node, int data){
		if(node == null){
			node = new Node<>(data);
			return node;
		}
		
		// left Child
		else if(data < node.data){
			node.leftchild = insert(node.leftchild, data);
		}
		// right Child
		else if(node.data < data){
			node.rightchild = insert(node.rightchild, data);
		}
		return node;
	}
	
	// inorder : left root right
	public static void inorder(Node<Integer> head){
		if(head == null){
			return;
		}
		inorder(head.leftchild);
		System.out.print(head.data + " ");
		inorder(head.rightchild);
	}
	
	// preorder : root left right
	public static void preorder(Node<Integer> head){
		if(head == null){
			return;
		}
		System.out.print(head.data + " ");
		preorder(head.leftchild);
		preorder(head.rightchild);
	}

	// postorder : left right root
	public static void postorder(Node<Integer> head){
		if(head == null){
			return;
		}
		postorder(head.leftchild);
		postorder(head.rightchild);
		System.out.print(head.data + " ");
	}

	public static void main(String[] args) {
		int[] input = {3, 7, 12, 2, 14, 11};
		
		Node<Integer> node = new Node<>(10);
		for(int each : input){
			node = insert(node, each);
		}
		
		System.out.print("inorder :");
		inorder(node);
		System.out.println();

		System.out.print("preorder :");
		preorder(node);
		System.out.println();
		
		System.out.print("postorder :");
		postorder(node);
		System.out.println();

	}

}
