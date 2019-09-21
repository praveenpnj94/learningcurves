//https://www.geeksforgeeks.org/equilibrium-index-of-an-array/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while(t-->0){
        int n = Integer.parseInt(br.readLine()); 
        int[] a = new int[n];
        String[] arr = br.readLine().split(" ");
        for(int i=0;i<arr.length;i++){
            a[i]=Integer.parseInt(arr[i]);
        }
        System.out.println(equilibrium(a,n));
    }
  }
  public static int equilibrium(int arr[], int n) 
    { 
        int sum = 0; // initialize sum of whole array 
        int leftsum = 0; // initialize leftsum 
  
        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i) 
            sum += arr[i]; 
  
        for (int i = 0; i < n; ++i) { 
            sum -= arr[i]; // sum is now right sum for index i 
  
            if (leftsum == sum) 
                return i+1; 
  
            leftsum += arr[i]; 
        } 
  
        /* If no equilibrium index found, then return 0 */
        return -1; 
    }
}