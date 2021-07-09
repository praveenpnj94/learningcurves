//https://leetcode.com/problems/house-robber/
//https://www.youtube.com/watch?v=xlvhyfcoQa4
//https://www.youtube.com/watch?v=FAxkaf_iDlc
//https://www.youtube.com/watch?v=ge_Fv2ZQAaE&ab_channel=JAVAAID-CodingInterviewPreparation

class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        if(n==1){
            return dp[1];
        }
        dp[2]= Math.max(nums[0],nums[1]);
        for(int i=3;i<=n;i++){
            dp[i]= Math.max(nums[i-1]+dp[i-2],dp[i-1]);
        }
        return dp[n];
    }
}