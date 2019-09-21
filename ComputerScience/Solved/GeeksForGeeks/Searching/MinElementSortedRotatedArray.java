//https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- >0){
		    int n = Integer.parseInt(br.readLine());
		    String[] arr = br.readLine().split(" ");
		    int[] a = new int[n];
		    for(int i=0;i<n;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    System.out.println(findMinimum(a,n));
		}
	}
	public static int findMinimum(int[] a,int n){
	   // int mid = low +(high-low)/2 ;
	   // if(low>high){
	   //     return -1;
	   // }
	   // if(a[mid-1]<a[mid] && a[mid]<a[mid+1]){
	   //     return mid;
	   // }
	   int min = Integer.MAX_VALUE;
	   for(int i=0;i<n;i++){
	       min = Math.min(min,a[i]);
	   }
	   return min;
	}
	
	static int findMin(int arr[], int low, int high) 
    { 
        // This condition is needed to handle the case when array 
        // is not rotated at all 
        if (high < low)  return arr[0]; 
  
        // If there is only one element left 
        if (high == low) return arr[low]; 
  
        // Find mid 
        int mid = low + (high - low)/2; /*(low + high)/2;*/
  
        // Check if element (mid+1) is minimum element. Consider 
        // the cases like {3, 4, 5, 1, 2} 
        if (mid < high && arr[mid+1] < arr[mid]) 
            return arr[mid+1]; 
  
        // Check if mid itself is minimum element 
        if (mid > low && arr[mid] < arr[mid - 1]) 
            return arr[mid]; 
  
        // Decide whether we need to go to left half or right half 
        if (arr[high] > arr[mid]) 
            return findMin(arr, low, mid-1); 
        return findMin(arr, mid+1, high); 
    }
}