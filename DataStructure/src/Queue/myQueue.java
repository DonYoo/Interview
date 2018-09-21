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



Stack - FILO

push() = add top of the queue
pop()  = get top item from the queue.

implement queue using stack
created 2 stacks. move value over to another as reversed order then pop value from there.


add = push.

The two statements you've written each construct a LinkedList<String> object to hold a list of strings, then assign it to a variable. The difference is in the type of the variable.

By assigning the LinkedList<String> to a variable of type Queue<String>, you can only access the methods in the LinkedList that are available in the Queue<String> interface, which includes support for enqueuing and dequeuing elements. This would be useful if you needed to write a program that used a queue for various operations and wanted to implement that queue by using a linked list.

By assigning the LinkedList<String> to a variable of type List<String>, you can only access the methods in the LinkedList that are available in the List<String> interface, which are normal operations for maintaining a sequence of elements. This would be useful, for example, if you needed to process a list of elements that could grow and shrink anywhere.

In short, the two lines create the same object but intend to use them in different ways. One says that it needs a queue backed by a linked list, while the other says that it needs a general sequence of elements backed by a linked list.

Hope this helps!




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
