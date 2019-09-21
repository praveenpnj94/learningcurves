
//https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/


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
		    String[] a = br.readLine().split(" ");
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = Integer.parseInt(a[i]);
		    }
		    int num = Integer.parseInt(br.readLine());
		    System.out.println(first(arr,0,n-1,num,n));
		}
	}
    public static int first(int arr[], int low, int high, int x, int n) 
    { 
        if(high >= low) 
        { 
            int mid = low + (high - low)/2; 
            if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x) 
                return mid; 
             else if(x > arr[mid]) 
                return first(arr, (mid + 1), high, x, n); 
            else
                return first(arr, low, (mid -1), x, n); 
        } 
    return -1; 
    } 
   
    /* if x is present in arr[] then returns the index of 
    LAST occurrence of x in arr[0..n-1], otherwise 
    returns -1 */
    public static int last(int arr[], int low, int high, int x, int n) 
    { 
        if (high >= low) 
        { 
            int mid = low + (high - low)/2; 
            if (( mid == n-1 || x < arr[mid+1]) && arr[mid] == x) 
                 return mid; 
            else if (x < arr[mid]) 
                return last(arr, low, (mid -1), x, n); 
            else
                return last(arr, (mid + 1), high, x, n); 
        } 
    return -1; 
    } 
}