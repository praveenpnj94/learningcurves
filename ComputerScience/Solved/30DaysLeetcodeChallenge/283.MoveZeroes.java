//https://www.youtube.com/watch?v=1PEncepEIoE
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3286/
//https://leetcode.com/problems/move-zeroes/
class Solution {
    public void moveZeroes(int[] nums) {
        int index =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index++]=nums[i];              
            }
        }
        for(int i =index;i<nums.length;i++){
            nums[i]=0;
        }
    }
}