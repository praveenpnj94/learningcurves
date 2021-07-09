//https://leetcode.com/problems/word-search/

// class Solution {
//     public boolean exist(char[][] board, String word) {
//         if(board==null||board.length==0){
//             return false;
//         }
//         int m = board.length;
//         int n = board[0].length;
//         boolean[][] vis = new boolean[m][n];
//         for(boolean[] v:vis){
//             Arrays.fill(v,false);
//         }
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(word.charAt(0)==board[i][j] && !vis[i][j]){
//                     if(dfs(i,j,0,board,vis,word)){
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }
    
//     public boolean dfs(int x, int y, int pos,char[][] board, boolean[][] vis, String word){
//         int m = board.length;
//         int n = board[0].length;
//         if( pos == word.length()){
//             return true;
//         }
//         if(x>=m||y>=n||x<0||y<0||vis[x][y]||pos>word.length()){
//             return false;
//         }
//         if(word.charAt(pos)!=board[x][y]){
//             return false;
//         }
//         vis[x][y]=true;
//         if(dfs(x-1,y,pos+1,board,vis,word)||dfs(x+1,y,pos+1,board,vis,word)||
//             dfs(x,y-1,pos+1,board,vis,word)||dfs(x,y+1,pos+1,board,vis,word)){
//             return true;
//         }
//         vis[x][y]=false;
//         return false;
//     }
// }

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, chs, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, char[] words, int idx, int x, int y) {
        if (idx == words.length) {
            return true;
        } 
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return false;
        }
        if (board[x][y] != words[idx]) {
            return false;
        }
        board[x][y] ^= 256;
        boolean exist = dfs(board, words, idx + 1, x, y + 1) ||
        dfs(board, words, idx + 1, x, y - 1) || dfs(board, words, idx + 1, x + 1, y) ||
        dfs(board, words, idx + 1, x - 1, y) ;
        board[x][y] ^= 256;
        return exist;
    }
}