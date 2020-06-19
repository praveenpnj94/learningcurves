//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3356/
//https://leetcode.com/problems/search-insert-position/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int i=0,j=n-1;
        while(i<=j)
        {
            int mid=(i+j)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            if(nums[mid]<target)
            {
                i=mid+1;
            }
            else
            {
                j=mid-1;
            }
            
        }
        return i;
        
    }
}