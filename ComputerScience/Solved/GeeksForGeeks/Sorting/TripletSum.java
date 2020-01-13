//https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] d = br.readLine().split(" ");
		    int n = Integer.parseInt(d[0]);
		    int x = Integer.parseInt(d[1]);
		    String[] arr = br.readLine().split(" ");
		    int[] a = new int[n];
		    for(int i=0;i<n;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    System.out.println(tripletSum(a,n,x));
		}
	}
	public static int tripletSum(int[] a,int n,int x){
	    Arrays.sort(a);
	    for(int i=0;i<n-2;i++){
	        int low = i+1;
	        int high = n-1;
	        while(low<high){
	            if(a[low]+a[high]+a[i]==x){
	                return 1;
	            }
	            else if(a[low]+a[high]+a[i]<x){
	                low++;
	            }
	            else{
	                high--;
	            }
	        }
	    }
	    return 0;
	}
}