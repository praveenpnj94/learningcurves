//https://www.geeksforgeeks.org/program-to-find-whether-a-no-is-power-of-two/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    boolean res = isPowerOfTwo(Long.parseLong(br.readLine()));
		    if(res){
		        System.out.println("YES");
		    }
		    else{
		        System.out.println("NO");
		    }
		}
	}
	public static boolean isPowerOfTwo(long n){
	    if(n==0){
	        return false;
	    }
	    return ((n&(n-1))>0)?false:true;
	}
}