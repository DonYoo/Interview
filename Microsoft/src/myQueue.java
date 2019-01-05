import java.util.LinkedList;


class thisQueue{
	LinkedList<Integer> myLink;
	
	public thisQueue(){
		myLink = new LinkedList<>();
	}
	
	public void enqueue(int input){
		myLink.add(input);
	}
	
	public void dequeue(){
		myLink.removeFirst();
	}
	
	public int print(){
		return myLink.getFirst();
	}
}
public class myQueue {

	public static void main(String[] args) {
		
		thisQueue test = new thisQueue();
		
		test.enqueue(1);
		//test.enqueue(2);
		//test.dequeue();
		
		System.out.println(test.print());
	}
}
