//https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] arr = br.readLine().split(" ");
		    int n = Integer.parseInt(arr[0]);
		    int k = Integer.parseInt(arr[1]);
		    System.out.println(gameOfDeaths(n,k));
		}
	}
	
	public static int gameOfDeaths(int n,int k){
	    if(n==1){
	        return n;
	    }
	    else{
	      return (gameOfDeaths(n-1,k)+k-1) % n +1;  
	    }
	}
}