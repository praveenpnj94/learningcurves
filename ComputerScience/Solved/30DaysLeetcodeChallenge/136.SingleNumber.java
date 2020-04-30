
//https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/528/week-1/3283/
//https://leetcode.com/problems/single-number/
class Solution {
    public int singleNumber(int[] nums) {
        int res= nums[0];
        for(int i=1;i<nums.length;i++){
            res=res^nums[i];
        }
        return res;
    }
}