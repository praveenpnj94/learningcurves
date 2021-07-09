//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high=nums.length-1;
        int fres=-1;
        int lres=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(nums[mid]==target){
                fres=mid;
                high=mid-1;
            }
            else if(nums[mid]>target){
                high=mid-1;               
            }
            else{
                low= mid+1;
            }
        }
        
        low = 0;
        high=nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(nums[mid]==target){
                lres=mid;
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;               
            }
            else{
                low= mid+1;
            }
        }
                
        int[] res=new int[2];
        res[0]=fres;
        res[1]=lres;
        return res;
    }
}