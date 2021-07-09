//https://leetcode.com/problems/first-missing-positive/
//https://www.youtube.com/watch?v=-lfHWWMmXXM&ab_channel=RachitJain

class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null){
            return 0;
        }
        if(nums.length==0){
            return 1;
        }
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            int correctPos = nums[i]-1;
            while(1<=nums[i] && nums[i]<=n && nums[i]!=nums[correctPos]){
                swap(nums,i,correctPos);
                correctPos = nums[i]-1;
            }
        }
        
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        
        return n+1;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}