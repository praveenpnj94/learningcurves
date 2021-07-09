//https://leetcode.com/problems/n-queens/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] ch:board){
            Arrays.fill(ch,'.');
        }
        List<List<String>> list = new ArrayList<>();
        nQueensUtil(board,list,0,n);
        return list;
    }
    
    public void nQueensUtil(char[][] board,List<List<String>> result, int col, int n){
        if(col>=n){
            result.add(convert(board));
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(board,i,col,n)){
                board[i][col]='Q';
                nQueensUtil(board,result,col+1,n);
                board[i][col]='.';
            }
        }
    }
    
    public boolean isSafe(char[][] board,int row,int col,int N){
        int i, j; 
		for (i = 0; i < col; i++) 
			if (board[row][i] == 'Q') 
				return false; 
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
			if (board[i][j] == 'Q') 
				return false; 
		for (i = row, j = col; j >= 0 && i < N; i++, j--) 
			if (board[i][j] == 'Q') 
				return false;
		return true; 
    } 
    
    public List<String> convert(char[][] board){
        List<String> l = new ArrayList<>();
        for(char[] c:board){
            String s="";
            for(char ch:c){
                s+=Character.toString(ch);
            }
            l.add(s);
        }
        return l;
    }
}