//https://leetcode.com/problems/trapping-rain-water/
//https://www.youtube.com/watch?v=Uog2Jmyb3iY

// class Solution {
//     public int trap(int[] height) {
//         if(height==null||height.length==0){
//             return 0;
//         }
//         int sum=0;
//         int n = height.length;
//         int[] left = new int[n];
//         int[] right = new int[n];
//         int maxVal = left[0];
//         for(int i=0;i<n;i++){
//             maxVal = Math.max(maxVal,height[i]);
//             left[i]=maxVal;
//         }
//         int maxRVal = height[n-1];
//         for(int i=n-1;i>=0;i--){
//             maxRVal = Math.max(maxRVal,height[i]);
//             right[i] = maxRVal;
//         }
//         for(int i=0;i<n;i++){
//             int res = Math.min(left[i],right[i]);
//             sum= sum+ res - height[i];
//         }
//         return sum;
//     }
// }


public class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0, maxleft = 0, maxright = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxleft) {
                    maxleft = height[left];
                } else {
                    res += maxleft - height[left];
                }
                left++;
            }
            else {
               if (height[right] >= maxright) {
                   maxright = height[right];
               } else {
                   res += maxright - height[right];
               }
                right--;
            }
        }
        return res;
    }
}
