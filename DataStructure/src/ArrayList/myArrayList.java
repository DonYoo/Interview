package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author DonYoo
 *
 *
Difference between Array and ArrayList
			Access	search	insert	delete	space
Array		O(1)	O(n)	O(n)	O(n)	O(n)
ArrayList	O(1)	O(n)	O(1)	O(n)	O(n)

 1. Resizable : ArrayList insert a new object in O(1), instead in an Array, 
 you have to create a new Array and copy all the object plus insert this new. 
 So the operation cost O(n). 
 
 2. Performance : Array has better performance to order and to have a direct access to an object.
 
 3. Primitives
  ArrayList can not contains primitive data types (like int , float , double)
 it can only contains Object while Array can contain both primitive data types as well as objects.
One get a misconception that we can store primitives(int,float,double) in ArrayList , but it is not true  

ArrayList  arraylistobject = new ArrayList();
arraylistobject.add(23);  // try to add 23 (primitive)
-> arraylistobject.add( new Integer(23));    

 4. Iterating the value
 ArrayList has iteration / Array with the loop through
 
 5. Multiple-dimension
 Array can be multiple dimension and ArrayList is single dimension
 
Implementation of ArrayList
To implement an ArrayList with an Array, use array but keep the track of array size.
default size is 10. if the input is getting bigger than capacity, make it double.

 * 
 */

public class myArrayList<T> {
	Object [] currentArray;
	
	int capacity_size = 10;
	int currentsize = 0;
	
	public myArrayList(){
		currentArray =  new Object[capacity_size];
	}
	
	private void makeCapacitydouble() {
		capacity_size *= 2;
		// copy original array to new array with double sized
		currentArray = Arrays.copyOf(currentArray, capacity_size);
	}
	
	public void add(T data) {
		if(currentsize > capacity_size){
			throw new IndexOutOfBoundsException("currentsize " + currentsize +" is bigger than capacity size "+ capacity_size );
		}
		else if(currentsize == capacity_size){
			makeCapacitydouble();
		}
		currentArray[currentsize++] = data;
	}
	
	public T get(int index){
		if(index > capacity_size){
			throw new IndexOutOfBoundsException("outOfBoundsMsg " + index);
		}
		return (T)currentArray[index];		
	}
	
	public static void main(String[] args){
		myArrayList<Integer> test = new myArrayList<>();
		
		for(int i=0; i<12; i++){
			test.add(i);
		}	
		System.out.println(test.get(11));
	}

}
