//https://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] ways = new long[1001];
		climbStairs(ways);
		while(t-->0){
		    int n = sc.nextInt();
		    System.out.println(ways[n]);
		}
	}
	public static void climbStairs(long[] ways){
	    int[] a = new int[3];
	    a[0]=3;
	    a[1]=5;
	    a[2]=10;
	    ways[0]=1;
	    for(int num:a){
            for (int j=1; j<=1000; j++) {
                if(j>=num){
                    ways[j] = ways[j]+ways[j-num];
                }
            }
	    }
	}
}