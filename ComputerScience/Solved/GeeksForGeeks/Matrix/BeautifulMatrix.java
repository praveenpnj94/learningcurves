//https://www.geeksforgeeks.org/minimum-operations-required-make-row-column-matrix-equals/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException
	 {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-->0){
            int n = Integer.parseInt(br.readLine());
            int[][] a = new int[n][n];
            String[] input = br.readLine().split(" ");
            int index = 0;
            for(int i = 0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j] = Integer.parseInt(input[index]);
                    index++;
                }
            }
            System.out.println(findMinOpeartion(a,n));
        }
	 }
	
	public static int findMinOpeartion(int matrix[][], 
                                         int n) 
    { 
        // Initialize the sumRow[] 
        // and sumCol[] array to 0 
        int[] sumRow = new int[n]; 
        int[] sumCol = new int[n]; 
          
        // Calculate sumRow[] and 
        // sumCol[] array 
        for (int i = 0; i < n; ++i) 
   
            for (int j = 0; j < n; ++j) 
            { 
                sumRow[i] += matrix[i][j]; 
                sumCol[j] += matrix[i][j]; 
            } 
      
        // Find maximum sum value  
        // in either row or in column 
        int maxSum = 0; 
        for (int i = 0; i < n; ++i)  
        { 
            maxSum = Math.max(maxSum, sumRow[i]); 
            maxSum = Math.max(maxSum, sumCol[i]); 
        } 
      
        int count = 0; 
        for (int i = 0, j = 0; i < n && j < n;)  
        { 
            // Find minimum increment 
            // required in either row 
            // or column 
            int diff = Math.min(maxSum - sumRow[i], 
                        maxSum - sumCol[j]); 
      
            // Add difference in  
            // corresponding cell, 
            // sumRow[] and sumCol[] 
            // array 
            matrix[i][j] += diff; 
            sumRow[i] += diff; 
            sumCol[j] += diff; 
      
            // Update the count  
            // variable 
            count += diff; 
      
            // If ith row satisfied, 
            // increment ith value  
            // for next iteration 
            if (sumRow[i] == maxSum) 
                ++i; 
      
            // If jth column satisfied,  
            // increment jth value for 
            // next iteration 
            if (sumCol[j] == maxSum) 
                ++j; 
        } 
        return count; 
    } 
}