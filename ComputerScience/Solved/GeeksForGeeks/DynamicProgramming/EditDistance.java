//https://www.geeksforgeeks.org/edit-distance-dp-5/


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
		    String[] arr = br.readLine().trim().split(" ");
		    String a = arr[0];
		    String b = arr[1];
		    System.out.println(editDistance(a,b));
		}
	}
	public static int editDistance(String a, String b){
	    int m = a.length();
	    int n = b.length();
	    char[] aArr = a.toCharArray();
	    char[] bArr = b.toCharArray();
	    int[][] res = new int[m+1][n+1];
	    for(int i=0;i<=m;i++){
	        for(int j=0;j<=n;j++){
	            if(i==0){
	                res[i][j]=j;
	            }
	            else if(j==0){
	                res[i][j]=i;
	            }
	            else if(aArr[i-1]==bArr[j-1]){
	                res[i][j] = res[i-1][j-1];
	            }
	            else
	            {
	                res[i][j] = 1 + Math.min(Math.min(res[i][j-1],res[i-1][j]),res[i-1][j-1]);
	            }
	        }
	    }
	    return res[m][n];
	}
}