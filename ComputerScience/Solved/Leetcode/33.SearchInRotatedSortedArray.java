//https://leetcode.com/problems/search-in-rotated-sorted-array/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3304/
//https://www.youtube.com/watch?v=6pSzsJH56BA
//https://www.youtube.com/watch?v=Id-DdcWb5AU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=8&ab_channel=AdityaVerma

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
        int minIdx = findMinIdx(nums);
        if(minIdx==0){
            return binary(nums,target,0,n-1);
        }
        else{
            int a = binary(nums,target,minIdx,n-1);
            int b = binary(nums,target,0,minIdx-1);
            if(a==-1 && b==-1){
                return -1;
            }
            else{
                return a==-1?b:a;
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
    
    public int findMinIdx(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        
        int n = nums.length;
        int start =0;
        int end = nums.length-1;
        if(nums[start]<=nums[end]){
            return start;
        }
        int res=-1;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;
            
            if(nums[mid]<=nums[next] && nums[mid]<=nums[prev]){
                res= mid;
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