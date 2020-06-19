//https://leetcode.com/problems/single-element-in-a-sorted-array/
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
//https://www.youtube.com/watch?v=nMGL2vlyJk0

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int high = nums.length-1;
        int low =0;
        
        if(high==0){
            return nums[0];
        }
        else if(nums[0]!=nums[1]){
            return nums[0];
        }
        else if(nums[high]!=nums[high-1]){
            return nums[high];
        }
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }
            else if((mid%2==0 && nums[mid]==nums[mid+1])||(mid%2==1 && nums[mid]==nums[mid-1])){
                low = mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}