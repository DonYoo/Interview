
/**
 * 
 * @author DonYoo
 *
 * @param <T>
 * 
 * https://www.careercup.com/forumpost?id=6220310781100032
 * 
 */

class myNode<T>{
	myNode<T> next;
	T value;
	
	public myNode(T value){
		next = null;
		this.value = value;
	}
}

class myLink<T>{
	myNode<T> head;
	myNode<T> tail;
	
	public myLink(){
		head = null;
		tail = null;
	}
	
	public void add(myNode<T> next){
		if(head == null){
			head = next;
			tail = head;
		}
		else{
			tail.next = next;
			tail = tail.next;
		}
	}
}
	
public class myLinkedlist {

	public static void main(String[] args) {
		myLink<Integer> test = new myLink<>();
		myNode temp = new myNode(1);
		test.add(temp);
	}
}
