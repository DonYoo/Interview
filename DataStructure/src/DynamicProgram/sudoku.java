package DynamicProgram;

import java.util.*;


class compare implements Comparator<suPair>{
    public int compare(suPair p1, suPair p2){
        if((p1.row == p2.row) && (p1.col == p2.col) ){
            return 0;
        }
        else if(p1.row < p2.row){
            return 1;
        }
        if(p1.col < p2.col){
            return 1;
        }
        return -1;
    }
}

class suPair{
    int row;
    int col;
    
    public suPair(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    public boolean theEnd(){
        if(row == -1 && col == -1){
            return true;
        }
        return false;
    }
}

class sudoku
{
    static Scanner scan;
    
    // find the next 0
    public static suPair findEmpty(int[][] matrix){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(matrix[i][j] == 0){
                    return new suPair(i, j);
                }
            }
        }
        return new suPair(-1, -1);
    }
    
    public static boolean isValid(int[][] matrix, int row, int col, int value){
        // check rows and columns
        for(int i=0; i<9; i++){
            if(matrix[i][col] == value){
                return false;
            }
            if(matrix[row][i] == value){
                return false;
            }
        }
        // 3x3 check
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(matrix[row-row%3+i][col-col%3+j] == value){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int isSudoku(int[][] matrix){
    	
    	suPair pair = findEmpty(matrix);
        if(pair.theEnd()){
            return 1;
        }
        
        //is valid?
        for(int value = 1; value<10; value++){
            if(isValid(matrix, pair.row, pair.col, value)){
                matrix[pair.row][pair.col] = value;
                if(isSudoku(matrix) == 1){
                    return 1;
                }
                matrix[pair.row][pair.col] = 0;
            }
        }
        // if no value work as a input
        return 0;
    }
    
	public static void main (String[] args)
	{
	    scan = new Scanner(System.in);
	    
	    int testcase = scan.nextInt();
	    
	    while(testcase-->0){
	        int[][] matrix = new int [9][9];
	        
	        for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
	                matrix[i][j] = scan.nextInt();
                }
	        }
	        
	        for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
	                System.out.print(matrix[i][j] +" ");
                }
                System.out.println();
	        }
	        System.out.println(isSudoku(matrix));
	    }
	}
}