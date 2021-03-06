//https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
    public boolean canPartition(int[] nums) {
        
        int totalSum =0;
        for(int n:nums){
            totalSum+=n;
        }
        if(totalSum%2>0){
            return false;
        }
        return solve(nums,totalSum/2);
    }
    
    public boolean solve(int[] A, int B) {
        int N = A.length;
        boolean[][] dp = new boolean[N+1][B+1];
        
        for(int i=0;i<=B;i++){
            dp[0][i]=false;
        }
        
        for(int i=0;i<=N;i++){
            dp[i][0]=true;
        }
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=B;j++){
                dp[i][j]=dp[i-1][j];
                if(A[i-1]<=j){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-A[i-1]];
                }
            }
        }
        return dp[N][B];
        
    }
}