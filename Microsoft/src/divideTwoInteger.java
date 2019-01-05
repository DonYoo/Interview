
/**
 * 
 * @author DonYoo

 *
 *
https://www.careercup.com/forumpost?id=6220310781100032


 */


public class divideTwoInteger {

	public static long divide(long dividend,  long divisor)  
	{ 

		//Calculate sign of divisor  
		//i.e., sign will be negative  
		//only iff either one of them  
		//is negative otherwise it  
		//will be positive 
		long sign = ((dividend < 0) ^  
				(divisor < 0)) ? -1 : 1; 

		//remove sign of operands 
		dividend = Math.abs(dividend); 
		divisor = Math.abs(divisor); 

		
		// process time O(logN)
		// Initialize the quotient 
		long quotient = 0, temp = 0; 

		//test down from the highest  
		//bit and accumulate the  
		//tentative value for 
		//valid bit 
		for (int i = 31; i >= 0; --i)  
		{ 

			if (temp + (divisor << i) <= dividend)  
			{ 
				temp += divisor << i; 
				quotient |= 1 << i; 
			} 
		} 

		return (sign * quotient); 
	}


	// process time O(n)
	public static int divide (int dividend, int divisor){
		if(divisor == 0){
			System.out.print("can't be divided");
			return 0;
		}
		int result = 0;

		int sign = (dividend <0) ^ (divisor < 0) ? -1:1 ;

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		while(dividend > divisor){
			dividend -= divisor;
			result++;
		}

		return sign * result;
	}

	public static void main(String[] args) {
		int dividend = 10;
		int divisor = 0;


		System.out.print(divide(dividend, divisor));
	}

}
