//https://www.geeksforgeeks.org/partition-problem-dp-18/
//https://www.youtube.com/watch?v=3N47yKRDed0


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
		    int[] a = new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		    }
		    System.out.println(findPartition(a,n)?"YES":"NO");
		}
	}
	// Returns true if arr[] can be partitioned in two subsets of 
    // equal sum, otherwise false 
    public static boolean findPartition (int arr[], int n) 
    { 
        int sum = 0; 
        int i, j; 
  
        // Calculate sum of all elements 
        for (i = 0; i < n; i++) 
            sum += arr[i]; 
  
        if (sum%2 != 0) 
            return false; 
  
        boolean part[][]=new boolean[sum/2+1][n+1]; 
  
        // initialize top row as true 
        for (i = 0; i <= n; i++) 
            part[0][i] = true; 
  
        // initialize leftmost column, except part[0][0], as 0 
        for (i = 1; i <= sum/2; i++) 
            part[i][0] = false; 
  
        // Fill the partition table in botton up manner 
        for (i = 1; i <= sum/2; i++) 
        { 
            for (j = 1; j <= n; j++) 
            { 
                part[i][j] = part[i][j-1]; 
                if (i >= arr[j-1]) 
                    part[i][j] = part[i][j] || 
                                 part[i - arr[j-1]][j-1]; 
            } 
        } 
  
        /* // uncomment this part to print table 
        for (i = 0; i <= sum/2; i++) 
        { 
            for (j = 0; j <= n; j++) 
                printf ("%4d", part[i][j]); 
            printf("\n"); 
        } */
  
        return part[sum/2][n]; 
    }
}