package DynamicProgram;

import java.util.*;


/**
 * 
 * @author DonYoo

https://www.geeksforgeeks.org/find-rectangle-binary-matrix-corners-1/

Find if there is a rectangle in binary matrix with corners as 1
There is a given binary matrix, we need to find if there exists any rectangle or square in the given matrix whose all four corners are equal to 1.

Examples:

Input :
mat[][] = { 1 0 0 1 0
            0 0 1 0 1
            0 0 0 1 0
            1 0 1 0 1}
Output : Yes
as there exists-
1 0 1
0 1 0
1 0 1

Efficient Approach 
– Scan from top to down, line by line
– For each line, remember each combination of 2 1’s and push that into a hash-set
– If we ever find that combination again in a later line, we get our rectangle
– Time Complexity of this solution- O(n*m^2)

 */

class Pair{
	int key;
	int value;
	
	public Pair(int key, int value){
		this.key = key;
		this.value = value;
	}
	
	public int findValue(int key){
		if(this.key == key){
			return value;
		}
		return -1;
	}
	
	public int findKey(int value){
		if(this.value == value){
			return key;
		}
		return -1;
	}
}
public class matrix {


	public static boolean isRectangle(int[][] mat){
		int row = mat.length;
		int column = mat[0].length;
		
		// arraylist for the column
		ArrayList<Integer>[] map = new ArrayList[column];
		
		for(int i=0; i<column; i++){
			map[i] = new ArrayList<>();
		}
		
		// iterate through and make a Map with value 1.
		for(int i=0; i<row; i++){
			for (int j=0; j<column; j++){
				
				for(int k=j+1; k<column; k++){
					// find where rows value are 1
					if((mat[i][j] == 1) &&
						(mat[i][k] ==1)){
						
						if(!map[j].isEmpty()){
							// check the columns
							for(int temp : map[j]){
								if(map[k].contains(temp)){
									return true;
								}
							}
						}
						map[j].add(i);
						map[k].add(i);
					}
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		int[][] mat = {	{ 1, 0, 0, 1, 0 },
						{ 0, 0, 1, 0, 1 },
						{ 1, 0, 0, 1, 0 },
						{ 1, 0, 1, 0, 0 } };
		System.out.println(isRectangle(mat));
	}

}
