//https://leetcode.com/problems/surrounded-regions/

class Solution {
    public void solve(char[][] board) {
        if(board==null||board.length==0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                bdfs(board,0,j,m,n);
            }
        }
        for(int j=0;j<n;j++){
            if(board[m-1][j]=='O'){
                bdfs(board,m-1,j,m,n);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                bdfs(board,i,0,m,n);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O'){
                bdfs(board,i,n-1,m,n);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j]=='*'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void bdfs(char[][] board, int i, int j, int m, int n){
        if(i<0||j<0||i>=m||j>=n||board[i][j]=='*'||board[i][j]=='X'){
            return;
        }
        board[i][j]='*';
        bdfs(board,i+1,j,m,n);
        bdfs(board,i-1,j,m,n);
        bdfs(board,i,j+1,m,n);
        bdfs(board,i,j-1,m,n);        
    }
}