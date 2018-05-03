package Abstract_Interface;

/**
 * @author DonYoo
 * 
Consider using abstract classes if any of these statements apply to your situation:

In java application, there are some related classes that need to share some lines of code then 
you can put these lines of code within abstract class and this abstract class should be extended by all these related classes.
You can define non-static or non-final field(s) in abstract class, so that via a method you can access and modify 
the state of Object to which they belong.
You can expect that the classes that extend an abstract class have "many common methods or fields," 
or require access modifiers other than public (such as protected and private).
*/

// abstract
//////////////////////////////////////////////////////

abstract class Person{
	abstract void definition();
	void mind() {
		System.out.print("Person have warm mind");
	}
}

class student extends Person{
	void definition() {
		System.out.println("this is student");
	}
}

class employee extends Person{
	void definition(){
		System.out.println("this is employee");
	}
}

/**
 * 
 * Interface.
 * A class can implement any number of interface.
 * 

It is total abstraction, All methods declared within an interface must be implemented by the class(es) that implements this interface.
A class can implement more than one interface. It is called multiple inheritance.
You want to specify the behavior of a particular data type, but not concerned about who implements its behavior.
 * 
 * 
 */

interface Human{
	void eye();
}

interface People{
	void definition();
	void salary();
	
	static void mind(){
		System.out.println("Person have warm mind");
	}
}

class Teacher implements People, Human{
	@Override
	public void definition() {
		System.out.println("this is teacher");
	}

	@Override
	public void salary() {
		System.out.println("this is employee");
	}
	
	public void mind(){
		System.out.println("teacher has warm mind");
	}
	
	@Override
	public void eye() {
		System.out.println("Teacher has 2 eyes");
	}
}


public class Abstract {

	public static void main(String[] args) {
		// abstract, extend
		Person don = new employee();
		don = new student();
		don.definition();
		don.mind();
		
		// interface, implements		
		Teacher ron = new Teacher();
		ron.definition();	
		ron.mind();
		ron.eye();
	}
}
