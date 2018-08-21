/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 * Kadane's Algorithm
 */
package medium;


/**
 * @author praveen
 *15-Aug-2018 6:12:48 PM
 */
public class MaxSumContiguousSubArray {
    public static int getMaxSumContiguousSubArray(int[] arr){
        int currentMax=arr[0];
        int maxSoFar=arr[0];
        for(int i=1;i<arr.length;i++){
            currentMax=Math.max(arr[i],currentMax+arr[i]);
            maxSoFar=Math.max(maxSoFar,currentMax);
        }
        return maxSoFar;
    }
    
    public static void printMaxSubArraySumIndices(int a[], int size)
    {
        int max_so_far = Integer.MIN_VALUE,
        max_ending_here = 0,start = 0,
        end = 0, s = 0;
 
        for (int i = 0; i < size; i++) 
        {
            max_ending_here += a[i];
 
            if (max_so_far < max_ending_here) 
            {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
 
            if (max_ending_here < 0) 
            {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                           + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }
}