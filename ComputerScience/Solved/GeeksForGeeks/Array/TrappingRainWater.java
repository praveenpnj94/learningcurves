//https://www.geeksforgeeks.org/trapping-rain-water/

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
		    int[] a = new int[n];
		    String[] arr = br.readLine().split(" ");
		    for(int i=0;i<arr.length;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    System.out.println(findWater(a,n));
		}
	}
	
	public static int findWater(int[] arr, int n) 
    { 
        // left[i] contains height of tallest bar to the 
        // left of i'th bar including itself 
        int left[] = new int[n]; 
       
        // Right [i] contains height of tallest bar to 
        // the right of ith bar including itself 
        int right[] = new int[n]; 
       
        // Initialize result 
        int water = 0; 
       
        // Fill left array 
        left[0] = arr[0]; 
        for (int i = 1; i < n; i++) 
           left[i] = Math.max(left[i-1], arr[i]); 
       
        // Fill right array 
        right[n-1] = arr[n-1]; 
        for (int i = n-2; i >= 0; i--) 
           right[i] = Math.max(right[i+1], arr[i]); 
       
        // Calculate the accumulated water element by element 
        // consider the amount of water on i'th bar, the 
        // amount of water accumulated on this particular 
        // bar will be equal to min(left[i], right[i]) - arr[i] . 
        for (int i = 0; i < n; i++) 
           water += Math.min(left[i],right[i]) - arr[i]; 
       
        return water; 
    } 
}

///Check Leetcode 