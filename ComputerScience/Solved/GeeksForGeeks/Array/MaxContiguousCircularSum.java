//https://www.techiedelight.com/maximum-sum-circular-subarray/
//https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException
	 {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-->0){
            int n = Integer.parseInt(br.readLine());
            String split[] = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            int allNegative = 0;
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(split[i]);
                if(arr[i]<0){
                    allNegative++;
                }
            }
            if(allNegative==n){
                System.out.println("-1");
            }
            else{
                System.out.println(KadaneCircular(arr));      
            }
        }
	 }
	 
	 // Function to find contiguous sub-array with the largest sum
	// in given set of integers
	public static int kadane(int[] A)
	{
		// stores maximum sum sub-array found so far
		int max_so_far = 0;

		// stores maximum sum of sub-array ending at current position
		int max_ending_here = 0;

		// traverse the given array
		for (int i = 0; i < A.length; i++)
		{
			// update maximum sum of sub-array "ending" at index i (by adding
			// current element to maximum sum ending at previous index i-1)
			max_ending_here = max_ending_here + A[i];

			// if maximum sum is negative, set it to 0 (which represents
			// an empty sub-array)
			max_ending_here = Integer.max(max_ending_here, 0);

			// update result if current sub-array sum is found to be greater
			max_so_far = Integer.max(max_so_far, max_ending_here);
		}

		return max_so_far;
	}

	// Function to find maximum sum circular subarray in a given array
	public static int KadaneCircular(int[] A)
	{
		// negate all elements of the array
		for (int i = 0; i < A.length; i++) {
			A[i] = -A[i];
		}

		// run Kadane's algorithm on modified array
		int negMaxSum = kadane(A);

		// restore the array
		for (int i = 0; i < A.length; i++) {
			A[i] = -A[i];
		}

		/*  return maximum of

			1. sum returned by Kadane's algorithm on original array.

			2. sum returned by Kadane's algorithm on modified array +
				sum of all elements of the array.
		*/

		return Integer.max(kadane(A), Arrays.stream(A).sum() + negMaxSum);
	}

}