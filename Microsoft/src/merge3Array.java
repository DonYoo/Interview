import java.util.Arrays;

public class merge3Array {

	public static int[] merge3 (int[]a, int[]b, int[]c){
		int []d = new int[a.length+b.length+c.length];
		
		return d;
	}
	
	public static void main(String[] args) {
		int[] a = {1,3};
	    int[] b = {2,4};
	    int[] c = {1,5};
	    
	    int[] d = merge3(a, b, c);
	    
	    int i = 0;
	    int j = 0;
	    int k = 0;
	    for (int l = 0; l < d.length; l++) {
	      d[l] = i < a.length && (j >= b.length || a[i] < b[j])
	                ? (k >= c.length || a[i] < c[k]
	                    ? a[i++]
	                    : c[k++])
	                : (j < b.length && (k >= c.length || b[j] < c[k])
	                    ? b[j++]
	                    : c[k++]);
	       // Uncomment this if you still need it:
	       //displayArrayContents(a,b,c,d,i,j,k,l); 
	    }

	    System.out.println(Arrays.toString(d));
	    
	}

}
