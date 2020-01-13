//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] dims = br.readLine().split(" ");
		    int n = Integer.parseInt(dims[0]);
		    int k = Integer.parseInt(dims[1]);
		    int[] a = new int[n];
		    String[] arr = br.readLine().split(" ");
		    for(int i=0;i<n;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    maxAllSubArray2(a,n,k);
		}
	}
	public static void maxAllSubArray(int[] a, int n , int k){
	    for(int i=0;i<=n-k;i++){
	        int j;
	        int max=Integer.MIN_VALUE;
	        for(j=i;j<i+k;j++){
	            max=Math.max(max,a[j]);
	        }
	        System.out.print(max+" ");
	    }
	    System.out.println();
	}
	
   static void maxAllSubArray2(int arr[], int n, int k) 
    { 
        // Create a Double Ended Queue, Qi that will store indexes of array elements 
        // The queue will store indexes of useful elements in every window and it will 
        // maintain decreasing order of values from front to rear in Qi, i.e., 
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order 
        Deque<Integer> Qi = new LinkedList<Integer>(); 
  
        /* Process first k (or first window) elements of array */
        int i; 
        for (i = 0; i < k; ++i) { 
            // For every element, the previous smaller elements are useless so 
            // remove them from Qi 
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) 
                Qi.removeLast(); // Remove from rear 
  
            // Add new element at rear of queue 
            Qi.addLast(i); 
        } 
  
        // Process rest of the elements, i.e., from arr[k] to arr[n-1] 
        for (; i < n; ++i) { 
            // The element at the front of the queue is the largest element of 
            // previous window, so print it 
            System.out.print(arr[Qi.peek()] + " "); 
  
            // Remove the elements which are out of this window 
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k) 
                Qi.removeFirst(); 
  
            // Remove all elements smaller than the currently 
            // being added element (remove useless elements) 
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]) 
                Qi.removeLast(); 
  
            // Add current element at the rear of Qi 
            Qi.addLast(i); 
        } 
  
        // Print the maximum element of last window 
        System.out.print(arr[Qi.peek()]); 
        System.out.println();
    } 
}