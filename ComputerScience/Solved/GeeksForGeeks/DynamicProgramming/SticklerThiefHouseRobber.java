//https://www.youtube.com/watch?v=xlvhyfcoQa4
//https://www.youtube.com/watch?v=FAxkaf_iDlc


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
		    int[] a = new int[n];
		    for(int i=0;i<n;i++){
		        a[i] = sc.nextInt();
		    }
		    System.out.println(sticklerThief(a,n));
		}
	}
	public static int sticklerThief(int[] a,int n){
	    int[] dp = new int[n+1];
	    dp[0]=0;
	    dp[1]=a[0];
	    if(n==1){
	        return dp[1];
	    }
	    dp[2]=Math.max(dp[1],a[1]);
	    if(n==2){
	        return dp[2];
	    }
	    for(int i=3;i<=n;i++){
	        dp[i]=Math.max(dp[i-1],a[i-1]+dp[i-2]);
	    }
	    return dp[n];
	}
}