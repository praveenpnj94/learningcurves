//https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/discuss/377397/Intuitive-Java-Solution-With-Explanation
//https://www.geeksforgeeks.org/maximum-sum-subarray-removing-one-element/

class GfG
{
         public int maxSumSubarray(int[] a,int n) {
        int[] maxEndHere = new int[n], maxStartHere = new int[n];
        int max = a[0];
        maxEndHere[0] = a[0];
        for(int i=1; i < n; i++){
            maxEndHere[i] = Math.max(a[i], maxEndHere[i-1]+a[i]);
            max = Math.max(max, maxEndHere[i]);
        }
        maxStartHere[n-1] = a[n-1];
        for(int i=n-2; i >= 0; i--)
            maxStartHere[i] = Math.max(a[i], maxStartHere[i+1]+a[i]);
        for(int i=1; i < n-1; i++)
            max = Math.max(max, maxEndHere[i-1]+maxStartHere[i+1]);
        return max;
    }
}