//https://www.geeksforgeeks.org/shortest-common-supersequence/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] arr = br.readLine().trim().split(" ");
		    String a = arr[0];
		    String b = arr[1];
		    System.out.println(a.length()+b.length()-lcs(a,b));
		}
	}
	public static int lcs(String a, String b){
	    int m = a.length();
	    int n = b.length();
	    char[] aArr = a.toCharArray();
	    char[] bArr = b.toCharArray();
	    int[][] res = new int[m+1][n+1];
	    for(int i=0;i<=m;i++){
	        for(int j=0;j<=n;j++){
	            if(i==0||j==0){
	                res[i][j]=0;
	            }
	            else if(aArr[i-1]==bArr[j-1]){
	                res[i][j] = 1 + res[i-1][j-1];
	            }
	            else
	            {
	                res[i][j] = Math.max(res[i][j-1],res[i-1][j]);
	            }
	        }
	    }
	    return res[m][n];
	}

	static int superSeq(String X, String Y,  
                                 int m, int n) 
    { 
        int[][] dp = new int[m + 1][n + 1]; 
      
        // Fill table in bottom up manner 
        for (int i = 0; i <= m; i++) 
        { 
            for (int j = 0; j <= n; j++) 
            { 
            // Below steps follow above recurrence 
            if (i == 0) 
                dp[i][j] = j; 
            else if (j == 0) 
                dp[i][j] = i; 
            else if (X.charAt(i - 1) == Y.charAt(j - 1)) 
                    dp[i][j] = 1 + dp[i - 1][j - 1]; 
            else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],  
                                           dp[i][j - 1]); 
            } 
        } 
      
        return dp[m][n]; 
    }
}