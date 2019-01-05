
public class test {

	public static void change (int[] b, int c){
		b[0] = 10;
		b[1] = 20;
		
		c = 30;
	}
	
	public static void main(String[] args) {

		int [] b = {1,2};
		
		for(int i =0; i<b.length; i++){
			System.out.print(b[i] + " ");
		}
		
		System.out.println();
		
		int c = 3;
		
		change(b, c);
		
		for(int i =0; i<b.length; i++){
			System.out.print(b[i] + " ");
		}
		
		System.out.println();
		
		System.out.println(c);
		
	}

}
