import java.util.LinkedList;

public class minimumNumber {
	
	public static int findMin(LinkedList<Integer> input){
		
		int size = input.size();
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<size; i++){
			if(min > input.get(i)){
				min = input.get(i);
			}
		}
		
		return min;
	}

	public static void main(String[] args) {
		LinkedList<Integer> temp = new LinkedList<>();
		
		temp.add(1);
		temp.add(4);
		temp.add(2);
		temp.add(3);
		
		System.out.print( findMin(temp) );
	}

}
