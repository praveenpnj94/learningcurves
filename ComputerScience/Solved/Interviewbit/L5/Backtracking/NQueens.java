//https://www.interviewbit.com/problems/nqueens/

public class Solution {
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
	    ArrayList<ArrayList<String>> result = new ArrayList<>();
	    if(a==1){
	        ArrayList<String> al = new ArrayList<>();
	        al.add("Q");
	        result.add(al);
	        return result;
	    }
	    int[][] board = new int[a][a];
	    nqueens(board,a,result,0);
	    return result;
	}
	
	public void nqueens(int[][] board,int a, ArrayList<ArrayList<String>> result,int col){
	    if(col>=a){
	        result.add(convert(board));
	        return;
	    }
	    for(int i=0;i<a;i++){
	        if(isSafe(board,i,col,a)){
	            board[i][col]=1;
	            nqueens(board,a,result,col+1);
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
	
	public ArrayList<String> convert(int[][] board){
	    ArrayList<String> al = new ArrayList<>();
	    for(int[] a:board){
	        String s ="";
	        for(int n:a){
	            s=n==1?(s+"Q"):(s+".");
	        }
	        al.add(s);
	    }
	    return al;
	}
}
