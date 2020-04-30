//https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/

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
		        a[i] = sc.nextInt();
		    }
		    System.out.println(maxSumIncreasingSeq(a,n));
		}
	}
	public static int maxSumIncreasingSeq(int[] a,int n){
	    int[] caching = new int[n];
	    for(int i=0;i<n;i++){
	        caching[i]=a[i];
	    }
	    int maximumSoFar = a[0];
	    for(int i=1;i<n;i++){
	        for(int j=0;j<i;j++){
	            if(a[j]<a[i]){
	                caching[i]=Math.max(caching[j]+a[i],caching[i]);
	            }
	        }
	        maximumSoFar=Math.max(maximumSoFar,caching[i]);
	    }
	    return maximumSoFar;
	}
}