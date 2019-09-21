//https://practice.geeksforgeeks.org/problems/gcd-of-array/0/?track=PC-W1

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String[] nos = br.readLine().trim().split("\\s+");
		    long[] arr = new long[n];
		    for(int j=0;j<n;j++){
		        arr[j]=Long.parseLong(nos[j]);
		    }
		    System.out.println(findGCD(arr, n));
		}
	}
	
	static long gcd(long a, long b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
  
    // Function to find gcd of array of 
    // numbers 
    static long findGCD(long arr[], int n) 
    { 
        long result = arr[0]; 
        for (int i = 1; i < n; i++) 
            result = gcd(arr[i], result); 
  
        return result; 
    } 
}