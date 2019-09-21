//https://www.geeksforgeeks.org/find-subarray-with-given-sum/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- >0){
		    String[] input = br.readLine().split(" ");
		    int n = Integer.parseInt(input[0]);
		    int s = Integer.parseInt(input[1]);
		    String[] a = br.readLine().split(" ");
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]= Integer.parseInt(a[i]);
		    }
		    subArraySum(arr,n,s);
		    System.out.println();
		}
	}
    static void subArraySum(int arr[], int n, int sum)  
    { 
        int curr_sum = arr[0], start = 0, i; 
  
        // Pick a starting point 
        for (i = 1; i <= n; i++)  
        { 
            // If curr_sum exceeds the sum, then remove the starting elements 
            while (curr_sum > sum && start < i-1) 
            { 
                curr_sum = curr_sum - arr[start]; 
                start++; 
            } 
              
            // If curr_sum becomes equal to sum, then return true 
            if (curr_sum == sum)  
            { 
                int p = i; 
                System.out.print(start+1 
                        + " "+p); 
                return ; 
            } 
              
            // Add this element to curr_sum 
            if (i < n) 
            curr_sum = curr_sum + arr[i]; 
              
        } 
        System.out.print("-1"); 
        return; 
    }
}