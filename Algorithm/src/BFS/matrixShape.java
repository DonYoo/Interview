package BFS;

import java.util.*;

/**
 * 
 * @author DonYoo

https://practice.geeksforgeeks.org/problems/x-total-shapes/0


sample

https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/


Given N * M string array of O's and X's
Return the number of 'X' total shapes. 'X' shape consists of one or more adjacent X's (diagonals not included).

Example (1):

OOOXOOO
OXXXXXO
OXOOOXO

answer is 1 , shapes are  :
(i)     X
    X X X X
    X     X


Example (2):

XXX
OOO
XXX

answer is 2, shapes are
(i)  XXX

(ii) XXX

Input:
The first line of input takes the number of test cases, T.
Then T test cases follow. Each of the T test cases takes 2 input lines.
The first line of each test case have two integers N and M.The second line of N space separated strings follow which indicate the elements in the array.

Output:

Print number of shapes.

Constraints:

1<=T<=100

1<=N,M<=50

Example:

Input:
2
4 7
OOOOXXO OXOXOOX XXXXOXO OXXXOOO
10 3
XXO OOX OXO OOO XOX XOX OXO XXO XXX OOO

Output:
4
6


sample

input:
OOOOXXO
OXOXOOX
XXXXOXO
OXXXOOO

output:
4

 */

public class matrixShape {

	static Scanner Scan; 

	private static void change(String[][]input, int col, int row){
		Queue<int[]> que = new LinkedList<>();
		int[] index = {col,row};
		que.add(index);

		// check 4 ways. if it has visited change to "O"
		while(!que.isEmpty()){
			index = que.poll();
			int i = index[0];
			int j = index[1];

			input[i][j] = "O";

			//left
			if(j > 0 ){
				if(input[i][j-1].equals("X")){
					int[] temp = {i,j-1};
					que.add(temp);
				}
			}
			//right
			if(j < input[0].length-1){
				if(input[i][j+1].equals("X")){
					int[] temp = {i,j+1};
					que.add(temp);
				}
			}

			//up
			if(i > 0 ){
				if(input[i-1][j].equals("X")){
					int[] temp = {i-1,j};
					que.add(temp);
				}
			}
			//down
			if(i < input.length-1 ){
				if(input[i+1][j].equals("X")){
					int[] temp = {i+1,j};
					que.add(temp);
				}
			}

		}
	}

	private static int BreadthFirst(String[][] input, int column, int row){


		int total = 0;

		for(int i=0; i<column;i++){
			for(int j=0; j<row; j++){
				if(input[i][j].equals("X")){
					change(input, i, j);
					total++;
				}
			}
		}

		return total;
	}



	public static void main(String[] args) {
		Scan = new Scanner(System.in);

		int testcase=Scan.nextInt();

		while(testcase--> 0){
			int column = Scan.nextInt();
			int row = Scan.nextInt();

			String[][]input = new String[column][row];

			// get input and put in the 2d array.
			for(int i=0; i<column; i++){
				String temp = Scan.next();
				input[i] = temp.split(""); 
			}

			System.out.println(BreadthFirst(input, column, row));
		}
	}

}
