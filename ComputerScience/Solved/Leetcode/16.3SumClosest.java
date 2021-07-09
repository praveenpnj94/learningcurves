//https://leetcode.com/problems/3sum-closest/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int result =0;
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                int diff = Math.abs(sum-target);
                if(diff==0){
                    return sum;
                }
                else{
                    if(diff<min){
                        min=diff;
                        result = sum;
                    }
                }
                if(sum<target){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return result;
    }
}