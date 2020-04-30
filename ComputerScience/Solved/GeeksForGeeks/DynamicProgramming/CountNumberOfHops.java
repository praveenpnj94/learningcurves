//https://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/

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
		    System.out.println(hops(n));
		}
	}
	public static long hops(int n){
	    long[] ways = new long[n+1];
	    if(n<2){
	        return 1;
	    }
	    ways[0]=1;
	    ways[1]=1;
	    ways[2]=2;
	    for (int i=3; i<=n; i++) 
            ways[i] = ways[i-1] + ways[i-2] + ways[i-3]; 
   
        return ways[n];
	}
    // Function returns count of ways to cover 'dist' 
    static int printCountRec(int dist) 
    { 
        // Base cases 
        if (dist<0)     
            return 0; 
        if (dist==0)     
            return 1; 
   
        // Recur for all previous 3 and add the results 
        return printCountRec(dist-1) +  
               printCountRec(dist-2) + 
               printCountRec(dist-3); 
    }
}