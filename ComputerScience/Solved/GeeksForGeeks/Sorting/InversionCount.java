//https://www.geeksforgeeks.org/counting-inversions/

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
		    String[] arr = br.readLine().split(" ");
		    long[] a = new long[n];
		    for(int i=0;i<n;i++){
		        a[i] = Long.parseLong(arr[i]);
		    }
		    System.out.println(mergeSortAndCount(a,0,n-1));
		}
	}
	public static int inversion(int[] a, int n){
	    int count = 0;
	    for(int i=0;i<n-1;i++){
	        for(int j=i+1;j<n;j++){
	            if(a[i]>a[j]){
	                count++;
	            }
	        }
	    }
	    return count;
	}
	
	
    private static long mergeAndCount(long[] arr, long l, long m, long r) 
    { 
  
        // Left subarray 
        long[] left = Arrays.copyOfRange(arr, (int)l, (int)(m + 1)); 
  
        // Right subarray 
        long[] right = Arrays.copyOfRange(arr, (int)(m + 1), (int)(r + 1)); 
  
        long i = 0L, j = 0L, k = l, swaps = 0L; 
  
        while (i < left.length && j < right.length) { 
            if (left[(int)i] <= right[(int)j]) 
                arr[(int)k++] = left[(int)i++]; 
            else { 
                arr[(int)k++] = right[(int)j++]; 
                swaps += (m + 1) - (l + i); 
            } 
        } 
  
        // Fill from the rest of the left subarray 
        while (i < left.length) 
            arr[(int)k++] = left[(int)i++]; 
  
        // Fill from the rest of the right subarray 
        while (j < right.length) 
            arr[(int)k++] = right[(int)j++]; 
  
        return swaps; 
    } 
  
    // Merge sort function 
    private static long mergeSortAndCount(long[] arr, long l, long r) 
    { 
  
        // Keeps track of the inversion count at a 
        // particular node of the recursion tree 
        long count = 0L; 
  
        if (l < r) { 
            long m = (l + r) / 2; 
  
            // Total inversion count = left subarray count 
            // + right subarray count + merge count 
  
            // Left subarray count 
            count += mergeSortAndCount(arr, l, m); 
  
            // Right subarray count 
            count += mergeSortAndCount(arr, m + 1, r); 
  
            // Merge count 
            count += mergeAndCount(arr, l, m, r); 
        } 
  
        return count; 
    }
}