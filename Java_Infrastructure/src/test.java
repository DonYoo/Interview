
public class test {

	public static void sum (int[] b, int c){
		b[0] = 10;
		b[1] = 20;
		
		c = 30;
	}
	
	public static void main(String[] args) {
		int a = 10;

		int [] b = {1,2};
		
		for(int i =0; i<b.length; i++){
			System.out.print(b[i] + " ");
		}
		
		int c = 3;
		
		sum(b, c);
		for(int i =0; i<b.length; i++){
			System.out.print(b[i] + " ");
		}
		System.out.println(c);
		
	}

}
