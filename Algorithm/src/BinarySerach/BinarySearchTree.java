package BinarySerach;


/*
 * Node with leftchild, rightchild, data
 * 
 * Access O log(n) search log(n) insert log(n) delete log(n)
 * memory space O(n)
 * 
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

/*
    10
  3    12
2  7 11  14
 	  
 */
public class BinarySearchTree {

	public static Node<Integer> insert (Node<Integer> head, int data){
		if(head == null){
			head = new Node<Integer>(data);
			return head;
		}
		// if the input is small then head value.
		if(data < head.data ){
			// make a new node and insert to the leftchild
			head.leftchild = insert(head.leftchild, data);		////////////////////
		}
		else if(head.data < data){
			// make a new node and insert to the rightchild
			head.rightchild = insert(head.rightchild, data);	////////////////////
		}
		// no duplicate
		return head;		
	}
	
	// inorder (Left, Root, Right) 2,3,7,10,11,12,14
	public static void inorder (Node<Integer> head){
		if (head == null){
			return;
		}
		inorder(head.leftchild);
		System.out.print(head.data + " ");
		inorder(head.rightchild);
	}
	
	// Preorder (Root, Left, Right)
	// preorder :10 3 2 7 12 11 14 
	public static void preorder(Node<Integer> head){
		if (head == null){
			return;
		}
		System.out.print(head.data + " ");
		preorder(head.leftchild);
		preorder(head.rightchild);
	}
	
	// Postorder (Left, Right, Root) 2,7,3,11,14,12,10
	public static void postorder(Node<Integer> head){
		if (head == null){
			return;
		}
		postorder(head.leftchild);
		postorder(head.rightchild);
		System.out.print(head.data + " ");
	}
	
	
	public static void main(String[] args){
		int[] input = {3, 7, 12, 2, 14, 11};
		
		Node <Integer> node = new Node<>(10);
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

