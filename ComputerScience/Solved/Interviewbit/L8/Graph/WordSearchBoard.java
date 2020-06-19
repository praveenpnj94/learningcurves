//https://www.interviewbit.com/problems/word-search-board/

public class Solution {
    public int exist(ArrayList<String> A, String B) {
        if(A==null||A.size()==0){
            return 0;
        }
        int m = A.size();
        int n = A.get(0).length();
        char[][] mat = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=A.get(i).charAt(j);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]== B.charAt(0)){
                    if(dfs(i,j,0,mat,m,n,B)){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    public boolean dfs(int i, int j, int pos, char[][] mat, int m, int n, String B){
        if(pos==B.length()){
            return true;
        }
        if(i<0||j<0||i>=m||j>=n || mat[i][j]!=B.charAt(pos)){
            return false;
        }
        return (dfs(i-1,j,pos+1,mat,m,n,B)||dfs(i+1,j,pos+1,mat,m,n,B)
        ||dfs(i,j-1,pos+1,mat,m,n,B)||dfs(i,j+1,pos+1,mat,m,n,B));
    }
}
