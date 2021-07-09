//https://www.interviewbit.com/problems/rain-water-trapped/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] height) {
        if(height==null||height.length==0){
            return 0;
        }
        int sum=0;
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxVal = left[0];
        for(int i=0;i<n;i++){
            maxVal = Math.max(maxVal,height[i]);
            left[i]=maxVal;
        }
        int maxRVal = height[n-1];
        for(int i=n-1;i>=0;i--){
            maxRVal = Math.max(maxRVal,height[i]);
            right[i] = maxRVal;
        }
        for(int i=0;i<n;i++){
            int res = Math.min(left[i],right[i]);
            sum= sum+ res - height[i];
        }
        return sum;
    }
}
