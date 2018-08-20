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


 */

public class PassbyValue_Reference {

	public static void passByValue(int value){
		value = 20;
	}
	
	public static void passByReference(int[] arrValue){
		arrValue[0] = 20;
	}
	
	public static void passString(String a){
		a = "def";
	}
	
	public static void main(String[] args) {
		int value = 10;
		
		
		// remains as 10 because copy of variable has passed.
		System.out.println("passByValue");
		System.out.println("Original :" + value);
		passByValue(value);
		System.out.println("new :" + value);
		
		System.out.println();
		
		int [] arrValue = {10};
		
		// change to 20 because the pointer of actual varibale is being passed.
		System.out.println("passByReference");
		System.out.println("Original :" + arrValue[0]);
		passByReference(arrValue);
		System.out.println("new :" + arrValue[0]);
		
		
		System.out.println();
		System.out.println("passByString");
		String a = "abc";
		System.out.println("Original :" + a);
		passString(a);
		System.out.println("new :" + a);
		
	}
}
