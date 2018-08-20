package staticMethod;


/**
 * 
 * @author DonYoo

 * Java static method
 * 

A static method belongs to the "class" rather than object of a class.
A static method can be invoked without the need for creating an instance of a class.
static method can access static data member and can change the value of it.

ex) Math.pow()

 */


class Sample{
	static int temp = 0;
	
	public static void yesStatic(){
		System.out.println("yes static");
	}
	
	public void notStatic(){
		System.out.println("not static");
	}
	
	public void testinNotstatic(){
		// calling static inside of class
		yesStatic();
		
		// calling non static inside of class
		notStatic();
	}
	
	public static void testinStatic(){
		// calling static inside of class
		yesStatic();
		
		// calling non static inside of class
		
		//Cannot make a static reference to the non-static method notStatic() from the type Sample
		//because static only created once in the beginning. 
		
		//notStatic();
	}
}

public class staticMethod {

	//static method is belong to class rather than object.
	//invoke without the need of class.
	
	public static void main(String[] args) {
		// make an object
		Sample objectclass = new Sample();
		// regular method
		objectclass.notStatic();
		
		// static method
		Sample.yesStatic();
		
		Sample.testinStatic();
		
		System.out.println(Sample.temp);
		
		Sample.temp = 2;
		
		System.out.println(Sample.temp);
	}
}
