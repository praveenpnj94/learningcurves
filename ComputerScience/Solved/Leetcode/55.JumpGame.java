//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3310/
//https://www.youtube.com/watch?v=Zb4eRjuPHbM
//https://leetcode.com/problems/jump-game/

class Solution {
    //Top Down
//     public boolean canJump(int[] nums) {
//         int pos = nums.length-1;
//         Boolean[] dp = new Boolean[pos+1];
//         return jumpUtil(nums,pos,dp);
//     }
    
//     public boolean jumpUtil(int[] nums, int pos,Boolean[] dp){
//         if(pos==0){
//             return dp[pos]=true;
//         }
//         if(dp[pos]!=null){
//             return dp[pos];
//         }
//         for(int i=pos-1;i>=0;i--){
//             if(jumpUtil(nums,i,dp) && nums[i]>=pos-i){
//                 return dp[pos]=true;
//             }
//         }
//         return dp[pos]=false;
//     }
    
    //Greedy O(n)
    // public boolean canJump(int[] nums) {
    //     int lastGoodpos = nums.length-1;
    //     for(int i=nums.length-1;i>=0;i--){
    //         if(i+nums[i]>=lastGoodpos){
    //             lastGoodpos = i;
    //         }
    //     }
    //     return lastGoodpos==0;
    // }
    
    //bottom up my
//     public boolean canJump(int[] nums) {
//         int n = nums.length;
//         boolean[] dp = new boolean[n];
//         dp[0]=true;
//         for(int i=0;i<n;i++){
//             if(dp[i]){
//                 int farthest = Math.min(nums[i]+i,n-1);
//                 for(int j=i;j<=farthest;j++){
//                     if(!dp[j]){
//                         dp[j]=true;
//                     }
                    
//                 }
//             }
//         }
//         return dp[n-1];        
//     }
    
    //bottom up sol
    public boolean canJump(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        memo[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j]) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[0];
    }
}