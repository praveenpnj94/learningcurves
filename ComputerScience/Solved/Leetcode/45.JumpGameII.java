//https://leetcode.com/problems/jump-game-ii/
//https://www.youtube.com/watch?v=vBdo7wtwlXs

class Solution {
    // public int jump(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp,Integer.MAX_VALUE);
    //     dp[0]=0;
    //     for(int i=1;i<n;i++){
    //         for(int j=0;j<i;j++){
    //             if(i<=j+nums[j]){
    //                 dp[i]=Math.min(dp[i],1+dp[j]);
    //             }
    //         }
    //     }
    //     return dp[n-1]==Integer.MAX_VALUE?-1:dp[n-1];
    // }
    
    public int jump(int[] nums) {
        int n = nums.length;
        if(nums[0]==0 ||nums.length<=1){
            return 0;
        }
        int ladder = nums[0];
        int stairs = nums[0];
        int jump = 1;
        for(int level=1;level<nums.length;level++){
            if(level==nums.length-1){
                return jump;
            }
            if(level+nums[level]>ladder){
                ladder = level+nums[level];
            }
            stairs--;
            if(stairs==0){
                jump++;
                stairs = ladder-level;
            }
        }
        return jump;
    }

    public int jump(int[] nums) {
        int currMax = 0;
        int currReach =0;
        int jumps =0;
        if(nums[0]==0 ||nums.length<=1){
            return 0;
        }
        for(int i=0;i<nums.length-1;i++){
            currMax = Math.max(currMax,i+nums[i]);
            if(i==currReach){
                jumps++;
                currReach = currMax;
            }
        }
        return jumps;
    }
}