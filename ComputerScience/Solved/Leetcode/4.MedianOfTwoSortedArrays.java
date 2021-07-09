//https://leetcode.com/problems/median-of-two-sorted-arrays/
//https://www.youtube.com/watch?v=LPFhl65R7ww

class Solution {
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int res = nums1.length+nums2.length;
    //     int[] result = new int[res];
    //     sort(result,nums1,nums2);
    //     return res%2!=0?result[res/2]:((double)result[res/2]+result[(res-1)/2])/2;
    // }
    // public void sort(int[] result,int[] nums1,int[] nums2){
    //     int i=0;
    //     int j=0;
    //     int k=0;
    //     int m = nums1.length;
    //     int n = nums2.length;
    //     while(i<m && j<n){
    //         if(nums1[i]<nums2[j]){
    //             result[k++] = nums1[i++];
    //         }
    //         else{
    //             result[k++] = nums2[j++];
    //         }
    //     }
    //     while(i<m){
    //         result[k++]=nums1[i++];
    //     }
    //     while(j<n){
    //         result[k++]=nums2[j++];
    //     }
    // }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int start = 0;
        int end = x;
        int total = x+y;
        while(start<=end){
            int partitionX = (start+end)/2;
            int partitionY = (x+y+1)/2 - partitionX;
            int maxLeftX = partitionX==0?Integer.MIN_VALUE:nums1[partitionX-1];
            int minRightX = partitionX==x?Integer.MAX_VALUE:nums1[partitionX];
            int maxLeftY = partitionY==0?Integer.MIN_VALUE:nums2[partitionY-1];
            int minRightY = partitionY==y?Integer.MAX_VALUE:nums2[partitionY];
            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                int a = Math.max(maxLeftX,maxLeftY);
                if(total%2!=0){
                    return (double)a;
                }
                else{
                    int b = Math.min(minRightX,minRightY);
                    return ((double)a+b)/2;
                }
            }
            else if(maxLeftX>minRightY){
                end--;
            }
            else if(maxLeftY>minRightX){
                start++;
            }
        }
        return -1;
    }
}