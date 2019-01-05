package encapsulation;


/**
 * 
 * @author DonYoo
 *
 * hide the implementation details from users.
 * 
 * Make the instance variables private
 * Have getter and setter methods
 * 
 * 
 */

class EncapsulationDemo{
	private int ssn;
	private String emName;
	
	public EncapsulationDemo(){
		
	}
	
	public int getEmpSSN(){
		return ssn;
	}
	
	public void setEmpSSN(int newValue){
		ssn = newValue;
	}
}

public class Encapsulation {

	public static void main(String[] args) {
		EncapsulationDemo obj = new EncapsulationDemo();
        obj.setEmpSSN(112233);
        
        // can't have ssn directly.
        // int test = obj.ssn;
        
        System.out.println("Employee SSN: " + obj.getEmpSSN());
	}

}
