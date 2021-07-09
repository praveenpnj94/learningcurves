//https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    int k = sc.nextInt();
		    firstNegative(arr,n,k);
		    System.out.println();
		}
	}
	public static void firstNegative(int[] arr, int n, int k){
	    if(arr==null||arr.length==0){
	        return;
	    }
	    for(int i=0;i<n-k+1;i++){
	        int j=i;
	        while(j<=i+k){
	            if(j==i+k){
	                System.out.print("0 ");
	                break;
	            }
	            if(arr[j]<0){
	                System.out.print(arr[j]+" ");
	                break;
	            }
	            j++;
	        }
	    }
	}
}

// Java implementation to find the 
// first negative integer in 
// every window of size k 
class GFG 
{ 

// function to find the first negative 
// integer in every window of size k 
static void printFirstNegativeInteger(int arr[], 
									int n, int k) 
{ 
	// A Double Ended Queue, Di that will 
	// store indexes of useful array elements 
	// for the current window of size k. 
	// The useful elements are all negative integers. 
	LinkedList<Integer> Di = new LinkedList<>(); 

	// Process first k (or first window) 
	// elements of array 
	int i; 
	for (i = 0; i < k; i++) 
	
		// Add current element at the rear of Di 
		// if it is a negative integer 
		if (arr[i] < 0) 
			Di.add(i); 
	
	// Process rest of the elements, 
	// i.e., from arr[k] to arr[n-1] 
	for ( ; i < n; i++) 
	{ 
		// if Di is not empty then the element 
		// at the front of the queue is the first 
		// negative integer of the previous window 
		if (!Di.isEmpty()) 
			System.out.print(arr[Di.peek()] + " "); 
		
		// else the window does not have a 
		// negative integer 
		else
			System.out.print("0" + " "); 

		// Remove the elements which are 
		// out of this window 
		while ((!Di.isEmpty()) && 
				Di.peek() < (i - k + 1)) 
			Di.remove(); // Remove from front of queue 

		// Add current element at the rear of Di 
		// if it is a negative integer 
		if (arr[i] < 0) 
			Di.add(i); 
	} 

	// Print the first negative 
	// integer of last window 
	if (!Di.isEmpty()) 
		System.out.print(arr[Di.peek()] + " "); 
	else
		System.out.print("0" + " ");	 
} 

// Driver Code 
public static void main(String[] args) 
{ 
	int arr[] = {12, -1, -7, 8, -15, 30, 16, 28}; 
	int n = arr.length; 
	int k = 3; 
	printFirstNegativeInteger(arr, n, k); 
} 
} 

// This code is contributed by PrinciRaj1992 
