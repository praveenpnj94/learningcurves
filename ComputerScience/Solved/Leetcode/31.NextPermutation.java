//https://leetcode.com/problems/next-permutation/
//https://www.youtube.com/watch?v=dMQcTJkypCg&ab_channel=PrakashShukla

class Solution {
    // public void nextPermutation(int[] nums) {
    //     if(nums==null||nums.length<=1){
    //         return;
    //     }
    //     int n = nums.length;
    //     int i=nums.length-1;
    //     for(;i>=1;i--){
    //         if(nums[i-1]<nums[i]){
    //             break;
    //         }
    //     }
    //     if(i==0){
    //         for(int l=0;l<n/2;l++){
    //             swap(nums,l,n-l-1);
    //         }
    //     }
    //     else{
    //         int k =i;
    //         int[] right = new int[n-i];
    //         int desiredIdx = -1;
    //         int size = n-i;
    //         boolean flag = false;
    //         i=0;
    //         for(int j =size-1;j>=0;j--){
    //             right[j]=nums[n-1-i];
    //             if(right[j]>nums[k-1] && !flag){
    //                 desiredIdx=j;
    //                 flag = true;
    //             }
    //             i++;
    //         }
    //         int temp=nums[k-1];
    //         nums[k-1]=right[desiredIdx];
    //         right[desiredIdx] = temp;
    //         for(int l=0;l<right.length/2;l++){
    //             swap(right,l,right.length-l-1);
    //         }
    //         for(int l=0;l<right.length;l++){
    //             nums[k++]=right[l];
    //         }
    //     }
    // }
    // public void swap(int[] nums, int i, int j){
    //     int temp = nums[i];
    //     nums[i]=nums[j];
    //     nums[j]=temp;
    // }
    
  public void nextPermutation(int[] nums) {
       
       int k = nums.length-2;
        
       while(k>=0 && nums[k]>=nums[k+1])k--; 
        
       //CASE 1
       if(k==-1){
          reverseArray(0,nums.length-1,nums);
          return;
       }
       
       //CASE 2
       for(int i = nums.length-1;i>k;i--){
            if(nums[i]>nums[k]){//2
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                break;
            }
        }
       reverseArray(k+1,nums.length-1,nums); 
  
        
    }
    
    void reverseArray(int i,int j,int[] nums){
        while(i<j){
            int temp = nums[i]; 
            nums[i] = nums[j];
            nums[j] = temp;
            i++;j--;
        }
    }
}