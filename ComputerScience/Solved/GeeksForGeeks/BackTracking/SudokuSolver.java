//https://www.geeksforgeeks.org/sudoku-backtracking-7/
//https://www.youtube.com/watch?list=PLpO3gASfJEIJ4tnnYUX6vm8OhR92iGM7J&v=8oAXSixi2Gg&feature=emb_title

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int[][] board = new int[9][9];
		    for(int j=0;j<9;j++){
		        for(int k=0;k<9;k++){
		            board[j][k] = sc.nextInt();
		        }
		    }
		    solveSudoku(board, 9);
		    printSudoku(board,9);
		}
	}
	
	public static void printSudoku(int[][] board,int n){
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            System.out.print(board[i][j]+" ");
	        }
	        //System.out.println();
	    }
	    System.out.println();
	}


public static boolean solveSudoku(int[][] board, int n)  
{ 
    int row = -1; 
    int col = -1; 
    boolean isEmpty = true; 
    for (int i = 0; i < n; i++) 
    { 
        for (int j = 0; j < n; j++)  
        { 
            if (board[i][j] == 0)  
            { 
                row = i; 
                col = j; 
                  
                // we still have some remaining 
                // missing values in Sudoku 
                isEmpty = false;  
                break; 
            } 
        } 
        if (!isEmpty) 
        { 
            break; 
        } 
    } 
  
    // no empty space left 
    if (isEmpty)  
    { 
        return true; 
    } 
  
    // else for each-row backtrack 
    for (int num = 1; num <= n; num++) 
    { 
        if (isSafe(board, row, col, num)) 
        { 
            board[row][col] = num; 
            if (solveSudoku(board, n))  
            { 
                // print(board, n); 
                return true; 
            }  
            else
            { 
                board[row][col] = 0; // replace it 
            } 
        } 
    } 
    return false; 
}
public static boolean isSafe(int[][] board,int row, int col, int num){
    int n = board.length;
    for(int r=0;r<board.length;r++){
        if(board[row][r]==num){
            return false;
        }
    }
    for(int c=0;c<board.length;c++){
        if(board[c][col]==num){
            return false;
        }
    }
    // corresponding square has 
    // unique number (box-clash) 
    int sqrt = (int) Math.sqrt(board.length); 
    int boxRowStart = row - row % sqrt; 
    int boxColStart = col - col % sqrt; 
  
    for (int r = boxRowStart; 
             r < boxRowStart + sqrt; r++)  
    { 
        for (int d = boxColStart;  
                 d < boxColStart + sqrt; d++)  
        { 
            if (board[r][d] == num)  
            { 
                return false; 
            } 
        } 
    } 
  
        // if there is no clash, it's safe 
    return true;
}
}