package PassbyValue_Reference;

/**
 * 
 * @author DonYoo
 * 
Pass by Value / Pass by Reference

By value: when arguments are passed by value to a method, 
it means that a copy of the actual variable is being sent to the method and not the actual one,
so any changes applied inside the method are actually affecting the copy version.

By reference: When arguments are passed by reference, 
it means that a reference or a pointer to the actual variable is being passed 
to the method and not the actual variable data.


 * Java static method
 * 

A static method belongs to the class rather than object of a class.
A static method can be invoked without the need for creating an instance of a class.
static method can access static data member and can change the value of it.

ex) Math.pow()

 */

public class PassbyValue_Reference {

	//static method is belong to class rather than object.
	//invoke without the need of class.
	
	public static void passByValue(int value){
		value = 20;
	}
	
	public static void passByReference(int[] arrValue){
		arrValue[0] = 20;
	}
	
	public static void main(String[] args) {
		int value = 10;
		passByValue(value);
		// remains as 10 because copy of variable has passed.
		System.out.println(value);
		
		int [] arrValue = {10};
		passByReference(arrValue);
		// change to 20 because the pointer of actual varibale is being passed.
		System.out.println(arrValue[0]);
	}

}
