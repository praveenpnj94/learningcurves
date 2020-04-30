/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] ways = new long[1000001];
		climbStairs(ways);
		while(t-->0){
		    int n = sc.nextInt();
		    System.out.println(ways[n]);
		}
	}
	public static void climbStairs(long[] ways){
	    ways[0]=1;
	    ways[1]=1;
	    for(int i=1;i<=2;i++){
            for (int j=2; j<=1000000; j++) {
                if(j>=i){
                    ways[j] = ways[j]+ways[j-i];
                }
            }
	    }
	}
}