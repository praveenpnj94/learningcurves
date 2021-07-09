//https://leetcode.com/problems/target-sum/

class Solution {
    //     public int findTargetSumWays(int[] nums, int S) {
    //         int n = nums.length ;
    //         if(n==0){
    //             return 0;
    //         }
    //         int totalSum = 0;
    //         for(int num:nums){
    //             totalSum+=num;
    //         }
            
    //         int d = totalSum+S;
            
    //         if(d%2>0||S>totalSum||S<-totalSum){
    //             return 0;
    //         }
            
    //         int s1 = d/2;
            
    //         int[][] dp = new int[n+1][totalSum+1];
            
    //         for(int i=0;i<=n;i++){
    //             dp[i][0]=1;
    //         }
            
    //         for(int i=1;i<=n;i++){
    //             for(int j=1;j<=totalSum;j++){
    //                 if(j>=nums[i-1]){
    //                     dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
    //                 }
    //                 else{
    //                     dp[i][j]=dp[i-1][j];
    //                 }
    //             }
    //         }
            
    //         return dp[n][s1];
    //     }
        
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if(S > sum || (sum + S) % 2 == 1)   return 0;
            return subsetSum(nums, (sum + S) / 2);
        }
    
        private int subsetSum(int[] nums, int S){
            int[] dp = new int[S + 1];
            dp[0] = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = S; j >= nums[i]; j--) {
                    dp[j] += dp[j - nums[i]];
                }
            }
            return dp[S];
        }
    }