//https://leetcode.com/problems/minimum-path-sum/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/
//https://www.youtube.com/watch?v=t1shZ8_s6jc
//https://www.youtube.com/watch?v=ItjZdu6jEMs
//my solution o(mn) space
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=grid[i][j];
                }
                else if(i==0){
                    dp[i][j]=grid[i][j]+dp[i][j-1];
                }
                else if(j==0){
                    dp[i][j]=grid[i][j]+dp[i-1][j];
                }
                else{
                    dp[i][j]=grid[i][j]+Math.min(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}