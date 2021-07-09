//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//https://www.youtube.com/watch?v=4WmTRFZilj8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=7&ab_channel=AdityaVerma

class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        
        int n = nums.length;
        int start =0;
        int end = nums.length-1;
        if(nums[start]<=nums[end]){
            return nums[start];
        }
        int res=0;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;
            
            if(nums[mid]<=nums[next] && nums[mid]<=nums[prev]){
                res= nums[mid];
                break;
            }
            
            if(nums[start]<=nums[mid] && nums[end]<=nums[mid]){
                start=mid+1;
            }
            
            else {
                end=mid-1;
            }
        }        
        return res;

    }
}