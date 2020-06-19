//https://leetcode.com/problems/search-in-rotated-sorted-array/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3304/
//https://www.youtube.com/watch?v=6pSzsJH56BA

//my solution
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0]==target?0:-1;
        }
        int n=nums.length;
        int pivotIndex;
        if(nums[0]<nums[n-1]){
            pivotIndex =0;
        }
        else{
            pivotIndex = getPivot(nums,0,n-1);
        }
        if(target<nums[pivotIndex]){
            return -1;
        }
        else{
            if(target<=nums[n-1]){
                return binary(nums,target,pivotIndex,n-1);
            }
            else{
                return binary(nums,target,0,pivotIndex-1);
            }
        }
    }
    public int binary(int[] arr, int target, int start, int end){
        if(start<=end){
        int mid = (start+end)/2;
        if(arr[mid]==target){
            return mid;
        }
        else if(arr[mid]<target){
            return binary(arr,target,mid+1,end);
        }
        else{
            return binary(arr,target,start,mid-1);
        }            
        }
        return -1;

    }
    
    public int getPivot(int[] arr, int start, int end){
        int mid = (start+end)/2;
        if(arr[mid]>arr[mid+1]){
            return mid+1;
        }
        else if(arr[mid]>=arr[start]){
            return getPivot(arr,mid+1,end);
        }
        else{
            return getPivot(arr,start,mid);
        }
    }
}


//one pass
class Solution {
    public int search(int[] nums, int target) {
      int start = 0, end = nums.length - 1;
      while (start <= end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] >= nums[start]) {
          if (target >= nums[start] && target < nums[mid]) end = mid - 1;
          else start = mid + 1;
        }
        else {
          if (target <= nums[end] && target > nums[mid]) start = mid + 1;
          else end = mid - 1;
        }
      }
      return -1;
    }
  }