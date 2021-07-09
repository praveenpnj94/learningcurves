//https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1

class Solution {
    int count(int[] arr, int n, int x) {
        if(arr==null||arr.length==0){
            return -1;
        }
        int a = getLast(arr,x);
        int b = getFirst(arr,x);
        return a!=-1?a-b+1:0;
    }
    
    int getFirst(int[] arr,int x){
        int res=-1;
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==x){
                res=mid;
                high=mid-1;
            }
            else if(arr[mid]>x){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return res;
    }
    
    int getLast(int[] arr,int x){
        int res=-1;
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==x){
                res=mid;
                low=mid+1;
            }
            else if(arr[mid]>x){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return res;
    }
}