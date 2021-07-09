//https://leetcode.com/problems/n-queens-ii/

class Solution {
    static int count = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        count=0;
        nQueensUtil(board,0,n);
        return count;
    }
    
    public void nQueensUtil(int[][] board, int col, int n){
        if(col>=n){
            count++;
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(board,i,col,n)){
                board[i][col]=1;
                nQueensUtil(board,col+1,n);
                board[i][col]=0;
            }
        }
    }
    
    public boolean isSafe(int[][] board,int row,int col,int N){
        int i, j; 
		for (i = 0; i < col; i++) 
			if (board[row][i] == 1) 
				return false; 
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
			if (board[i][j] == 1) 
				return false; 
		for (i = row, j = col; j >= 0 && i < N; i++, j--) 
			if (board[i][j] == 1) 
				return false;
		return true; 
    }
}