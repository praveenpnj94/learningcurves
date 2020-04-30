//https://www.youtube.com/watch?v=iOaRjDT0vjc&t=2s
//https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int e = sc.nextInt();
		    int n = sc.nextInt();
		    System.out.println(eggDrop(n,e));
		}
	}
	public static int eggDrop(int n, int e){
	    int[][] dp = new int[e+1][n+1];
	    for(int i=0;i<=e;i++){
	        for(int j=0;j<=n;j++){
	            if(i==0||j==0){
	                dp[i][j]=0;
	            }
	        }
	    }
	    for(int i=1;i<=e;i++){
	        for(int j=1;j<=n;j++){
	            dp[i][1]=1;
	            dp[1][j]=j;
	        }
	    }
	    for(int i=2;i<=e;i++){
	        for(int j=2;j<=n;j++){
	            dp[i][j]= Integer.MAX_VALUE;
	            for(int w=1;w<j;w++){
	                int tries = 1+Math.max(dp[i-1][w-1],dp[i][j-w]);
	                dp[i][j]=Math.min(dp[i][j],tries);	                
	            }

	        }
	    }
	    return dp[e][n];
	}
}