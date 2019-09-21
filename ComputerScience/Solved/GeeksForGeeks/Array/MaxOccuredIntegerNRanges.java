//https://www.geeksforgeeks.org/maximum-occurred-integer-n-ranges/

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
		    int[] l = new int[n];
		    int[] r = new int[n];
		    String left[] = br.readLine().split(" ");
		    String right[] = br.readLine().split(" ");
		    for(int i=0;i<left.length;i++){
		        l[i] = Integer.parseInt(left[i]);
		        r[i] = Integer.parseInt(right[i]);
		    }
		    System.out.println(maximumOccuredElement(l,r,n));
		}
	}
    static int MAX = 1000000; 
  
    // Return the maximum occurred element in all ranges. 
    public static int maximumOccuredElement(int[] L, int[] R, int n) 
    { 
        // Initalising all element of array to 0. 
        int[] arr = new int[MAX]; 
  
        // Adding +1 at Li index and  
        // substracting 1 at Ri index. 
        for (int i = 0; i < n; i++) { 
            arr[L[i]] += 1; 
            arr[R[i] + 1] -= 1; 
        } 
  
        // Finding prefix sum and index 
        // having maximum prefix sum. 
        int msum = arr[0]; 
        int ind = 0; 
        for (int i = 1; i < MAX; i++) { 
            arr[i] += arr[i - 1]; 
            if (msum < arr[i]) { 
                msum = arr[i]; 
                ind = i; 
            } 
        } 
  
        return ind; 
    } 
}