//https://www.geeksforgeeks.org/count-1s-sorted-binary-array/

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
		    System.out.println(countOnes(a,0,n-1));
		}
	}
    static int countOnes(int arr[], int low, int high) 
    { 
      if (high >= low) 
      { 
        // get the middle index 
        int mid = low + (high - low)/2; 
  
        // check if the element at middle index is last 1 
        if ( (mid == high || arr[mid+1] == 0) && 
             (arr[mid] == 1)) 
          return mid+1; 
  
        // If element is not last 1, recur for right side 
        if (arr[mid] == 1) 
          return countOnes(arr, (mid + 1), high); 
  
        // else recur for left side 
        return countOnes(arr, low, (mid -1)); 
      } 
      return 0; 
    }
}