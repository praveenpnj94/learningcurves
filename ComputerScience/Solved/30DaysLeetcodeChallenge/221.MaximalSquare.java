//https://leetcode.com/problems/maximal-square/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3312/
//https://www.youtube.com/watch?v=FO7VXDfS8Gk

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSize = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]= matrix[i][j]-'0';
                }
                else{
                    if(matrix[i][j]=='0'){
                        dp[i][j]= 0;
                    }
                    else{
                        dp[i][j]= 1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                    }
                }
                maxSize = Math.max(dp[i][j],maxSize);
            }
        }
        return maxSize*maxSize;
    }
}