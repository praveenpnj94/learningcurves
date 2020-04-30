//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/
//https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int currMax = 0;
        for(int i=0;i<nums.length;i++){
            currMax = Math.max(nums[i]+currMax,nums[i]);
            maxSoFar = Math.max(currMax,maxSoFar);
        }
        return maxSoFar;
    }
}