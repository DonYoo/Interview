package LinkedList;

/**
 * 
			Access	search	insert	delete	space
LinkedList	O(n)	O(n)	O(1)	O(1)	O(n)

 *  
 */

class Node<T>{
	Node<T> nextNode;
	T data;
	public Node(T data){
		nextNode = null;
		this.data = data;
	}
}

public class myLinkedList<T> {
	// double point LinkedList
	private Node<T> head = null;
	private Node<T> tail = null;
	
	public void add(Node<T> node){
		if(head == null){
			head = node;
			tail = head;
		}
		else{
			tail.nextNode = node;
			tail = tail.nextNode;
		}
	}
	
	public T get(int index){
		Node<T>temp = head;
		for(int i =0; i<index; i++){
			temp = temp.nextNode;
		}
		return temp.data;
	}
	
	public T remove(int index){
		Node<T>temp = head;
		for(int i =0; i<index-2; i++){
			temp = temp.nextNode;
		}
		T removeone = temp.nextNode.data;
		temp.nextNode = temp.nextNode.nextNode;
		return removeone;
	}

	public static void main(String[] args) {
		myLinkedList<Integer> test = new myLinkedList<>();
		
		for(int i=0; i<12; i++){
			Node<Integer> temp = new Node<Integer>(i);
			test.add(temp);
		}
		System.out.println( test.get(5) );
		test.remove(5);
		System.out.println( test.get(5) );
	}

}
