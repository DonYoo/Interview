package BFS;

import java.util.*;

/**
 * 
 * @author DonYoo

Shortest Source to Destination Path

Given a boolean 2D matrix (0-based index), find whether there is path from (0,0) to (x,y) and if there is one path, print the minimum no of steps needed to reach it, else print -1 if the destination is not reachable. You may move in only four direction ie up, down, left and right. The path can only be created out of a cell if its value is 1.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines . The first line of each test case contains two integers n and m denoting the size of the matrix. Then in the next line are n*m space separated values of the matrix. The following line after it contains two integers x and y denoting the index of the destination.

Output:
For each test case print in a new line the min no of steps needed to reach the destination.

Constraints:
1<=T<=100
1<=n,m<=20

Example:
Input:
2
3 4
1 0 0 0 
1 1 0 1 
0 1 1 1

2 3


3 4
1 1 1 1 
0 0 0 1 
0 0 0 1

0 3
Output:
5
3

 */


class pair{
    int x;
    int y;
    int step;
    int path;
    
    public pair(int x, int y, int step){
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

public class shortestPath {

	static Scanner scan;
    
    static int findShortestPath(int[][]arr, int rows, int columns, int destx, int desty){
        Queue <pair> que = new LinkedList<>();
        pair start = new pair(0, 0, 0);
        boolean [][] visited = new boolean[rows][columns];
        que.add(start);
        
        while(!que.isEmpty()){
            pair current = que.poll();

            // x = rows
            // y = columns
            int x = current.x;
            int y = current.y;
            
            boolean visit = visited[x][y];
            
            //System.out.println(x+ " " + y);
            
            // check if its valid path
            if(arr[x][y] != 0 && visit == false){
            	
            	// if it comes to destination
                if(x == destx && y == desty){
                    return current.step;
                }
                
                // left
                if(y-1 >= 0){
                    pair left = new pair(x, y-1, current.step + 1);
                    if(arr[x][y-1] != 0){
                        que.add(left);
                    }
                }
                // right
                if(y+1 < columns){
                    pair right = new pair(x, y+1, current.step + 1);
                    if(arr[x][y+1] != 0){
                        que.add(right);
                    }
                }
                
                // up
                if(x-1 >=0){
                    pair up = new pair(x-1, y, current.step + 1);
                    if(arr[x-1][y] != 0){
                        que.add(up);
                    }
                }
                // down
                if(x+1 < rows){
                    pair down = new pair(x+1, y, current.step + 1);
                    if(arr[x+1][y] != 0){
                        que.add(down);
                    }
                }
            }
            // mark visited
            visited[x][y] = true;
        }
        return -1;
    }
    
	public static void main (String[] args)
	{
	    scan = new Scanner(System.in);
	    
	    int testcase = scan.nextInt();
	    
	    while(testcase-->0){
	        int rows = scan.nextInt();
	        int columns = scan.nextInt();
	        
	        int[][] arr = new int[rows][columns];
	        
	        // put input into the 2d array
	        for(int i=0; i<rows; i++){
	            for(int j=0; j<columns; j++){
	                arr[i][j] = scan.nextInt();
	            }
	        }
	        
	        int destx = scan.nextInt();
	        int desty = scan.nextInt();
	        
	        System.out.println(findShortestPath(arr, rows, columns, destx, desty));
	    }
	}
	
}
