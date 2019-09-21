//https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine()); 
		    long[] a = new long[n];
		    String[] arr = br.readLine().split(" ");
		    for(int i=0;i<arr.length;i++){
		        a[i]=Long.parseLong(arr[i]);
		    }
		    System.out.println(maxIndexDiff(a,n));
		}
	}
    /* For a given array arr[], returns the maximum j-i such that 
       arr[j] > arr[i] */
    public static long maxIndexDiff(long arr[], int n)  
    { 
        long maxDiff; 
        int i, j; 
  
        long RMax[] = new long[n]; 
        long LMin[] = new long[n]; 
  
        /* Construct LMin[] such that LMin[i] stores the minimum value 
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0]; 
        for (i = 1; i < n; ++i) 
            LMin[i] = Math.min(arr[i], LMin[i - 1]); 
  
        /* Construct RMax[] such that RMax[j] stores the maximum value 
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1]; 
        for (j = n - 2; j >= 0; --j) 
            RMax[j] = Math.max(arr[j], RMax[j + 1]); 
  
        /* Traverse both arrays from left to right to find optimum j - i 
           This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1; 
        while (j < n && i < n)  
        { 
            if (LMin[i] <= RMax[j])  
            { 
                maxDiff = Math.max(maxDiff, j - i); 
                j = j + 1; 
            }  
            else 
                i = i + 1; 
        } 
  
        return maxDiff; 
    }
}