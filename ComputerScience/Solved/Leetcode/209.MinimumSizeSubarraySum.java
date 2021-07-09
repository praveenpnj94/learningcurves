//https://leetcode.com/problems/minimum-size-subarray-sum/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int minLen=Integer.MAX_VALUE;
        int n= nums.length;
        int sum=0; int left = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            while(sum>=s){
                minLen=Math.min(minLen,i-left+1);
                sum=sum-nums[left];
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}