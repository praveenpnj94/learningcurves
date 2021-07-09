//https://leetcode.com/problems/climbing-stairs/

class Solution {
    int[] dp = new int[46];
    public int climbStairs(int n) {
        dp[0]=1;
        dp[1]=1;
        if(n==1||n==2){
            return dp[n]=n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        return dp[n]=(climbStairs(n-1)+climbStairs(n-2));
        
    }
}