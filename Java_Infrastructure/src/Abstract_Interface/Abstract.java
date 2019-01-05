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

example : 
making all different kinds of dog.
they have 4 legs, ears, mouse and 2 eyes.

however, different kind of dog can have different color, barking style, size. 

*/

// abstract
//////////////////////////////////////////////////////

abstract class Person{
	abstract void definition();
	public String name = "";
	
	void mind() {
		System.out.println(name + " have warm mind");
	}
}

class student extends Person{
	void definition() {
		super.name = "student";
		System.out.println("this is student");
	}
	
	public void test(){
		System.out.println("student class individual function");
	}
}

class employee extends Person{
	void definition(){
		super.name = "employee";
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
You want to "specify the behavior of a particular data type, but not concerned about who implements its behavior."

example : game character. since every game character need to have a attributes.
however every player's character has different strength, dexterity, intelligent or skills.

 * 
 * 
 */

interface Human{
	void eye();
}

interface People{
	void definition();
	void salary();
}

// class that implements interface must have all the method.

class Teacher implements People, Human{
	
	// implements from People
	@Override
	public void definition() {
		System.out.println("this is teacher");
	}

	@Override
	public void salary() {
		System.out.println("this is employee");
	}
	
	// implements from Human
	@Override
	public void eye() {
		System.out.println("Teacher has 2 eyes");
	}
	
	// individual method for Teacher
	public void mind(){
		System.out.println("teacher has warm mind");
	}
	
}


public class Abstract {

	public static void main(String[] args) {
		// abstract, extend
		// person can't have individual function that specific class offer.
		// such as don is defiend as person so it can't have individual function from employee.
		Person don = new employee();
		don = new student();
		don.definition();
		don.mind();
		
		System.out.println();
		
		student bon = new student();
		bon.test();
		bon.definition();
		bon.mind();
		
		
		System.out.println();
		
		// interface, implements		
		Teacher ron = new Teacher();
		ron.definition();	
		ron.eye();
		
		ron.mind();
	}
}
