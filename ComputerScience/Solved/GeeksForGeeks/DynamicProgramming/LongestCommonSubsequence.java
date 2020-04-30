//https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/LongestCommonSubsequence/LongestCommonSubsequence.java
//https://www.youtube.com/watch?v=ASoaQq66foQ


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] dim = br.readLine().trim().split(" ");
		    int m = Integer.parseInt(dim[0]);
		    int n = Integer.parseInt(dim[1]);
		    String a = br.readLine();
		    String b = br.readLine();
		    System.out.println(lcs(a,b));
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
}