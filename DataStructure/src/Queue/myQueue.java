package Queue;

import java.util.Stack;

/**
 * 
 * @author DonYoo
 *

Queue - FIFO

			Access	search	insert	delete	space
Queue		O(n)	O(n)	O(1)	O(1)	O(n)

add(), poll()
add()  = add top of the queue
poll() = get bottom item from the queue.

Stack
push() = add top of the queue
pop()  = get top item from the queue.

implement queue using stack
created 2 stacks. move value over to another as reversed order then pop value from there.

*
*
*/

public class myQueue <T> {

	Stack <T>stack = new Stack<>();
	Stack <T>storage = new Stack<>();
	
	public void add(T input){
		stack.push(input);
	}
	public T poll(){
		if(!stack.isEmpty()){
			while(!stack.isEmpty()){
				storage.push(stack.pop());
			}
		}
		return storage.pop();
	}
	
	public String toString(){
		Stack <T>copyStack = stack;
		Stack <T>copyStorage = storage;
		
		while(!copyStorage.isEmpty()){
			copyStack.push(copyStorage.pop());
		}
		return copyStack.toString();
	}
	
	public static void main(String[] args) {
		myQueue <Integer> test = new myQueue<>();
		
		for(int i =0; i<10; i++){
			test.add(i);
		}
		System.out.println(test);
		System.out.println(test.poll());
		System.out.println(test);
		System.out.println(test.poll());
		System.out.println(test);
		test.add(10);
		System.out.println(test);
		System.out.println(test.poll());
		System.out.println(test);
	}
}
