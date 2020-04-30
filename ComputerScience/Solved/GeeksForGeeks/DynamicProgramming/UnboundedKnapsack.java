//https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/


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
		    int tw = sc.nextInt();
		    int[] val = new int[n];
		    int[] w = new int[n];
		    for(int i=0;i<n;i++){
		        val[i] = sc.nextInt();
		    }
		    for(int j=0;j<n;j++){
		        w[j] = sc.nextInt();
		    }
		    System.out.println(knapSack(val,w,tw,n));
		}
	}
	   // A utility function that returns maximum of two integers 
    static int max(int a, int b) { return (a > b)? a : b; } 
       
   // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int val[],int wt[],int W, int n) 
    { 
     int i, w; 
     int K[][] = new int[n+1][W+1]; 
       
     // Build table K[][] in bottom up manner 
     for (i = 0; i <= n; i++) 
     { 
         for (w = 0; w <= W; w++) 
         { 
             if (i==0 || w==0) 
                  K[i][w] = 0; 
             else if (wt[i-1] <= w) 
                   K[i][w] = max(val[i-1] + K[i][w-wt[i-1]],  K[i-1][w]); 
             else
                   K[i][w] = K[i-1][w]; 
         } 
      } 
       
      return K[n][W]; 
    }
}
