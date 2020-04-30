/*package whatever //do not write package name here */
//https://www.youtube.com/watch?v=NFJ3m9a1oJQ

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] ways = new long[100001];
		climbStairs(ways);
		while(t-->0){
		    int n = sc.nextInt();
		    System.out.println(ways[n]);
		}
	}
	public static void climbStairs(long[] ways){
	    ways[0]=1;
	    ways[1]=1;
	    for (int i=2; i<=100000; i++) 
            ways[i] = (ways[i-1]%(long)(Math.pow(10,9)+7) + ways[i-2]%(long)(Math.pow(10,9)+7))%(long)(Math.pow(10,9)+7); 
   
	}
}