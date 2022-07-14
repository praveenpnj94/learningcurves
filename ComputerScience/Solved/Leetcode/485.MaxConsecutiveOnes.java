//https://leetcode.com/problems/max-consecutive-ones/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        else if(nums.length==1){
            if(nums[0]==1){
                return 1;
            }
            return 0;
        }
        else{
            int maxCnt=0;
            int cnt=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==1){
                    cnt++;
                    maxCnt=Math.max(maxCnt,cnt);
                }
                else{
                    cnt=0;
                }
            }
            return maxCnt;
        }
    }
}